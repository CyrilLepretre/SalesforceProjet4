package com.hemebiotech.analytics;

/**
 * <b>Main class to launch the processing</b>
 *
 * @author Cyril Lepretre
 * @version 1.0
 */
public class AnalyticsCounter {
	public static void main(String args[]){
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomFileFromData("result.out");
		SymptomsCounter symptomsCounter = new SymptomsCounter();
		try{
			if (symptomsCounter.process(reader, writer)){
				System.out.println("Successful");
			} else{
				System.out.println("Error");
			}
		} catch (Exception e) {
			System.out.println("Error - " + e);
		}
	}
}
