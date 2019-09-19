package com.example.surveillance;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;

public class Agentinfo extends AppCompatActivity {
    Button share;
    String text;
    String il;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agentinfo);
        share = (Button) findViewById(R.id.share);
        getIncomingIntent();
        share.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, text);
                try {

                    startActivity(whatsappIntent);

                } catch (android.content.ActivityNotFoundException ex) {

                    Toast.makeText(getApplicationContext(),"Whatsap not installed",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    private void getIncomingIntent() {
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("name_text") && getIntent().hasExtra("info_text") && getIntent().hasExtra("health") && getIntent().hasExtra("bloodgroup")&& getIntent().hasExtra("medical")) {
            String imageUrl = getIntent().getStringExtra("image_url");
            String namer = getIntent().getStringExtra("name_text");
            String info = getIntent().getStringExtra("info_text");
            String hr = getIntent().getStringExtra("health");
            String bg = getIntent().getStringExtra("bloodgroup");
            String medical = getIntent().getStringExtra("medical");
            text = "Name:"+namer+"\nDesignation:"+info+"\nBloodGroup:"+bg+"\nMedical History:"+medical+"\nSent by SURVEILLANCE";
            il = imageUrl;

            setImage(imageUrl, namer, info, hr, bg, medical);
        }
    }

    private void setImage(String imageUrl, String name_text, String info, String health, String bloodgroup, String medical) {

        TextView name = findViewById(R.id.agentinfoname);
        name.setText(name_text);
        TextView desg = findViewById(R.id.agentdesignation);
        desg.setText(info);
        TextView heal = findViewById(R.id.infohealth);
        heal.setText(health);
        TextView rate = findViewById(R.id.infobg);
        rate.setText(bloodgroup);
        TextView medic = findViewById(R.id.infomedical);
        medic.setText(medical);
        ImageView image = findViewById(R.id.agentinfoimage);
        Picasso.get().load(imageUrl).into(image);

    }
}
