package com.shsxt.server;

public class OthersServlet implements Servlet {

	@Override
	public void  service(Request request,Response response) {
		response.print("ÆäËü²âÊÔÒ³Ãæ");
	}

}
