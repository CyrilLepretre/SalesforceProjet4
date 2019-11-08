package com.hemebiotech.analytics;
import java.io.IOException;
import java.util.TreeMap;
import java.util.List;

/**
 * <b>Business logic class</b>
 *
 * @author Cyril Lepretre
 * @version 1.0
 */

public class SymptomsCounter {

    /**
     * Processing in 3 steps :
     * <ul>
     *     <li>Get the list of symptoms from the reader</li>
     *     <li>Generate the TreeMap of results calling the generateSymptomsList method</li>
     *     <li>Print the results in the output using the writer</li>
     * </ul>
     * @param reader the reader
     * @param writer the writer
     * @return true if the processing is OK and false else
     * @throws IOException if the file name of input or output is empty
     */
    public Boolean process(ISymptomReader reader, ISymptomWriter writer) throws IOException{
        Boolean result = false;
        try {
            List<String> lines = reader.getSymptoms();
            TreeMap<String, Integer> resultMap = this.generateSymptomsList(lines);
            result = (writer.writeSymptoms(resultMap));
        } catch (IOException e){
            throw new IOException(e);
        }
        return result;
    }

    /**
     * Generate a TreeMap based on a list of Strings, each string corresponds to a symptom
     * Use of TreeMap allow an automatic logical (alphabetical order) rendering of results
     * For each symptom :
     * <ul>
     *     <li>If the symptom is not in the TreeMap yet, symptom added with counter 1</li>
     *     <li>If the symptom already exists in the TreeMap, we add 1 to the counter of this symptom</li>
     * </ul>
     * @param lines A list of symptom (as strings)
     * @return La réponse valide
     */

    private TreeMap<String, Integer> generateSymptomsList(List<String> lines){
        TreeMap<String, Integer> symptomsMap = new TreeMap<>();
        try {
            symptomsMap = new TreeMap<String, Integer>();
            for (String line:lines){
                if (!symptomsMap.containsKey(line)){
                    symptomsMap.put(line,1);
                } else{
                    symptomsMap.replace(line,symptomsMap.get(line)+1);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return symptomsMap;
    }
}
