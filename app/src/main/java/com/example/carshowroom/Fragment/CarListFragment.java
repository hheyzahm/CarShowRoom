package com.example.carshowroom.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carshowroom.ModelClasses.CarsAdapter;
import com.example.carshowroom.R;
import com.example.carshowroom.ModelClasses.carDetailsClass;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CarListFragment extends Fragment {


    RecyclerView recyclerView;
    CarsAdapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList carList= carDetailsClass.carsDetailClassArrayList;
    View view;

    public CarListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       view =  inflater.inflate(R.layout.fragment_car_list, container, false);

        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = view.findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new CarsAdapter(getContext(), carDetailsClass.carsDetailClassArrayList);
        recyclerView.setAdapter(myAdapter);

    }
    public void notifyDataChanged()
    {
        myAdapter.notifyDataSetChanged();
    }


}
