package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.capstone.ui.main.SimpleChatFragment;

public class SimpleChat extends AppCompatActivity {
    public static final String Xtra_Msg = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_chat_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SimpleChatFragment.newInstance())
                    .commitNow();
        }
    }

    public void OpenSimpleChat(View view) {
    }

    public void GoingBack(View view) {
        Intent switchToChat = new Intent(SimpleChat.this, MainActivity.class);
        SimpleChat.this.startActivity(switchToChat);
    }

    public void sendMessage(View view) //Send button response
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(Xtra_Msg, message);
        startActivity(intent);
    }


}