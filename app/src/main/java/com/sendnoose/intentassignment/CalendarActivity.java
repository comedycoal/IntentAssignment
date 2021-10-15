package com.sendnoose.intentassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

    public void onAdd(View view)
    {
        String title = ((EditText) findViewById(R.id.titleView)).getText().toString();
        String desc = ((EditText) findViewById(R.id.descView)).getText().toString();
        String location = ((EditText) findViewById(R.id.locationView)).getText().toString();
        String startTime = ((EditText) findViewById(R.id.startDayView)).getText().toString();
        String endTime = ((EditText) findViewById(R.id.endDayView)).getText().toString();
        boolean allday = ((CheckBox) findViewById(R.id.allDayView)).isChecked();

        Date start;
        Date end;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd/MM/yyyy");

        try
        {
            start = formatter.parse(startTime);
        }
        catch (ParseException excpt) {
            start = null;
        }

        try
        {
            end = formatter.parse(endTime);
        }
        catch (ParseException excpt) {
            end = null;
        }

        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.DESCRIPTION, desc)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, allday);

        if (start != null) intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, start.getTime());
        if (end != null) intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, end.getTime());

        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }
}