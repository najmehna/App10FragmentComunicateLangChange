package com.example.app10fragmentcomunicate;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Frag1 extends Fragment {
    private IncrementListener inc;
    private DecrementListener dec;
    private ChangeColorListener chCol;

    public interface ChangeColorListener{
        void ChangeColListen();
    }

    public interface IncrementListener {
        void IncrementListen();
    }
    public interface DecrementListener{
        void DecrementListen();
    }

    public Frag1(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.frag1_layout, container, false);

        Button button1 = (Button) v.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chCol.ChangeColListen();
            }
        });
        Button button2 = (Button) v.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc.IncrementListen();
            }
        });
        Button button3 = (Button) v.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dec.DecrementListen();
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IncrementListener) {
            inc = (IncrementListener) context;
            dec= (DecrementListener) context;
            chCol= (ChangeColorListener) context;
        }
        else {
            throw new RuntimeException(context.toString()
                    + " must implement OnGreenFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        inc = null;
        dec=null;
        chCol=null;
    }
}
