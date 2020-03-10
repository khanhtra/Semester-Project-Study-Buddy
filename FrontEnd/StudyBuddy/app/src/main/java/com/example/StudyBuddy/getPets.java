package com.example.StudyBuddy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.StudyBuddy.LocalData.LocalDataStorage;
import com.example.StudyBuddy.LocalData.User;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class getPets extends AppCompatActivity {
    private Button getPet;
    private String rarity;
    private String URL;

    private LocalDataStorage data;
    private User user;

    private AlertDialog notEnoughTickets;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_pets);

        data = new LocalDataStorage(getApplicationContext());
        user = data.getUserData();
        URL = "http://coms-309-vb-5.cs.iastate.edu:8080/users/pets/";

        getPet = findViewById(R.id.useTickGP);
        getPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRand();
                URL = URL.concat(rarity);
                if(user.getTickets() > 0){
                    getPet();
                    user.removeTicket();
                    deleteTicket();
                }

                else{displayTicketError();}
            }
        });
    }

    public void getRand(){
        Random rand = new Random();
        int percentage = rand.nextInt(100);

        if(percentage < 80){rarity = "Common"; }
        else if (percentage < 99){rarity = "Rare";}
        else{rarity = "Ultra Rare"; }

    }

    public void getPet(){
        RequestQueue rq = Volley.newRequestQueue(getApplicationContext());

        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { Toast.makeText(getPets.this, "Got a pet!", Toast.LENGTH_SHORT).show(); }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { error.printStackTrace(); }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
            @Override
            public byte[] getBody() {
                Gson gson = new Gson();
                String json = gson.toJson(user);

                try{ return (json).getBytes("utf-8"); }
                catch (UnsupportedEncodingException e) { return null; }
            }
        };

        rq.add(request);
    }

    public void deleteTicket(){
        String delURL = "http://coms-309-vb-5.cs.iastate.edu:8080/users/".concat(user.getId()).concat("/tickets");
        RequestQueue rq = Volley.newRequestQueue(getApplicationContext());

        StringRequest request = new StringRequest(Request.Method.DELETE, delURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {}
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                error.printStackTrace();
            }
        });

        rq.add(request);
    }

    public void displayTicketError(){
        builder = new AlertDialog.Builder(getPets.this);
        builder.setTitle("Sorry, you don't have enough tickets.");


        builder.setPositiveButton("OK, I UNDERSTAND", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }
        });

        notEnoughTickets = builder.create();
        notEnoughTickets.show();
    }
}
