package com.hemebiotech.analytics;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.io.FileWriter;

/**
 * <b>Writer class</b>
 * Implements ISymptomWriter interface
 *
 * @author Cyril Lepretre
 * @version 1.0
 */

public class WriteSymptomFileFromData implements ISymptomWriter{
    private String filepath;

    /**
     * Constructor
     *
     * @param filepath a full or partial path to file to write the results
     */
    public WriteSymptomFileFromData (String filepath) {
        this.filepath = filepath;
    }

    /**
     * Writing of results in a output file
     *
     * @param symptomsMap TreeMap result
     * @return true if the output file was correctly written, false else
     */
    @Override
    public Boolean writeSymptoms(TreeMap<String, Integer> symptomsMap) throws IOException{
        boolean result = true;
        if ((this.filepath != null)&&(this.filepath != "")) {
            try {
                if (symptomsMap != null){
                    FileWriter writer = new FileWriter (this.filepath);
                    Set<Map.Entry<String, Integer>> setsymptomsMap = symptomsMap.entrySet();
                    Iterator<Map.Entry<String, Integer>> iterator = setsymptomsMap.iterator();
                    while(iterator.hasNext()){
                        Map.Entry<String, Integer> symptomLine = iterator.next();
                        writer.write(symptomLine.getKey() + " : " + symptomLine.getValue() + "\n");
                    }
                    writer.close();
                    result = true;
                } else{
                    System.out.println("SymptomsCounter list empty");
                    result = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new IOException("No ouput file indicated");
        }
        return result;
    }
}
