package com.example.StudyBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.StudyBuddy.LocalData.LocalDataStorage;
import com.example.StudyBuddy.LocalData.User;
import com.google.android.material.snackbar.Snackbar;

public class Friends extends AppCompatActivity implements addFriendsDialog.addFriendListener{
    private Button addFriends;
    private Button friendList;

    private LocalDataStorage data;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        String test = "test";

        data = new LocalDataStorage(getApplicationContext());
        user = data.getUserData();

        addFriends = findViewById(R.id.addFRIENDS);
        friendList = findViewById(R.id.viewFriendList);

        addFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
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

    @Override
    public void applyUsername(String name) {

    }
}
