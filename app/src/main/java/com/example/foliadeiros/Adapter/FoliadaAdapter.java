package com.example.foliadeiros.Adapter;


import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foliadeiros.Model.Foliada;

import java.util.List;

public class FoliadaAdapter extends RecyclerView.Adapter<FoliadaAdapter.ViewHolder> {
    private List<Foliada> lista;

    @NonNull
    @Override
    public FoliadaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoliadaAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
