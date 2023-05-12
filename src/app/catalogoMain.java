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

		Rivista test1 = new Rivista("il corriere dello sport", 2020, 30, Periodicita.mensile);
		Libro test2 = new Libro("one piece: capitolo 1", 1999, 30, "Eiichiro Oda", "shonen");
		Rivista test4 = new Rivista("il messaggero", 2022, 100, Periodicita.settimanale);

		Libro test3 = new Libro("supernatural", 2022, 63, "Eric Kripke", "horror");

		Archivio archivioPublicazioni = new Archivio();

		// leggo dal disco

		archivioPublicazioni.leggiDalDisco();

		// aggiungo articoli

		archivioPublicazioni.aggiungiInAchivio(test1);
		archivioPublicazioni.aggiungiInAchivio(test2);
		archivioPublicazioni.aggiungiInAchivio(test3);
		archivioPublicazioni.aggiungiInAchivio(test4);
		System.out.println("archivio originale ");
		// stampo articolo
		archivioPublicazioni.StampaArchivio();
		System.out.println();
		System.out.println(separatore);
		System.out.println();

//		per eliminare un elemento inserire elementoDaEliminare.GetISBN() poichè gli ISBN sono randomici e a ogni run cambiano o se si legge dal disco inserire l'isbn

		System.out.println("ELIMINAZIONE ELEMENTO");
		archivioPublicazioni.rimuoviElementoByIsbn("979-87-78720-46-1");
		archivioPublicazioni.rimuoviElementoByIsbn(test1.getISBN());// rimuove senza lettura dal disco, funziona anche
																	// con lettura dal disco!funziona
		archivioPublicazioni.StampaArchivio();

		System.out.println();
		System.out.println(separatore);
		System.out.println();

//		per cercare un elemento inserire elementoDaRicercare.GetISBN() (poichè gli ISBN sono randomici e a ogni run cambiano)o se si legge dal disco inserire l'ISBN per la ricerca tramite ISBN 
		// o l'anno di publicazione per la ricerca tramite anno come negli esempi di
		// seguito

		System.out.println("ricerca per ISBN");
//		archivioPublicazioni.cercaElemento("978-29-21761-66-8"); // ricerca con lettura dal disco !non funziona
		archivioPublicazioni.cercaElemento(test3.getISBN());// ricerca senza lettura dal disco, funziona anche con
															// lettura dal disco!funziona
		System.out.println("ricerca per anno");
		archivioPublicazioni.cercaElemento(2022);

		System.out.println();
		System.out.println(separatore);
		System.out.println();

		System.out.println("ricerca tramite autore");
		archivioPublicazioni.cercaTramiteAutore("Eiichiro Oda");

		System.out.println();
		System.out.println(separatore);
		System.out.println();
		// salvo sul disco
		Archivio.salvaSulDisco(archivioPublicazioni);
	}

}