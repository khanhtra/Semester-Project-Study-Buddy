package com.example.userpets;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class settings extends AppCompatActivity {
    private Button toDel;
    private AlertDialog confirmDeletion;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        toDel = (Button) findViewById(R.id.toDelete);

        toDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDialog();
            }
        });
    }

    public void displayDialog(){
        builder = new AlertDialog.Builder(settings.this);
        builder.setTitle("Are you sure you want to delete this account?\nYou will not be able to recover your account.");


        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteThisUser();
                openDeletePage();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        confirmDeletion = builder.create();
        confirmDeletion.show();
    }

    //TODO: Delete user from server
    public void deleteThisUser(){
        String url = "http://coms-309-vb-5.cs.iastate.edu:8080/users/{id}";
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        StringRequest strReq = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        );

    }

    public void openDeletePage(){
        Intent toStart = new Intent(this, deletedUser.class);
        startActivity(toStart);
    }
}
