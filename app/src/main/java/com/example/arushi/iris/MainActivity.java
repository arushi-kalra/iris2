package com.example.arushi.iris;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    EditText sepal_length, sepal_width, petal_length, petal_width;
    Button button;
    List<String>vizdata=new ArrayList<>();
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiInterface apiInterface;


        button=(Button) findViewById(R.id.btn);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sepal_length = (EditText) findViewById(R.id.txt1);
                    sepal_width = (EditText) findViewById(R.id.txt2);
                    petal_length = (EditText) findViewById(R.id.txt3);
                    sepal_width = (EditText) findViewById(R.id.txt4);
                    String s_l=sepal_length.getText().toString();
                    String s_w=sepal_length.getText().toString();
                    String p_l=sepal_length.getText().toString();
                    String p_w=sepal_length.getText().toString();
                    hitApi(s_l,s_w,p_l,p_w);
                }
            });

    }
 public void hitApi(String s_l,String s_w,String p_l,String p_w)
 {

     apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
     Call<Pojo> call=apiInterface.getAPIResponse(s_l,s_w,p_l,p_w);
     call.enqueue(
             new Callback<Pojo>() {
                 @Override
                 public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                     if(response.isSuccessful())
                     {
                        if(response!=null)
                        {
                            Log.d(TAG, "onResponse: "+ response.body().getPrediction());
                        }
                     }

                 }

                 @Override
                 public void onFailure(Call<Pojo> call, Throwable t) {
                     Log.d(TAG, "onFailure: "+t.getMessage());

                 }
             }
     );


 }
 }


