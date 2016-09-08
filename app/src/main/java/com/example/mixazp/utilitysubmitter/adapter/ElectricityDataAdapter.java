package com.example.mixazp.utilitysubmitter.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mixazp.utilitysubmitter.R;
import com.example.mixazp.utilitysubmitter.model.ElectricityDataModel;

import java.util.ArrayList;

public class ElectricityDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ElectricityDataModel> items;

    public ElectricityDataAdapter(ArrayList<ElectricityDataModel> items) {
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {     //конструктор


        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.item_row_electricity, parent, false); // получаем вьюху (замени название xml на своё)

        return new ElectricityDataViewHolder(view); // создаем объект класса для твоей модели, наследующийся от RecyclerView.ViewHolder, щас создадим сам класс
    }

    public class ElectricityDataViewHolder extends RecyclerView.ViewHolder {  //иницыализация всех элементов, что бы проще работать

        TextView rvname;
        TextView rvemail;

        public ElectricityDataViewHolder(View itemView) {
            super(itemView);

            rvname = (TextView) itemView.findViewById(R.id.rvname_electricity);
            rvemail = (TextView) itemView.findViewById(R.id.rvemail_electricity);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {    // по окончанию onBindViewHolder получается
        // готовая вьюхакоторая добавляется в ресайклер

        ElectricityDataViewHolder myHolder = (ElectricityDataViewHolder) holder; // приводим холдер к нашему типу
        ElectricityDataModel data = items.get(position); // получаем текущий экземпляр модели

        // заполняем поля
        myHolder.rvname.setText(data.getDateElectricity());
        myHolder.rvemail.setText(data.getUtilitesElectricity());
    }

    @Override
    public int getItemCount() {
        return items.size();             // возвращает количество объктов в ресайкреле
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name,email;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.rvname_electricity);
            email = (TextView)view.findViewById(R.id.rvemail_electricity);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }

        @Override
        public void onClick(View view) {

        }
    }
}