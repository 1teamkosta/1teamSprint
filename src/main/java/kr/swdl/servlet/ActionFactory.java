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
		case "addAnswerAction":
			a=new AddAnswerAction();
			break;
		case "adoptAnswerAction":
			a=new adoptAnswerAction();
			break;
		default:
			a = new MainUIAction();
			break;
		}
		return a;
		
	}
}
