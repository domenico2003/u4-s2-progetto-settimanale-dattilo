package app.classiPrincipaliCatalogo.azioni;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import app.classiPrincipaliCatalogo.Libro;
import app.classiPrincipaliCatalogo.Periodicita;
import app.classiPrincipaliCatalogo.ProdottoCatalogo;
import app.classiPrincipaliCatalogo.Rivista;

public class Archivio {
	static File file = new File("archivio.txt");

	List<ProdottoCatalogo> archivio = new ArrayList<>();

	public List<ProdottoCatalogo> getArchivio() {
		return this.archivio;
	}

	public void aggiungiInAchivio(ProdottoCatalogo prodotto) {
		archivio.add(prodotto);
	}

	public void rimuoviElementoByIsbn(String ISBN) {
		archivio = archivio.stream().filter(articolo -> articolo.getISBN() != ISBN).toList();
	}

	public void cercaElemento(String ISBN) {
		List<ProdottoCatalogo> risultato = archivio.stream().filter(articolo -> articolo.getISBN() == ISBN).toList();

		System.out.println("risultato della ricerca:");
		System.out.println(risultato);
	}

	public void cercaElemento(int anno) {
		List<ProdottoCatalogo> risultati = archivio.stream().filter(articolo -> articolo.getAnnoPublicazione() == anno)
				.toList();

		System.out.println("risultato della ricerca:");
		System.out.println(risultati);
	}

	public void cercaTramiteAutore(String autore) {

		List<ProdottoCatalogo> risultati = archivio.stream().filter(articolo -> articolo instanceof Libro)
				.filter(libro -> ((Libro) libro).getAutore() == autore).toList();

		System.out.println("risultato della ricerca:");
		System.out.println(risultati);
	}

	public static void salvaSulDisco(List<ProdottoCatalogo> archivio) {
		try {
			FileUtils.writeStringToFile(file, archivio.toString(), "UTF-8", true);
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
	}

	public void leggiDalDisco() {
		List<ProdottoCatalogo> archivioDelDisco = new ArrayList<>();
		try {
			String[] newArchivio = FileUtils.readFileToString(file, "UTF-8").split(",");
			for (int i = 0; i < newArchivio.length; i++) {
				String[] oggettoParametri = newArchivio[i].split(";");
				if (oggettoParametri.length == 6) {
					String titolo = oggettoParametri[1].split(":")[1].split(" ")[1];
					int anno = Integer.parseInt(oggettoParametri[2].split(":")[1].split(" ")[1]);
					int pagine = Integer.parseInt(oggettoParametri[3].split(":")[1].split(" ")[1]);
					Periodicita periodo = Periodicita.valueOf(oggettoParametri[4].split(":")[1].split(" ")[1]);
					String isbn = oggettoParametri[0].split(":")[1].split(" ")[1];

					Rivista rivistaNuova = new Rivista(titolo, anno, pagine, periodo, isbn);
					archivioDelDisco.add(rivistaNuova);
				} else if (oggettoParametri.length == 7) {
					String titolo = oggettoParametri[1].split(":")[1].split(" ")[1];
					int anno = Integer.parseInt(oggettoParametri[2].split(":")[1].split(" ")[1]);
					int pagine = Integer.parseInt(oggettoParametri[3].split(":")[1].split(" ")[1]);
					String autore = oggettoParametri[4].split(":")[1].split(" ")[1];
					String genere = oggettoParametri[5].split(":")[1].split(" ")[1];
					String isbn = oggettoParametri[0].split(":")[1].split(" ")[1];

					Libro libroNuovo = new Libro(titolo, anno, pagine, autore, genere, isbn);
					archivioDelDisco.add(libroNuovo);
				}

			}

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
		archivio = archivioDelDisco;

	}

	public void StampaArchivio() {
		archivio.stream().forEach(prodotto -> {
			System.out.println(prodotto);
		});
	}

}
