package ahmed;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;





public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Additve_cipher additve = new Additve_cipher();
		Monoalphabetic_Substitution_Cipher mono = new Monoalphabetic_Substitution_Cipher();
		Vigenere vig = new Vigenere();
		RailFence rf = new RailFence();
		Kasiski k = new Kasiski();
		BruteForce bf = new BruteForce();
		Statical_Analyisis sa = new Statical_Analyisis();
		
		
		
		
		vig.readciphertextfromconsole("zxfvxha");
		vig.key_manage("helstu");
		vig.decryptiontoconsol();
		while (true) {
			System.out.println("\nPlease Select one choice");
			System.out.println("1- Additive  Cipher");
			System.out.println("2- Monoalphabetic Substitution Cipher");
			System.out.println("3- Vigenère Cipher");
			System.out.println("4- Rail Fence Cipher");
			System.out.println("5- Brute Force Attack");
			System.out.println("6- Statical Analyisis Attack");
			System.out.println("7- Kasiski Attack");
			System.out.println("0- Exit");

			
			
		
			
			int choice = input.nextInt();
			if (choice == 0)
				break;

			input.nextLine();

			switch (choice) {

			case 1:
			    System.out.println("Please Select one choice");
			    System.out.println("Read The key from ");
			    System.out.println("1- Key (Console)");
			    System.out.println("2- Seed (File)");
			    int Additive_key_choice = input.nextInt();
			    input.nextLine();

			    if (Additive_key_choice == 1) {
			        System.out.println("Please enter the key as a number:");
			        additve.key = additve.postive(input.nextInt());
			        input.nextLine();
			    } else if (Additive_key_choice == 2) {
			        additve.key = additve.key_seed(additve.read_seed()) % 26;
			        System.out.println("Reading key from file...");
			    }

			    System.out.println("Please Select one choice");
			    System.out.println("1- Encryption");
			    System.out.println("2- Decryption");
			    int encryption_or_decryption_Additive = input.nextInt();
			    input.nextLine();

			    if (encryption_or_decryption_Additive == 1) {
			        System.out.println("Please Select one choice");
			        System.out.println("1- Read from File");
			        System.out.println("2- Read from Console");

			        int read_Additive = input.nextInt();
			        input.nextLine();

			        if (read_Additive == 2) {
			            System.out.println("Enter plaintext:");
			            String text = input.nextLine();
			            additve.readplaintextfromconsole(text);
			        } else if (read_Additive == 1) {
			            System.out.println("Do you want to read:");
			            System.out.println("1- Single file");
			            System.out.println("2- Multiple files");

			            int file_choice = input.nextInt();
			            input.nextLine();

			            if (file_choice == 1) {
			                System.out.println("Reading plaintext from single file...");
			                additve.readplaintext("");
			            } else if (file_choice == 2) {
			                JFrame frame = new JFrame("Choose Files");
			                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			                frame.setSize(300, 200);
			                frame.setLocationRelativeTo(null);
			                frame.setVisible(true);

			                System.out.println("Reading plaintext from Multiple files...");

			                SwingUtilities.invokeLater(() -> {
			                    JFileChooser fileChooser = new JFileChooser();
			                    fileChooser.setMultiSelectionEnabled(true);

			                    int result = fileChooser.showOpenDialog(frame);

			                    if (result == JFileChooser.APPROVE_OPTION) {
			                        File[] selectedFiles = fileChooser.getSelectedFiles();
			                        for (File file : selectedFiles) {
			                            additve.plaintext.clear();
			                            additve.readplaintext(file.getAbsolutePath());
			                            additve.encryptiontofile(file.getAbsolutePath());
			                        }
			                    }
			                });
			            }
			        }

			        System.out.println("Would you like to save the encrypted text?");
			        System.out.println("1- Save to File");
			        System.out.println("2- Display on Console");
			        System.out.println("3- Send to Email");

			        int save_choice_enc = input.nextInt();
			        input.nextLine();

			        if (save_choice_enc == 1) {
			            additve.encryptiontofile("");
			            System.out.println("Saving encrypted text to file...");
			        } else if (save_choice_enc == 2) {
			            System.out.println("Encrypted text displayed on console.");
			            additve.encryptiontoConsole(additve.key, additve.plaintext);
			        }
			    } else if (encryption_or_decryption_Additive == 2) {
			        System.out.println("Please Select one choice");
			        System.out.println("1- Read from File");
			        System.out.println("2- Read from Console");
			        int read_Additive_dec = input.nextInt();
			        input.nextLine();

			        if (read_Additive_dec == 1) {
			            System.out.println("Do you want to read:");
			            System.out.println("1- Single file");
			            System.out.println("2- Multiple files");
			            int file_choice = input.nextInt();
			            input.nextLine();

			            if (file_choice == 1) {
			                additve.readciphertext("");
			                System.out.println("Reading ciphertext from file...");
			            } else if (file_choice == 2) {
			                JFrame frame = new JFrame("Choose Files");
			                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			                frame.setSize(300, 200);
			                frame.setLocationRelativeTo(null);
			                frame.setVisible(true);

			                System.out.println("Reading plaintext from Multiple files...");

			                SwingUtilities.invokeLater(() -> {
			                    JFileChooser fileChooser = new JFileChooser();
			                    fileChooser.setMultiSelectionEnabled(true);

			                    int result = fileChooser.showOpenDialog(frame);

			                    if (result == JFileChooser.APPROVE_OPTION) {
			                        File[] selectedFiles = fileChooser.getSelectedFiles();
			                        for (File file : selectedFiles) {
			                            additve.ciphertext.clear();
			                            additve.readciphertext(file.getAbsolutePath());
			                            additve.decryptiontofile(file.getAbsolutePath());
			                        }
			                    }
			                });
			            }
			        } else if (read_Additive_dec == 2) {
			            System.out.println("Enter ciphertext:");
			            String cipher = input.nextLine();
			            additve.readciphertextfromconsole(cipher);
			        }

			        System.out.println("Would you like to save the decrypted text?");
			        System.out.println("1- Save to File");
			        System.out.println("2- Display on Console");
			        System.out.println("3- Send decrypted text by Email and Key to sms");

			        int save_choice_dec = input.nextInt();
			        input.nextLine();

			        if (save_choice_dec == 1) {
			            System.out.println("Saving decrypted text to file...");
			            additve.decryptiontofile("");
			        } else if (save_choice_dec == 2) {
			            System.out.println("Decrypted text displayed on console.");
			            additve.decryptiontoconsole(additve.key, additve.ciphertext);
			        }

			    }
			    break;
			case 2:
				System.out.println("Please Select one choice");
				System.out.println("Read The key from ");
				System.out.println("1- Key (Console)");
				System.out.println("2- Seed (File)");
				int mono_key_choice = input.nextInt();
				input.nextLine();

				if (mono_key_choice == 1) {
					System.out.println("Please enter the key as a Text :");
					mono.key = input.next();
					mono.maping(mono.key, mono.mapingtext);
					input.nextLine();
				} else if (mono_key_choice == 2) {
					mono.read_seed();
					mono.maping(mono.key, mono.mapingtext);
					System.out.println("Reading seed from file...");
				}

				System.out.println("Please Select one choice");
				System.out.println("1- Encryption");
				System.out.println("2- Decryption");
				int encryption_or_decryption_mono = input.nextInt();
				input.nextLine();

				if (encryption_or_decryption_mono == 1) {

					System.out.println("Please Select one choice");
					System.out.println("1- Read from File");
					System.out.println("2- Read from Console");
					int read_mono = input.nextInt();
					input.nextLine();

					if (read_mono == 1) {
						System.out.println("Do you want to read:");
						System.out.println("1- Single file");
						System.out.println("2- Multiple files");
						int file_choice = input.nextInt();
						input.nextLine();

						if (file_choice == 1) {
							System.out.println("Reading plaintext from single file...");
							mono.readplaintext("");
						}else if (file_choice == 2) {
							JFrame frame = new JFrame("Choose Files");
					        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        frame.setSize(300, 200);
					        frame.setLocationRelativeTo(null);
					        frame.setVisible(true);

					        System.out.println("Reading plaintext from Multiple files...");

					        SwingUtilities.invokeLater(() -> {
					            JFileChooser fileChooser = new JFileChooser();
					            fileChooser.setMultiSelectionEnabled(true); 

					            int result = fileChooser.showOpenDialog(frame); 

					            if (result == JFileChooser.APPROVE_OPTION) {
					                File[] selectedFiles = fileChooser.getSelectedFiles();
					                for (int i = 0; i < selectedFiles.length; i++) {
					                    File file = selectedFiles[i];
					                    mono.plaintext.clear();
					                    mono.readplaintext(file.getAbsolutePath());
					                    mono.enctyptiontofile(file.getAbsolutePath());
					                }

					            }
					        });
					
						
						break;
						}
					} else if (read_mono == 2) {
						System.out.println("Enter plaintext:");
						String text = input.nextLine();
						mono.readplaintextfromconsole(text);
					}

					System.out.println("Would you like to save the encrypted text?");
					System.out.println("1- Save to File");
					System.out.println("2- Display on Console");
					int save_choice_enc_mono = input.nextInt();
					input.nextLine();

					if (save_choice_enc_mono == 1) {
						mono.enctyptiontofile("");
						System.out.println("Saving encrypted text to file...");
					} else if (save_choice_enc_mono == 2) {
						System.out.println("Encrypted text displayed on console.");
						mono.enctyptiontoconsole(mono.mapingtext, mono.plaintext);
					}

				} else if (encryption_or_decryption_mono == 2) {

					System.out.println("Please Select one choice");
					System.out.println("1- Read from File");
					System.out.println("2- Read from Console");
					int read_mono_dec = input.nextInt();
					input.nextLine();

					if (read_mono_dec == 1) {
						System.out.println("Do you want to read:");
						System.out.println("1- Single file");
						System.out.println("2- Multiple files");
						int file_choice = input.nextInt();
						input.nextLine();

						if (file_choice == 1) {
							mono.readciphertext("");
							System.out.println("Reading ciphertext from file...");
						}else if (file_choice == 2) {
							JFrame frame = new JFrame("Choose Files");
					        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        frame.setSize(300, 200);
					        frame.setLocationRelativeTo(null);
					        frame.setVisible(true);

					        System.out.println("Reading plaintext from Multiple files...");

					        SwingUtilities.invokeLater(() -> {
					            JFileChooser fileChooser = new JFileChooser();
					            fileChooser.setMultiSelectionEnabled(true); 

					            int result = fileChooser.showOpenDialog(frame); 

					            if (result == JFileChooser.APPROVE_OPTION) {
					                File[] selectedFiles = fileChooser.getSelectedFiles();
					                for (int i = 0; i < selectedFiles.length; i++) {
					                    File file = selectedFiles[i];
					                    mono.ciphertext.clear();
					                    mono.readciphertext(file.getAbsolutePath());
					                    mono.dectyptiontofile(file.getAbsolutePath());
		 			             }
					           }
					        });
					
						
						break;
						}
					} else if (read_mono_dec == 2) {
						System.out.println("Enter ciphertext:");
						String cipher = input.nextLine();
						mono.readciphertextfromconsole(cipher);
					}

					System.out.println("Would you like to save the decrypted text?");
					System.out.println("1- Save to File");
					System.out.println("2- Display on Console");
					System.out.println("3- Send To Email");

					int save_choice_dec_mono = input.nextInt();
					input.nextLine();

					if (save_choice_dec_mono == 1) {
						System.out.println("Saving decrypted text to file...");
						mono.dectyptiontofile("");
					} else if (save_choice_dec_mono == 2) {
						System.out.println("Decrypted text displayed on console.");
						System.out.println(mono.dectyptiontoconsole(mono.mapingtext, mono.ciphertext));
					}
				}
				break;

			case 3:
				System.out.println("Please Select one choice");
				System.out.println("1- Encryption");
				System.out.println("2- Decryption");
				int encryption_or_decryption_vig = input.nextInt();
				input.nextLine();

				if (encryption_or_decryption_vig == 1) {
					System.out.println("Please Select one choice");
					System.out.println("Read Plaintext from:");
					System.out.println("1- Single File");
					System.out.println("2- Multiple Files");
					System.out.println("3- Console");
					int read_vig = input.nextInt();
					input.nextLine();

					if (read_vig == 1) {
						System.out.println("Reading plaintext from single file...");
						vig.readplaintext("");
					} else if (read_vig == 2) {
						JFrame frame = new JFrame("Choose Files");
				        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        frame.setSize(300, 200);
				        frame.setLocationRelativeTo(null);
				        frame.setVisible(true);

				        System.out.println("Reading plaintext from Multiple files...");

				        SwingUtilities.invokeLater(() -> {
				            JFileChooser fileChooser = new JFileChooser();
				            fileChooser.setMultiSelectionEnabled(true); 

				            int result = fileChooser.showOpenDialog(frame); 

				            if (result == JFileChooser.APPROVE_OPTION) {
				                File[] selectedFiles = fileChooser.getSelectedFiles();
				                for (int i = 0; i < selectedFiles.length; i++) {
				                    File file = selectedFiles[i];
				                    vig.plaintext.clear();
				                    vig.readplaintext(file.getAbsolutePath());
				                    vig.encryptiontofile(file.getAbsolutePath());
	 			             }
				           }
				        });
				
					
					break;
					}
					 else if (read_vig == 3) {
						System.out.println("Enter plaintext:");
						String text = input.nextLine();
						vig.readplaintextfromconsole(text);
					}

				} else if (encryption_or_decryption_vig == 2) {
					System.out.println("Please Select one choice");
					System.out.println("Read Ciphertext from:");
					System.out.println("1- Single File");
					System.out.println("2- Multiple Files");
					System.out.println("3- Console");
					int read_vig_dec = input.nextInt();
					input.nextLine();

					if (read_vig_dec == 1) {
						System.out.println("Reading ciphertext from single file...");
						vig.readciphertext("");
					}  else if (read_vig_dec == 3) {
						System.out.println("Enter ciphertext:");
						String cipher = input.next();
						vig.readciphertextfromconsole(cipher);
					}
				}

				System.out.println("\nPlease Select one choice");
				System.out.println("Read The key from ");
				System.out.println("1- Key (Console)");
				System.out.println("2- Seed (File)");
				int vig_key_choice = input.nextInt();
				input.nextLine();

				if (vig_key_choice == 1) {
					System.out.println("Please enter the keyword (letters only):");
					vig.key_manage(input.next());
				} else if (vig_key_choice == 2) {
					System.out.println("Reading keyword from file...");
					vig.key_manage(vig.read_seed());

				}

				if (encryption_or_decryption_vig == 1) {
					System.out.println("Would you like to save the encrypted text?");
					System.out.println("1- Save to File");
					System.out.println("2- Display on Console");
					System.out.println("3- Sent Encrypted text by Email and Key to sms ");

					int save_choice_enc_vig = input.nextInt();
					input.nextLine();

					if (save_choice_enc_vig == 1) {
						System.out.println("Saving encrypted text to file...");
						vig.encryptiontofile("");

					} else if (save_choice_enc_vig == 2) {
						System.out.println("Encrypted text displayed on console:");
						vig.encryptiontoconsol();
					}
				} else if (encryption_or_decryption_vig == 2) {
					System.out.println("Would you like to save the decrypted text?");
					System.out.println("1- Save to File");
					System.out.println("2- Display on Console");
					System.out.println("3- Sent decrypted text by Email  ");
					int save_choice_dec_vig = input.nextInt();
					input.nextLine();
					if (save_choice_dec_vig == 1) {
						System.out.println("Saving encrypted text to file...");
						vig.decryptiontofile("");
					} else if (save_choice_dec_vig == 2) {
						vig.decryptiontoconsol();
						System.out.println("Encrypted text displayed on console:");
					}
				}
				System.out.println(vig.ciphertext.toString());
				System.out.println(vig.plaintext.toString());
				System.out.println(vig.Key.toString());

				break;
			// ================================
			// 4️⃣ Rail Fence Cipher
			// ================================
			case 4:

				System.out.println("Please Select one choice");
				System.out.println("1- Encryption");
				System.out.println("2- Decryption");
				int rail_choice = input.nextInt();
				input.nextLine();

				// ================================
				// 🔹 Encryption
				// ================================
				if (rail_choice == 1) {
					System.out.println("Please select how to provide the key (number of rails):");
					System.out.println("1- Read KEY from File (seed)");
					System.out.println("2- Read KEY from Console");
					int keyChoice = input.nextInt();
					input.nextLine();
					if (keyChoice == 1) {
						rf.key_manage();
					} else if (keyChoice == 2) {
						System.out.println("Enter the number of rails:");
						rf.depth = input.nextInt();
						input.nextLine();

					}

					System.out.println("Please Select one choice");
					System.out.println("1- Read plaintext from File");
					System.out.println("2- Read plaintext from Console");
					int read_choice = input.nextInt();
					input.nextLine();

					if (read_choice == 1) {
						System.out.println("Do you want to read:");
						System.out.println("1- Single file");
						System.out.println("2- Multiple files");
						int file_choice = input.nextInt();
						input.nextLine();

						if (file_choice == 1) {
							System.out.println("Reading plaintext from single file...");
							rf.readplaintext("");
						}  else if (file_choice == 2) {
							JFrame frame = new JFrame("Choose Files");
					        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        frame.setSize(300, 200);
					        frame.setLocationRelativeTo(null);
					        frame.setVisible(true);

					        System.out.println("Reading plaintext from Multiple files...");

					        SwingUtilities.invokeLater(() -> {
					            JFileChooser fileChooser = new JFileChooser();
					            fileChooser.setMultiSelectionEnabled(true); 

					            int result = fileChooser.showOpenDialog(frame); 

					            if (result == JFileChooser.APPROVE_OPTION) {
					                File[] selectedFiles = fileChooser.getSelectedFiles();
					                for (int i = 0; i < selectedFiles.length; i++) {
					                    File file = selectedFiles[i];
					                    rf.plaintext.clear();
					                    rf.readplaintext(file.getAbsolutePath());
					                    rf.encryptiontofile(file.getAbsolutePath());

		 			             }
					           }
					        });
					
						
						break;
						}
					} else if (read_choice == 2) {
						System.out.println("Enter plaintext:");
						String text = input.nextLine();
						rf.readplaintextfromconsole(text);
					}

					System.out.println("Would you like to save the encrypted text?");
					System.out.println("1- Save to File");
					System.out.println("2- Display on Console");
					System.out.println("2- Send to EMAIL");

					int save_choice = input.nextInt();
					input.nextLine();

					if (save_choice == 1) {
						rf.encryptiontofile("");
						System.out.println("Encrypted text saved to file.");
					} else if (save_choice == 2) {
						rf.encryptiontoconsol();
					}
				}


				else if (rail_choice == 2) {
					System.out.println("Please select how to provide the key (number of rails):");
					System.out.println("1- Read KEY from File (seed)");
					System.out.println("2- Read KEY from Console");
					int keyChoice = input.nextInt();
					input.nextLine();
					if (keyChoice == 1) {
						rf.key_manage();
					} else if (keyChoice == 2) {
						System.out.println("Enter the number of rails:");
						rf.depth = input.nextInt();
						input.nextLine();

					}

					System.out.println("Please Select one choice");
					System.out.println("1- Read ciphertext from File");
					System.out.println("2- Read ciphertext from Console");
					int read_choice_dec = input.nextInt();
					input.nextLine();

					if (read_choice_dec == 1) {
						System.out.println("Do you want to read:");
						System.out.println("1- Single file");
						System.out.println("2- Multiple files");
						int file_choice = input.nextInt();
						input.nextLine();

						if (file_choice == 1) {
							System.out.println("Reading ciphertext from single file...");
							rf.readciphertext("");
						} else if (file_choice == 2) {
							JFrame frame = new JFrame("Choose Files");
					        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        frame.setSize(300, 200);
					        frame.setLocationRelativeTo(null);
					        frame.setVisible(true);

					        System.out.println("Reading plaintext from Multiple files...");

					        SwingUtilities.invokeLater(() -> {
					            JFileChooser fileChooser = new JFileChooser();
					            fileChooser.setMultiSelectionEnabled(true); 

					            int result = fileChooser.showOpenDialog(frame); 

					            if (result == JFileChooser.APPROVE_OPTION) {
					                File[] selectedFiles = fileChooser.getSelectedFiles();
					                for (int i = 0; i < selectedFiles.length; i++) {
					                    File file = selectedFiles[i];
					                    rf.ciphertext.clear();
					                    rf.readciphertext(file.getAbsolutePath());
					                    rf.decryptiontofile(file.getAbsolutePath());
		 			             }
					           }
					        });
					
						
						break;
						}
					} else if (read_choice_dec == 2) {
						System.out.println("Enter ciphertext:");
						String text = input.nextLine();
						rf.readciphertextfromconsole(text);
					}

					System.out.println("Would you like to save the decrypted text?");
					System.out.println("1- Save to File");
					System.out.println("2- Display on Console");
					int save_choice_dec = input.nextInt();
					input.nextLine();

					if (save_choice_dec == 1) {

						rf.decryptiontofile("");
						System.out.println("Decrypted text saved to file.");
					} else if (save_choice_dec == 2) {
						rf.decryptiontoconsol();
					}
				}
				break;
			case 5:
				System.out.println("please enter the ciphertext  :");
				String ciphertext = input.nextLine();
				bf.readciphertextfromconsole(ciphertext);
				System.out.println("The Attack on the console  :");
				bf.Attack_Console();
				break;
			case 6:
				System.out.println("please enter the ciphertext  :");
				String ciphertext_stat = input.nextLine();
				System.out.println("The Attack on the console  :");
				sa.Attack_ToConsole(ciphertext_stat);
				break;
			case 7:
				System.out.println("please enter the ciphertext  :");
				String ciphertext_kasiski = input.nextLine();
				k.DataProcessing(ciphertext_kasiski);
				k.Strings_freq_add(k.ciphertext);
				k.find_key_gcd();
				System.out.println("The Attack on the console  :");
				break;
			}
		}

		input.close();
	}
}
