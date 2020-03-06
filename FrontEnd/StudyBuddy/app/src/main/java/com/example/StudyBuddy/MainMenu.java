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

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
private Button loginButton;
private Button timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        loginButton = findViewById(R.id.loginButtonMM);
        timer = findViewById(R.id.timerButtonMM);

        loginButton.setOnClickListener(this);
        timer.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButtonMM:
                Intent intent = new Intent(this, mainPage.class);
                startActivity(intent);
                break;

            case R.id.timerButtonMM:
                Intent intent2 = new Intent(this, Timer.class);
                startActivity(intent2);
                break;
        }
    }
    }

