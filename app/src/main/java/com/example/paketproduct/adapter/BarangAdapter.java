package com.example.paketproduct.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paketproduct.databinding.ItemBarangBinding;
import com.example.paketproduct.databinding.ItemRuleBinding;
import com.example.paketproduct.model.Barang;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ViewHolder> {

    private List<Barang> barangList;

    public BarangAdapter(List<Barang> barangList) {
        this.barangList = barangList;
    }

    public void setBarangList(List<Barang> barangList) {
        this.barangList = barangList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBarangBinding binding =ItemBarangBinding.inflate(inflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Barang barang = barangList.get(position);
        holder.bind(barang);
    }

    @Override
    public int getItemCount() {
        if (barangList != null){
            return barangList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemBarangBinding binding;

        public ViewHolder(@NonNull ItemBarangBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Barang barang){
            binding.tvNamaBarang.setText(barang.getName());
            binding.tvDescBarang.setText(barang.getDescription());
        }
    }
}
