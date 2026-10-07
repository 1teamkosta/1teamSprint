package kr.swdl.servlet;

public class ActionFactory {

	public static Action getAction(String cmd) {
		if(cmd == null) {
			cmd = "";
		}
		Action a = null;
		
		switch (cmd) {
		case "qnaListUI":
			a = new QnAListUIAction();
			break;
		
	
			
		case "":
		default:
			a = new MainUIAction();
			break;
		}
		return a;
		
	}
}
