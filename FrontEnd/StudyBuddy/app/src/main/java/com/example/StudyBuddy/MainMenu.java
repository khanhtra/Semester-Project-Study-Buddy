package com.example.StudyBuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.StudyBuddy.LocalData.LocalDataStorage;
import com.example.StudyBuddy.LocalData.User;
import com.example.StudyBuddy.UI_elements.RecyclerViewAdapter;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Implements the main page of the app.
 * Has the buttons getPet, timer and settings.
 */
public class MainMenu extends AppCompatActivity implements View.OnClickListener {
private Button getPet;
private Button timer;
private Button settings;

private WebSocketClient client;

private ArrayList<String> chat_entries = new ArrayList<>();
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        adapter = new RecyclerViewAdapter(chat_entries);
        initRecylerView();

        getPet = findViewById(R.id.getPetMM);
        timer = findViewById(R.id.timerButtonMM);
        settings = findViewById(R.id.settingsMM);
        checkPets = findViewById(R.id.checkPetsMM);

        getPet.setOnClickListener(this);
        timer.setOnClickListener(this);
        settings.setOnClickListener(this);

        LocalDataStorage data = new LocalDataStorage(this);
        User user = data.getUserData();
        Draft[] drafts = {new Draft_6455()};
        try{
            client = new WebSocketClient(new URI("ws://coms-309-vb-5.cs.iastate.edu:8080/websocket/" + user.getId()), drafts[0]) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {

                }

                @Override
                public void onMessage(String message)
                {
                    update(message);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {

                }

                @Override
                public void onError(Exception ex) {

                }
            };
        }

        catch (URISyntaxException e)
        {

        }

        client.connect();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getPetMM:
                Intent intent1 = new Intent(this, getPets.class);
                startActivity(intent1);
                break;

            case R.id.timerButtonMM:
                Intent intent2 = new Intent(this, Timer.class);
                startActivity(intent2);
                break;

            case R.id.settingsMM:
                Intent intent3 = new Intent(this, settings.class);
                startActivity(intent3);
                break;

            case R.id.checkPetsMM:
                Intent intent4 = new Intent(this, petList.class);
                startActivity(intent4);
                break;
        }
    }

    private void initRecylerView()
    {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void update(String item)
    {
        adapter.addItem(item);
    }

}

