package com.example.surveillance;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.jar.Attributes;

public class ProfileFragment extends Fragment {
    TextView proname;
    TextView prodesg;
    ImageView proimg;
    TextView prohb;
    TextView promed;
    TextView probg;
    Button c1;
    FirebaseUser user;
    DatabaseReference db;
    View v;
    String uid;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profilelayout, container, false);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstancestate) {
        super.onViewCreated(view, savedInstancestate);
        this.v = view;
        proname = (TextView) getActivity().findViewById(R.id.profilename);
        prodesg = (TextView) getActivity().findViewById(R.id.profiledesg);
        prohb = (TextView) getActivity().findViewById(R.id.profilehb);
        probg = (TextView) getActivity().findViewById(R.id.profilebg);
        proimg = (ImageView) getActivity().findViewById(R.id.profileimage);
        promed = (TextView) getActivity().findViewById(R.id.profilemedical);
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getEmail();
        c1 = (Button) getActivity().findViewById(R.id.logout);
        db = FirebaseDatabase.getInstance().getReference().child("agent");
        Query query = db.orderByChild("email").equalTo(uid);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    for (DataSnapshot des : dataSnapshot.getChildren()) {
                        final Agent hes = des.getValue(Agent.class);
                        proname.setText(hes.getName());
                        prodesg.setText(hes.getDesignation());
                        probg.setText(hes.getBloodgroup());
                        promed.setText(hes.getMedical());
                        prohb.setText(hes.getHb());
                        Picasso.get().load(hes.getImage()).into(proimg);


                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        init();
    }

    public void init() {

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                getActivity().finish();
                startActivity(new Intent(getActivity(), MainActivity.class));

            }
        });

    }
}
