package kr.swdl.servlet;

public class ActionFactory {

	public static Action getAction(String cmd) {
		if(cmd == null) {
			cmd = "";
		}
		Action a = null;
		
		switch (cmd) {
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
