package com.jieding.basictest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(InputStream in = ByteStreamTest.class.getClassLoader().getResourceAsStream("com/jieding/resources/abc.txt")){
			int data = in.read();
			while(data != -1){
				System.out.print((char) data);
				//一个字节一个字节的读输入字节流中的数据
				data = in.read();
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		
		try(InputStream in = ByteStreamTest.class.getClassLoader().getResourceAsStream("com/jieding/resources/abc.txt")){
			byte[] b = new byte[1024];
			//已将输入字节流中的数据存储在了字节数组b中
			int bytesRead = in.read(b);  
			System.out.println(bytesRead);
			while(bytesRead != -1){
				
				//返回-1因为已经没有数据
				bytesRead = in.read(b);
				System.out.println(bytesRead);
			}
			for(int i=0;i<9;i++){
				System.out.print((char) b[i]);
			}
			System.out.println();
			System.out.println(b.length);
		}catch (IOException e){
			e.printStackTrace();
		}
		
		try(ByteArrayOutputStream out = new ByteArrayOutputStream()){
			 
			out.write(104);
			byte[] b = out.toByteArray();
			for(byte b1: b){
				System.out.println((char)b1);
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		
		
	}

}
