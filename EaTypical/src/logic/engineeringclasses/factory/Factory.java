package logic.engineeringclasses.factory;

public class Factory {
	
	private static Factory instance=null;
	
	protected Factory() {}
	
	public static synchronized Factory getFactory() {
		if(Factory.instance==null) {
			Factory.instance = new Factory();
		}
		return Factory.instance;
	}
	
	// Methods for DAOs creation
	
}
