package com.jieding.arraytest;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

public class CharArrayIOTest {
	public static void main(String[] args) {
		char[] c = "hello world".toCharArray();
		try(Reader in = new CharArrayReader(c)){
			int data = in.read();
			while(data != -1){
				System.out.print((char) data);
				data = in.read();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println();
		
		try(CharArrayWriter out = new CharArrayWriter()){
			out.write("hello world".toCharArray());
			char[] c2 = out.toCharArray();
			System.out.println(Arrays.toString(c2));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
