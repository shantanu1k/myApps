package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class detail_activity extends Activity {

    private Button mperform = null;
    private Spinner mspinner = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
         Bundle extras = getIntent().getExtras();
         if(extras!=null){
             String detailvalue = extras.getString("KeyForSending");
             if(detailvalue!=null){
                 Toast.makeText(this, "So,you are gonna do a thing...", Toast.LENGTH_SHORT).show();
             }
         }
         mspinner = (Spinner) findViewById(R.id.mySpinner);


         mperform = (Button) findViewById(R.id.perform);
         mperform.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int position = mspinner.getSelectedItemPosition();
                 Intent iIntent = null;
                 switch (position){
                     case 0 :
                         iIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                         if (iIntent.resolveActivity(getPackageManager()) != null) {
                             startActivity(iIntent);
                         }
                         break;
                     case 1 :
                         iIntent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"));
                        if (iIntent.resolveActivity(getPackageManager()) != null) {
                             startActivity(iIntent);
                         }
                         break;

                     case 2 :
                         iIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("sms:"));
                         if (iIntent.resolveActivity(getPackageManager()) != null) {
                             startActivity(iIntent);
                         }
                         break;
                     case 3 :
                         iIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                         if (iIntent.resolveActivity(getPackageManager()) != null) {
                             startActivity(iIntent);
                         }
                         break;
                 }

             }
         });
    }
}
