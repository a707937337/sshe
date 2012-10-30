package sy.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent hse) {
		System.out.println("sessionCreated ");
	}

	public void sessionDestroyed(HttpSessionEvent hse) {
		System.out.println("sessionDestroyed ");
	}
}
