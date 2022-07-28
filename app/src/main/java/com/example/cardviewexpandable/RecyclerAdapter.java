package com.example.cardviewexpandable;

import android.content.Context;
import android.transition.AutoTransition;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.holder> {
    String[] que;
    Context context;

    public RecyclerAdapter(String[] que, Context context) {
        this.que = que;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater=LayoutInflater.from(parent.getContext());
    View view=inflater.inflate(R.layout.recyclerview_row,parent,false);
    return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.maintext.setText(que[position]);
        holder.tv1.setText("First Textbox");
        holder.tv2.setText("Second Textbox");



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Transition transition = new Slide(Gravity.TOP);
                transition.setDuration(300);
                transition.addTarget(holder.cardView);
                TransitionManager.beginDelayedTransition((ViewGroup) view.getParent(), new AutoTransition());



                switch (holder.rr_ll.getVisibility())
                {
                    case 0:
                        holder.rr_ll.setVisibility(View.GONE);

                        holder.rr_iv.setImageResource(R.drawable.ic_down);
                        break;

                    case 8:
                        holder.rr_ll.setVisibility(View.VISIBLE);

                        holder.rr_iv.setImageResource(R.drawable.ic_up);
                        break;


                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return que.length;
    }

    public class holder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,maintext;
        LinearLayout rr_ll;
        CardView cardView;
        ImageView rr_iv;


        public holder(@NonNull View itemView) {
            super(itemView);

            maintext=itemView.findViewById(R.id.rr_maintext);

            tv1=itemView.findViewById(R.id.rr_tv1);
            tv2=itemView.findViewById(R.id.rr_tv2);

            rr_ll=itemView.findViewById(R.id.rr_linearlayout);
            rr_iv=itemView.findViewById(R.id.rr_iv);
            cardView=itemView.findViewById(R.id.cardview);


        }
    }
}
