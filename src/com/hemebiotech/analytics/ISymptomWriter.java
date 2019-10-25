package com.hemebiotech.analytics;
import java.util.TreeMap;

/**
 * Write in a file the list of symptoms and how many times there are in the input file
 *
 *
 */
public interface ISymptomWriter {
    /**
     * @param TreeMap<String, Integer>, String
     * @return true if the file was correctly written, false else
     */

    Boolean writeSymptoms (TreeMap<String, Integer> map, String filePath);
}
