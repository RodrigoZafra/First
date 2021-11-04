package com.first.myapplicationfirst;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * @author Rodrigo
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView myRotate = findViewById(R.id.loginThunder);
        Animation rotate = AnimationUtils.loadAnimation(this,R.anim.rotate);
        myRotate.startAnimation(rotate);

        ImageView mGirl = findViewById(R.id.girl);

        Glide.with(this)
                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions
                        .withCrossFade(500))
                .into(mGirl);
    }

    public void openMain(View v){
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void openSignup(View v){
        Intent intent = new Intent(LoginActivity.this,Signup.class);
        startActivity(intent);
    }


}