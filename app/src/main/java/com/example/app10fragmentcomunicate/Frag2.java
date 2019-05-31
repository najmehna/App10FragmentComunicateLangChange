package com.example.app10fragmentcomunicate;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Frag2 extends Fragment {
    TextView myTextView;
    LinearLayout ll;
    int num=0;
public Frag2(){

}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.frag2_layout, container, false);
        myTextView=v.findViewById(R.id.textView);
        ll=v.findViewById(R.id.myView);
        return v;
    }

    public void Increment(){
    num++;
    myTextView.setText(String.valueOf(num));
    }
    public void Decrement(){
    num--;
    myTextView.setText(String.valueOf(num));
    }
    public void ChangeColor(){
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        ll.setBackgroundColor(color);
    }
}
