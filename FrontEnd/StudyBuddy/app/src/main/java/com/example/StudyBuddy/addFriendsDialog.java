package com.example.StudyBuddy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class addFriendsDialog extends AppCompatDialogFragment {
    private EditText editTextFriendUsername;
    private addFriendListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder addF = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_friends_dialog_box, null);

        addF.setView(view)
                .setTitle("Add Friend")
                .setNegativeButton("I have no friends", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { }
                })
                .setPositiveButton("Add!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = editTextFriendUsername.getText().toString();
                        listener.applyUsername(name);
                    }
                });

        editTextFriendUsername = view.findViewById(R.id.edit_newFriend);
        return addF.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{ listener = (addFriendListener) context; }
        catch (ClassCastException e){ throw new ClassCastException(context.toString() + "must Implement addFriendListener"); }
    }

    public interface addFriendListener{
        void applyUsername(String name);
    }
}
