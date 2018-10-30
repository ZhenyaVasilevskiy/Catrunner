package com.example.user.catrunner;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public ImageButton btnHome;
    public ImageButton btnProfile;
    public ImageButton btnHistory;
    public ImageButton btnSettings;
    public ImageButton btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHistory = findViewById(R.id.btn_history);
        btnHome = findViewById(R.id.btn_home);
        btnProfile = findViewById(R.id.btn_profile);
        btnSettings = findViewById(R.id.btn_settings);
        btnInfo = findViewById(R.id.btn_info);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnHome.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_25dp_selected));
                Toast.makeText(MainActivity.this, getResources().getText(R.string.kek), Toast.LENGTH_LONG).show();
            }
        });
    }
}