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
import com.example.mixazp.utilitysubmitter.activity.ElectricityActivity;
import com.example.mixazp.utilitysubmitter.adapter.ElectricityDataAdapter;
import com.example.mixazp.utilitysubmitter.model.ElectricityDataModel;

import java.util.ArrayList;

public class ElectricityFragment extends Fragment {

    public ElectricityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_electricity, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_eletricity);

        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab_eletricity);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ElectricityDataModel> items = DataManager.getInstance().getElectricityDataModelItems(getActivity());
                ElectricityDataAdapter adapter = new ElectricityDataAdapter(items);
                Intent intent = new Intent( getContext(), ElectricityActivity.class);
                adapter.notifyDataSetChanged();
                startActivity(intent);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<ElectricityDataModel> items = DataManager.getInstance().getElectricityDataModelItems(getActivity());
        ElectricityDataAdapter adapter = new ElectricityDataAdapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }

}

