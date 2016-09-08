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
import com.example.mixazp.utilitysubmitter.activity.WaterActivity;
import com.example.mixazp.utilitysubmitter.adapter.WaterDataAdapter;
import com.example.mixazp.utilitysubmitter.model.WaterDataModel;

import java.util.ArrayList;

public class WaterFragment extends Fragment {

    public WaterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_water, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_water);

        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab_water);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<WaterDataModel> items = DataManager.getInstance().getWaterDataModelItems(getActivity());
                WaterDataAdapter adapter = new WaterDataAdapter(items);
                Intent intent = new Intent(getContext(), WaterActivity.class);
                adapter.notifyDataSetChanged();
                startActivity(intent);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<WaterDataModel> items = DataManager.getInstance().getWaterDataModelItems(getActivity());
        WaterDataAdapter adapter = new WaterDataAdapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }

}
