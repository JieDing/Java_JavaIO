package com.jieding.filetest;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;

public class FileIOCharTest {
	static File f = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			f = new File(FileIOByteTest.class.getClassLoader().getResource("com/jieding/resources/abc.txt").toURI());			
			System.out.println(f.getAbsolutePath());
		} 
		catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(Reader in = new FileReader(f)){
			char[] b = new char[15];
			int charsRead = in.read(b);
			int bufferRead = charsRead;
			while(charsRead != -1){
				charsRead = in.read(b);
			}
			for(int i=0; i<bufferRead;i++)
				System.out.print(b[i]);
			System.out.println();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		try(Writer out = new FileWriter(f)){
			out.write("hello_world".toCharArray());
			out.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
