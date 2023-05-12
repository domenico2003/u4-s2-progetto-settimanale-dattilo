package app;

import java.util.Random;

public class TestIsbn {

	public static void main(String[] args) {
		String isbn = generateIsbn();
		System.out.println(isbn);
	}

	public static String generateIsbn() {
		Random random = new Random();
		int group = 88; // codice gruppo assegnato dall'ISBN
		int publisher = random.nextInt(100000); // codice editore casuale
		int publicationYear = 23; // anno di pubblicazione (qui, il 2021)
		int titleNumber = random.nextInt(1000); // numero del libro casuale
		int checksum = calculateChecksum(group, publisher, publicationYear, titleNumber);

		return String.format("978-%02d-%05d-%03d-%d", group, publisher, titleNumber, checksum);
	}

	public static int calculateChecksum(int group, int publisher, int publicationYear, int titleNumber) {
		int[] digits = new int[12];
		int i = 0;

		// aggiunge i primi 12 cifre del codice ISBN
		while (group > 0) {
			digits[i++] = group % 10;
			group /= 10;
		}
		while (publisher > 0) {
			digits[i++] = publisher % 10;
			publisher /= 10;
		}
		digits[i++] = publicationYear / 10;
		digits[i++] = publicationYear % 10;
		while (titleNumber > 0) {
			digits[i++] = titleNumber % 10;
			titleNumber /= 10;
		}

		// calcola la cifra di controllo usando la formula specifica
		int sum = 0;
		for (i = 0; i < 12; i++) {
			sum += (i % 2 == 0) ? digits[i] : 3 * digits[i];
		}
		return (10 - sum % 10) % 10;
	}

}
