package com.example.geektrustproblems;


import java.io.File;
import java.io.FileNotFoundException;

public class GeektrustProblems {

	public static void main(String[] args) {
		GeektrustProblems geektrustProblems = new GeektrustProblems();
		String filePath = args[0];
		try {
			geektrustProblems.initFileToProcess(filePath);
		} catch (Exception e){
			System.out.printf("Interrupted due to exception: %s%n",e.getStackTrace());
		}
	}

	public void initFileToProcess(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		FileProcessor fileProcessor = new FileProcessor();
		fileProcessor.processInputFile(file);
	}

}
