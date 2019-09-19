package com.example.surveillance;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AgentFragment extends Fragment {
    RecyclerView rv;
    View v;
    DatabaseReference db;
    ArrayList<Agent> arrayList;
    FirebaseRecyclerOptions<Agent> opt;
    FirebaseRecyclerAdapter<Agent, AviewHolder> adapt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.agentlayout, null);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstancestate) {
        super.onViewCreated(view, savedInstancestate);
        this.v = view;
        init();
    }

    public void init() {
        rv = getView().findViewById(R.id.agentlist);
        rv.setHasFixedSize(true);
        arrayList = new ArrayList<>();
        db = FirebaseDatabase.getInstance().getReference().child("agent");
        opt = new FirebaseRecyclerOptions.Builder<Agent>()
                .setQuery(db, Agent.class).build();

        adapt = new FirebaseRecyclerAdapter<Agent, AviewHolder>(opt) {
            @Override
            protected void onBindViewHolder(@NonNull AviewHolder holder, final int position, @NonNull Agent model) {
                Picasso.get().load(model.getImage()).into(holder.i1, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
                holder.t1.setText(model.getName());
                holder.t2.setText(model.getDesignation());
                holder.t3.setText(model.getHb());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), Agentinfo.class);
                        Agent agent = getItem(position);
                        intent.putExtra("name_text", agent.name);
                        intent.putExtra("image_url", agent.image);
                        intent.putExtra("info_text", agent.designation);
                        intent.putExtra("health", agent.hb);
                        intent.putExtra("bloodgroup", agent.bloodgroup);
                        intent.putExtra("medical", agent.medical);
                        startActivity(intent);

                    }
                });


            }

            @NonNull
            @Override
            public AviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.agentcard, parent, false);
                return new AviewHolder(view);
            }
        };
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(linearLayoutManager);
        adapt.startListening();
        rv.setAdapter(adapt);


    }
    @Override
    public void onStart() {
        super.onStart();
        if (adapt != null)
            adapt.startListening();
    }

    @Override
    public void onStop() {
        if (adapt != null)
            adapt.stopListening();
        super.onStop();

    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapt != null)
            adapt.startListening();
    }


}



