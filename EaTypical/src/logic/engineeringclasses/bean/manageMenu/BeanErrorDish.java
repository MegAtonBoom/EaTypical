package logic.engineeringclasses.bean.manageMenu;

public class BeanErrorDish {
	
	private String piatto;
	private String ristorante;
	
	public BeanErrorDish(String piatto,String ristorante) {
		this.piatto = piatto;
		this.ristorante = ristorante;
	}
	
	public String getMess() {
		return "Il piatto ** "+piatto+" ** non è presente nel ristorante ** " + ristorante + " **";
	}
}
