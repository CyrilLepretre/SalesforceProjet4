package com.hemebiotech.analytics;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.io.FileWriter;

public class WriteSymptomFileFromData implements ISymptomWriter{

    @Override
    public Boolean writeSymptoms(TreeMap<String, Integer> symptomsMap, String filePath){
        boolean result = true;
        if (filePath != null) {
            try {
                if (symptomsMap != null){
                    FileWriter writer = new FileWriter (filePath);
                    Set<Map.Entry<String, Integer>> setsymptomsMap = symptomsMap.entrySet();
                    Iterator<Map.Entry<String, Integer>> iterator = setsymptomsMap.iterator();
                    while(iterator.hasNext()){
                        Map.Entry<String, Integer> symptomLine = iterator.next();
                        writer.write(symptomLine.getKey() + " : " + symptomLine.getValue() + "\n");
                    }
                    writer.close();
                    result = true;
                } else{
                    System.out.println("Symptoms list empty");
                    result = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            result = false;
        }
        return result;
    }
}
