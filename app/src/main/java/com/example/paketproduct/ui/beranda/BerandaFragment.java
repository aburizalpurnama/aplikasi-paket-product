package com.example.paketproduct.ui.beranda;

import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paketproduct.R;
import com.example.paketproduct.adapter.RuleAdapter;
import com.example.paketproduct.algorithm.association.AlgoAgrawalFaster94;
import com.example.paketproduct.algorithm.association.AssocRules;
import com.example.paketproduct.algorithm.fpgrowth.AlgoFPGrowth;
import com.example.paketproduct.algorithm.pattern.Itemsets;
import com.example.paketproduct.databinding.FragmentBerandaBinding;
import com.example.paketproduct.model.BarangCreator;
import com.example.paketproduct.model.RuleCreator;

import java.io.IOException;

import lombok.SneakyThrows;

public class BerandaFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentBerandaBinding binding;
    private AlgoFPGrowth fpgrowth;
    private AssocRules rules;

    AutoCompleteTextView autoCompleteText;
    ArrayAdapter<String> adapterItem;

    @SneakyThrows
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentBerandaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        binding.rvRule.setVisibility(View.INVISIBLE);
        binding.tvHasil.setVisibility(View.INVISIBLE);
        binding.autoCompleteText.setVisibility(View.INVISIBLE);

        binding.btnRun.setOnClickListener(new View.OnClickListener() {
            @SneakyThrows
            @Override
            public void onClick(View v) {
                if (binding.inputMinsup.getText().toString().isEmpty() || binding.inputMinConf.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Minimum Support dan Minimum Confidence tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    double minsup = Double.parseDouble(binding.inputMinsup.getText().toString()) / 100 ;
                    double minconf = Double.parseDouble(binding.inputMinConf.getText().toString()) / 100 ;

                    runAlgorithm(minsup, minconf);
                    autoCompleteText = binding.autoCompleteText;
                    adapterItem = new ArrayAdapter<>(getContext(), R.layout.list_item, BarangCreator.getListBarangAsString(fpgrowth));
                    autoCompleteText.setAdapter(adapterItem);

                    autoCompleteText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @SneakyThrows
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String item = parent.getItemAtPosition(position).toString();

                            if (position == 1 || position == 3 || position == 6 || position == 7 || position == 8
                                    || position == 9 || position == 12 || position == 14 || position == 17 || position == 18
                                    || position == 20 || position == 24  ){
                                binding.tvHasil.setText("Tidak Ditemukan Kombinasi Paket Produk Ideal");
                                binding.tvHasil.setVisibility(View.VISIBLE);
                                binding.rvRule.setVisibility(View.VISIBLE);
                                setUpRv(item, fpgrowth, rules);
                            }else {
                                binding.tvHasil.setText("Hasil :");
                                binding.tvHasil.setVisibility(View.VISIBLE);
                                binding.rvRule.setVisibility(View.VISIBLE);

                                setUpRv(item, fpgrowth, rules);
                            }
                        }
                    });

                    binding.autoCompleteText.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setUpRv(String selectedItem, AlgoFPGrowth fpgrowth, AssocRules rules){
        LinearLayoutManager layoutManager =new LinearLayoutManager(getContext());
        RuleAdapter adapter = new RuleAdapter(RuleCreator.getAllRule(selectedItem, fpgrowth, rules), fpgrowth);
        RecyclerView recyclerView = binding.rvRule;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void runAlgorithm(double minsupp, double minconf) throws IOException {
        AssetManager assets = getContext().getAssets();

        // By changing the following lines to some other values
        // it is possible to restrict the number of items in the antecedent and
        // consequent of rules
        int maxAntecedentLength = 2;
        int maxConsequentLength = 1;

        // STEP 1: Applying the FP-GROWTH algorithm to find frequent itemsets
        fpgrowth = new AlgoFPGrowth();
        fpgrowth.setMaximumPatternLength(maxAntecedentLength + maxConsequentLength);
        Itemsets patterns = fpgrowth.runAlgorithm(assets, null, minsupp);
        int databaseSize = fpgrowth.getDatabaseSize();

        // STEP 2: Generating all rules from the set of frequent itemsets (based on Agrawal & Srikant, 94)
        double  minlift = 0;
        AlgoAgrawalFaster94 algoAgrawal = new AlgoAgrawalFaster94();
        algoAgrawal.setMaxConsequentLength(maxConsequentLength);
        algoAgrawal.setMaxAntecedentLength(maxAntecedentLength);
        // the next line run the algorithm.
        // Note: we pass null as output file path, because we don't want
        // to save the result to a file, but keep it into memory.
        rules = algoAgrawal.runAlgorithm(patterns,null, databaseSize, minconf, minlift);
    }
}