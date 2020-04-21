package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second_Activity extends Activity {
    public static final int DETAIL_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Button nbutton = (Button) findViewById(R.id.fbutton);
        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
            }
        });

        Button detailbutton = (Button) findViewById(R.id.detailb);
        detailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),detail_activity.class);
                i.putExtra("KeyForSending","Some data from second activity");
                startActivityForResult(i,DETAIL_REQUEST);
            }
        });


    }

}



