package chemp.notes.linenotify;

import java.util.Calendar;


public class Run {

	public static void main(String[] args) {
		LineNotify test = new LineNotify();
		Calendar calendar = Calendar.getInstance();
		test.callEvent("Hello!!! My name is Niwes Tipboonchu");
		System.out.println("Alert!!! Test Success Time : "+calendar.get(Calendar.HOUR)+":"+ calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));

	}

}
