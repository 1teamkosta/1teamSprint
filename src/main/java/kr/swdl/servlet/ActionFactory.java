package kr.swdl.servlet;

public class ActionFactory {

	public static Action getAction(String cmd) {
		
		if(cmd ==null) cmd="";
		Action a=null;
		//메뉴를 규칙이 없지만 값을 비교
		switch(cmd) {
		case "tradeWrite":
			a = new TradeWriteUIAction();
			break;
		case "addTrade":
			a = new AddTradeAction();
			break;
		case "setTrade":
			a = new SetTradeAction();
			break;
		case "deleteTrade":
			a = new DeleteTradeAction();
			break;
		case "viewTrade":
			a = new ViewTradeUIAction();
			break;
		case "addRely":
			a = new AddRelyAction();
			break;
		case "setRely":
			a = new SetRelyAction();
			break;
		case "deleteRely":
			a = new DeleteRelyAction();
			break;
		
			
			
		case "tradeSearchAction":
			a=new TradeSearchAction();
			break;
		case "tradeListUI":
			a=new TradeListUIAction();
			break;
	
		default :
			a=new MainUIAction();			
		}		
		return a;
	}

}
