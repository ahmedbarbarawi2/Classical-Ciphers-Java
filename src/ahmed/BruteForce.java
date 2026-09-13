package ahmed;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BruteForce {
	static String[] characters1 = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			"r", "s", "t", "u", "v", "w", "x", "y", "z" };
	static ArrayList<Integer> ciphertext = new ArrayList<>();
	static ArrayList<Character> small_capital = new ArrayList<>();
	static int key;
	static ArrayList<Integer> BruteForce_ciphertext = new ArrayList<>();

	public static int mymod(int x, int y) {
		while (x >= 0 && y >= 0) {
			x = x % y;
			if (x < y) {
				return x;
			}
		}
		while (x < 0) {
			if (x < 0) {
				x += y;

			}

		}
		return x;
	}

	public static void readciphertextfromconsole(String text) {
		Scanner input = new Scanner(text);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c >= 97 && c <= 122) {
					int char_value = (int) c - 97;
					ciphertext.add(char_value);
					small_capital.add('s');
				} else if (c >= 65 && c <= 90) {
					int char_value = (int) c - 65;
					ciphertext.add(char_value);
					small_capital.add('c');

				} else {
					int char_value = (int) c;
					ciphertext.add(char_value);
					small_capital.add('n');

				}

			}
		}

	}

	public static void Attack_Console() {
		int key = 0;

		for (int j = 0; j < 26; j++) {
			for (int i = 0; i < ciphertext.size(); i++) {
				int ch = ciphertext.get(i);
				if (small_capital.get(i).equals('s')) {
					int charvalue = mymod(ciphertext.get(i) - key, 26);
					char c = (char) (charvalue + 'a');
					String s1 = String.valueOf(c);
					System.out.print(s1);
				}
				if (small_capital.get(i).equals('c')) {
					int charvalue = mymod(ciphertext.get(i) - key, 26);
					char c = (char) (charvalue + 'A');
					String s1 = String.valueOf(c);
					System.out.print(s1);
				}

				if (small_capital.get(i).equals('n')) {
					int charvalue = ciphertext.get(i);
					String s1 = String.valueOf((char) charvalue);
					System.out.print(s1);
				}

			}

			System.out.println("      KEY : " + key);
			key++;
		}

	}

	public static int postive(int shift) {
		for (int i = 0; i < 26; i++) {
			if (shift < 0)
				shift += 26;
			else
				return shift;
		}

		return 0;
	}

	public static void count_chars_ToFile() {
		int count = 0;
		int[] char_count = new int[26];
		char[] characters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		try {
			File file1 = new File(
					"C:\\Users\\ahmed\\eclipse-workspace\\q2\\src\\application\\cyber_project1\\src\\ciphertext.txt");
			Scanner input = new Scanner(file1);

			while (input.hasNextLine()) {

				String Line = input.nextLine();
				Line.toLowerCase();
				for (int i = 0; i < Line.length(); i++) {
					count++;
				}
				for (int i = 0; i < Line.length(); i++) {
					char c = Line.charAt(i);
					if (Character.isLetter(c)) {
						int element = c - 'a';
						if (element >= 0 && element < 26) {
							char_count[element]++;
						}

					}
				}

			}
			File file = new File(
					"C:\\Users\\ahmed\\eclipse-workspace\\q2\\src\\application\\cyber_project1\\src\\Analysis.txt");
			try (PrintWriter writer = new PrintWriter(file);) {

				int maxCount = 0;
				char maxChar = 'a';
				writer.println("The number of charchters: " + count);
				for (int i = 0; i < characters.length; i++) {

					double percentege = (double) char_count[i] / count;
					writer.println("the character: " + characters[i] + " the redundancy: " + char_count[i]
							+ " the percentege: " + (float) percentege * 100 + "%");
					if (char_count[i] > maxCount) {
						maxCount = char_count[i];
						maxChar = characters[i];

					}
				}
				writer.println("The max redundancy character is: " + maxChar + " : " + maxCount);

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void count_chars_ToConsole() {
		int count = 0;
		int[] char_count = new int[26];
		char[] characters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		try {
			File file1 = new File(
					"C:\\Users\\ahmed\\eclipse-workspace\\q2\\src\\application\\cyber_project1\\src\\ciphertext.txt");
			Scanner input = new Scanner(file1);

			while (input.hasNextLine()) {

				String Line = input.nextLine();
				Line.toLowerCase();
				for (int i = 0; i < Line.length(); i++) {
					count++;
				}
				for (int i = 0; i < Line.length(); i++) {
					char c = Line.charAt(i);
					if (Character.isLetter(c)) {
						int element = c - 'a';
						if (element >= 0 && element < 26) {
							char_count[element]++;
						}

					}
				}

			}
			int maxCount = 0;
			char maxChar = 'a';
			System.out.println("The number of charchters: " + count);
			for (int i = 0; i < characters.length; i++) {

				double percentege = (double) char_count[i] / count;
				System.out.println("the character: " + characters[i] + " the redundancy: " + char_count[i]
						+ " the percentege: " + (float) percentege * 100 + "%");
				if (char_count[i] > maxCount) {
					maxCount = char_count[i];
					maxChar = characters[i];

				}
			}
			System.out.println("The max redundancy character is: " + maxChar + " : " + maxCount);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}