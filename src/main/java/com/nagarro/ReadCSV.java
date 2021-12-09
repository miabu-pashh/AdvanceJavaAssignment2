package com.nagarro;

import java.io.File;


/**
 * The Class ReadCSV.
 */
public class ReadCSV extends Thread {
	
	/**
	 * Read csv from folder.
	 *
	 * @return the file[]
	 */
	public File[] readCsvFromFolder() {
		final String ROOT_FILE_PATH = "C:\\Users\\mohammadpasha\\OneDrive - Nagarro\\Documents\\java files\\Asignment5-Advance Java\\Assigment Links\\Assigment Links";
		File f = new File(ROOT_FILE_PATH);
		File[] allSubFiles = f.listFiles();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
		;
		return allSubFiles;
	}

}
