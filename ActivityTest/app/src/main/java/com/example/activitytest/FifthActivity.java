package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FifthActivity extends BaseActivity {
    //onBackPressed已经是一个
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_layout);
        Button backdata_back = (Button)findViewById(R.id.button_6);
        backdata_back.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent();
                        intent.putExtra("data_return","Hello FirstActivity");
                        setResult(RESULT_OK,intent);
                        finish();


                    }

                }
        );
    }
}
