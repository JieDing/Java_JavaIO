package com.jieding.filetest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;

public class RandomAccessFileTest {
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
		
		try(RandomAccessFile raf = new RandomAccessFile(f,"rw")){
			raf.seek(f.length()-5);		//Sets the file-pointer offset
			byte[] b = new byte[5];
			int data = raf.read(b);
			for(byte b2: b)
				System.out.print((char)b2);
			System.out.println();
			raf.seek(f.length()-5);	
			raf.write("-inter-".getBytes());
		}catch (IOException e){
			e.printStackTrace();
		}
		
		
	}

}
