package com.example.paketproduct.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.paketproduct.algorithm.association.AssocRules;
import com.example.paketproduct.algorithm.fpgrowth.AlgoFPGrowth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RuleCreator {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<Rule> getRules(String item, AlgoFPGrowth fpgrowth, AssocRules rules){
        List<Rule> ruleList = new ArrayList<>();
        Map<String, Integer> itemAndInitial = fpgrowth.getItemAndInit();
        Integer selectedItem = itemAndInitial.get(item);
        List<com.example.paketproduct.algorithm.association.Rule> allRule = rules.getAllRule();

        for (int i = 1; i <= itemAndInitial.size(); i++) {
            if (selectedItem == i){

            }
        }
        switch (item){
            case "Normal Key" :
                ruleList.add(new Rule.RuleBuilder("Normal Key",
                        "Swing Lockcase",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Normal Key dan Lever handle, semuanya juga membeli Swing Lockcase" )
                        .premise2("Lever Handle").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Accessories",
                        8.333,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Normal Key, 8 diantaranya juga membeli Accessories")
                        .premise2("Normal Key").build());
                break;

            case "Lever Handle" :
                ruleList.add(new Rule.RuleBuilder("Accessories",
                        "Swing Lockcase",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Accessories dan Lever handle, semuanya juga membeli Swing Lockcase")
                        .premise2("Lever Handle").build());

                ruleList.add(new Rule.RuleBuilder("Computer Key",
                        "Swing Lockcase",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Computer Key dan Lever Handle, semuanya juga membeli Swing Lockcase")
                        .premise2("Lever Handle").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Lever Handle",
                        0.833,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Swing Lockcase, 8 diantaranya juga membeli Lever Handle")
                        .premise2("Swing Lockcase").build());

                ruleList.add(new Rule.RuleBuilder(
                        "Lever Handle",
                        "Swing Lockcase",
                        0.813,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Lever Handle, 8 diantaranya juga membeli Swing Lockcase")
                        .build());

                ruleList.add(new Rule.RuleBuilder("Normal Key",
                        "Swing Lockcase",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Normal Key dan Lever Handle, semuanya juga membeli Swing Lockcase")
                        .premise2("Lever Handle").build());
                break;

            case "Swing Lockcase" :
                ruleList.add(new Rule.RuleBuilder("Normal key",
                        "Swing Lockcase",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Normal Key dan Lever Handle, semuanya juga membeli Swing Lockcase")
                        .premise2("Lever Handle").build());

                ruleList.add(new Rule.RuleBuilder("Push & Pull Handle",
                        "Acessories",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Push & Pull Handle dan Swing Lockcase, semuanya juga membeli Accessories")
                        .premise2("Swing Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Accessories",
                        "Swing Lockcase",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Accessories dan Lever Handle, semuanya juga membeli Swing Lockcase")
                        .premise2("Lever Handle").build());

                ruleList.add(new Rule.RuleBuilder("Computer Key",
                        "Swing Lockcase",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Computer Key dan Lever Handle, semuanya juga membeli Swing Lockcase")
                        .premise2("Lever Handle").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Lever Handle",
                        0.833,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Swing Lockcase, 8 diantaranya juga membeli Lever Handle")
                        .premise2("Swing Lockcase").build());

                ruleList.add(new Rule.RuleBuilder(
                        "Lever Handle",
                        "Swing Lockcase",
                        0.813,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Lever Handle, 8 diantaranya juga membeli Swing Lockcase")
                        .build());
                break;

            case "Push & Pull Handle" :
                ruleList.add(new Rule.RuleBuilder("Push & Pull Handle",
                        "Acessories",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Push & Pull Handle dan Swing Lockcase, semuanya juga membeli Accessories")
                        .premise2("Swing Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Handle Set",
                        "Push & Pull Handle",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Handle Set dan Roller Lockcase, semuanya juga membeli Push & Pull Handle")
                        .premise2("Roller Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Push & Pull Handle",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Roller Lockcase, semuanya juga membeli Push & Pull Handle")
                        .premise2("Roller Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Accessories",
                        "Push & Pull Handle",
                        0.9,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Accessories dan Computer Key, 9 diantaranya juga membeli Push & Pull Handle")
                        .premise2("Computer Key").build());

                ruleList.add(new Rule.RuleBuilder("Roller Lockcase",
                        "Push & Pull Handle",
                        0.889,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Roller Lockcase dan Computer Key, 8 diantaranya juga membeli Push & Pull Handle")
                        .premise2("Computer Key").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Accessories",
                        0.875,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Push & Pull Handle, 8 diantaranya juga membeli Accessories")
                        .premise2("Push & Pull Handle").build());

                ruleList.add(new Rule.RuleBuilder("Push & Pull Handle",
                        "Accessories",
                        0.833,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Push & Pull Handle dan Roller Lockcase, 8 diantaranya juga membeli Accessories")
                        .premise2("Roller Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Push & Pull Handle",
                        "Accessories",
                        0.818,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Push & Pull Handle dan Computer Key, 8 diantaranya juga membeli Accessories")
                        .premise2("Computer Key").build());
                break;

            case "Accessories" :
                ruleList.add(new Rule.RuleBuilder("Push & Pull Handle",
                        "Acessories",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Push & Pull Handle dan Swing Lockcase, semuanya juga membeli Accessories")
                        .premise2("Swing Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Acessories",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Roller Lockcase, semuanya juga membeli Accessories")
                        .premise2("Roller Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Accessories",
                        0.875,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Push & Pull Handle, 8 diantaranya juga membeli Accessories")
                        .premise2("Push & Pull Handle").build());

                ruleList.add(new Rule.RuleBuilder("Push & Pull Handle",
                        "Accessories",
                        0.833,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Push & Pull Handle dan Roller Lockcase, 8 diantaranya juga membeli Accessories")
                        .premise2("Roller Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Handle Set",
                        "Accessories",
                        0.833,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Push & Pull Handle dan Roller Lockcase, 8 diantaranya juga membeli Accessories")
                        .premise2("Roller Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Accessories",
                        8.333,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Normal Key, 8 diantaranya juga membeli Accessories")
                        .premise2("Normal Key").build());

                ruleList.add(new Rule.RuleBuilder("Push & Pull Handle",
                        "Accessories",
                        0.818,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Push & Pull Handle dan Computer Key, 8 diantaranya juga membeli Accessories")
                        .premise2("Computer Key").build());

                ruleList.add(new Rule.RuleBuilder("Roller Lockcase",
                        "Accessories",
                        0.778,
                        "Kombinasi barang ini cukup ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Push & Pull Handle dan Computer Key, 7 diantaranya juga membeli Accessories")
                        .premise2("Computer Key").build());

                ruleList.add(new Rule.RuleBuilder("Accessories",
                        "Push & Pull Handle",
                        0.9,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Accessories dan Computer Key, 9 diantaranya juga membeli Push & Pull Handle")
                        .premise2("Computer Key").build());
                break;

            case "Handle Set" :
                ruleList.add(new Rule.RuleBuilder("Handle Set",
                        "Push & Pull Handle",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Handle Set dan Roller Lockcase, semuanya juga membeli Push & Pull Handle")
                        .premise2("Roller Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Cylindrical Handle",
                        "Handle Set",
                        0.833,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Handle Set dan Roller Lockcase, 8 diantaranya juga membeli Push & Pull Handle")
                        .build());

                ruleList.add(new Rule.RuleBuilder("Handle Set",
                        "Accessories",
                        0.833,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Push & Pull Handle dan Roller Lockcase, 8 diantaranya juga membeli Accessories")
                        .premise2("Roller Lockcase").build());
                break;

            case "Roller Lockcase" :
                ruleList.add(new Rule.RuleBuilder("Handle Set",
                        "Push & Pull Handle",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Handle Set dan Roller Lockcase, semuanya juga membeli Push & Pull Handle")
                        .premise2("Roller Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Acessories",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Roller Lockcase, semuanya juga membeli Accessories")
                        .premise2("Roller Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Push & Pull Handle",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Roller Lockcase, semuanya juga membeli Push & Pull Handle")
                        .premise2("Roller Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Handle Set",
                        "Accessories",
                        0.833,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Push & Pull Handle dan Roller Lockcase, 8 diantaranya juga membeli Accessories")
                        .premise2("Roller Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Roller Lockcase",
                        "Accessories",
                        0.778,
                        "Kombinasi barang ini cukup ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Push & Pull Handle dan Computer Key, 7 diantaranya juga membeli Accessories")
                        .premise2("Computer Key").build());

                ruleList.add(new Rule.RuleBuilder("Roller Lockcase",
                        "Push & Pull Handle",
                        0.889,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Roller Lockcase dan Computer Key, 8 diantaranya juga membeli Push & Pull Handle")
                        .premise2("Computer Key").build());
                break;

            case "Shelves" :

            case "Bracket" :
                ruleList.add(new Rule.RuleBuilder("Shelves",
                        "Bracket",
                        0.778,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Shelves dan Bracket, semuanya juga membeli Accessories")
                        .premise2("Computer Key").build());

                break;

            case "Hinges" :
                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Acessories",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Roller Lockcase, semuanya juga membeli Accessories")
                        .premise2("Roller Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Push & Pull Handle",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Roller Lockcase, semuanya juga membeli Push & Pull Handle")
                        .premise2("Roller Lockcase").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Accessories",
                        0.875,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Push & Pull Handle, 8 diantaranya juga membeli Accessories")
                        .premise2("Push & Pull Handle").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Accessories",
                        8.333,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Normal Key, 8 diantaranya juga membeli Accessories")
                        .premise2("Normal Key").build());

                ruleList.add(new Rule.RuleBuilder("Hinges",
                        "Lever Handle",
                        0.833,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Hinges dan Swing Lockcase, 8 diantaranya juga membeli Lever Handle")
                        .premise2("Swing Lockcase").build());
                break;

            case "Computer Key" :
                ruleList.add(new Rule.RuleBuilder("Computer Key",
                        "Swing Lockcase",
                        1.0,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Computer Key dan Lever Handle, semuanya juga membeli Swing Lockcase")
                        .premise2("Lever Handle").build());

                ruleList.add(new Rule.RuleBuilder("Accessories",
                        "Push & Pull Handle",
                        0.9,
                        "Kombinasi barang ini sangat ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Accessories dan Computer Key, 9 diantaranya juga membeli Push & Pull Handle")
                        .premise2("Computer Key").build());

                ruleList.add(new Rule.RuleBuilder("Roller Lockcase",
                        "Push & Pull Handle",
                        0.889,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Roller Lockcase dan Computer Key, 8 diantaranya juga membeli Push & Pull Handle")
                        .premise2("Computer Key").build());

                break;

            case "Cylindrical Handle" :
                ruleList.add(new Rule.RuleBuilder("Cylindrical Handle",
                        "Handle Set",
                        0.833,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Cylindrical Handle, 8 diantaranya juga membeli Handle Set")
                        .build());
                break;

            case "Screws" :

            case "Nuts, Bolts & Spacer" :
                ruleList.add(new Rule.RuleBuilder("Screws",
                        "Nuts, Bolts & Spacer",
                        0.833,
                        "Kombinasi barang ini ideal untuk dijadikan paket penjualan karena dari 10 pelanggan yang membeli Screws, 8 diantaranya juga membeli Nuts, Bolts & Spacer")
                        .build());
                break;
        }

        return ruleList;
    }

    public static List<com.example.paketproduct.algorithm.association.Rule> getAllRule(String item, AlgoFPGrowth fpGrowth, AssocRules rules){
        List<com.example.paketproduct.algorithm.association.Rule> ruleList = new ArrayList<>();
        Map<String, Integer> itemAndInitial = fpGrowth.getItemAndInit();
        List<com.example.paketproduct.algorithm.association.Rule> allRule = rules.getAllRule();
        Integer selectedItem = itemAndInitial.get(item);

        for (int i = 1; i <= itemAndInitial.size(); i++) {
            if (selectedItem == i){
                for (com.example.paketproduct.algorithm.association.Rule rule : allRule){
                    final int[] antecedent = rule.getItemset1();
                    final int[] consequent = rule.getItemset2();
                    for (int j = 0; j < antecedent.length; j++) {
                        if (antecedent[j] == i){
                            ruleList.add(rule);
                        }
                    }
                    for (int k = 0; k < consequent.length; k++){
                        if (consequent[k] == i){
                            ruleList.add(rule);
                        }
                    }
                }
            }
        }

//        for (int i = 1; i <= itemAndInitial.size(); i++) {
//            if (selectedItem == i){
//                for (com.example.paketproduct.algorithm.association.Rule rule : allRule){
//                    final int[] antecedent = rule.getItemset1();
//                    final int[] consequent = rule.getItemset2();
//                    for (int j = 0; j < antecedent.length; j++) {
//                        if (antecedent[j] == i){
//                            for (int x : antecedent){
//                                ruleList.add(rule);
//                            }
//                            for (int y : consequent){
//                                ruleList.add(rule);
//                            }
//                        }
//                    }
//                    for (int k = 0; k < consequent.length; k++){
//                        if (consequent[k] == i){
//                            for (int x : antecedent){
//                                ruleList.add(rule);
//                            }
//                            for (int y : consequent){
//                                ruleList.add(rule);
//                            }
//                        }
//                    }
//                }
//            }
//        }

        return ruleList;
    }
}
