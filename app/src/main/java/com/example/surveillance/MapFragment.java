package com.example.surveillance;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    DatabaseReference db;
    View v;
    private static  LatLng MORRIS;
    private static  LatLng JOHNSON;
    private Marker mMorris;
    private Marker mJohnson;
    GoogleMap mMap;
    SupportMapFragment mapFragment;
    public  MapFragment(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.maplayout, container, false);
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment==null){
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.map, mapFragment).commit();

        }
        mapFragment.getMapAsync(this);
        return v;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstancestate) {
        super.onViewCreated(view, savedInstancestate);
        this.v = view;
        db = FirebaseDatabase.getInstance().getReference().child("agent");
        Query query = db.orderByChild("email").equalTo("morris@gmail.com");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    for (DataSnapshot des : dataSnapshot.getChildren()) {
                        final Agent hes = des.getValue(Agent.class);
                        MORRIS = new LatLng(hes.getLat(),hes.getLng());
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Query que = db.orderByChild("email").equalTo("johnson@gmail.com");
        que.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    for (DataSnapshot des : dataSnapshot.getChildren()) {
                        final Agent hes = des.getValue(Agent.class);
                        JOHNSON = new LatLng(hes.getLat(),hes.getLng());
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(getActivity(), R.raw.mapstyle));

            if (!success) {
                Log.e("Bottomnav", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("Bottomnav", "Can't find style. Error: ", e);
        }
        mMorris = mMap.addMarker(new MarkerOptions()
                .position(MORRIS)
                .title("Agent Morris").snippet("Commander"));
        mMorris.setTag(0);

        mJohnson = mMap.addMarker(new MarkerOptions()
                .position(JOHNSON)
                .title("Agent Jhonson").snippet("Patrol Officer"));
        mJohnson.setTag(0);
        float zoomLevel = 16.0f;
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MORRIS,zoomLevel));
    }



    }
