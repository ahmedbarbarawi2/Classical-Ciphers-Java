package ahmed;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Kasiski {
	String key;
	ArrayList<Integer> index = new ArrayList<>();
	static ArrayList<Character> ciphertext = new ArrayList<>();
	static ArrayList<String> Strings = new ArrayList<>();
	static ArrayList<Integer> freq = new ArrayList<>();
	static ArrayList<Kasiski> keys = new ArrayList<>();

	public int find_gcd(int a, int b) {
		if (b == 0)
			return a;
		return find_gcd(b, a % b);
	}

	public void DataProcessing(String cipher) {


				String word = cipher;
				word = word.toLowerCase();
				for (int i = 0; i < word.length(); i++) {
					char c = word.charAt(i);
					ciphertext.add(c);
				}
			}

		
	


	public void Strings_freq_add(ArrayList<Character> ciphertext) {
		for (int i = 0; i <= ciphertext.size() - 3; i++) {
			char firstchar = ciphertext.get(i);
			char secondchar = ciphertext.get(i + 1);
			char thirdchar = ciphertext.get(i + 2);

			StringBuilder Key_sb = new StringBuilder();
			Key_sb.append(firstchar);
			Key_sb.append(secondchar);
			Key_sb.append(thirdchar);
			String key = Key_sb.toString();
			Strings.add(key);
		}
	}

	public int Final_gcd(ArrayList<Integer> GCD) {
		int gcd = GCD.get(0);
		for (int i = 1; i < GCD.size(); i++) {
			gcd = find_gcd(gcd, GCD.get(i));
		}
		return gcd;
	}

	public void find_key_gcd() { // 3 step
	    for (int i = 0; i < Strings.size(); i++) {
	        String s = Strings.get(i);
	        int count = 0;
	        freq.add(0);

	        for (int j = 0; j < Strings.size(); j++) {
	            if (Strings.get(j).equalsIgnoreCase(s)) {
	                count++;
	            }
	            freq.set(i, count);
	        }

	        if (freq.get(i) >= 2) {
	            Kasiski kasiski = new Kasiski();
	            kasiski.key = Strings.get(i);
	            for (int j = 0; j < Strings.size(); j++) {
	                if (Strings.get(j).equalsIgnoreCase(s)) {
	                    kasiski.index.add(j);
	                }
	            }

	            boolean exist = false;
	            for (int l = 0; l < keys.size(); l++) {
	                if (keys.get(l).key.equalsIgnoreCase(kasiski.key)) {
	                    exist = true;
	                }
	            }
	            if (!exist) {
	                keys.add(kasiski);
	            }
	        }
	    }

	    ArrayList<Integer> GCD = new ArrayList<>();
	    for (int i = 0; i < keys.size(); i++) {
	        Kasiski kasiski = keys.get(i);
	        if (kasiski.index.size() >= 2) {
	            int diff = kasiski.index.get(1) - kasiski.index.get(0);
	            if (diff > 0) GCD.add(diff);
	        }
	    }

	    int keyLength = Final_gcd(GCD);
	    
		System.out.println("\n"+"Key length or multiple of  : " + keyLength);
		for (int i =0;i<keys.size();i++) {
			System.out.println("the string that repetion  : " + keys.get(i).key);
			System.out.println("repetion at  : " + keys.get(i).index.get(0)+","+ keys.get(i).index.get(1)+"   ");

		}
		
	    System.out.println("\nKey length or multiple of: " + keyLength);

	    StringBuilder s1 = new StringBuilder();
	    for (int i = 0; i < ciphertext.size(); i++) {
	        s1.append(ciphertext.get(i));
	    }
	    String cipher = s1.toString();

	    int textLength = cipher.length();
	    int rows = textLength / keyLength;
	    if (textLength % keyLength != 0) rows += 1;

	    char[][] columns = new char[rows][keyLength];
	    for (int i = 0; i < textLength; i++) {
	        int row = i / keyLength;
	        int col = i % keyLength;
	        columns[row][col] = cipher.charAt(i);
	    }
	    StringBuilder plaintext = new StringBuilder();

	    char[] key = new char[keyLength];
	    for (int c = 0; c < keyLength; c++) {
	        StringBuilder column = new StringBuilder();
	        for (int r = 0; r < rows; r++) {
	            if (columns[r][c] != 0) {
	                column.append(columns[r][c]);
	            }
	        }
	        System.out.println(column.toString());
	        key[c] = statisticalAnalysisColumn(column.toString());
	        
	    }

	    System.out.print("Detected Vigenere key: ");
	    for (char k : key) System.out.print(k);
	    System.out.println();


	    System.out.println("Decrypted text: " + plaintext.toString());
	}

	public static char statisticalAnalysisColumn(String column) {
		System.out.println();
	    int[] freq = new int[26];
	    column = column.toLowerCase();

	    for (int i = 0; i < column.length(); i++) {
	        char ch = column.charAt(i);
	        freq[ch - 'a']++;
	    }

	    int maxCount = 0;
	    char maxChar = 'a';
	    for (int i = 0; i < 26; i++) {
	        if (freq[i] > maxCount) {
	            maxCount = freq[i];
	            maxChar = (char) ('a' + i);
	        }
	    }

	    int shift = (maxChar - 'e' + 26) % 26;
	    return (char) ('a' + shift);
	}

	
}
