package com.example.carshowroom;

import android.content.Context;
import android.icu.text.Transliterator;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder>  {
ArrayList<CARS> Cars_ArrayList;
    OnItemSelected activity;
    public interface OnItemSelected{
        void onItemClick(int index);
    }



    public CarsAdapter(Context context, ArrayList<CARS> cars_ArrayList) {

        this.Cars_ArrayList = cars_ArrayList;
        activity=(OnItemSelected) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list  , parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(Cars_ArrayList.get(position));
        holder.CarsNameTextView.setText(Cars_ArrayList.get(position).getCarModel());
        holder.OwnerNameTextView.setText(Cars_ArrayList.get(position).getOwnerName());
        if(carDetailsClass.carsDetailClassArrayList.get(position).getMaker()=="Mercedes"
                ||carDetailsClass.carsDetailClassArrayList.get(position).getMaker()=="mercedes")
        {
            holder.imageView_car.setImageResource(R.drawable.mercedes);
        }else if(carDetailsClass.carsDetailClassArrayList.get(position).getMaker()=="Nissan"
                ||carDetailsClass.carsDetailClassArrayList.get(position).getMaker()=="nissan")
        {
            holder.imageView_car.setImageResource(R.drawable.nissan);
        }
        else if(carDetailsClass.carsDetailClassArrayList.get(position).getMaker()=="Volkswagen"
                ||carDetailsClass.carsDetailClassArrayList.get(position).getMaker()=="volkswagen")
        {
            holder.imageView_car.setImageResource(R.drawable.volkswagen);
        }
    }

    @Override
    public int getItemCount() {
        return Cars_ArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView_car;
        TextView CarsNameTextView, OwnerNameTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_car=itemView.findViewById(R.id.imageView_car);
            CarsNameTextView = itemView.findViewById(R.id.CarsNameTextView);
            OwnerNameTextView=itemView.findViewById(R.id.OwnerNameTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClick(Cars_ArrayList.indexOf((CARS) v.getTag()));
                }
            });
        }
    }
}
