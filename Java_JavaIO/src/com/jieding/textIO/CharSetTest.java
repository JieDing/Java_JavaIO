package com.jieding.textIO;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;

public class CharSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 列出所有Java支持的字符集
		 */
		Map<String,Charset> charsets = Charset.availableCharsets();
		for(String name : charsets.keySet()){
			System.out.println(name);
		}
		
		Charset charset = Charset.forName("UTF-8");
		String str = "hello_jieding_world";
		ByteBuffer buffer = charset.encode(str);
		byte[] bytes = buffer.array();
		System.out.println(Arrays.toString(bytes));
		byte[] bytes2 = null;
		try {
			 bytes2 =str.getBytes("UTF-8");
			System.out.println(Arrays.toString(bytes2));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(charset.decode(buffer).toString());
		System.out.println(charset.decode(ByteBuffer.wrap(bytes2)).toString());
		
	}

}
