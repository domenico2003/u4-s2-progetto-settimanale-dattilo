package app;

import app.classiPrincipaliCatalogo.Libro;
import app.classiPrincipaliCatalogo.Periodicita;
import app.classiPrincipaliCatalogo.Rivista;
import app.classiPrincipaliCatalogo.azioni.Archivio;

public class catalogoMain {

	public static void main(String[] args) {

		Rivista test1 = new Rivista("titolo", 2020, 30, Periodicita.mensile);
		Libro test2 = new Libro("titolo1", 2022, 30, "autore", "genere");
		Rivista test4 = new Rivista("prova", 2022, 100, Periodicita.settimanale);

		Libro test3 = new Libro("titolo2", 2024, 63, "autore1", "genere1");

		Archivio archivioPublicazioni = new Archivio();
		archivioPublicazioni.aggiungiInAchivio(test1);
		archivioPublicazioni.aggiungiInAchivio(test2);
		archivioPublicazioni.aggiungiInAchivio(test3);
		archivioPublicazioni.aggiungiInAchivio(test4);

		archivioPublicazioni.StampaArchivio();

//		System.out.println("ELIMINAZIONE ELEMENTO");
//		per eliminare un elemento inserire elementoDaEliminare.GetISBN() poichè gli ISBN sono randomici e a ogni run cambiano
//		archivioPublicazioni.rimuoviElementoByIsbn(test1.getISBN());
//		archivioPublicazioni.StampaArchivio();
//		per cercare un elemento inserire elementoDaRicercare.GetISBN() poichè gli ISBN sono randomici e a ogni run cambiano
		System.out.println("ricerca per ISBN");
		archivioPublicazioni.cercaElementoByIsbn(test3.getISBN());
		System.out.println("ricerca per anno");

		archivioPublicazioni.cercaElementoByAnno(2022);
	}

}