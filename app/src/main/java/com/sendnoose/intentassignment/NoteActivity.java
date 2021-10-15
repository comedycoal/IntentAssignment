package com.sendnoose.intentassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.actions.NoteIntents;

public class NoteActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
    }

    public void onMakeNote(View view)
    {
        String name = ((EditText)findViewById(R.id.noteNameView)).getText().toString();
        String body = ((EditText)findViewById(R.id.noteContentView)).getText().toString();

        Intent intent = new Intent(NoteIntents.ACTION_CREATE_NOTE)
                            .putExtra(NoteIntents.EXTRA_NAME, name)
                            .putExtra(NoteIntents.EXTRA_TEXT, body);

        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }
}