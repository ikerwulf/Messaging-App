package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.text.Layout;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.capstone.ui.main.SimpleChatFragment;

public class SimpleChat extends AppCompatActivity {
    public static final String Xtra_Msg = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_chat_activity);
        //final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
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
        Intent intent = getIntent();
        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        EditText editText = (EditText) findViewById(R.id.message_input);
        String message = editText.getText().toString();
        intent.putExtra(Xtra_Msg, message);


        message = intent.getStringExtra(SimpleChat.Xtra_Msg);
        TextView message_out = findViewById(R.id.message_output);

        if(message_out.hasSelection() == false)
        {
            // Capture the layout's TextView and set the string as its tex
            message_out.setText(message);

        }
        else
        {
            message_out.getLayoutParams();
            params1.addRule(RelativeLayout.ABOVE, message_out.getId());
            message_out.setLayoutParams(params1);
            TextView nwTxt = findViewById(R.id.message_output);
            nwTxt.setText(message);
        }



        //Creates a new text box
        //TextView nwTxt = new TextView(SimpleChat.this);
        //nwTxt.setId(R.id.message_output);
        //FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);

        //((FrameLayout) findViewById(R.id.simple_chat)).addView(nwTxt, params1);



    }


}