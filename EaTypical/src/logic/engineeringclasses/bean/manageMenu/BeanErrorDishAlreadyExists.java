package logic.engineeringclasses.bean.manageMenu;

public class BeanErrorDishAlreadyExists {

	private String nomePiatto;
	
	public BeanErrorDishAlreadyExists(String nomePiatto) {
		this.nomePiatto = nomePiatto;
	}

	public String getMess() {
		return "Il piatto ** "+nomePiatto+" ** già è stato inserito";
	}

	
	
}
