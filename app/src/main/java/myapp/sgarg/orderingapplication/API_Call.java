package myapp.sgarg.orderingapplication;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Call {

    String baseURL = "https://catfact.ninja/";

    @GET("fact")
    Call<ModelData> data();

    @GET("facts")
    Call<MultiFactsModel> listData();

}
