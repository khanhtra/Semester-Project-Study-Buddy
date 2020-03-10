package com.example.StudyBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.StudyBuddy.LocalData.LocalDataStorage;
import com.example.StudyBuddy.LocalData.User;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class Timer extends AppCompatActivity {

    private TextView toMain;

    private long totalTime;
    private Chronometer chronometer;
    private boolean running;
    private Date dateStart;
    private Date dateEnd;
    private Button addT;
    private long tempTime;

    private String URL;
    private String ticketURL;
    private LocalDataStorage data;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        toMain = findViewById(R.id.toMenuTimer);

        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });



        chronometer = findViewById(R.id.chronometer);
        data = new LocalDataStorage(getApplicationContext());
        user = data.getUserData();

        URL = "http://coms-309-vb-5.cs.iastate.edu:8080/timings/";
        URL = URL.concat(user.getId());

        ticketURL = "http://coms-309-vb-5.cs.iastate.edu:8080/users/varun/tickets";
//        addT = findViewById(R.id.buttonReset);
//        addT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addTimer();
//            }
//        });

    }

    public void goBack(){
        startActivity(new Intent(this, MainMenu.class));
    }

    public void startChronometer(View v){
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - totalTime);
            chronometer.start();
            running = true;
            dateStart = new Date();

        }
    }
    public void stopChronometer(View v) {
        if (running == true) {
            chronometer.stop();
            totalTime = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }
    public void resetChronometer (View v){


        chronometer.setBase(SystemClock.elapsedRealtime());
        tempTime = totalTime;
        totalTime = 0;
        dateEnd = new Date();
        addTimer();
        grantTickets();



    }
    public void addTimer(){
        RequestQueue rq = Volley.newRequestQueue(getApplicationContext());

        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //display
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                error.printStackTrace();
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() {
                Gson gson = new Gson();
                String json = gson.toJson(dateStart);
                json = json.concat(",").concat(gson.toJson(dateEnd));

                try{ return (json).getBytes("utf-8"); }
                catch (UnsupportedEncodingException e) { return null; }
            }
        };
        rq.add(request);
    }

    //Set ticket conditions
    public void grantTickets(){
        //45mins
        if (tempTime >= 10){
            addTicket();
        }
        tempTime = 0;
    }
    public void addTicket(){
        RequestQueue rq = Volley.newRequestQueue(getApplicationContext());

        StringRequest request = new StringRequest(Request.Method.POST, ticketURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //display
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                error.printStackTrace();
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() {
                Gson gson = new Gson();
                String json = gson.toJson(1);

                try{ return (json).getBytes("utf-8"); }
                catch (UnsupportedEncodingException e) { return null; }
            }
        };
        rq.add(request);
    }
}
