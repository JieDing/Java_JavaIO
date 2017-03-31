package com.jieding.filetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;

public class FileIOByteTest {
	static File f = null;
	public static void main(String[] args) {
		
		try {
			f = new File(FileIOByteTest.class.getClassLoader().getResource("com/jieding/resources/abc.txt").toURI());			
		} 
		catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(InputStream in = new FileInputStream(f)){
			byte[] b = new byte[10];
			int bytesRead = in.read(b);
			int bufferSize = bytesRead;
			while(bytesRead != -1){
				bytesRead = in.read(b);
			}
			for(int i=0; i<bufferSize; i++){
				System.out.print((char)b[i]);
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		
		try(OutputStream out = new FileOutputStream(f)){
			out.write("hello_world".getBytes());
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
}
