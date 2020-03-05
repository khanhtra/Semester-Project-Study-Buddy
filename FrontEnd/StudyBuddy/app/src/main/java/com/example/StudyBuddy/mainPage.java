package com.example.StudyBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainPage extends AppCompatActivity {
    private Button toSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        toSettings = (Button) findViewById(R.id.toSettings);
        toSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsPage();
            }
        });
    }

    public void openSettingsPage(){
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }
}
