package com.first.myapplicationfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        openApp(true);

        //Hacer animación del rayo del splah
        ImageView mThunder = findViewById(R.id.thunder);
        Animation myAnim = AnimationUtils.loadAnimation(this,R.anim.fadein);
        mThunder.startAnimation(myAnim);

        ImageView mSea = findViewById(R.id.backView);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1590126759486-61d07f267fed?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=687&q=80")
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
                .into(mSea);
    }


    /*public void openLogin(View v){
        Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }*/
    //Esto sirve para pasar de la pantalla de splash a la de login de manera automática
    private void openApp(boolean locationPermission){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        },4000);
    }
}