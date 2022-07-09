package myapp.sgarg.orderingapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private static RetrofitBuilder instance = null;
    private API_Call myApi;

    private RetrofitBuilder() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_Call.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApi = retrofit.create(API_Call.class);
    }

    public static synchronized RetrofitBuilder getInstance() {
        if (instance == null) {
            instance = new RetrofitBuilder();
        }
        return instance;
    }

    public API_Call getMyApi() {
        return myApi;
    }
}
