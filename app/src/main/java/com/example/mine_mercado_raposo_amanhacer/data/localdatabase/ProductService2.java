package com.example.mine_mercado_raposo_amanhacer.data.localdatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ProductService2 {

    @GET("product2")
    Call<List<ProductItem>> getProduct2();

    @DELETE("product2")
    Call<List<ProductItem>> deleteProduct();

    @POST("product2")
    Call<List<ProductItem>> addProduct();

    @PUT("product2")
    Call<List<ProductItem>> updateProduct();


}
