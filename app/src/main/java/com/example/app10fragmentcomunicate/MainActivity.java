package com.example.app10fragmentcomunicate;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.Locale;

import static android.graphics.ColorSpace.Model.XYZ;

public class MainActivity extends AppCompatActivity implements Frag1.ChangeColorListener, Frag1.IncrementListener , Frag1.DecrementListener{
    Frag1 frag1;
    Frag2 frag2;
    static String languageToLoad  = "fa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();

        frag1 = (Frag1) fragmentManager.findFragmentById(R.id.fragment);
        if (frag1 == null) {
            frag1 = new Frag1();
            fragmentManager.beginTransaction().add(R.id.fragment, frag1).commit();
        }

        frag2 = (Frag2) fragmentManager.findFragmentById(R.id.fragment2);
        if (frag2 == null) {
            frag2 = new Frag2();
            fragmentManager.beginTransaction().add(R.id.fragment2, frag2).commit();
        }
    }

    @Override
    public void IncrementListen() {
        frag2.Increment();
    }
    public void DecrementListen(){
        frag2.Decrement();
    }

    @Override
    public void ChangeColListen() {
        frag2.ChangeColor();
    }

    public void changeLanguage(View view) {
        Locale locale = new Locale(languageToLoad);
        if(languageToLoad.equals("fa")) languageToLoad="en"; else languageToLoad="fa";
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        this.getResources().updateConfiguration(config,this.getResources().getDisplayMetrics());
        this.recreate();
       // Intent intent = new Intent(MainActivity.this, MainActivity.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //startActivity(intent);
        }
}

