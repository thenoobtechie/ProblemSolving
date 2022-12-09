package com.example.djtestapplication.problem_solving;

import java.util.ArrayList;
import java.util.TreeMap;

public class Test {


    public static ArrayList<Integer> main(int arr[], int n) {
        ArrayList<Integer> results = new ArrayList<>();

        TreeMap<Integer, Boolean> map = new TreeMap<>();

        for(int i=0; i<n; i++) {

            if(map.containsKey(arr[i])) {
                if(!map.get(arr[i])) {
                    map.put(arr[i], true);
                }
            }
            else {
                map.put(arr[i], false);
            }
        }


        Integer[] keyset = map.keySet().toArray(new Integer[0]);
        for(int i=0; i < keyset.length; i++) {
            if(map.get(keyset[i])) {
                results.add(keyset[i]);
            }
        }

        if(results.isEmpty()) results.add(-1);
        return results;
    }
}
