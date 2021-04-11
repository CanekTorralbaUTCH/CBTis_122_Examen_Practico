package com.canektorralba.examenpractico;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.VideoView;

public class Multimedia extends AppCompatActivity {

    TextView txvEleccion;
    VideoView vvVideo;
    ImageView imgvGif;
    Spinner spnCanciones;
    Button btnMaestro, btnPause, btnPlay, btnStop, btnYouTube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);
        //Animacion
        imgvGif=(ImageView)findViewById(R.id.gif);
        imgvGif.setBackgroundResource(R.drawable.frame);
        final AnimationDrawable adAnimacion =(AnimationDrawable)imgvGif.getBackground();
        btnMaestro=(Button)findViewById(R.id.BotonMaestro);
        btnMaestro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!adAnimacion.isRunning()){
                    adAnimacion.start();
                }
                else{
                    adAnimacion.stop();
                }
            }
        });
        //video trailer
        vvVideo=(VideoView)findViewById(R.id.video);
        Uri uPath =Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.solo_a_starwars);
        vvVideo.setVideoURI(uPath);
        MediaController mcControl =new MediaController(this);
        mcControl.setAnchorView(vvVideo);
        vvVideo.setMediaController(mcControl);
        //musica
        spnCanciones=(Spinner)findViewById(R.id.Canciones);
        spnCanciones.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                this.getResources().getStringArray(R.array.ListaCanciones)));
        btnPause=(Button)findViewById(R.id.Pause);
        btnPlay=(Button)findViewById(R.id.Play);
        btnStop=(Button)findViewById(R.id.Stop);
        txvEleccion=(TextView)findViewById(R.id.eleccion);
        final MediaPlayer mpMagic =MediaPlayer.create(this,R.raw.magicworks);
        final MediaPlayer mpWannable =MediaPlayer.create(this,R.raw.wannabe);
        spnCanciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strCancion="";
                strCancion=spnCanciones.getSelectedItem().toString();
                switch (strCancion){
                    case "Seleccione una cancion":
                        txvEleccion.setText("Creado por Canek Torralba");
                        if(mpMagic.isPlaying()){
                            mpMagic.stop();
                        }
                        if(mpWannable.isPlaying()){
                            mpWannable.stop();
                        }
                        break;
                    case "Magic Works":
                        txvEleccion.setText("Magic Works");
                        if(mpWannable.isPlaying()){
                            mpWannable.stop();
                        }
                        break;
                    case "Wannable":
                        txvEleccion.setText("Wannable");
                        if(mpMagic.isPlaying()){
                            mpMagic.stop();
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Pause
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEleccion = txvEleccion.getText().toString();
                if (strEleccion.equals("Magic Works")){
                    mpMagic.pause();
                }
                else if(strEleccion.equals("Wannable")){
                    mpWannable.pause();
                }
            }
        });
        //Play
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEleccion = txvEleccion.getText().toString();
                if (strEleccion.equals("Magic Works")){
                    mpMagic.start();
                }
                else if(strEleccion.equals("Wannable")){
                    mpWannable.start();
                }
            }
        });
        //stop
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEleccion = txvEleccion.getText().toString();
                if (strEleccion.equals("Magic Works")){
                    mpMagic.stop();
                }
                else if(strEleccion.equals("Wannable")){
                    mpWannable.stop();
                }
            }
        });
        //YouTube
        btnYouTube=(Button)findViewById(R.id.YouTube);
        btnYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Magic Works
                String strURL1 = "https://www.youtube.com/watch?v=pFm8RTxcaoc";
                Uri uri1 = Uri.parse(strURL1);
                uri1 = Uri.parse("vnd.youtube:" + uri1.getQueryParameter("v"));
                Intent iYouTube1 = new Intent(Intent.ACTION_VIEW, uri1);
                //Wannabe
                String strURL2 = "https://www.youtube.com/watch?v=gJLIiF15wjQ";
                Uri uri2 = Uri.parse(strURL2);
                uri2 = Uri.parse("vnd.youtube:" + uri2.getQueryParameter("v"));
                Intent iYouTube2 = new Intent(Intent.ACTION_VIEW, uri2);
                //Los if
                String strEleccion = txvEleccion.getText().toString();
                if (strEleccion.equals("Magic Works")){
                    if(mpMagic.isPlaying()){
                        mpMagic.stop();
                    }
                    startActivity(iYouTube1);
                    overridePendingTransition(R.anim.slide_down, R.anim.slide_up);
                }
                else if(strEleccion.equals("Wannable")){
                    if(mpWannable.isPlaying()){
                        mpWannable.stop();
                    }
                    startActivity(iYouTube2);
                    overridePendingTransition(R.anim.slide_down, R.anim.slide_up);
                }
            }
        });
    }
}
