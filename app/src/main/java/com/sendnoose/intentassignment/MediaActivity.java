package com.sendnoose.intentassignment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MediaActivity extends AppCompatActivity
{
    private Uri m_savedUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
    }

    public void onSelectFile(View view)
    {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("audio/*");
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(intent, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK)
        {
            TextView view = (TextView) findViewById(R.id.fileUriView);
            m_savedUri = (Uri) (data != null ? data.getData() : null);
            view.setText(m_savedUri != null ? m_savedUri.toString() : "");
        }
    }

    public void onPlay(View view) {
            try {
                MediaPlayer mediaPlayer = MediaPlayer.create(this, m_savedUri);
                mediaPlayer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}