package kr.swdl.servlet;


public class ActionFactory {

	public static Action getAction(String cmd) {

		if(cmd ==null) cmd="";
		Action a=null;
		//메뉴를 규칙이 없지만 값을 비교
		switch (cmd) {
		case "addTradeAction":
			a = new AddTradeAction();
			break;
		case "deleteTrade":
			a=new deleteTradeAction();
			break;

		case "tradeWriteUIAction":
			a= new TradeWriteUIAction();
			break;
		case "viewTrade":
			a= new ViewTradeUIAction();
			break;
		case "viewQnA":
			a = new ViewQnAUIAction();
			break;

		case "setTrade":
			a= new SetTradeActionUI();
			break;
		case "setTradeAction":
			a= new SetTradeAction();
			break;
		case "addReplyAction":
			a = new AddReplyAction();
			break;
		case "setReplyAction":
			a = new SetReplyAction();
			break;
			//case "deleteReplyAction":
			//	a = new DeleteReplyAction();
			//	break;
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
			
			
		case "qnaListAction":
		a=new QnAListAction();
		break;
		case "tradeListUI":
			a=new TradeListUIAction();
			break;
		case "":
		default :
			a=new MainUIAction();			
		}		
		return a;
	}

}
