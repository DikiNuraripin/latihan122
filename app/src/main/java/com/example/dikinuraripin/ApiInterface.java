package com.example.dikinuraripin;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("b046da16")
    Call<Orang> ambilOrang();
}
