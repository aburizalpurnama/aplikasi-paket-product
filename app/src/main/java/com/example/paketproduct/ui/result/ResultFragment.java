package com.example.paketproduct.ui.result;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.paketproduct.R;
import com.example.paketproduct.adapter.RuleAdapter;
import com.example.paketproduct.algorithm.association.AssocRules;
import com.example.paketproduct.algorithm.association.ParcelableAssocResult;
import com.example.paketproduct.algorithm.fpgrowth.AlgoFPGrowth;
import com.example.paketproduct.databinding.FragmentResultBinding;
import com.example.paketproduct.model.BarangCreator;
import com.example.paketproduct.model.RuleCreator;

import lombok.SneakyThrows;


public class ResultFragment extends Fragment {

    private FragmentResultBinding binding;

    private ParcelableAssocResult resultRules;

    private AutoCompleteTextView autoCompleteText;
    private ArrayAdapter<String> adapterItem;

    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        assert getArguments() != null;
        resultRules = ResultFragmentArgs.fromBundle(getArguments()).getResultRules();
        binding = FragmentResultBinding.inflate(inflater, container, false);

        AlgoFPGrowth fpgrowth = resultRules.getFpGrowth();
        AssocRules rules = resultRules.getRules();

        autoCompleteText = binding.autoCompleteText;
        adapterItem = new ArrayAdapter<>(getContext(), R.layout.list_item, BarangCreator.getListBarangAsString(fpgrowth));
        autoCompleteText.setAdapter(adapterItem);

        autoCompleteText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @SneakyThrows
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                setUpRv(item, fpgrowth, rules);
                binding.rvRule.setVisibility(View.VISIBLE);
            }
        });

        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setUpRv(String selectedItem, AlgoFPGrowth fpgrowth, AssocRules rules){
        LinearLayoutManager layoutManager =new LinearLayoutManager(getContext());
        RuleAdapter adapter = new RuleAdapter(RuleCreator.getAllRule(selectedItem, fpgrowth, rules), fpgrowth);
        RecyclerView recyclerView = binding.rvRule;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}