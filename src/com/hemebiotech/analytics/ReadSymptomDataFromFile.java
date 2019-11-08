package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Writing of results in a output file
	 * Browse the file, line by line and generates a list of string where each string corresponds to a line
	 *
	 * @return A list of string, each string is a symptom
	 */
	@Override
	public List<String> getSymptoms() throws IOException{
		ArrayList<String> result = new ArrayList<String>();

		if ((filepath != null)&&(filepath != "")) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				throw new IOException("File "+filepath+" not found or error while reading it");
			}
		} else {
			throw new IOException("No input file indicated");
		}

		return result;
	}

}
