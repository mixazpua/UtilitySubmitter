package com.example.mixazp.utilitysubmitter.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mixazp.utilitysubmitter.R;
import com.example.mixazp.utilitysubmitter.model.GazDataModel;

import java.util.ArrayList;

public class GazDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<GazDataModel> items;

    public GazDataAdapter(ArrayList<GazDataModel> items) {
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {     //конструктор

        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.item_row_gaz, parent, false); // получаем вьюху (замени название xml на своё)

        return new GazDataViewHolder(view); // создаем объект класса для твоей модели, наследующийся от RecyclerView.ViewHolder, щас создадим сам класс
    }

    public class GazDataViewHolder extends RecyclerView.ViewHolder {  //иницыализация всех элементов, что бы проще работать

        TextView rvname;
        TextView rvemail;

        public GazDataViewHolder(View itemView) {
            super(itemView);

            rvname = (TextView) itemView.findViewById(R.id.rvname_gaz);
            rvemail = (TextView) itemView.findViewById(R.id.rvemail_gaz);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {    // по окончанию onBindViewHolder получается
        // готовая вьюхакоторая добавляется в ресайклер

        GazDataViewHolder myHolder = (GazDataViewHolder) holder; // приводим холдер к нашему типу
        GazDataModel data = items.get(position); // получаем текущий экземпляр модели

        // заполняем поля
        myHolder.rvname.setText(data.getDateGaz());
        myHolder.rvemail.setText(data.getUtilitesGaz());
    }

    @Override
    public int getItemCount() {
        return items.size();             // возвращает количество объктов в ресайкреле
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name,email;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.rvname_gaz);
            email = (TextView)view.findViewById(R.id.rvemail_gaz);
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