package com.jieding.combtest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CombTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (DataOutputStream dos = new DataOutputStream(
			    new FileOutputStream("abc.txt"));){
			System.out.println("世界".getBytes().length);
			dos.writeInt(12);
		/*	dos.writeChars("世界"); 
			dos.writeUTF("世界");  */ 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (DataInputStream dis = new DataInputStream(
			    new FileInputStream("abc.txt"));){
			
			 byte[] b = new byte[4];  
	            int x = dis.readInt(); 
	            System.out.println(x);  

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
