package kr.swdl.servlet;

public class ActionFactory {

	public static Action getAction(String cmd) {
		
		if(cmd ==null) cmd="";
		Action a=null;
		//메뉴를 규칙이 없지만 값을 비교
		switch(cmd) {
		case "searchAction":
			a=new SearchAction();
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
