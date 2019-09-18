package com.example.surveillance;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {
    Context c;
    ArrayList<Agent> arrayList;

    public Adapter(Context c, ArrayList<Agent> agent) {
        this.c = c;
        this.arrayList = agent;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.agentcard, viewGroup, false);
        return new AdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder adapterViewHolder, final int i) {
        Agent agent = arrayList.get(i);
        adapterViewHolder.t1.setText(agent.getName());
        adapterViewHolder.t4.setText(agent.getEmail());
        adapterViewHolder.t3.setText(agent.getHb());
        adapterViewHolder.t2.setText(agent.getDesignation());
        Picasso.get().load(agent.getImage()).into(adapterViewHolder.i1);


    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        public TextView t1;
        public TextView t2;
        public TextView t3;
        public TextView t4;
        public ImageView i1;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.agentname);
            t2 = itemView.findViewById(R.id.designation);
            i1 = itemView.findViewById(R.id.agentimage);
            t3 = itemView.findViewById(R.id.heartbeat);
        }
    }
}
