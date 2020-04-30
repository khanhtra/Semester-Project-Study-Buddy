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
import com.android.volley.toolbox.Volley;
import com.example.StudyBuddy.LocalData.LocalDataStorage;
import com.example.StudyBuddy.LocalData.User;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import org.json.JSONObject;

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
                final String FriendURL = "coms-309-vb-5.cs.iastate.edu:8080/friends/";
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL + "/" + friendUsername , null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //add friend to user
                        RequestQueue friendQ = Volley.newRequestQueue(getApplicationContext());
                        //JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, FriendURL )
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
}
