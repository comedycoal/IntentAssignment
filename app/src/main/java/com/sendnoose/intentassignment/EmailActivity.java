package com.sendnoose.intentassignment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EmailActivity extends AppCompatActivity {
    public final int PICKFILE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
    }

    public void onSelectFile(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, PICKFILE_REQUEST_CODE);
        }
    }

    public void onSend(View view) {
        String addresses = ((EditText) findViewById(R.id.addressView)).getText().toString();
        String ccs = ((EditText) findViewById(R.id.ccView)).getText().toString();
        String bccs = ((EditText) findViewById(R.id.bccView)).getText().toString();
        String subject = ((EditText) findViewById(R.id.subjectView)).getText().toString();
        String body = ((EditText) findViewById(R.id.bodyView)).getText().toString();
        String fileUri = ((TextView) findViewById(R.id.fileUriView)).getText().toString();
        Uri uri = Uri.parse(Uri.decode(fileUri));

        Intent intent = new Intent(Intent.ACTION_SEND)
                .setType("*/*")
                .putExtra(Intent.EXTRA_EMAIL, addresses.isEmpty() ? "" : addresses.split(","))
                .putExtra(Intent.EXTRA_BCC, bccs.isEmpty() ? "" : bccs.split(","))
                .putExtra(Intent.EXTRA_CC, ccs.isEmpty() ? "" : ccs.split(","))
                .putExtra(Intent.EXTRA_SUBJECT, subject)
                .putExtra(Intent.EXTRA_TEXT, body)
                .putExtra(Intent.EXTRA_STREAM, uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}