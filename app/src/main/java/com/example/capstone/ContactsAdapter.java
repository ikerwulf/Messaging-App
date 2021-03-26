package com.example.capstone;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;


public class ContactsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    ArrayList<ContactModel> list;
    public static final int CONTACT_IN = 1;
    // public static final int CONTACT_OUT = 2;

    public ContactsAdapter(Context context, ArrayList<ContactModel> list) { // you can pass other parameters in constructor
        this.context = context;
        this.list = list;
    }

    private class anotherContactViewHolder extends RecyclerView.ViewHolder {

        TextView contactTV;

        anotherContactViewHolder(final View itemView) {
            super(itemView);
            contactTV = itemView.findViewById(R.id.contact_item);
        }

        void bind(int position) {
            ContactModel contactModel = list.get(position);
            contactTV.setText(contactModel.contactName);
        }
    }

    private class contactFalseViewHolder extends RecyclerView.ViewHolder {

        TextView contactTV;

        contactFalseViewHolder(final View itemView) {
            super(itemView);
            contactTV = itemView.findViewById(R.id.message_text);
        }

        void bind(int position) {
            ContactModel messageModel = list.get(position);
            contactTV.setText(messageModel.contactName);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == CONTACT_IN) {
            return new ContactsAdapter.anotherContactViewHolder(LayoutInflater.from(context).inflate(R.layout.content_main, parent, false));
        } else {
            return new ContactsAdapter.anotherContactViewHolder(LayoutInflater.from(context).inflate(R.layout.content_main, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (list.get(position).contactType == CONTACT_IN) {
            ((anotherContactViewHolder) holder).bind(position);
        }  else {
            ((contactFalseViewHolder) holder).bind(position);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).contactType;
    }

}
