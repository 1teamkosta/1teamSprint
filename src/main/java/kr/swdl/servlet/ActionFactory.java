package kr.swdl.servlet;

public class ActionFactory {

	public static Action getAction(String cmd) {
		if(cmd == null) {
			cmd = "";
		}
		Action a = null;
		
		switch (cmd) {
		
		case "bizMainUIAction":
			a= new bizMainUIAction();
			break;
			
		case "idCheck":
			a = new IdCheckAction();
			break;
			
		case "nicknameCheck":
			a = new NicknameCheckAction();
			break;
			
		
		case "signUpAction":
			a = new signUpAction();
			break;
		
		case "loginUIAction":
			a = new LoginUIAction();
			break;
			
		case "loginAction":
			a = new LoginAction();
			break;
			
		case "":
		default:
			a = new MainUIAction();
			break;
		}
		return a;
		
	}
}
