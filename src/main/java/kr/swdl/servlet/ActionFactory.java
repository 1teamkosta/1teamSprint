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
			break;
			
		case "":
		default:
			a = new MainUIAction();
			break;
		}
		return a;
		
	}
}
