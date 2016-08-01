package com.example.saket.sevenwonders;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;

public class details extends AppCompatActivity
{
    Uri output;
    File file;
    String filePath;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        filePath = Environment.getExternalStorageDirectory() + "/img1.jpeg";
        file = new File(filePath);
        output = Uri.fromFile(file);
        imageView=new ImageView(this);
        imageView.setImageURI(output);
        setContentView(imageView);

    }

}
