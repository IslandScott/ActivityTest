package com.example.activitytest;

import android.app.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SixActivity extends AppCompatActivity {
    private  EditText newEditText;
    private  ImageView newImageView;
    private static boolean new_boolean = true;
    private ProgressBar  newProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        Button RememberText = (Button)findViewById(R.id.button_8);
        Button changeView = (Button)findViewById(R.id.button_9);
        Button alert_dialog = (Button)findViewById(R.id.button_10);
        Button ProgressButton = (Button)findViewById(R.id.ProgressButton);
        newEditText = (EditText) findViewById(R.id.edit_text);
        newImageView = (ImageView) findViewById(R.id.image_view);
        newProgressBar = (ProgressBar) findViewById(R.id.progress_bar);



        RememberText.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        String inputText = newEditText.getText().toString();
                        Toast.makeText(SixActivity.this,inputText, Toast.LENGTH_LONG).show();
                    }

                }
        );

        changeView.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        System.out.println("该数值为"+new_boolean);
                        if(new_boolean == true){
                            System.out.println("是否进入IF"+new_boolean);
                            newImageView.setImageResource(R.drawable.timg2);
                        }
                        if(new_boolean == false){
                            newImageView.setImageResource(R.drawable.timg);
                        }
                        new_boolean = !new_boolean;

                        //if(newProgressBar.getVisibility() == View.GONE){
                        //    newProgressBar.setVisibility(View.VISIBLE);
                        //}else{
                        //    newProgressBar.setVisibility(View.GONE);
                        //}

                        int progress = newProgressBar.getProgress();
                        progress = progress + 10;
                        newProgressBar.setProgress(progress);
                        if(progress ==100){
                            newProgressBar.setProgress(0);
                        }
                    }
                }
        );

        alert_dialog.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        AlertDialog.Builder dialog = new AlertDialog.Builder (SixActivity.this);
                        dialog.setTitle("Warning");
                        dialog.setMessage("Are you sure to delete the game?");
                        dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }
                        );

                        dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }
                        );

                        dialog.show();

                    }

                }
        );


        ProgressButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        ProgressDialog progressdialog = new ProgressDialog (SixActivity.this);
                        progressdialog.setTitle("Waiting");
                        progressdialog.setMessage("小机器人正在努力工作哦~~~");
                        progressdialog.setCancelable(true);
                        progressdialog.show();
                    }

                }
        );
    }


}
