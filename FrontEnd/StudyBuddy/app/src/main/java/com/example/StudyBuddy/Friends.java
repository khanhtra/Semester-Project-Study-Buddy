package com.example.StudyBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.StudyBuddy.LocalData.LocalDataStorage;
import com.example.StudyBuddy.LocalData.User;

public class Friends extends AppCompatActivity {
    private Button addFriends;
    private Button friendList;

    private LocalDataStorage data;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        addFriends = findViewById(R.id.addFRIENDS);
        friendList = findViewById(R.id.viewFriendList);
    }
}
