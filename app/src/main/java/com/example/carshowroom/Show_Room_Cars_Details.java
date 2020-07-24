package com.example.carshowroom;

        import android.app.Application;
        import android.widget.Toast;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.StringTokenizer;

public class Show_Room_Cars_Details extends Application {
    public static ArrayList<CARS> cars_Details_List;

    @Override
    public void onCreate() {
        super.onCreate();
        cars_Details_List = new ArrayList<>();
       /* carsDetailClassArrayList.add(new CARS("Amg GT R PRO","Mercedes","Rana WaQas", "03344398837"));
        carsDetailClassArrayList.add(new CARS("E250","Mercedes","Nabeel Shabir Khan Baloch", "03344398837"));
        carsDetailClassArrayList.add(new CARS("kicks","Nissan","Adnan Abid", "03344398837"));
        carsDetailClassArrayList.add(new CARS("GT-R","Nissan","Ahsan Farooq", "03344398837"));
        carsDetailClassArrayList.add(new CARS("BEETLE","Volkswagen","Mohsin Javeed", "03344398837"));
        carsDetailClassArrayList.add(new CARS("G CLASS","Mercedes","Hazeem Hassan", "03344398837"));*/
    }
    public void loadData(){

        File file=getApplicationContext().getFileStreamPath("CarShowRoomData.txt");
        if(file.exists())
        {
            try {
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(openFileInput("CarShowRoomData.txt")));
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    StringTokenizer stringTokenizer=new StringTokenizer(line,",");
                    Show_Room_Cars_Details.cars_Details_List.add(new CARS(stringTokenizer.nextToken(),stringTokenizer.nextToken()
                            ,stringTokenizer.nextToken(),stringTokenizer.nextToken()));


                }
                bufferedReader.close();
            }
            catch (IOException e)
            {
                //Toast.makeText(MainActivity.this,"load data\n "+e,Toast.LENGTH_LONG).show();
            }
        }

    }

}
