package com.shsxt.server;

/**
 * 服务器小脚本接口
 * 
 * @author A
 *
 */
public interface Servlet {
	 void service(Request request,Response response);
	// void doGet(Request request,Response response);
	 //void doPost(Request request,Response response);
}
