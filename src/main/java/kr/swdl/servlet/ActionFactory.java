package kr.swdl.servlet;

public class ActionFactory {

	public static Action getAction(String cmd) {
		if(cmd == null) {
			cmd = "";
		}
		Action a = null;
		
		switch (cmd) {
		
		case "TradeAction":
			a = new TradeAction();
			break;
	
		case "addReplyAction":
			a = new AddReplyAction();
			break;
			
		case "setReplyAction":
			a = new SetReplyAction();
			break;
			
		case "deleteReplyAction":
			a = new DeleteReplyAction();
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
			
		case "qnaUI":
			a=new QnAUIAction();
			break;
			
		case "addQnaUI":
			a=new AddQnaUIAction();
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
			
		case "":
		default:
			a = new MainUIAction();
			break;
		}
		return a;
		
	}
}
