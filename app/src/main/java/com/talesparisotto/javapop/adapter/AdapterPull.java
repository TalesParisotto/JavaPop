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
import com.talesparisotto.javapop.model.Pull;

import java.util.List;

public class AdapterPull extends RecyclerView.Adapter<AdapterPull.MyViewHolder> {

    private List<Pull> pulls;

    public AdapterPull(List<Pull> pull) {
        this.pulls = pull;
    }

    @NonNull
    @Override
    public AdapterPull.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pull, parent, false);
        return new AdapterPull.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPull.MyViewHolder holder, int i) {

        Pull pull = pulls.get(i);
        holder.nomePull.setText(pull.title);
        holder.descricaoPull.setText("Descrição: " + pull.description);
        holder.body.setText("Body: " + pull.body);
        holder.data.setText("Data:" + pull.created_at);
        holder.nomeAutorPull.setText(pull.user.login);

        String url = pull.user.avatar_url;
        Picasso.get().load(url).into(holder.imagePull);

    }

    @Override
    public int getItemCount() {
        return pulls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nomePull;
        TextView descricaoPull;
        TextView nomeAutorPull;
        TextView body;
        TextView data;
        ImageView imagePull;

        public MyViewHolder(View itemView) {
            super(itemView);

            nomePull = itemView.findViewById(R.id.NomePull);
            descricaoPull = itemView.findViewById(R.id.descricaoPull);
            imagePull = itemView.findViewById(R.id.imagePull);
            nomeAutorPull = itemView.findViewById(R.id.textNomeAutorPull);
            body = itemView.findViewById(R.id.textViewBody);
            data = itemView.findViewById(R.id.textViewData);
        }
    }

}