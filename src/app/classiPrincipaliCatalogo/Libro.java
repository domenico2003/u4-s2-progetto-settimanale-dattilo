package app.classiPrincipaliCatalogo;

public class Libro extends ProdottoCatalogo {
	private String autore;
	private String genere;

	public Libro(String titolo, int anno, int pagine, String autore, String genere) {
		super(titolo, anno, pagine);
		setAutore(autore);
		setGenere(genere);
	}

	public Libro(String titolo, int anno, int pagine, String autore, String genere, String ISBN) {
		super(titolo, anno, pagine, ISBN);
		setAutore(autore);
		setGenere(genere);
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	@Override
	public String toString() {
		return "{\n ISBN: " + this.getISBN() + ";\n titolo: " + this.getTitolo() + ";\n anno di publicazione: "
				+ this.getAnnoPublicazione() + ";\n numero pagine: " + this.getnPagine() + ";\n autore: "
				+ this.getAutore() + ";\n genere: " + this.getGenere() + ";\n}";
	}
}
