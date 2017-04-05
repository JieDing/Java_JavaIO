package com.jieding.bytesIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class BytesInputAndOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File(System.getProperty("user.dir")+"/bin/com/jieding/bytesIO","bytes.data");
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//向文件中写一个
		try (DataOutputStream out = new DataOutputStream(
				new FileOutputStream(f))){
			
			
			out.writeUTF("hello_world");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(DataInputStream in = new DataInputStream(
				new FileInputStream(f))){
			
			byte[] bytes = new byte["hello_world".length()*2];
			in.read(bytes);
			System.out.println(Arrays.toString(bytes));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
