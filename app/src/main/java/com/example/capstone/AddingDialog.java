package com.example.capstone;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.content.Context;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.capstone.R;

public class AddingDialog extends AppCompatDialogFragment {

    private EditText editAddContact;
    private ContactDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.contact_dialog, null);

        builder.setView(view)
                .setTitle("Add Contact:")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String userContact = editAddContact.getText().toString();
                        listener.applyTexts(userContact);
                    }
                });
        editAddContact = view.findViewById(R.id.add_Contact);
        return builder.create();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ContactDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }
    public interface ContactDialogListener {
        void applyTexts(String userContact);

    }
}
