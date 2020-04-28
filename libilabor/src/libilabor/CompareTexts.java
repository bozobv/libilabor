package libilabor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompareTexts {
	public void compare() throws IOException {
		BufferedReader reader1 = new BufferedReader(new FileReader("C:\file1.txt"));
		BufferedReader reader2 = new BufferedReader(new FileReader("C:\file2.txt"));
		String line1 = reader1.readLine();
		String line2 = reader2.readLine();
		boolean areEqual = true;
		int lineNum = 1;

		while (line1 != null || line2 != null) {
			if (line1 == null || line2 == null) {
				areEqual = false;

				break;
			} else if (!line1.equalsIgnoreCase(line2)) {
				areEqual = false;

				break;
			}

			line1 = reader1.readLine();

			line2 = reader2.readLine();

			lineNum++;
		}

		if (areEqual) {
			System.out.println("Nincsen elteres.");
		} else {
			System.out.println("A ket fajlban elteres van a kovetkezo sorban:" + lineNum);

			System.out.println("File1 tartalma: " + line1 +"\n"+ " File2 tartalma: " + line2 +"\n"+ "Sorszam: " + lineNum);
		}

		reader1.close();
		reader2.close();
	}
}
