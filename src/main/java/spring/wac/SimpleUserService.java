package spring.wac;

public class SimpleUserService {
	
	private LoginAction loginAction;

	public void setLoginAction(LoginAction loginAction) {
		this.loginAction = loginAction;
	}
	
	public String performLogin() {
		return loginAction.getPassword();
	}
	
}
