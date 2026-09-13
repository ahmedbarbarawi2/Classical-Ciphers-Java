package ahmed;

import java.io.File;
import java.util.Scanner;

public class Statical_Analyisis {
	public static void Attack_ToConsole(String cipher) {
	    int[] char_count = new int[26];
	    char[] characters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	    int count = 0;

	    for (int i = 0; i < cipher.length(); i++) {
	        char c = Character.toLowerCase(cipher.charAt(i));
	        if (c >= 'a' && c <= 'z') {
	            char_count[c - 'a']++;
	            count++;
	        }
	    }

	    int maxCount = 0;
	    char maxChar = 'a';
	    System.out.println("The number of letters: " + count);

	    for (int i = 0; i < characters.length; i++) {
	        double percentage = (double) char_count[i] / count * 100;
	        System.out.println("Character: " + characters[i] + " Count: " + char_count[i] + " Percentage: " + percentage + "%");
	        if (char_count[i] > maxCount) {
	            maxCount = char_count[i];
	            maxChar = characters[i];
	        }
	    }

	    System.out.println("The max redundancy character is: " + maxChar + " : " + maxCount);
	    int shift = (maxChar - 'e' + 26) % 26;
	    System.out.println("The Shift is: " + shift);
	}

}
