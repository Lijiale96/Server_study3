package com.shsxt.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/*
 * Ŀ�꣺������Servlet������ҵ�����
 */
public class Server06 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
	
		Server06 server = new Server06();
		server.start();
		
	}
	//��������
	public void start() {
		
		try {
			serverSocket = new ServerSocket(8888);
			 receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("����������ʧ��...");
		}		
	}
	//�������Ӵ���
    public void receive() {
    	try {
			Socket client = serverSocket.accept();
			System.out.println("һ���ͻ��˽��������ӡ�����");
			//��ȡ����Э��
			Request request = new Request(client);
			//��ȡ��ӦЭ��
			Response response = new Response(client);
			 Servlet servlet =  null;
			if (request.getUrl().equals("login")) {
				servlet =  new LoginServlet();
			}else if(request.getUrl().equals("reg")) {
				servlet =  new RegisterServlet();
			}else {
				//��ҳ������
			}
	      servlet.service(request, response);
			
		   //��ע��״̬��
			response.pushToBrowser(200);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ͻ��˴���");
		}
	}    
    //ֹͣ����
    public void stop() {
		
	}
}
