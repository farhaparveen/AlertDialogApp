package com.example.alertdialogapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    String[] arr;
    boolean[] checkedNums;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.alertBtn);

        arr = new String[]{"1","2","3"};

       checkedNums = new boolean[]{
                false, // 1
                true, // 2
                true, // 3


        };
       // final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
       // final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, arr);

        //Neutral button, list, single/multiple choice list

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder  builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Alert!!!!");
               // builder.setMessage("Do You want to close this app!!");




//This is for list but here on selection of one item the alertDialog will disappear ,and in single and multi choice after selection also alertdialog doesn't disappear
//
//                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "position "+which, Toast.LENGTH_SHORT).show();
//                    }
//                });


                //This is for singlechoice in bulit alertDialog


                /*builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "position "+which, Toast.LENGTH_SHORT).show();

                    }
                });*/


                //This is for multichoice in bulit alertDialog


                builder.setMultiChoiceItems(arr,checkedNums, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedNums[which] = isChecked;


                        String currentItem = arr[which];
                        Toast.makeText(MainActivity.this, "position "+which, Toast.LENGTH_SHORT).show();

                    }
                });




                builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "position "+which, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "position "+which, Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });



                builder.setNeutralButton("Remind me later", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "position "+which, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });





    }
}
