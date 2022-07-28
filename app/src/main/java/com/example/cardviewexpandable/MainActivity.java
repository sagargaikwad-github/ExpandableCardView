package com.example.cardviewexpandable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CardView cardView;
    TextView textView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView=findViewById(R.id.cardview);

        recyclerView=findViewById(R.id.recyclerview);

        String [] que={"Que 1","Que 2","Que 3","Que 4","Que 5"};
        //ok


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(que,MainActivity.this);
        recyclerView.setAdapter(recyclerAdapter);

    }


//    private void card() {
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               switch (recyclerView.getVisibility())
//               {
//                   case 8:
//                       recyclerView.setVisibility(View.VISIBLE);
//                       break;
//                   case 0:
//                       recyclerView.setVisibility(View.GONE);
//                       break;
//               }
//            }
//        });
    }
