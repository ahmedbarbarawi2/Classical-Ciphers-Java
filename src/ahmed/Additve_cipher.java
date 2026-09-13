```java
package ahmed;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Additve_cipher {

	static ArrayList<Integer> plaintext = new ArrayList<>();
	static ArrayList<Integer> ciphertext = new ArrayList<>();
	static ArrayList<Character> small_capital = new ArrayList<>();
	static int key;

	public static int postive(int shift) {
		for (int i = 0; i < 26; i++) {
			if (shift < 0)
				shift += 26;
			else
				return shift;
		}

		return 0;
	}

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

	public static String read_seed() {
		String lastLine = "";

		try (Scanner scanner = new Scanner(new File("plaintext.txt"))) {
			while (scanner.hasNextLine()) {
				lastLine = scanner.nextLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lastLine;
	}

	public static int key_seed(String seed) {
		Random random = new Random(seed.hashCode());
		int key = random.nextInt(26);
		return key;
	}

	public static void readplaintext(String path) {
		if (path == "") {
			path = "plaintext.txt";
		}

		try {
			File file = new File(path);
			Scanner input = new Scanner(file);

			while (input.hasNextLine()) {
				String line = input.nextLine();

				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);

					if (c >= 97 && c <= 122) {
						int char_value = (int) c - 97;
						plaintext.add(char_value);
						small_capital.add('s');

					} else if (c >= 65 && c <= 90) {
						int char_value = (int) c - 65;
						plaintext.add(char_value);
						small_capital.add('c');

					} else {
						int char_value = (int) c;
						plaintext.add(char_value);
						small_capital.add('n');
					}
				}
			}

			input.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void readplaintextfromconsole(String text) {
		Scanner input = new Scanner(text);

		while (input.hasNextLine()) {
			String line = input.nextLine();

			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);

				if (c >= 97 && c <= 122) {
					int char_value = (int) c - 97;
					plaintext.add(char_value);
					small_capital.add('s');

				} else if (c >= 65 && c <= 90) {
					int char_value = (int) c - 65;
					plaintext.add(char_value);
					small_capital.add('c');

				} else {
					int char_value = (int) c;
					plaintext.add(char_value);
					small_capital.add('n');
				}
			}
		}
	}

	public static void readciphertext(String path) {
		try {
			if (path == "") {
				path = "ciphertext.txt";
			}

			File file = new File(path);
			Scanner input = new Scanner(file);

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

			input.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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

	public void encryptiontofile(String path) {
		if (path == "") {
			path = "ciphertext.txt";
		}

		File file = new File(path);

		try (PrintWriter writer = new PrintWriter(file)) {

			for (int i = 0; i < plaintext.size(); i++) {

				if (plaintext.get(i) < 26) {

					if (small_capital.get(i).equals('s')) {
						int charvalue = mymod(plaintext.get(i) + key, 26);
						char c = (char) (charvalue + 'a');
						String s1 = String.valueOf(c);
						writer.print(s1);
					}

					if (small_capital.get(i).equals('c')) {
						int charvalue = mymod(plaintext.get(i) + key, 26);
						char c = (char) (charvalue + 'A');
						String s1 = String.valueOf(c);
						writer.print(s1);
					}
				}

				if (small_capital.get(i).equals('n')) {
					int charvalue = plaintext.get(i);
					String s1 = String.valueOf((char) charvalue);
					writer.print(s1);
				}
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void encryptiontoConsole(int key, ArrayList<Integer> plaintext) {

		for (int i = 0; i < plaintext.size(); i++) {

			if (plaintext.get(i) < 26) {

				if (small_capital.get(i).equals('s')) {
					int charvalue = mymod(plaintext.get(i) + key, 26);
					char c = (char) (charvalue + 'a');
					String s1 = String.valueOf(c);
					System.out.print(s1);
				}

				if (small_capital.get(i).equals('c')) {
					int charvalue = mymod(plaintext.get(i) + key, 26);
					char c = (char) (charvalue + 'A');
					String s1 = String.valueOf(c);
					System.out.print(s1);
				}
			}

			if (small_capital.get(i).equals('n')) {
				int charvalue = plaintext.get(i);
				String s1 = String.valueOf((char) charvalue);
				System.out.print(s1);
			}
		}
	}

	public static void decryptiontofile(String path) {

		if (path == "") {
			path = "plaintext.txt";
		}

		File file = new File(path);

		try (PrintWriter writer = new PrintWriter(file)) {

			for (int i = 0; i < ciphertext.size(); i++) {

				if (ciphertext.get(i) < 26) {

					if (small_capital.get(i).equals('s')) {
						int charvalue = mymod(ciphertext.get(i) - key, 26);
						char c = (char) (charvalue + 'a');
						String s1 = String.valueOf(c);
						writer.print(s1);
					}

					if (small_capital.get(i).equals('c')) {
						int charvalue = mymod(ciphertext.get(i) - key, 26);
						char c = (char) (charvalue + 'A');
						String s1 = String.valueOf(c);
						writer.print(s1);
					}
				}

				if (small_capital.get(i).equals('n')) {
					int charvalue = ciphertext.get(i);
					String s1 = String.valueOf((char) charvalue);
					writer.print(s1);
				}
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void decryptiontoconsole(int key, ArrayList<Integer> ciphertext) {

		for (int i = 0; i < ciphertext.size(); i++) {

			if (ciphertext.get(i) < 26) {

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
			}

			if (small_capital.get(i).equals('n')) {
				int charvalue = ciphertext.get(i);
				String s1 = String.valueOf((char) charvalue);
				System.out.print(s1);
			}
		}
	}
}

