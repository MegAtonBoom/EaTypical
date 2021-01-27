package logic.engineeringclasses.bean.manageMenu;

import java.util.ArrayList;

public class BeanAdvice {
	
	ArrayList<String> piattiMancanti;
	
	public BeanAdvice(ArrayList<String> listaPiattiMancanti) {
		this.piattiMancanti = listaPiattiMancanti;
	}

	public ArrayList<String> getPiattiMancanti() {
		return piattiMancanti;
	}

	public void setPiattiMancanti(ArrayList<String> piattiMancanti) {
		this.piattiMancanti = piattiMancanti;
	}
	
	
}
