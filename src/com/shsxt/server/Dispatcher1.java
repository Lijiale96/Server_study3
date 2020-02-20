package com.shsxt.server;

import java.io.IOException;
import java.net.Socket;


/**
 * �ַ���
 * @author A
 *
 */
public class Dispatcher1 implements Runnable{
	private Socket client;
	private Request request;
	private Response response;
	
  public Dispatcher1(Socket client) {
	  this.client=client;
	  try {
			//��ȡ����Э��
			//��ȡ��ӦЭ��
		request = new Request(client);
		  response = new Response(client);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	this.release();
	}
	
  }
	@Override
	public void run() {
	   try {
		 Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
		 if (null!=servlet) {
			servlet.service(request, response);
			 //��ע��״̬��
			response.pushToBrowser(200);
		}else {
			//���󡣡�
			response.pushToBrowser(404);
		}
	   }catch(Exception e) {
		   try {
			response.pushToBrowser(500);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	   }
	   release();
	}

//�ͷ���Դ	
	private void release() {
		try {
			client.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
