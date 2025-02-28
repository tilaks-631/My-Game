package com.example.racinggame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSinglePlayer = findViewById(R.id.btnSinglePlayer);
        Button btnMultiplayer = findViewById(R.id.btnMultiplayer);
        Button btnGarage = findViewById(R.id.btnGarage);
        Button btnSettings = findViewById(R.id.btnSettings);

        btnSinglePlayer.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SinglePlayerActivity.class));
        });

        btnMultiplayer.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MultiplayerActivity.class));
        });

        btnGarage.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, GarageActivity.class));
        });

        btnSettings.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        });
    }
}
