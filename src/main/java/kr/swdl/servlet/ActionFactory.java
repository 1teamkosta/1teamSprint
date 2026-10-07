package kr.swdl.servlet;

public class ActionFactory {

	public static Action getAction(String cmd) {
		if(cmd == null) {
			cmd = "";
		}
		Action a = null;
		
		switch (cmd) {
		case "qnaUI":
			a=new QnAUIAction();
			break;
		case "addAnswer":
			a=new AddAnswerAction();
			break;
		default:
			a = new MainUIAction();
			break;
		}
		return a;
		
	}
}
