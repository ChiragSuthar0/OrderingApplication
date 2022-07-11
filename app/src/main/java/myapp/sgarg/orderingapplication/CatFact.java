package myapp.sgarg.orderingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CatFact extends AppCompatActivity {

    private TextView catFact;
    private Button btn;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_fact);

        catFact = findViewById(R.id.catFact);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);

        Call<ModelData> call = RetrofitBuilder.getInstance().getMyApi().data();

        btn.setOnClickListener(V -> {
            call.clone().enqueue(new Callback<ModelData>() {
                @Override
                public void onResponse(Call<ModelData> call, Response<ModelData> response) {
                    ModelData Fact = response.body();

                    catFact.setText(Fact.getFact());
                    Toast.makeText(CatFact.this, Fact.getLength() + "", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ModelData> call, Throwable t) {
                    Toast.makeText(CatFact.this, "Some Error has Occured", Toast.LENGTH_LONG).show();
                }
            });
        });

        Call<MultiFactsModel> call2 = RetrofitBuilder.getInstance().getMyApi().listData();

        btn2.setOnClickListener(v -> {
            catFact.setText("");

            call2.clone().enqueue(new Callback<MultiFactsModel>() {
                @Override
                public void onResponse(Call<MultiFactsModel> call1, Response<MultiFactsModel> response) {

                    MultiFactsModel multiFacts = response.body();

                    List<ModelData> mdata = new ArrayList<>();

                    final boolean b = mdata.addAll(multiFacts.getData());

                    if (b) {
                        Toast.makeText(CatFact.this, "Addition of All the data was successful!!!", Toast.LENGTH_SHORT).show();
                        for (int i = 0; i < 5; i++) {
                            catFact.append((i + 1) + ")\t" + mdata.get(i).getFact() + "\n\n");
                        }
                    }
                    else {
                        Toast.makeText(CatFact.this, "Could Not add All the data", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<MultiFactsModel> call1, Throwable t) {
                    Toast.makeText(CatFact.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}