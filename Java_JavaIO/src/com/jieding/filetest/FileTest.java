package com.jieding.filetest;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class FileTest {
	static File f = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * �Ծ���·�����������ڵĵ��ļ���Ŀ¼
		 * ȡ���Ŀ¼�ָ���֮ǰ��Ϊ�µ�·��
		 * ֮���Ϊ�ļ�����Ŀ¼��
		 * ����f.createNewFile();�򴴽��ļ�
		 * ����f.mkdir();�򴴽�Ŀ¼
		 * ����f.mkdirs();��ǿ�ƴ���Ŀ¼(����֮ǰĿ¼�����в����ڵ�Ŀ¼)
		 */
		
	/*	f = new File("C:\\Users\\admin\\git\\Java_JavaIO\\Java_JavaIO\\bin\\com\\jieding\\resources\\ab.txt");
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!f.exists()){
			System.out.println(f.mkdir());
		}
	*/	
		
		
		/**
		 * class.getClassLoader().getResource("") ���Ի�ȡ��ǰ����Ŀ¼��binĿ¼���˷�������һ��URL����
		 * ���зָ������� '/'ʵ�ֵ�
		 * 
		 * System.getProperty("user.dir")  ���Ի�õ�ǰ����Ŀ¼�ľ���·��
		 * ���еķָ�����ȡ���ڲ���ϵͳ�ķָ���
		 * 
		 * ���ʹ��File f = new File(URI uri)����ȡ�ļ�
		 * ��uri�޷���λ��һ��ʵ�ʴ��ڵ��ļ�ʱ�����׳���ָ���쳣
		 */
		
	/*	System.out.println(FileTest.class.getClassLoader().getResource(""));
		System.out.println(FileTest.class.getClassLoader().getResource("com/jieding/resources/ab.txt"));
		System.out.println(System.getProperty("user.dir"));
		try {
			//��URIָ����ļ������ڣ�����׳���ָ���쳣
			f = new File(FileTest.class.getClassLoader().getResource("com/jieding/resources/ab.txt").toURI());
			if(!f.exists()){
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(!f.exists()){
				System.out.println(f.mkdir());
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/**
		 * ��Ŀ¼�������ļ�������ʽ���д����ļ�
		 */
	/*	f = new File(System.getProperty("user.dir")+"/bin/com/jieding/resources", "abc.txt");
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		if(!f.exists()){
			System.out.println(f.mkdir());
		}*/
	}

}
