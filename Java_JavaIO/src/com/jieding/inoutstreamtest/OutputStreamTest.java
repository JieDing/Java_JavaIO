package com.jieding.inoutstreamtest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class OutputStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
