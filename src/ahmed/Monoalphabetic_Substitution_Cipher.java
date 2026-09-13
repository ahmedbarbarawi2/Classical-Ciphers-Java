package ahmed;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Monoalphabetic_Substitution_Cipher {
	static  ArrayList<Integer>plaintext = new ArrayList<>();
	static  ArrayList<Integer>mapingtext = new ArrayList<>();
	static  ArrayList<Integer>ciphertext = new ArrayList<>();
    static String key  ;
	public static void readplaintext (String path) {
		try {
			if (path.equalsIgnoreCase("")) {
				path = "FILE PATH HERE !"  ;
			}
			File file = new File(path);
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				String word = input.next();
				for (int i = 0; i < word.length(); i++) {
					char c = word.toLowerCase().charAt(i);//97-122 للاسكي
					int char_value = (int) c - 97;
					if (char_value<26) {
	
						plaintext.add(char_value);
					
					}

				}
			}
			input.close();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void readciphertext (String path) {
		try {
			if (path.equalsIgnoreCase("")) {
				path = "FILE PATH HERE !" ;
			}
			File file = new File(path);
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				String word = input.next();
				for (int i = 0; i < word.length(); i++) {
					char c = word.toLowerCase().charAt(i);//97-122 للاسكي
					int char_value = (int) c - 97;
					if (char_value<26) {
	
						ciphertext.add(char_value);
					
					}

				}
			}
			input.close();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void readplaintextfromconsole (String text) {
			Scanner input = new Scanner(text);
			while (input.hasNext()) {
				String word = input.next();
				for (int i = 0; i < word.length(); i++) {
					char c = word.toLowerCase().charAt(i);//97-122 للاسكي
					int char_value = (int) c - 97;
					if (char_value<26) {
	
						plaintext.add(char_value);
					
					}

				}
			}
		
		
	}
	public static void readciphertextfromconsole (String text) {
			Scanner input = new Scanner(text);
			while (input.hasNext()) {
				String word = input.next();
				for (int i = 0; i < word.length(); i++) {
					char c = word.toLowerCase().charAt(i);//97-122 للاسكي
					int char_value = (int) c - 97;
					if (char_value<26) {
	
						ciphertext.add(char_value);
					
					}

				}
			}
		
		} 
	
	
	
	
	
	
	
	
	
	public static void read_seed() {
		 String lastLine = "";
		    try (Scanner scanner = new Scanner(new File("FILE PATH HERE !"))) {
		        while (scanner.hasNextLine()) {
		            lastLine = scanner.nextLine();
		        }
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }
          key = lastLine;
	}


	

	public static void maping (String key , ArrayList<Integer>mapingtext ) {
        Random random = new Random(key.hashCode());
		for (int j =0 ;j<26;j++) {
			int key1 = random.nextInt(26);
			boolean exist = false;
			for (int i =0 ;i<mapingtext.size();i++) {
				if (mapingtext.get(i)==key1) {
					j--;
					exist=true;
					break;
				}
			}
			if (exist==false) {
			mapingtext.add(key1);
			}
	   }
	 
	   
	   
	  
   }
	public static void enctyptiontofile (String path) {
		if (path =="") {
			path ="FILE PATH HERE !";
		}
		File file = new File(path);
		try (PrintWriter writer = new PrintWriter(file);) {
			for (int i=0;i<plaintext.size();i++) {
			int charvalue = plaintext.get(i);
			char ciphervalue = (char) (mapingtext.get(charvalue)+97);
			writer.print(String.valueOf(ciphervalue));
			}
		
	} catch (IOException e) {
		System.out.println(e.getMessage());
	}
	
	}
	
	public static void enctyptiontoconsole ( ArrayList<Integer>mapingtext , ArrayList<Integer> plaintext ) {
			for (int i=0;i<plaintext.size();i++) {
			int charvalue = plaintext.get(i);
			char ciphervalue = (char) (mapingtext.get(charvalue)+97);
			System.out.print(String.valueOf(ciphervalue));
			}
	
	}
	public static String dectyptiontoconsole ( ArrayList<Integer>mapingtext , ArrayList<Integer> ciphertext ) {
		StringBuilder s1 = new StringBuilder ();
		for (int i=0;i<ciphertext.size();i++) {
		int charvalue = ciphertext.get(i);
		char plainvalue = (char) (mapingtext.indexOf(charvalue)+97);
		s1.append(String.valueOf(plainvalue));
		
	
}
		return s1.toString();
}	
	public static void dectyptiontofile (String path ) {
		if (path =="") {
			path ="FILE PATH HERE !";
		}
		File file = new File(path);
		try (PrintWriter writer = new PrintWriter(file);) {
			for (int i=0;i<ciphertext.size();i++) {
			int charvalue = ciphertext.get(i);
			char plainvalue = (char) (mapingtext.indexOf(charvalue)+97);
			writer.print(String.valueOf(plainvalue));
			}
		
	} catch (IOException e) {
		System.out.println(e.getMessage());
	}
	
	}	
		
		
	
	
	
	
	
	
	
	
	
	
}
