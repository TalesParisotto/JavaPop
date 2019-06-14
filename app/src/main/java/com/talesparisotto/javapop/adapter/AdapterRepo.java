package com.talesparisotto.javapop.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.talesparisotto.javapop.R;
import com.talesparisotto.javapop.model.Item;
import java.util.List;


public class AdapterRepo extends RecyclerView.Adapter<AdapterRepo.MyViewHolder> {

    private List<Item> repositorios;

    public AdapterRepo(List<Item> repositorios) {
        this.repositorios = repositorios;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_repo, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        Item repositorio = repositorios.get(i);
        Log.d("corpo", "adapterRepo: Nome:" + repositorio.name + "  descricao: " + repositorio.description + "  forks: " + repositorio.forks);
        holder.nomeRepo.setText( repositorio.name );
        holder.descricao.setText( repositorio.description);
        holder.fork.setText("quantidade de forks: " + String.valueOf(repositorio.forks));
        holder.strela.setText("quantidade de strelas: " + String.valueOf(repositorio.stargazers_count));
        holder.nomeAutor.setText(repositorio.owner.login);

        String url = repositorio.owner.avatar_url;
        Picasso.get().load(url).into(holder.imageRepo);

    }

    @Override
    public int getItemCount() {
        return repositorios.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nomeRepo;
        TextView descricao;
        TextView fork;
        TextView strela;
        TextView nomeAutor;
        ImageView imageRepo;

        public MyViewHolder(View itemView) {
            super(itemView);

            nomeRepo        = itemView.findViewById(R.id.NomeRepo);
            descricao       = itemView.findViewById(R.id.descricaoRepo);
            fork            = itemView.findViewById(R.id.forkRepo);
            imageRepo       = itemView.findViewById(R.id.imageRepo);
            strela          = itemView.findViewById(R.id.textStrela);
            nomeAutor       = itemView.findViewById(R.id.textNomeAutor);
        }
    }

}
