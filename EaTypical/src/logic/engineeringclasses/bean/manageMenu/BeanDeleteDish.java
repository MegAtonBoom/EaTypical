package logic.engineeringclasses.bean.manageMenu;


/**
 * 
 * @author Luca Capotombolo
 *
 */

public class BeanDeleteDish {
	
	private String ristorante;
	private String piatto;
	private int tipoModifica;
	
	public BeanDeleteDish(String ristorante, String piatto,int tipoModifica) {
		this.ristorante = ristorante;
		this.piatto = piatto;
		this.tipoModifica = tipoModifica;
	}

	public int getTipoModifica() {
		return tipoModifica;
	}

	public void setTipoModifica(int tipoModifica) {
		this.tipoModifica = tipoModifica;
	}

	public String getRistorante() {
		return ristorante;
	}

	public void setRistorante(String ristorante) {
		this.ristorante = ristorante;
	}

	public String getPiatto() {
		return piatto;
	}

	public void setPiatto(String piatto) {
		this.piatto = piatto;
	}
	
	
	
}
