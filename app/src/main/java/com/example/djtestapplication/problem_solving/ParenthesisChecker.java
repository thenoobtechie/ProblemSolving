package com.example.djtestapplication.problem_solving;


import android.util.Pair;

import java.util.*;

/* Online Java Compiler and Editor */
public class HelloWorld{

    static ArrayList<Competitor> competitors = new ArrayList<>();
//    static Pair<String, Integer> competitorsPair = new Pair<>();
    public static void main(String []args){
        System.out.println("Hello, World!");

        populateList(competitors);

        int size = competitors.size();
        int max = competitors.get(0).votes;
        String maxVoteId = competitors.get(0).id;
        for(int i = 1; i < size; i++) {

            int votes = competitors.get(i).votes;
            if(votes > max) {
                max = votes;
                maxVoteId = competitors.get(i).id;
            }
        }

        System.out.println("Max votes: Id: " + maxVoteId + ", With votes: " + max);
    }

    public static void populateList(ArrayList competitors) {

        for(int i=0; i<10; i++) {
            competitors.add(new Competitor("id:" + i, (int)(Math.random() * 100) + 1));
        }
    }
}
class Competitor {

    String id;
    int votes;

    public Competitor(String id, int votes) {
        this.id = id;
        this.votes = votes;
    }
}
