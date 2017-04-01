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
		 * 以绝对路径创建不存在的的文件或目录
		 * 取最后目录分隔符之前的为新的路径
		 * 之后的为文件名或目录名
		 * 调用f.createNewFile();则创建文件
		 * 调用f.mkdir();则创建目录
		 * 调用f.mkdirs();则强制创建目录(创建之前目录中所有不存在的目录)
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
		 * class.getClassLoader().getResource("") 可以获取当前工作目录的bin目录，此方法返回一个URL对象
		 * 其中分隔符是以 '/'实现的
		 * 
		 * System.getProperty("user.dir")  可以获得当前工作目录的绝对路径
		 * 其中的分隔符是取决于操作系统的分隔符
		 * 
		 * 如果使用File f = new File(URI uri)来获取文件
		 * 但uri无法定位到一个实际存在的文件时，会抛出空指针异常
		 */
		
	/*	System.out.println(FileTest.class.getClassLoader().getResource(""));
		System.out.println(FileTest.class.getClassLoader().getResource("com/jieding/resources/ab.txt"));
		System.out.println(System.getProperty("user.dir"));
		try {
			//若URI指向的文件不存在，则会抛出空指针异常
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
		 * 以目录名，与文件名的形式进行创建文件
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
