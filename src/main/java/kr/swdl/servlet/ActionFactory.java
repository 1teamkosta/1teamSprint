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
		case "addQnaAction":
			a=new addQnaAction();
			break;
		case "setQnaUI":
			a=new setQnaUIAction();
			break;
		case "setQnaAction":
			a=new setQnaAction();
			break;
		case "deleteQnaAction":
			a=new deleteQnaAction();
			break;
		case "addAnswerAction":
			a=new AddAnswerAction();
			break;
		case "setAnswerAction":
			a=new setAnswerAction();
			break;
		case "deleteAnswerAction":
			a=new deleteAnswerAction();
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
