package com.example.aula09;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceApi {



        @GET("android/rest/produto")
        Call<List<Modelo_Produto>> getProduto();


}
