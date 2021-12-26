package com.example.paketproduct.ui.barang;

import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paketproduct.adapter.BarangAdapter;
import com.example.paketproduct.algorithm.association.AlgoAgrawalFaster94;
import com.example.paketproduct.algorithm.association.AssocRules;
import com.example.paketproduct.algorithm.fpgrowth.AlgoFPGrowth;
import com.example.paketproduct.algorithm.pattern.Itemsets;
import com.example.paketproduct.databinding.FragmentBarangBinding;
import com.example.paketproduct.model.BarangCreator;

import java.io.UnsupportedEncodingException;
import java.net.URL;

import lombok.SneakyThrows;

public class BarangFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentBarangBinding binding;
    private AlgoFPGrowth fpgrowth;
    private AssocRules rules;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SneakyThrows
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentBarangBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        String input = "/D:/AndroidStudioProjects/paket-produk/app/src/main/resDataTrainingText.txt";
        AssetManager assets = getContext().getAssets();

        // By changing the following lines to some other values
        // it is possible to restrict the number of items in the antecedent and
        // consequent of rules
        int maxAntecedentLength = 2;
        int maxConsequentLength = 1;

        // STEP 1: Applying the FP-GROWTH algorithm to find frequent itemsets
        double minsupp = 0.03;
        fpgrowth = new AlgoFPGrowth();
        fpgrowth.setMaximumPatternLength(maxAntecedentLength + maxConsequentLength);
        Itemsets patterns = fpgrowth.runAlgorithm(assets, null, minsupp);
        int databaseSize = fpgrowth.getDatabaseSize();

        // STEP 2: Generating all rules from the set of frequent itemsets (based on Agrawal & Srikant, 94)
        double  minlift = 0;
        double  minconf = 0.75;
        AlgoAgrawalFaster94 algoAgrawal = new AlgoAgrawalFaster94();
        algoAgrawal.setMaxConsequentLength(maxConsequentLength);
        algoAgrawal.setMaxAntecedentLength(maxAntecedentLength);
        // the next line run the algorithm.
        // Note: we pass null as output file path, because we don't want
        // to save the result to a file, but keep it into memory.
        rules = algoAgrawal.runAlgorithm(patterns,null, databaseSize, minconf, minlift);

        setUpRv(fpgrowth);

        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setUpRv(AlgoFPGrowth fpgrowth){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        BarangAdapter adapter = new BarangAdapter(BarangCreator.getListBarang(fpgrowth));

        RecyclerView recyclerView = binding.rvBarang;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public static String fileToPath(String filename) throws UnsupportedEncodingException {
        URL url = BarangFragment.class.getResource(filename);
        if (url != null){
            return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
        }
        throw new UnsupportedEncodingException("File Tidak Ditemukan !");
    }
}