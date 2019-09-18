package com.example.surveillance;

import android.support.v7.widget.RecyclerView;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class AviewHolder extends RecyclerView.ViewHolder{
    TextView t1;
    TextView t2;
    ImageView i1;
    TextView t3;

    public AviewHolder(@NonNull View itemView) {
        super(itemView);
        t1 = itemView.findViewById(R.id.agentname);
        t2 = itemView.findViewById(R.id.designation);
        t3 = itemView.findViewById(R.id.heartbeat);
        i1 = itemView.findViewById(R.id.agentimage);
    }
}
