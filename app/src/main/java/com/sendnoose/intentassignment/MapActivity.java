package com.sendnoose.intentassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MapActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    public void onLocationGo(View view)
    {
        String latitude = ((EditText) findViewById(R.id.latView)).getText().toString();
        String longitude = ((EditText) findViewById(R.id.lngView)).getText().toString();
        String zoom = ((EditText) findViewById(R.id.zoomView)).getText().toString();
        String uriStr = "geo:" + (latitude.isEmpty() ? "0" : latitude) + ","
                                + (longitude.isEmpty() ? "0" : longitude)
                                + (zoom.isEmpty() ? "" : "?z=" + zoom);

        Intent intent = new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse(uriStr));
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }

    public void onQueryGo(View view)
    {
        String query = ((EditText) findViewById(R.id.queryView)).getText().toString();
        if (!query.isEmpty())
        {
            String uriStr = null;
            try
            {
                uriStr = "geo:0,0?q=" + URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
            } catch (UnsupportedEncodingException e)
            {
                return;
            }

            Intent intent = new Intent(Intent.ACTION_VIEW)
                    .setData(Uri.parse(uriStr));

            if (intent.resolveActivity(getPackageManager()) != null)
            {
                startActivity(intent);
            }
        }
    }
}