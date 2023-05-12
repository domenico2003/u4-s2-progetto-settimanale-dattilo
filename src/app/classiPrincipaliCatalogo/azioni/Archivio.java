package app.classiPrincipaliCatalogo.azioni;

import java.util.ArrayList;
import java.util.List;

import app.classiPrincipaliCatalogo.ProdottoCatalogo;

public class Archivio {

	List<ProdottoCatalogo> archivio = new ArrayList<>();

	public void aggiungiInAchivio(ProdottoCatalogo prodotto) {
		archivio.add(prodotto);
	}

	public void rimuoviElementoByIsbn(String ISBN) {
		archivio = archivio.stream().filter(articolo -> articolo.getISBN() != ISBN).toList();
	}

	public void cercaElementoByIsbn(String ISBN) {
		List<ProdottoCatalogo> risultato = archivio.stream().filter(articolo -> articolo.getISBN() == ISBN).toList();

		System.out.println("risultato della ricerca:");
		System.out.println(risultato.get(0));
	}

	public void cercaElementoByAnno(int anno) {
		List<ProdottoCatalogo> risultati = archivio.stream().filter(articolo -> articolo.getAnnoPublicazione() == anno)
				.toList();

		System.out.println("risultato della ricerca:");
		System.out.println(risultati);
	}

	public void StampaArchivio() {
		archivio.stream().forEach(prodotto -> {
			System.out.println(prodotto);
		});
	}

}
