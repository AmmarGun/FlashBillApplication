package com.example.individualassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;

public class about extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);


        btn = (Button)findViewById(R.id.btncalc);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Intent intent = new Intent(about.this, MainActivity.class);
                                       startActivity(intent);
                                   }
                               });

        TextView text_developers = findViewById(R.id.text_developers);
        TextView copyrightTextView = findViewById(R.id.copyrightTextView);
        TextView text_url = findViewById(R.id.text_url);

        text_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite();
            }
        });
    }

    private void openWebsite() {
        String url = "https://github.com/your-github-page"; // Replace with your GitHub page URL

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
