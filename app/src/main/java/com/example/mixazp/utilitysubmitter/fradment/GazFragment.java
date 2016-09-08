package com.example.mixazp.utilitysubmitter.fradment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.mixazp.utilitysubmitter.DataManager;
import com.example.mixazp.utilitysubmitter.R;
import com.example.mixazp.utilitysubmitter.activity.GazActivity;
import com.example.mixazp.utilitysubmitter.adapter.GazDataAdapter;
import com.example.mixazp.utilitysubmitter.model.GazDataModel;

import java.util.ArrayList;

public class GazFragment extends Fragment {

    public GazFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gaz, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_gaz);

        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab_gaz);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ArrayList<GazDataModel> items = DataManager.getInstance().getGazDataModelItems(getActivity());
//                GazDataAdapter adapter = new GazDataAdapter(items);
                Intent intent = new Intent(getContext(), GazActivity.class);
//                adapter.notifyDataSetChanged();
                startActivity(intent);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<GazDataModel> items = DataManager.getInstance().getGazDataModelItems(getActivity());
        GazDataAdapter adapter = new GazDataAdapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }

}