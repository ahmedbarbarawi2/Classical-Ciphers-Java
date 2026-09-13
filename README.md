# Classical Ciphers Java

A Java implementation of several classical cryptographic algorithms.

This project was developed for educational purposes to understand the basic principles of classical cryptography, encryption, decryption, and cryptanalysis.

## Implemented Algorithms

### 1. Additive Cipher
A substitution cipher that shifts each letter by a fixed numerical key.

### 2. Monoalphabetic Substitution Cipher
A substitution cipher that replaces each letter with another letter according to a substitution mapping.

### 3. Vigenère Cipher
A polyalphabetic substitution cipher that uses a keyword to encrypt and decrypt text.

### 4. Rail Fence Cipher
A transposition cipher that rearranges characters using a zigzag pattern.

### 5. Brute Force
Attempts to recover plaintext by trying all possible keys.

### 6. Kasiski Examination
A cryptanalysis technique used to analyze repeated sequences in Vigenère ciphertext and estimate the key length.

### 7. Statistical Analysis
Uses letter-frequency analysis to help study and analyze encrypted text.

### 8. Main
The main class used to run the project and access the implemented cryptographic algorithms.

## Features

- Encryption and decryption.
- Support for uppercase and lowercase letters.
- Preservation of spaces and special characters.
- Console input and output.
- File input and output.
- Brute-force analysis.
- Statistical analysis.
- Kasiski examination.
- Multiple classical cipher implementations.

## Project Structure

```text
Classical-Ciphers-Java/
├── Additve_cipher.java
├── BruteForce.java
├── Kasiski.java
├── Main.java
├── Monoalphabetic_Substitution_Cipher.java
├── RailFence.java
├── Statical_Analysis.java
└── Vigenere.java
