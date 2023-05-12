package app.classiPrincipaliCatalogo;

public class Rivista extends ProdottoCatalogo {
	Periodicita periodicita;

	public Rivista(String titolo, int i, int pagine, Periodicita periodi) {
		super(titolo, i, pagine);
		this.periodicita = periodi;
	}

	@Override
	public String toString() {
		return "{\n ISBN: " + this.getISBN() + ";\n titolo: " + this.getTitolo() + ";\n anno di publicazione: "
				+ this.getAnnoPublicazione() + ";\n numero pagine: " + this.getnPagine() + ";\n periodicita: "
				+ this.periodicita + ";\n}";
	}
}
