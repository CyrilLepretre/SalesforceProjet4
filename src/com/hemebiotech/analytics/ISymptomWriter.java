package com.hemebiotech.analytics;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Write in a file the list of symptoms and how many times it occurs
 *
 * @author Cyril Lepretre
 * @version 1.0
 */
public interface ISymptomWriter {

    /**
     * @param map TreeMap with symptom as key, counter as walue
     * @return true if the file was correctly written, false else
     * @throws IOException if the file name was empty
     */
    Boolean writeSymptoms (TreeMap<String, Integer> map) throws IOException;
}
