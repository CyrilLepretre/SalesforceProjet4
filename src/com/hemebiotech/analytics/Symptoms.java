package com.hemebiotech.analytics;
import java.util.TreeMap;
import java.util.List;

public class Symptoms {

    // TreeMap used to store symptoms and counter. It provides logical order when browsed
    private TreeMap<String, Integer> symptomsMap;

    public Symptoms(List<String> lines){
        try {
            this.symptomsMap = new TreeMap<String, Integer>();
            for (String line:lines){
                if (!this.symptomsMap.containsKey(line)){
                    // If the symptom is not in the TreeMap yet, symptom added with counter 1
                    this.symptomsMap.put(line,1);
                } else{
                    // If the symptom is already in the TreeMap, we add 1 to the counter
                    this.symptomsMap.replace(line,symptomsMap.get(line)+1);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public TreeMap<String, Integer> getSymptomsMap(){
        return this.symptomsMap;
    }
}
