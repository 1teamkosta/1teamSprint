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
			a=new AddQnaAction();
			break;
		case "setQnaUI":
			a=new SetQnaUIAction();
			break;
		case "setQnaAction":
			a=new SetQnaAction();
			break;
		case "deleteQnaAction":
			a=new DeleteQnaAction();
			break;
		case "addAnswerAction":
			a=new AddAnswerAction();
			break;
		case "setAnswerAction":
			a=new SetAnswerAction();
			break;
		case "deleteAnswerAction":
			a=new DeleteAnswerAction();
			break;
		case "adoptAnswerAction":
			a=new AdoptAnswerAction();
			break;
		default:
			a = new MainUIAction();
			break;
		}
		return a;
		
	}
}
