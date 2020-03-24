package com.clavardage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.clavardage.app.CesarWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int lineCount = 1;

		FileWriter fileWriter = new FileWriter("./file.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();

			printWriter.write(lineCount + "| " + line + System.getProperty("line.separator"));
			CesarWriter cesarWriter = new CesarWriter(line);
			System.out.println(cesarWriter.defineNumberToCrypt(1).build().toString());
			System.out.println(lineCount + " " + line);

			lineCount += 1;
		}
		printWriter.close();
		System.out.println("Done");

	}

}