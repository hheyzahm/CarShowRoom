package com.example.carshowroom;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements CarsAdapter.OnItemSelected  {
    FragmentManager manager;

    Button  CarInfoButton,OwnerInfoButton,addnewButton,cancel,save;
    TextView ownerInfo_textView,OwnerName_textView,ownerNumber_textView,carname_textView,
           Add_new_ownerInfo_textView,Add_new_OwnerName_textView,Add_new_ownerNumber_textView,Add_new_carname_textView;
    EditText Add_new_CarModel_EditText,Add_new_CarMaker_EditText,Add_new_ownerName_EditText,Add_new_ownerNumber_EditText;
    ImageView car_imageview;
    CarListFragment list;
    RecyclerView recyclerView;
     @RequiresApi(api = Build.VERSION_CODES.KITKAT)
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button Fragment connecting
         CarInfoButton= findViewById(R.id.car_info);
         OwnerInfoButton=findViewById(R.id.ownerInfo);
         addnewButton=findViewById(R.id.Addnew);
         cancel=findViewById(R.id.cancel);
         save=findViewById(R.id.Save);
         
        //DetailsFragment TextView For Owner Information connecting
         ownerInfo_textView = findViewById(R.id.ownerInfo_textView);
         car_imageview= findViewById(R.id.car_imageview);
         OwnerName_textView= findViewById(R.id.OwnerName_textView);
         ownerNumber_textView= findViewById(R.id.ownerNumber_textView);
         //DetailsFragment TextView& ImageView For Car Information connecting
         carname_textView= findViewById(R.id.carname_textView);
         //DetailsFragment TextView For new Car Informationconnecting
         Add_new_ownerInfo_textView = findViewById(R.id.Add_new_ownerInfo_textView);
         Add_new_OwnerName_textView= findViewById(R.id.Add_new_OwnerName_textView);
         Add_new_ownerNumber_textView= findViewById(R.id.Add_new_ownerNumber_textView);
         Add_new_carname_textView= findViewById(R.id.Add_new_carname_textView);
         //DetailsFragment EditText For new Car Information connecting
         Add_new_CarModel_EditText=findViewById(R.id.Add_new_CarModel_EditText);
         Add_new_CarMaker_EditText= findViewById(R.id.Add_new_CarMaker_EditText);
         Add_new_ownerName_EditText= findViewById(R.id.Add_new_ownerName_EditText);
         Add_new_ownerNumber_EditText= findViewById(R.id.Add_new_ownerNumber_EditText);

         //setting all above TextViews,ImageView & EditText to gone so that every buuton click show respective items
         ownerInfo_textView.setVisibility(View.GONE);
         OwnerName_textView.setVisibility(View.GONE);
         ownerNumber_textView.setVisibility(View.GONE);
         carname_textView.setVisibility(View.GONE);

         car_imageview.setVisibility(View.GONE);

         Add_new_ownerInfo_textView.setVisibility(View.GONE);
         Add_new_OwnerName_textView.setVisibility(View.GONE);
         Add_new_ownerNumber_textView.setVisibility(View.GONE);
         Add_new_carname_textView.setVisibility(View.GONE);

         Add_new_CarModel_EditText.setVisibility(View.GONE);
         Add_new_CarMaker_EditText.setVisibility(View.GONE);
         Add_new_ownerName_EditText.setVisibility(View.GONE);
         Add_new_ownerNumber_EditText.setVisibility(View.GONE);

         cancel.setVisibility(View.GONE);
         save.setVisibility(View.GONE);
         
         manager= getSupportFragmentManager();
         list = (CarListFragment) manager.findFragmentById(R.id.list_fragmet);
         recyclerView=findViewById(R.id.RecyclerView);


         if(findViewById(R.id.Layout_Portrait)!=null)
         {
             manager.beginTransaction()
                     .show(Objects.requireNonNull(manager.findFragmentById(R.id.list_fragmet)))
                     .hide(Objects.requireNonNull(manager.findFragmentById(R.id.ButtonFragment)))
                     .hide(Objects.requireNonNull(manager.findFragmentById(R.id.DetailsFragement)))
                     .commit();
         }
         if(findViewById(R.id.Layout_Landscape)!=null){
             manager.beginTransaction()
                     .show(Objects.requireNonNull(manager.findFragmentById(R.id.list_fragmet)))
                     .show(Objects.requireNonNull(manager.findFragmentById(R.id.ButtonFragment)))
                     .show(Objects.requireNonNull(manager.findFragmentById(R.id.DetailsFragement)))
                     .commit();
         }


         CarInfoButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 car_imageview.setVisibility(View.VISIBLE);
                 carname_textView.setVisibility(View.VISIBLE);

                 ownerInfo_textView.setVisibility(View.GONE);
                 ownerNumber_textView.setVisibility(View.GONE);
                 OwnerName_textView.setVisibility(View.GONE);
                 Add_new_ownerInfo_textView.setVisibility(View.GONE);
                 Add_new_OwnerName_textView.setVisibility(View.GONE);
                 Add_new_ownerNumber_textView.setVisibility(View.GONE);
                 Add_new_carname_textView.setVisibility(View.GONE);

                 Add_new_CarModel_EditText.setVisibility(View.GONE);
                 Add_new_CarMaker_EditText.setVisibility(View.GONE);
                 Add_new_ownerName_EditText.setVisibility(View.GONE);
                 Add_new_ownerNumber_EditText.setVisibility(View.GONE);
             }
         });

         OwnerInfoButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 ownerInfo_textView.setVisibility(View.VISIBLE);
                 ownerNumber_textView.setVisibility(View.VISIBLE);
                 OwnerName_textView.setVisibility(View.VISIBLE);

                 car_imageview.setVisibility(View.GONE);
                 carname_textView.setVisibility(View.GONE);
                 Add_new_ownerInfo_textView.setVisibility(View.GONE);
                 Add_new_OwnerName_textView.setVisibility(View.GONE);
                 Add_new_ownerNumber_textView.setVisibility(View.GONE);
                 Add_new_carname_textView.setVisibility(View.GONE);
                 Add_new_CarModel_EditText.setVisibility(View.GONE);
                 Add_new_CarMaker_EditText.setVisibility(View.GONE);
                 Add_new_ownerName_EditText.setVisibility(View.GONE);
                 Add_new_ownerNumber_EditText.setVisibility(View.GONE);

             }
         });
         addnewButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 OwnerInfoButton.setVisibility(View.GONE);
                 CarInfoButton.setVisibility(View.GONE);
                 addnewButton.setVisibility(View.GONE);

                 save.setVisibility(View.VISIBLE);
                 cancel.setVisibility(View.VISIBLE);

                 Add_new_CarModel_EditText.setVisibility(View.VISIBLE);
                 Add_new_CarMaker_EditText.setVisibility(View.VISIBLE);
                 Add_new_ownerName_EditText.setVisibility(View.VISIBLE);
                 Add_new_ownerNumber_EditText.setVisibility(View.VISIBLE);


                 Add_new_ownerInfo_textView.setVisibility(View.VISIBLE);
                 Add_new_OwnerName_textView.setVisibility(View.VISIBLE);
                 Add_new_ownerNumber_textView.setVisibility(View.VISIBLE);
                 Add_new_carname_textView.setVisibility(View.VISIBLE);

                 ownerInfo_textView.setVisibility(View.GONE);
                 ownerNumber_textView.setVisibility(View.GONE);
                 OwnerName_textView.setVisibility(View.GONE);
                 car_imageview.setVisibility(View.GONE);
                 carname_textView.setVisibility(View.GONE);
             }
         });
         cancel.setOnClickListener(new View.OnClickListener() {
             @RequiresApi(api = Build.VERSION_CODES.KITKAT)
             @Override
             public void onClick(View v) {
                 OwnerInfoButton.setVisibility(View.VISIBLE);
                 CarInfoButton.setVisibility(View.VISIBLE);
                 addnewButton.setVisibility(View.VISIBLE);

                 save.setVisibility(View.GONE);
                 cancel.setVisibility(View.GONE);

                 car_imageview.setVisibility(View.VISIBLE);
                 carname_textView.setVisibility(View.VISIBLE);

                 ownerInfo_textView.setVisibility(View.GONE);
                 ownerNumber_textView.setVisibility(View.GONE);
                 OwnerName_textView.setVisibility(View.GONE);
                 Add_new_ownerInfo_textView.setVisibility(View.GONE);
                 Add_new_OwnerName_textView.setVisibility(View.GONE);
                 Add_new_ownerNumber_textView.setVisibility(View.GONE);
                 Add_new_carname_textView.setVisibility(View.GONE);

                 Add_new_CarModel_EditText.setVisibility(View.GONE);
                 Add_new_CarMaker_EditText.setVisibility(View.GONE);
                 Add_new_ownerName_EditText.setVisibility(View.GONE);
                 Add_new_ownerNumber_EditText.setVisibility(View.GONE);


             }
         });
         save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String carModel=Add_new_CarModel_EditText.getText().toString().trim();
                 String Maker=Add_new_CarMaker_EditText.getText().toString().trim();
                 String ownerName=Add_new_ownerName_EditText.getText().toString().trim();
                 String ownerNumber=Add_new_ownerNumber_EditText.getText().toString().trim();
                 if(carModel.isEmpty()){Add_new_CarModel_EditText.setError(getString(R.string.carModelError));}
                 if(Maker.isEmpty()){Add_new_CarMaker_EditText.setError(getString(R.string.MakerError));}
                 if(ownerName.isEmpty()){Add_new_ownerName_EditText.setError(getString(R.string.ownerNameError));}
                 if(ownerNumber.isEmpty()){Add_new_ownerNumber_EditText.setError(getString(R.string.ownerNameError));}
                 if(!ownerNumber.isEmpty()){
                     if(ownerNumber.length()<11)
                     {
                         Add_new_ownerNumber_EditText.setError(getString(R.string.ownerNumberErr));
                     }
                 }
                 if(Maker.equals("Mercedes") || Maker.equals("Nissan")|| Maker.equals("Volkswagen"))
                 {
                    list.notifyDataChanged();
                     car_imageview.setVisibility(View.VISIBLE);
                     carname_textView.setVisibility(View.VISIBLE);

                     ownerInfo_textView.setVisibility(View.GONE);
                     ownerNumber_textView.setVisibility(View.GONE);
                     OwnerName_textView.setVisibility(View.GONE);
                     Add_new_ownerInfo_textView.setVisibility(View.GONE);
                     Add_new_OwnerName_textView.setVisibility(View.GONE);
                     Add_new_ownerNumber_textView.setVisibility(View.GONE);
                     Add_new_carname_textView.setVisibility(View.GONE);

                     Add_new_CarModel_EditText.setVisibility(View.GONE);
                     Add_new_CarMaker_EditText.setVisibility(View.GONE);
                     Add_new_ownerName_EditText.setVisibility(View.GONE);
                     Add_new_ownerNumber_EditText.setVisibility(View.GONE);
                 }
                 else
                 {
                     Add_new_CarMaker_EditText.setError(getString(R.string.MakerErr));
                 }

             }
         });

         onItemClick(0);
     }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onItemClick(int index) {

        OwnerName_textView.setText(carDetailsClass.carsDetailClassArrayList.get(index).getOwnerName());
        ownerNumber_textView.setText(carDetailsClass.carsDetailClassArrayList.get(index).getOwnerNumber());
        carname_textView.setText(carDetailsClass.carsDetailClassArrayList.get(index).getCarModel());
        if(carDetailsClass.carsDetailClassArrayList.get(index).getMaker().equals("Mercedes")
                ||carDetailsClass.carsDetailClassArrayList.get(index).getMaker().equals("mercedes"))
        {
            car_imageview.setImageResource(R.drawable.mercedes);
        }else if(carDetailsClass.carsDetailClassArrayList.get(index).getMaker().equals("Nissan")
                ||carDetailsClass.carsDetailClassArrayList.get(index).getMaker().equals("nissan"))
        {
            car_imageview.setImageResource(R.drawable.nissan);
        }
        else if(carDetailsClass.carsDetailClassArrayList.get(index).getMaker().equals("Volkswagen")
                ||carDetailsClass.carsDetailClassArrayList.get(index).getMaker().equals("volkswagen"))
        {
            car_imageview.setImageResource(R.drawable.volkswagen);
        }

    }

}
