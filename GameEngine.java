package com.example.racinggame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameEngine extends SurfaceView implements Runnable {

    private Thread gameThread;
    private boolean isPlaying = true;
    private SurfaceHolder holder;
    private Paint paint;
    private int carX, carY;
    private int screenWidth, screenHeight;
    private SinglePlayerActivity activity;

    public GameEngine(SurfaceView surfaceView, Context context) {
        super(context);
        holder = surfaceView.getHolder();
        paint = new Paint();
        activity = (SinglePlayerActivity) context;
    }

    @Override
    public void run() {
        while (isPlaying) {
            update();
            draw();
            try {
                Thread.sleep(16); // 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        carY -= 10; // Car moves forward
        activity.updateScore();
    }

    private void draw() {
        if (!holder.getSurface().isValid()) return;

        Canvas canvas = holder.lockCanvas();
        canvas.drawColor(Color.BLACK);

        // Draw car
        paint.setColor(Color.RED);
        canvas.drawRect(carX, carY, carX + 50, carY + 100, paint);

        holder.unlockCanvasAndPost(canvas);
    }

    public void togglePause() {
        isPlaying = !isPlaying;
        if (isPlaying) {
            gameThread = new Thread(this);
            gameThread.start();
        }
    }
}
