package app;

import app.classiPrincipaliCatalogo.Libro;
import app.classiPrincipaliCatalogo.Periodicita;
import app.classiPrincipaliCatalogo.Rivista;
import app.classiPrincipaliCatalogo.azioni.Archivio;

public class catalogoMain {

	public static void main(String[] args) {
//		per separare i risultati dei metodi
		String separatore = "";
		for (int i = 0; i < 144; i++) {
			if (i == 72) {
				separatore += " nuovo metodo ";
			} else {
				separatore += "#";
			}
		}

		Rivista test1 = new Rivista("titolo", 2020, 30, Periodicita.mensile);
		Libro test2 = new Libro("titolo1", 2022, 30, "autore", "genere");
		Rivista test4 = new Rivista("prova", 2022, 100, Periodicita.settimanale);

		Libro test3 = new Libro("titolo2", 2024, 63, "autore1", "genere1");

		Archivio archivioPublicazioni = new Archivio();
		archivioPublicazioni.leggiDalDisco();
//		archivioPublicazioni.aggiungiInAchivio(test1);
//		archivioPublicazioni.aggiungiInAchivio(test2);
//		archivioPublicazioni.aggiungiInAchivio(test3);
//		archivioPublicazioni.aggiungiInAchivio(test4);

		System.out.println("archivio originale ");
		archivioPublicazioni.StampaArchivio();
		System.out.println();
		System.out.println(separatore);
		System.out.println();

//		per eliminare un elemento inserire elementoDaEliminare.GetISBN() poichè gli ISBN sono randomici e a ogni run cambiano o se si legge dal disco inserire l'isbn

		System.out.println("ELIMINAZIONE ELEMENTO");
		archivioPublicazioni.rimuoviElementoByIsbn(test1.getISBN());
		archivioPublicazioni.StampaArchivio();

		System.out.println();
		System.out.println(separatore);
		System.out.println();

//		per cercare un elemento inserire elementoDaRicercare.GetISBN() (poichè gli ISBN sono randomici e a ogni run cambiano)o se si legge dal disco inserire l'ISBN per la ricerca tramite ISBN 
		// o l'anno di publicazione per la ricerca tramite anno come negli esempi di
		// seguito

		System.out.println("ricerca per ISBN");
		archivioPublicazioni.cercaElemento("978-29-21761-66-8"); // ricerca con lettura dal disco
//		archivioPublicazioni.cercaElemento(test3.getISBN());//ricerca senza lettura dal disco
		System.out.println("ricerca per anno");
		archivioPublicazioni.cercaElemento(2022);

		System.out.println();
		System.out.println(separatore);
		System.out.println();

		System.out.println("ricerca tramite autore");
		archivioPublicazioni.cercaTramiteAutore(" autore");

		System.out.println();
		System.out.println(separatore);
		System.out.println();

	}

}