package com.example.saket.sevenwonders;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.ConnectionService;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.net.URL;

public class MainActivity extends Activity
{
    String filePath;
    File file;
    Uri output;

    Context context;
    Button browse,photo,net;
    EditText etext;
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        context=getBaseContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        browse=(Button)findViewById(R.id.browse);
        net=(Button)findViewById(R.id.net);
        photo=(Button)findViewById(R.id.photo);
        etext=(EditText)findViewById(R.id.etxt1);
        imageView=(ImageView)findViewById(R.id.image);
        textView=(TextView)findViewById(R.id.txtv1);
        filePath= Environment.getExternalStorageDirectory()+"/img.jpeg";
        file=new File(filePath);
        etext.getText();
        output=Uri.fromFile(file);
        SQLiteDatabase database=openOrCreateDatabase("photos",MODE_PRIVATE,null);
        browse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(
               MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,output);
                startActivityForResult(intent,0);
            }
        });
        photo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                i.setType("IMAGES");
                i.putExtra("crop",true);
                i.putExtra("scale",true);
                startActivityForResult(i,1);
            }
        });
                final ConnectivityManager check=(ConnectivityManager)
                this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
                 NetworkInfo[] infos=check.getAllNetworkInfo();
        for (int i=0;i<infos.length;i++)
                {
                    if (infos[i].getState()== NetworkInfo.State.CONNECTED)
                        Toast.makeText(context,"CONNECTED",Toast.LENGTH_LONG).show();
                }
                net.setOnClickListener(new View.OnClickListener() {
                    @Override
                 public void onClick(View view) {
                        Uri uri=Uri.parse("http://www.google.com");
                        Intent intent=new Intent(Intent.ACTION_PICK,uri);
                        startActivity(intent);


                /*String link="http://www.google.com";
                URL url=new URL(link);*/
                //ConnectionService.MODE_ENABLE_WRITE_AHEAD_LOGGING

            }
        });
        /*ConnectivityManager check=(ConnectivityManager)
                this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] infos=check.getAllNetworkInfo();
        for (int i=0;i<infos.length;i++)
        {
            if (infos[i].getState()== NetworkInfo.State.CONNECTED)
            Toast.makeText(context,"CONNECTED",Toast.LENGTH_LONG).show();
        }
        String link="http://www.google.com";
        URL url=new URL(link);*/
        //ConnectionService.MODE_ENABLE_WRITE_AHEAD_LOGGING



        /*net.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                check
            }
        });*/


    }
    /*@Override
    protected void onActivityResult(int requestcode,int resultcode,Intent data) {
        super.onActivityResult(requestcode, resultcode, data);
        if(data!=null){
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }

    }
        @Override
        public void onDestroy()
        {
            super.onDestroy();
        }
//    @Override*/
//    public boolean onCreateOptionMenu(Menu menu)
//    {
//        getMenuInflater().inflate(R.menu.menu_main,menu);
//        return true;
//    }
//

}
