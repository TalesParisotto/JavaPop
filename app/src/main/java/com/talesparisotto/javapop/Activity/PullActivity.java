package com.talesparisotto.javapop.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.talesparisotto.javapop.R;
import com.talesparisotto.javapop.adapter.AdapterPull;
import com.talesparisotto.javapop.api.GitServacePull;
import com.talesparisotto.javapop.helper.RetrofitConfig;
import com.talesparisotto.javapop.listener.RecyclerItemClickListener;
import com.talesparisotto.javapop.model.Pull;
import com.talesparisotto.javapop.model.ResultadoPull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PullActivity extends AppCompatActivity {

    private Retrofit retrofitPull;
    private RecyclerView recyclerViewPull;
    private AdapterPull adapterPull;

    private List<Pull> pulls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);

        recyclerViewPull = findViewById(R.id.recyclerViewPull);
        retrofitPull = RetrofitConfig.getRetrofit();

        GitServacePull gitServacePull = retrofitPull.create(GitServacePull.class);


        gitServacePull.recuperarPull1(
        ).enqueue(new Callback<List<Pull>>() {
            @Override
            public void onResponse(Call<List<Pull>> call, Response<List<Pull>> response) {
                if (response.isSuccessful()) {


                    pulls = response.body();


                    adapterPull = new AdapterPull(pulls  /*, this*/);
                    recyclerViewPull.setHasFixedSize(true);
                    recyclerViewPull.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerViewPull.setAdapter(adapterPull);

                    recyclerViewPull.addOnItemTouchListener(
                            new RecyclerItemClickListener(
                                    getApplicationContext(),
                                    recyclerViewPull,
                                    new RecyclerItemClickListener.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(View view, int position) {
                                            String url = pulls.get(position).html_url;
                                            Intent i = new Intent(Intent.ACTION_VIEW);
                                            i.setData(Uri.parse(url));
                                            startActivity(i);
                                        }

                                        @Override
                                        public void onLongItemClick(View view, int position) {

                                        }

                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                        }
                                    }
                            )
                    );

                }
                else{

                }

            }

            @Override
            public void onFailure(Call<List<Pull>> call, Throwable t) {
                Log.d("pull",  t.getStackTrace() + " " + t.getMessage() );
            }
        });
    }
}
