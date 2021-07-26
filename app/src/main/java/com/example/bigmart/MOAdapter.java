package com.example.bigmart;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class MOAdapter extends RecyclerView.Adapter<MOAdapter.MostViewHolder> {
    ArrayList<MOHelperClass> mostLocations;

    public MOAdapter(ArrayList<MOHelperClass> mostLocations) {
        this.mostLocations = mostLocations;
    }

    @NonNull
    @Override
    public MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_orders_design,parent,false);
        MostViewHolder mostViewHolder = new MostViewHolder(view);
        return mostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MostViewHolder holder, int position) {

        final MOHelperClass dHelperClass = mostLocations.get(position);
        holder.title.setText(dHelperClass.getTitle());
        holder.price.setText(dHelperClass.getPrice());
        holder.adress.setText("Name : "+dHelperClass.getName()+"\nAddress : "+dHelperClass.getAdress()+"\n PIN : "+dHelperClass.getPin()+"\nContact : "+dHelperClass.getContact());
        holder.quantity.setText("Quantity : "+dHelperClass.getQuantity());
        holder.imageView.setImageResource(dHelperClass.getRedId());


    }

    @Override
    public int getItemCount() {

        return mostLocations.size();
    }

    public static class MostViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title,price,adress,quantity;
        public MostViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            imageView = itemView.findViewById(R.id.moimage);
            price = itemView.findViewById(R.id.moprice);
            title = itemView.findViewById(R.id.motitle);
            adress = itemView.findViewById(R.id.moadress);
            quantity = itemView.findViewById(R.id.moqnt);


        }
    }
}


