package NumberGenerator;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGenerator {
	/**
	 * Generates the specified number of random integers, then writes the generated
	 * integers to the specified file.
	 * 
	 * @param	numEntries		the number of random integers to generate.
	 * @param	outputFileName 	the name of the file to which random integers are written.
	 * */
	public static void generateNumbersIntoFile(int numEntries, String outputFileName) {
		List<Integer> outputList = new ArrayList<>();
		Random rand = new Random();
		for(int i = 0; i < numEntries; i++) {
			outputList.add(rand.nextInt());
		}
		FileWriter outFile = null;
		try {
			try {
				outFile = new FileWriter(outputFileName);
				for(int i = 0; i < numEntries; i++) {
					outFile.write(outputList.get(i).toString());
					if(i < numEntries - 1) {
						outFile.write("\n");
					}
				}
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				outFile.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Takes a text file of randomly-generated integers, sorts them in ascending order,
	 * then outputs the sorted result into the specified output file.
	 * 
	 * @param	inputFileName	the file containing randomly-generated integers.
	 * @param	outputFileName	the name of the file to which sorted output is written.
	 * */
	public static void sortIntoNewFile(String inputFileName, String outputFileName) {
		File inputFile = null;
		List<Integer> resultsList = new ArrayList<>(); 
		try {
			inputFile = new File(inputFileName);
			Scanner sc = new Scanner(inputFile);
			while(sc.hasNextLine()) {
				resultsList.add(sc.nextInt());
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		resultsList.sort(null);
		FileWriter outFile = null;
		try {
			try {
				outFile = new FileWriter(outputFileName);
				for(Integer entry : resultsList) {
					outFile.write(entry.toString());
					outFile.write("\n");
				}
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				outFile.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printHelpMenu() {
		System.out.println("Usage:");
		System.out.println("-g [NUM_INTEGERS] [RANDOM_FILE] [SORTED_FILE]");
		System.out.println("Generates NUM_INTEGERS number of random integers, stored in new file RANDOM_FILE, where ");
		System.out.println("the new file SORTED_FILE contains the sorted output.");
		System.out.println("-e [RANDOM_FILE] [SORTED_FILE]");
		System.out.println("Reads from an existing RANDOM_FILE to create sorted output for new file SORTED_FILE.");
	}
	
	public static void main(String args[]) {
		if(args[0].equals("-g")) {
			int numEntries = Integer.parseInt(args[1]);
			String inputFileName = args[2];
			String outputFileName = args[3];
			generateNumbersIntoFile(numEntries, inputFileName);
			sortIntoNewFile(inputFileName, outputFileName);
		} else if(args[0].equals("-e")) {
			String inputFileName = args[1];
			String outputFileName = args[2];
			sortIntoNewFile(inputFileName, outputFileName);
		} else {
			System.out.println("Error: malformed arguments. Please try again");
			printHelpMenu();
		}
	}
}
