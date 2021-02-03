package logic.engineeringclasses.bean.manageMenu;

import java.util.List;

public class BeanAdvice {
	
	List<String> piattiMancanti;
	
	public BeanAdvice(List<String> listaPiattiMancanti) {
		this.piattiMancanti = listaPiattiMancanti;
	}

	public List<String> getPiattiMancanti() {
		return piattiMancanti;
	}

	public void setPiattiMancanti(List<String> piattiMancanti) {
		this.piattiMancanti = piattiMancanti;
	}
	
	
}
