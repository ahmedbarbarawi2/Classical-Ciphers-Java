package ahmed;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Vigenere {
	static ArrayList<Integer> plaintext = new ArrayList<>();
	static ArrayList<Integer> ciphertext = new ArrayList<>();
	static ArrayList<Integer> Key = new ArrayList<>();

	public static String read_seed() {
		String lastLine = "";
		try (Scanner scanner = new Scanner(new File(
				"C:\\Users\\ahmed\\eclipse-workspace\\q2\\src\\application\\Cyber_Projectone\\plaintext.txt"))) {
			while (scanner.hasNextLine()) {
				lastLine = scanner.nextLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lastLine;
	}

	public static void key_manage(String keyy) {
		int key_length = keyy.length();
		keyy=keyy.toLowerCase();
		if (plaintext.size() > 0) {
			for (int i = 0; i < plaintext.size(); i++) {
				Key.add(((int) keyy.charAt(i % key_length)-'a'));
			}

		} else {
			for (int i = 0; i < ciphertext.size(); i++) {
				Key.add((int) (keyy.charAt(i % key_length) -'a'));
			}
		}

	}

	public static void readplaintext(String path) {
		if (path=="") {
			path = "C:\\Users\\ahmed\\eclipse-workspace\\q2\\src\\application\\Cyber_Projectone\\plaintext.txt";
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
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void readplaintextfromconsole(String text) {
		text.toLowerCase();
		Scanner input = new Scanner(text);
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c >= 97 && c <= 122) {
					int char_value = (int) c - 97;
					plaintext.add(char_value);
				}
			}

			
		}

	}

	public static void readciphertext(String path) {
		if (path=="") {
			path = "C:\\Users\\ahmed\\eclipse-workspace\\q2\\src\\application\\Cyber_Projectone\\ciphertext.txt";
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
						ciphertext.add(char_value);
					}

				}
			}

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
				} 

			}
		}

	}

	public void encryptiontofile (String path)  {
		if (path=="") {
			path = "C:\\Users\\ahmed\\eclipse-workspace\\q2\\src\\application\\Cyber_Projectone\\ciphertext.txt";
		}
		File file = new File(path);
		try (PrintWriter writer = new PrintWriter(file);) {
			for (int i=0;i<plaintext.size();i++) {
				char cipher =(char)( mymod((plaintext.get(i)+Key.get(i)),26)+'a');
				writer.write(cipher);
				
			}
		
	} catch (IOException e) {
		System.out.println(e.getMessage());
	
	
	}
		
	}

	public void encryptiontoconsol ()  {
			for (int i=0;i<plaintext.size();i++) {
				char cipher = (char)(mymod((plaintext.get(i)+Key.get(i)),26)+'a');
				System.out.print(cipher);
				
			}
		
	
	}
		
	public void decryptiontofile (String path)  {
		if (path=="") {
			path = "C:\\Users\\ahmed\\eclipse-workspace\\q2\\src\\application\\Cyber_Projectone\\plaintext.txt";
		}
		File file = new File(path);
		try (PrintWriter writer = new PrintWriter(file);) {
			for (int i=0;i<plaintext.size();i++) {
				char cipher =(char)( mymod((ciphertext.get(i)-Key.get(i)),26)+'a');
				writer.write(cipher);
				
			}
		
	} catch (IOException e) {
		System.out.println(e.getMessage());
	
	
	}
		
	}

	public void decryptiontoconsol ()  {
			for (int i=0;i<plaintext.size();i++) {
				char cipher = (char)(mymod((ciphertext.get(i)-Key.get(i)),26)+'a');
				System.out.print(cipher);
				
			}
		
	
	}
		
 

	public static int mymod (int x , int y) {	
	while(x>=0&&y>=0) {
		x=x%y;
		if (x<y) {
		return x ;
		}
	}
	while(x<0) {
	if (x<0) {
		x+=y;
		
	}
	
	}
	return x;
}

}
