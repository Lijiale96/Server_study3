package com.shsxt.server;

public class LoginServlet implements Servlet {

	@Override
	public void  service(Request request,Response response) {
		response.print("<html>");
		response.print("<head>");
		response.print("<title>");
		response.print("��һ��servlet");
		response.print("</title>");
		response.print("<head>");
		response.print("<body>");
		response.print("��ӭ������"+request.getParameter("uname"));
		response.print("</body>");
		response.print("</html>");
	}

}
