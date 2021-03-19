package com.example.capstone;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.recyclerview.widget.RecyclerView;

import com.example.capstone.CustomAdapter;
import com.example.capstone.MessageModel;
import com.example.capstone.R;

public class ContactModel {

    public String contactName;
    public int contactType;
    // Constructor
    public ContactModel(String contactName, int contactType) {
        this.contactName = contactName;
        this.contactType = contactType;
    }
}
