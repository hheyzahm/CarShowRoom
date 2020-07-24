package com.example.carshowroom;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class UserNameActivity extends AppCompatActivity {
    Switch switchMode;
    Button Cancel_Button,Save_button;
    EditText User_naame_editText;
    String userName="";
    ConstraintLayout layout;
    ActionBar actionbar;
    EditText editText;
    private final String FileName="com.example.carshowroom.Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);

        switchMode=findViewById(R.id.switchMode);

        layout=findViewById(R.id.layout_userName);
        Cancel_Button=findViewById(R.id.Cancel_button);
        Save_button=findViewById(R.id.Save_button);
        User_naame_editText=findViewById(R.id.User_naame_editText);
        userName=User_naame_editText.getText().toString();
        editText=findViewById(R.id.User_naame_editText);
        //actionbar = getActionBar();
       // getSupportActionBar().setIcon(R.drawable.mercedes);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.lined_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        SharedPreferences prefreences = getSharedPreferences(FileName,MODE_PRIVATE);
        userName=prefreences.getString("UserName","" );
        if(!userName.isEmpty())
        {
            editText.setText(userName);
            int position = userName.length();
            editText.setSelection(position);
            getSupportActionBar().setTitle("  "+userName);
        }
        switchMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    layout.setBackgroundColor(Color.BLACK);
                    //actionbar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                    Cancel_Button.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_border_white));
                    Cancel_Button.setTextColor(Color.BLACK);
                    Save_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_border_white));
                    Save_button.setTextColor(Color.BLACK);
                    User_naame_editText.setBackgroundColor(Color.BLACK);
                    User_naame_editText.setTextColor(Color.BLACK);
                    User_naame_editText.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_border_white));
                }
                else {
                    layout.setBackgroundColor(Color.WHITE);
                   // actionbar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                    Cancel_Button.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_border_black));
                    Cancel_Button.setTextColor(Color.WHITE);
                    Save_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_border_black));
                    Save_button.setTextColor(Color.WHITE);
                    User_naame_editText.setBackgroundColor(Color.WHITE);
                    User_naame_editText.setTextColor(Color.WHITE);
                    User_naame_editText.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_border_black));
                }

            }
        });

        Cancel_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   AlertDialog.Builder builder = new AlertDialog.Builder(UserNameActivity.this);
                   builder.setTitle(R.string.app_name);
                   builder.setIcon(R.mipmap.ic_launcher);
                   builder.setMessage("Do you want to exit?")
                           .setCancelable(false)
                           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int id) {
                                   finish();
                               }
                           })
                           .setNegativeButton("No", new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int id) {
                                   dialog.cancel();
                               }
                           });
                   AlertDialog alert = builder.create();
                   alert.show();

            }
        });

        Save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName=User_naame_editText.getText().toString();
                if(userName.isEmpty())
                {
                    User_naame_editText.setError(getResources().getString(R.string.UserNameError));
                }
                else if(!validateFields(userName))
                {
                    User_naame_editText.setError(getResources().getString(R.string.UserNameError));
                }
                else
                {
                    SharedPreferences.Editor editor = getSharedPreferences(FileName,MODE_PRIVATE).edit();
                    editor.putString("UserName",userName);
                    editor.commit();
                    new Handler().postDelayed(new Runnable() {
                        @Override public void run() {

                            Intent i = new Intent(UserNameActivity.this,MainActivity.class);
                            i.putExtra("UserName",userName);
                            startActivity(i);
                            finish();
                        }
                    }, 1000);
                }

            }
        });
    }
    private boolean validateFields(String n) {
        String names[]= n.split("\\s+");
        if((names.length <2))
        {
            return false;
        }
        return true;
    }

}
