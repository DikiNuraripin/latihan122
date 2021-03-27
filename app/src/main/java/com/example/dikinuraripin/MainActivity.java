package com.example.dikinuraripin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView txtNama,txtNoInduk,txtAlamat,txtNoHp;
    ApiInterface apiInterface;
    Orang orangnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNama = (TextView) findViewById(R.id.txt_nama);
        txtAlamat = (TextView) findViewById(R.id.txt_alamat);
        txtNoHp = (TextView) findViewById(R.id.txt_NoHp);
        txtNoInduk = (TextView) findViewById(R.id.txt_NoInduk);
        apiInterface=apiclient.getApiClient().create(ApiInterface.class);
        Call<Orang>call=apiInterface.ambilOrang();
        call.enqueue(new Callback<Orang>() {
            @Override
            public void onResponse(Call<Orang> call, Response<Orang> response) {
                orangnya=response.body();
                txtNama.setText(orangnya.getNama());
                txtAlamat.setText(orangnya.getAlamat());
                txtNoHp.setText(orangnya.getNo_hp());
                txtNoInduk.setText(orangnya.getNo_induk());
            }

            @Override
            public void onFailure(Call<Orang> call, Throwable t) {

            }
        });
    }
}