package com.example.StudyBuddy.LoginSystem;

import android.content.Context;

import com.example.StudyBuddy.LocalData.LocalDataStorage;

public class Logout
{
    public static void out(Context context)
    {
        LocalDataStorage data = new LocalDataStorage(context);
        data.setUserLoggedInStatus(false);
        data.clearUserData();
        //startActivity(new Intent(this, RegisterPage.class));
    }
}
