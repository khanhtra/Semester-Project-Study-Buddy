package com.example.StudyBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Implements the main page of the app.
 * Has the buttons getPet, timer and settings.
 */
public class MainMenu extends AppCompatActivity implements View.OnClickListener {
private Button getPet;
private Button timer;
private Button settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        getPet = findViewById(R.id.getPetMM);
        timer = findViewById(R.id.timerButtonMM);
        settings = findViewById(R.id.settingsMM);

        getPet.setOnClickListener(this);
        timer.setOnClickListener(this);
        settings.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getPetMM:
                Intent intent1 = new Intent(this, getPets.class);
                startActivity(intent1);
                break;

            case R.id.timerButtonMM:
                Intent intent2 = new Intent(this, Timer.class);
                startActivity(intent2);
                break;

            case R.id.settingsMM:
                Intent intent3 = new Intent(this, settings.class);
                startActivity(intent3);
                break;
        }
    }
    }

