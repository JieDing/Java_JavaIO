package com.jieding.arraytest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ByteArrayIOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] b = "hello world".getBytes();
		
		try(InputStream in = new ByteArrayInputStream(b)) {
			int data = in.read();
			while(data != -1){
				System.out.print((char) data);
				data = in.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		try(ByteArrayOutputStream out = new ByteArrayOutputStream()){
			out.write("hello world".getBytes());
			byte[] receive = out.toByteArray();
			System.out.println(Arrays.toString(receive));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
