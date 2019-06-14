package com.talesparisotto.javapop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.talesparisotto.javapop.R;
import com.talesparisotto.javapop.adapter.AdapterRepo;
import com.talesparisotto.javapop.api.GitService;
import com.talesparisotto.javapop.helper.RetrofitConfig;
import com.talesparisotto.javapop.listener.RecyclerItemClickListener;
import com.talesparisotto.javapop.model.Item;
import com.talesparisotto.javapop.model.Resultado;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;


    private List<Item> repositorios = new ArrayList<>();
    private Resultado resultado;
    private AdapterRepo adapterRepo;


    //Retrofit
    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar componentes
        recyclerView = findViewById(R.id.recyclerView);

        //Configurações iniciais
        retrofit = RetrofitConfig.getRetrofit();


        //Recupera Repositorios
         recuperarRepo();
    }


        private void recuperarRepo() {

            GitService gitService = retrofit.create(GitService.class);
            gitService.recuperarRepo(
                    "language:java", "stars", "1"
            ).enqueue(new Callback<Resultado>() {
                @Override
                public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                    if (response.isSuccessful()) {
                        resultado = response.body();
                        repositorios = resultado.items;
                        configurarRecyclerView();
                    }
                }

                @Override
                public void onFailure(Call<Resultado> call, Throwable t) {

                }
            });

        }

        public void configurarRecyclerView () {

            adapterRepo = new AdapterRepo(repositorios  /*, this*/);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapterRepo);

            //Configura evento de clique
            recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(
                            this,
                            recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, final int position) {

                                    Toast.makeText(MainActivity.this, "O item foi clicado",
                                            Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(getApplicationContext(),PullActivity.class);
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

    }
