package com.jieding.systemiotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SystemIOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			//ʹ����������ñ���Ŀ����Դ��λ��
			InputStream in = SystemIOTest.class.getClassLoader().getResourceAsStream("com/jieding/resources/abc.txt");
			
		
			try {
				InputStream in2 = new FileInputStream("C:\\Users\\admin\\git\\Java_JavaIO\\Java_JavaIO\\src\\com\\jieding\\resources\\abc.txt");
				System.setIn(in2);
				Scanner s = new Scanner(System.in);
				while(s.hasNext()){
					System.out.println(s.nextLine());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				OutputStream out = new FileOutputStream("C:\\Users\\admin\\git\\Java_JavaIO\\Java_JavaIO\\src\\com\\jieding\\resources\\abc.txt");
				PrintStream p = new PrintStream(out);
				System.setOut(p);
				System.out.println("hahah a");
				System.out.flush();  //ȷ�����
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}

}
