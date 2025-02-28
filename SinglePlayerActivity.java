package com.example.racinggame;

import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SinglePlayerActivity extends AppCompatActivity {

    private GameEngine gameEngine;
    private TextView txtScore;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        txtScore = findViewById(R.id.txtScore);
        SurfaceView gameSurface = findViewById(R.id.gameSurfaceView);
        Button btnPause = findViewById(R.id.btnPause);

        gameEngine = new GameEngine(gameSurface, this);

        btnPause.setOnClickListener(v -> gameEngine.togglePause());
    }

    public void updateScore() {
        score += 10;
        runOnUiThread(() -> txtScore.setText("Score: " + score));
    }
}
