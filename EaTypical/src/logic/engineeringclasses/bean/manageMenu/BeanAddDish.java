package logic.engineeringclasses.bean.manageMenu;

public class BeanAddDish {
	
	private String piatto;
	private String ristorante;
	private String contenuto;
	private boolean vegano;
	private boolean celiaco;
	private double prezzo;
	private int tipoModifica;
	
	public BeanAddDish(String piatto, String ristorante,String contenuto,boolean vegano, boolean celiaco, double prezzo,int tipoModifica) {
		this.piatto = piatto;
		this.ristorante = ristorante;
		this.contenuto = contenuto;
		this.vegano = vegano;
		this.celiaco = celiaco;
		this.prezzo = prezzo;
		this.tipoModifica = tipoModifica;
		
	}

	public String getPiatto() {
		return piatto;
	}

	public void setPiatto(String piatto) {
		this.piatto = piatto;
	}

	public String getRistorante() {
		return ristorante;
	}

	public void setRistorante(String ristorante) {
		this.ristorante = ristorante;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}

	public boolean isCeliaco() {
		return celiaco;
	}

	public void setCeliaco(boolean celiaco) {
		this.celiaco = celiaco;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getTipoModifica() {
		return tipoModifica;
	}

	public void setTipoModifica(int tipoModifica) {
		this.tipoModifica = tipoModifica;
	}
	
	

}
