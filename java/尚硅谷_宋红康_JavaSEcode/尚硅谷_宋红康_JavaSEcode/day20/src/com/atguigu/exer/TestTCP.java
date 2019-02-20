package com.atguigu.exer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.junit.Test;
//客户端给服务端发送文本，服务端会将文本转成大写在返回给客户端。
//如下程序为了保证相应的流及socket的关闭（即使在关闭之前出现异常，也一定要保证相应的资源的关闭），要求是用
//try-catch-finally进行操作。要求将关闭的信息写在finally里！

public class TestTCP {

	@Test
	public void client() {
		// 1.
		Socket socket = null;
		// 2.
		OutputStream os = null;
		Scanner scanner = null;
		// 4.接收来自于服务端的数据
		InputStream is = null;
		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
			os = socket.getOutputStream();
			// 3.向服务端发送数据
			// os.write("abc".getBytes());
			System.out.println("请输入多个字符：");
			scanner = new Scanner(System.in);
			String str = scanner.next();
			os.write(str.getBytes());
			socket.shutdownOutput();
			is = socket.getInputStream();
			byte[] b = new byte[10];
			int len;
			while ((len = is.read(b)) != -1) {
				String str1 = new String(b, 0, len);
				System.out.print(str1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5.
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(scanner != null){
				scanner.close();
				
			}
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}

	@Test
	public void server() {
		// 1.
		ServerSocket ss = null;
		// 2.
		Socket s = null;
		// 3.接收来自于客户端的信息
		InputStream is = null;
		// 4.返回给客户端
		OutputStream os = null;
		try {
			ss = new ServerSocket(9090);
			s = ss.accept();
			is = s.getInputStream();
			byte[] b = new byte[10];
			int len;
			String str = new String();
			while ((len = is.read(b)) != -1) {
				String str1 = new String(b, 0, len);
				str += str1;
			}
			String strUpperCase = str.toUpperCase();
			os = s.getOutputStream();
			os.write(strUpperCase.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(s != null){
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(ss != null){
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		// 5.
	}
}
