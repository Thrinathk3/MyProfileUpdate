package com.tmb.reports;

public class ConsoleLoggerimpl implements Loggable {

	@Override
	public void log(String status, String message) {
		System.out.println(status+"-------->"+message);
	}

}
