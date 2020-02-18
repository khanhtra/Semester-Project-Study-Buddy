package com.example.userpets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class LoginPage extends AppCompatActivity {
    private RequestQueue requestQueue;
    private EditText userName;
    private Button btnCreateUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        userName = (EditText)findViewById(R.id.userInput);
        btnCreateUser = (Button) findViewById(R.id.butUserCreation);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInfo = userName.getText().toString();
                Submit(userInfo);
                openMainPage();
            }
        });
    }

    private void Submit(String info){
        final String userChosenName = info;
        String url = "http://coms-309-vb-5.cs.iastate.edu:8080/users/{id}";
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    Toast.makeText(getApplicationContext(), obj.toString(), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
//            @Override
//            public String getBodyContentType(){
//                return"application/json; charset=utf-8";
//            }
//            @Override
//            public byte[] getBody() throws AuthFailureError{
//                try{ return userChosenName == null ? null : userChosenName.getBytes("utf-8");}
//                catch (UnsupportedEncodingException uee){return null;}
//            }
        };

        requestQueue.add(strReq);
    }

    public void openMainPage(){
        Intent intent = new Intent(this, mainPage.class);
        startActivity(intent);
    }
}
