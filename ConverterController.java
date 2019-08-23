package com.karumien.conventer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConverterController {

	public static String readFileAsString(String fileName) throws Exception {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		return data;
	}
	
	public static String getBaseName(String fileName) {
	    int index = fileName.lastIndexOf('.');
	    if (index == -1) {
	        return fileName;
	    } else {
	        return fileName.substring(0, index);
	    }
	}
  
	public static void main(String[] args) throws Exception {
		String inputPath = args[0];
		String outputPath = args[1];

		Files.newDirectoryStream(Paths.get(inputPath), path -> path.toString().endsWith(".dta")).forEach(filePath -> {
			try {
				String data = readFileAsString(filePath.toString());
				data = data.replace("\t", ";");
				PrintWriter writer = new PrintWriter(new File(outputPath +"\\"+ getBaseName(filePath.getFileName().toString()) + ".csv"));
				writer.write(data);

			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		System.out.println("done!");
	}
}
