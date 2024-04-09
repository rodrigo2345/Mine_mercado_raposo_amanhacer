package com.example.mine_mercado_raposo_amanhacer.data.localdatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ProductService {

    @GET("product")
    Call<List<ProductItem>> getProduct();

    @DELETE("product")
    Call<List<ProductItem>> deleteProduct();

    @POST("product")
    Call<List<ProductItem>> addProduct();

    @PUT("product")
    Call<List<ProductItem>> updateProduct();


}