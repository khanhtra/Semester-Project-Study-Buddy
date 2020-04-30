package com.example.StudyBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.StudyBuddy.LocalData.LocalDataStorage;
import com.example.StudyBuddy.LocalData.User;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class Friends extends AppCompatActivity implements addFriendsDialog.addFriendListener{
    private Button addFriends;
    private Button friendList;

    private LocalDataStorage data;
    private User user;
    private String friendUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        data = new LocalDataStorage(getApplicationContext());
        user = data.getUserData();

        addFriends = findViewById(R.id.addFRIENDS);
        friendList = findViewById(R.id.viewFriendList);

        addFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                openDialog();

                String URL = "http://coms-309-vb-5.cs.iastate.edu:8080/users";
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL + "/" + friendUsername , null,new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        addNewFriend();
                    }},
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Snackbar noUser = Snackbar.make(v, "This user does not exist. Failed to add.", Snackbar.LENGTH_LONG);
                                noUser.show();
                            }
                        });

                queue.add(request);
            }
        });

        friendList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                //view friends in list
            }
        });
    }

    /**
     * Displays pop-up and allows user to add a friend through username
     */
    public void openDialog(){
        addFriendsDialog addNewFriend = new addFriendsDialog();
        addNewFriend.show(getSupportFragmentManager(), "Add friend");
    }


    /**
     * sets friendUsername to the name given
     * @param name
     */
    @Override
    public void applyUsername(String name) {friendUsername = name;}

    /**
     * Makes a POST request to add a new friend to this user
     */
    public void addNewFriend(){
        String URL = "http://coms-309-vb-5.cs.iastate.edu:8080/friends/";
        URL = URL.concat(user.getId());
    }
}
