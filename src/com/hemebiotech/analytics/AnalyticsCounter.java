package com.hemebiotech.analytics;
import java.util.List;

public class AnalyticsCounter {
	public static void main(String args[]){
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> lines = reader.getSymptoms();
		Symptoms symptoms = new Symptoms(lines);
		//analyticsCounter.printSymptoms();
		WriteSymptomFileFromData writer = new WriteSymptomFileFromData();
		if (writer.writeSymptoms(symptoms.getSymptomsMap(),"result.out")){
			System.out.println("Success");
		} else {
			System.out.println("Error");
		}
	}
}
