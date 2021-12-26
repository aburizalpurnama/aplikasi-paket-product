package com.example.paketproduct.algorithm.tools;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertFromTabular {

    private String input;
    private Map<Integer, String> initAndItem = new HashMap<>();
    private Map<String, Integer> itemAndInit = new HashMap<>();
    private List<List<Integer>> dataset = new ArrayList<>();

    public ConvertFromTabular() {
    }

    public ConvertFromTabular(AssetManager input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input.open("DataTrainingText.txt")));
        String line;
        List<List<Integer>> transaction = new ArrayList<>();

        //get atributes (header)
        String[] atributes = null;

        atributes = reader.readLine().split("	");
//		for (String atribute : atributes){
//			System.out.println(atribute);
//		}

        // for each line (transaction) until the end of file
        while( ((line = reader.readLine())!= null)) {
            // if the line is  a comment, is  empty or is a
            // kind of metadata
            int counter = 0;
            if (line.isEmpty() == true ||  line.charAt(0) == '#' || line.charAt(0) == '%' 	|| line.charAt(0) == '@') {
                continue;
            }

            // split the line into items
            String[] lineSplited = line.split("	");
//
//			for(var val : lineSplited){
//				System.out.print(val);
//			}
//			System.out.println();
            // convert binominal to list of items
            List<Integer> items = new ArrayList<>();
            for (int i = 0; i < lineSplited.length; i++) {
                initAndItem.put(i + 1,atributes[i]);
                itemAndInit.put(atributes[i], i + 1);
                if (lineSplited[i].equals("1")) {
                    items.add(i + 1);
                }
            }
            transaction.add(items);
        }

        this.dataset = transaction;
    }

    public static List<List<String>> convert(String input) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line;
        List<List<String>> transaction = new ArrayList<>();


        //get atributes (header)
        String[] atributes = null;

        atributes = reader.readLine().split("	");
//		for (String atribute : atributes){
//			System.out.println(atribute);
//		}

        // for each line (transaction) until the end of file
        while( ((line = reader.readLine())!= null)) {
            // if the line is  a comment, is  empty or is a
            // kind of metadata
            int counter = 0;

            if (line.isEmpty() == true ||  line.charAt(0) == '#' || line.charAt(0) == '%' 	|| line.charAt(0) == '@') {
                continue;
            }

            // split the line into items
            String[] lineSplited = line.split("	");
//
//			for(var val : lineSplited){
//				System.out.print(val);
//			}
//			System.out.println();
            // convert binominal to list of items
            List<String> items = new ArrayList<>();
            for (String itemString : lineSplited) {
                if (itemString.equals("1")) {
                    items.add(atributes[counter]);
//					System.out.println("item : " + itemString);
                }
                counter++;
            }
            transaction.add(items);
            counter++;
        }

        return transaction;
    }


    public List<List<Integer>> convertToInteger(String input) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line;
        List<List<Integer>> transaction = new ArrayList<>();

        //get atributes (header)
        String[] atributes = null;

        atributes = reader.readLine().split("	");
//		for (String atribute : atributes){
//			System.out.println(atribute);
//		}

        // for each line (transaction) until the end of file
        while( ((line = reader.readLine())!= null)) {
            // if the line is  a comment, is  empty or is a
            // kind of metadata
            int counter = 0;
            if (line.isEmpty() == true ||  line.charAt(0) == '#' || line.charAt(0) == '%' 	|| line.charAt(0) == '@') {
                continue;
            }

            // split the line into items
            String[] lineSplited = line.split("	");
//
//			for(var val : lineSplited){
//				System.out.print(val);
//			}
//			System.out.println();
            // convert binominal to list of items
            List<Integer> items = new ArrayList<>();
            for (int i = 0; i < lineSplited.length; i++) {
                initAndItem.put(i + 1,atributes[i]);
                if (lineSplited[i].equals("1")) {
                    items.add(i + 1);
                }
            }
            transaction.add(items);
        }

        return transaction;
    }

    public List<List<Integer>> getDataset() {
        return dataset;
    }

    public Map<Integer, String> getInitAndItem(){
        return initAndItem;
    }

    public Map<String, Integer> getItemAndInit() {
        return itemAndInit;
    }
}
