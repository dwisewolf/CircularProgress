package com.welmondetest.camerabit;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    TextView a,b,c,d;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        a=findViewById(R.id.textView12);
        b=findViewById(R.id.activity);
        c=findViewById(R.id.textView14);
       d=findViewById(R.id.textView15);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        final Home home = new Home();
        final Cart cart = new Cart();
       a.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               replacefrag(home);

           }
       });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replacefrag(cart);

            }
        });

    }
    void replacefrag(Fragment fr){
        try {
            fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.page_shift,fr);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
       catch (Exception e ){
           Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();

        }

    }
}






