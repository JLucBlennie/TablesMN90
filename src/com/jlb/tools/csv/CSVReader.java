package com.jlb.tools.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	private static String SEPARATOR = ";";

	public static List<String[]> readFile(File file) throws IOException {

		List<String[]> result = new ArrayList<String[]>();

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		for (String line = br.readLine(); line != null; line = br.readLine()) {
			String[] readedLine = line.split(SEPARATOR);
			final int size = readedLine.length;
			if (size == 0) {
				continue;
			}

			String debut = readedLine[0].trim();
			if (debut.length() == 0 && size == 1) {
				continue;
			}
			if (debut.startsWith("#")) {
				continue;
			}
			result.add(readedLine);
		}

		br.close();
		fr.close();

		return result;
	}

}
