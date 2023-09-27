package Lab1;

public class MyCaesar {

	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

//task2
	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char encryptChar(char c) {
		// TO DO
		if (c == ' ') {
			return ' ';
		}
		return ALPHABET[((int) c - (int) 'A' + n + 26) % 26];
	}

	// Encrypt a text using the above function for encrypting a charater.
	public String encrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += encryptChar(input.charAt(i));
		}
		return result;
	}

	// Decrypt a character according to the given shif steps.
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char decryptChar(char c) {
		// TO DO
		if (c == ' ') {
			return ' ';
		}
		return ALPHABET[((int) c - (int) 'A' - n + 26) % 26];
	}

	// Decrypt a encrypted text using the above function for decrypting a charater.
	public String decrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += decryptChar(input.charAt(i));
		}
		return result;
	}

//task3
	public static void main(String[] args) {
		MyCaesar mycaesar = new MyCaesar(4);
//		System.out.println(mycaesar.encryptChar('Z'));
		System.out.println(mycaesar.encrypt("BAO DUY"));
//		System.out.println(mycaesar.decryptChar('D'));
		System.out.println(mycaesar.decrypt("FES HYC"));

	}
}
