package ahmed;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RailFence {

	static ArrayList<Integer> plaintext = new ArrayList<>();
	static ArrayList<Integer> ciphertext = new ArrayList<>();
	static int depth;

	public static void key_manage() {
		String lastLine = "";
		try (Scanner scanner = new Scanner(new File(
				"C:\\Users\\ahmed\\eclipse-workspace\\q2\\src\\application\\Cyber_Projectone\\plaintext.txt"))) {
			while (scanner.hasNextLine()) {
				lastLine = scanner.nextLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		lastLine=lastLine.toLowerCase();
		Random random = new Random(lastLine.hashCode());
		int key = random.nextInt(2, 10);
		depth = key;

	}

	public static void readplaintext(String path) {
		if (path == "") {
			path = "C:\\Users\\ahmed\\eclipse-workspace\\q2\\src\\application\\Cyber_Projectone\\plaintext.txt";
		}
		try {

			File file = new File(path);
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				String line = input.nextLine();
				line.toLowerCase();
				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if (c >= 97 && c <= 122) {
						int char_value = (int) c;
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
			line.toLowerCase();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c >= 97 && c <= 122) {
					int char_value = (int) c;
					plaintext.add(char_value);
				}
			}

		}

	}

	public static void readciphertext(String path) {
		if (path == "") {
			path = "C:\\Users\\ahmed\\eclipse-workspace\\q2\\src\\application\\Cyber_Projectone\\ciphertext.txt";
		}
		try {
			File file = new File(path);
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				String line = input.nextLine();
				line.toLowerCase();
				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if (c >= 97 && c <= 122) {
						int char_value = (int) c;
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
			line.toLowerCase();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c >= 97 && c <= 122) {
					int char_value = (int) c;
					ciphertext.add(char_value);
				}

			}
		}

	}

	public void encryptiontofile(String path) {
		char[][] cipher = new char[depth][plaintext.size()];
		if (path == "") {
			path = "C:\\Users\\ahmed\\eclipse-workspace\\q2\\src\\application\\Cyber_Projectone\\ciphertext.txt";
		}
		StringBuilder s1 = new StringBuilder();
		File file = new File(path);
		try (PrintWriter writer = new PrintWriter(file);) {
			int row = 0;
			boolean up = false; 
			for (int i = 0; i < plaintext.size(); i++) {
				int c = plaintext.get(i);
				cipher[row][i] = (char) c;
				if (row == 0) {
					up = false;
				} else if (row == depth - 1) {
					up = true;

				}

				if (up == false) {
					row++;
				} else if (up == true) {
					row--;

				}
			}
			for (int j = 0; j < depth; j++) {
				for (int k = 0; k < plaintext.size(); k++) {
					if (cipher[j][k] != 0) {
						s1.append(cipher[j][k]);
					}
				}
			}

			String ciphertxt = s1.toString();
			writer.write(ciphertxt);

		} catch (IOException e) {
			System.out.println(e.getMessage());

		}

	}

	public void encryptiontoconsol() {
		char[][] cipher = new char[depth][plaintext.size()];
		StringBuilder s1 = new StringBuilder();
		int row = 0;
		boolean up = false;
		for (int i = 0; i < plaintext.size(); i++) {
			int c = plaintext.get(i);
			cipher[row][i] = (char) c;
			if (row == 0) {
				up = false;
			} else if (row == depth - 1) {
				up = true;

			}

			if (up == false) {
				row++;
			} else if (up == true) {
				row--;

			}
		}
		for (int j = 0; j < depth; j++) {
			for (int k = 0; k < plaintext.size(); k++) {
				if (cipher[j][k] != 0) {
					s1.append(cipher[j][k]);
				}
			}
		}

		String ciphertxt = s1.toString();
		System.out.print(ciphertxt);

	}

	public void decryptiontofile(String path) {
		if (path == "") {
			path = "C:\\Users\\ahmed\\eclipse-workspace\\q2\\src\\application\\Cyber_Projectone\\plaintext.txt";
		}
		StringBuilder s1 = new StringBuilder();
	    char[][] rail = new char[depth][ciphertext.size()];
	    boolean dirDown = false;
	    int row = 0, col = 0;
		File file = new File(path);
		try (PrintWriter writer = new PrintWriter(file);) {
        for (int i=0;i<ciphertext.size();i++) {
        s1.append((char)(int)ciphertext.get(i));
        }
        for (int i = 0; i < s1.length(); i++) {
		        if (row == 0) {
		            dirDown = true;
		        } else if (row == depth - 1) {
		            dirDown = false;
		        }

		        rail[row][col++] = '*';

		        if (dirDown) {
		            row++;
		        } else {
		            row--;
		        }
		    }
		    int index = 0;
		    for (int r = 0; r < depth; r++) {
		        for (int c = 0; c <s1.length(); c++) {
		            if (rail[r][c] == '*' && index < s1.length()) {
		                rail[r][c] = s1.charAt(index++);
		            }
		        }
		    }
		    StringBuilder result = new StringBuilder();
		    row = 0;
		    col = 0;
		    dirDown = false;

		    for (int i = 0; i < s1.length(); i++) {

		        if (row == 0) {
		            dirDown = true;
		        } else if (row == depth - 1) {
		            dirDown = false;
		        }

		        if (rail[row][col] != '*') {
		            result.append(rail[row][col++]);
		        }
		        if (dirDown) {
		            row++;
		        } else {
		            row--;
		        }
		    }

		     writer.write(result.toString());
		}


		catch (IOException e) {
			System.out.println(e.getMessage());

		}
	
	}
	public void decryptiontoconsol() {
		StringBuilder s1 = new StringBuilder();
	    char[][] rail = new char[depth][ciphertext.size()];
	    boolean dirDown = false;
	    int row = 0, col = 0;
        for (int i=0;i<ciphertext.size();i++) {
        s1.append((char)(int)ciphertext.get(i));
        }
        for (int i = 0; i < s1.length(); i++) {
		        if (row == 0) {
		            dirDown = true;
		        } else if (row == depth - 1) {
		            dirDown = false;
		        }

		        rail[row][col++] = '*';

		        if (dirDown) {
		            row++;
		        } else {
		            row--;
		        }
		    }
		    int index = 0;
		    for (int r = 0; r < depth; r++) {
		        for (int c = 0; c <s1.length(); c++) {
		            if (rail[r][c] == '*' && index < s1.length()) {
		                rail[r][c] = s1.charAt(index++);
		            }
		        }
		    }
		    StringBuilder result = new StringBuilder();
		    row = 0;
		    col = 0;
		    dirDown = false;

		    for (int i = 0; i < s1.length(); i++) {

		        if (row == 0) {
		            dirDown = true;
		        } else if (row == depth - 1) {
		            dirDown = false;
		        }

		        if (rail[row][col] != '*') {
		            result.append(rail[row][col++]);
		        }
		        if (dirDown) {
		            row++;
		        } else {
		            row--;
		        }
		    }

		     System.out.print(result.toString());
		}


	

	}
	




