package com.example.paketproduct.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paketproduct.algorithm.association.Rule;
import com.example.paketproduct.algorithm.fpgrowth.AlgoFPGrowth;
import com.example.paketproduct.databinding.ItemRuleBinding;

import java.util.List;
import java.util.Map;

public class RuleAdapter extends RecyclerView.Adapter<RuleAdapter.ViewHolder>{

    private List<Rule> ruleList;
    private AlgoFPGrowth fpGrowth;

    public RuleAdapter(List<Rule> ruleList, AlgoFPGrowth fpgrowth) {
        this.ruleList = ruleList;
        this.fpGrowth = fpgrowth;
    }

    public void setRuleList(List<Rule> ruleList) {
        this.ruleList = ruleList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRuleBinding binding =ItemRuleBinding.inflate(inflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Rule rule = ruleList.get(position);
        holder.bind(rule, fpGrowth);
    }

    @Override
    public int getItemCount() {
        if (ruleList != null){
            return ruleList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRuleBinding binding;

        public ViewHolder(@NonNull ItemRuleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Rule rule, AlgoFPGrowth fpGrowth){
            int[] antecedant = rule.getItemset1();
            int[] conclution = rule.getItemset2();
            int confidence = (int) (Math.floor(rule.getConfidence() * 10));

            Map<Integer, String> initAndItem = fpGrowth.getInitAndItem();

            if (antecedant.length > 1){
                binding.tvPremise1.setText(initAndItem.get(antecedant[0]));
                binding.tvPremise2.setText(initAndItem.get(antecedant[1]));

                if (rule.getConfidence() == 1){
                    binding.tvDescription.setText("Kombinasi barang ini sempurna untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli "+initAndItem.get(antecedant[0])+" dan "+initAndItem.get(antecedant[1])+", semuanya juga membeli " + initAndItem.get(conclution[0]));
                }else if (rule.getConfidence() > 0.8){
                    binding.tvDescription.setText("Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli "+initAndItem.get(antecedant[0])+" dan "+initAndItem.get(antecedant[1])+", "+ confidence+" diantaranya juga membeli "+ initAndItem.get(conclution[0]));
                } else {
                    binding.tvDescription.setText("Kombinasi barang ini cukup ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli "+initAndItem.get(antecedant[0])+" dan "+initAndItem.get(antecedant[1])+", "+ confidence+" diantaranya juga membeli "+ initAndItem.get(conclution[0]));
                }
            }else {
                binding.tvPremise1.setText(initAndItem.get(antecedant[0]));
                binding.tvPremise2.setText(null);

                if (rule.getConfidence() == 1){
                    binding.tvDescription.setText("Kombinasi barang ini sempurna untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli "+initAndItem.get(antecedant[0])+", semuanya juga membeli " + initAndItem.get(conclution[0]));
                }else if (rule.getConfidence() > 0.8){
                    binding.tvDescription.setText("Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli "+initAndItem.get(antecedant[0])+", "+ confidence+" diantaranya juga membeli "+ initAndItem.get(conclution[0]));
                } else {
                    binding.tvDescription.setText("Kombinasi barang ini cukup ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli "+initAndItem.get(antecedant[0])+", "+ confidence+" diantaranya juga membeli "+ initAndItem.get(conclution[0]));
                }
            }

            binding.tvConclusion.setText(initAndItem.get(conclution[0]));

        }
    }
}
