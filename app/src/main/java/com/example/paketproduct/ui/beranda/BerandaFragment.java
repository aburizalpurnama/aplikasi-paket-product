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
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paketproduct.R;
import com.example.paketproduct.adapter.RuleAdapter;
import com.example.paketproduct.algorithm.association.AlgoAgrawalFaster94;
import com.example.paketproduct.algorithm.association.AssocRules;
import com.example.paketproduct.algorithm.association.ParcelableAssocResult;
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

        binding.btnRun.setOnClickListener(new View.OnClickListener() {
            @SneakyThrows
            @Override
            public void onClick(View v) {
                if (binding.inputMinsup.getText().toString().isEmpty() || binding.inputMinConf.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Minimum Support dan Minimum Confidence tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    double minsup = Double.parseDouble(binding.inputMinsup.getText().toString()) / 100 ;
                    double minconf = Double.parseDouble(binding.inputMinConf.getText().toString()) / 100 ;

                    ParcelableAssocResult assocResult = runAlgorithm(minsup, minconf);

                    NavDirections action = BerandaFragmentDirections.actionNavBerandaToResultFragment(assocResult);
                    Navigation.findNavController(requireView()).navigate(action);
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private ParcelableAssocResult runAlgorithm(double minsupp, double minconf) throws IOException {
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

        return new ParcelableAssocResult(fpgrowth, rules);
    }
}