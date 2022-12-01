package com.furkankurt.apigetretrofitdata.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.furkankurt.apigetretrofitdata.Adapter.RecyclerviewAdapter;
import com.furkankurt.apigetretrofitdata.Api.ApiInterface;
import com.furkankurt.apigetretrofitdata.Client.RetrofitClient;
import com.furkankurt.apigetretrofitdata.Model.DataModel;
import com.furkankurt.apigetretrofitdata.Model.UserModel;
import com.furkankurt.apigetretrofitdata.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<UserModel> dataModelList=new ArrayList<>();
    RecyclerviewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        getDataRequest();
    }
    private void getDataRequest()
    {
        ApiInterface apiInterface= RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<DataModel> call=apiInterface.getUserInformation();
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if(response.isSuccessful())
                {
                    List<UserModel> responseList = response.body().getData();
                    for (int i=0;i<responseList.size();i++)
                    {
                        //String responseListEnd = response.body().getData().get(i).getEmail();
                        //System.out.println("ASD"+responseListEnd);
                        dataModelList = new ArrayList(responseList);
                        recyclerViewAdapter = new RecyclerviewAdapter(dataModelList,MainActivity.this);
                        recyclerView.setAdapter(recyclerViewAdapter);
                    }



                }
                else
                {
                    Log.d("NVDİA","FAİL");
                }


            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });
    }
}