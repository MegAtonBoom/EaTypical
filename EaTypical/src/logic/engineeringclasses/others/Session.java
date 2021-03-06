package logic.engineeringclasses.others;

import logic.model.User;

public class Session {

	private SizedStack sizedStack;
	private User user;
	private boolean isOwner;
	
	public boolean isOwner() {
		return isOwner;
	}

	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	public Session(boolean isWeb) {
		this.user = null;
		//True --> WEB		False --> StandAlone
		this.sizedStack = new SizedStack(isWeb);
	}

	public SizedStack getSizedStack() {
		return sizedStack;
	}

	public void setSizedStack(SizedStack sizedStack) {
		this.sizedStack = sizedStack;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
