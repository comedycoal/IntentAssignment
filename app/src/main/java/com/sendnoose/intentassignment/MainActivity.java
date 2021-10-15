package com.sendnoose.intentassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onEmailActivity(View view)
    {
        startActivity(new Intent(this, EmailActivity.class));
    }

    public void onAddToCalendar(View view) { startActivity(new Intent(this, CalendarActivity.class)); }

    public void onTakePhoto(View view)
    {
        startActivity(new Intent(this, PhotoActivity.class));
    }

    public void onCall(View view)
    {
        startActivity(new Intent(this, CallActivity.class));
    }

    public void onViewFile(View view) { startActivity(new Intent(this, MediaActivity.class)); }

    public void onMakeNote(View view) { startActivity(new Intent(this, NoteActivity.class)); }

    public void onMapPick(View view) { startActivity(new Intent(this, MapActivity.class)); }

    public void onURL(View view) { startActivity(new Intent(this, WebUrlActivity.class));}

    public void onWebSearch(View view) { startActivity(new Intent(this, WebSearchActivity.class));}
}