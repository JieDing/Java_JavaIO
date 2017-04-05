package com.jieding.fileAndPath;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MappingFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path workPath = Paths.get(System.getProperty("user.dir"));
		Path file = workPath.resolve("tempFile/abc.data");
		
		File f = new File(file.toString());
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/*try(DataOutputStream out = new DataOutputStream(
				new FileOutputStream(f))){
			out.write("扂請間豌\n".getBytes("UTF-16BE"));
			out.write("扂請間豌2\n".getBytes("UTF-16BE"));
			out.write("扂請間豌3\n".getBytes("UTF-16BE"));
			out.write("扂請間豌4\n".getBytes("UTF-16BE"));
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		
		
		try{
			RandomAccessFile randomAccessFile = new RandomAccessFile(f, "rw");
			FileChannel channel = randomAccessFile.getChannel();
			int length = (int) channel.size();
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, length);
			
			ByteBuffer b = buffer.duplicate();
	
			
			System.out.print(Charset.forName("UTF-16BE").decode(b));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
