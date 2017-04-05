package com.jieding.niotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChannelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path workDirectory = Paths.get(System.getProperty("user.dir"));
		Path file = workDirectory.resolve("tempFile/abc.data");
		File f = new File(file.toString());
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try(FileChannel channel = new RandomAccessFile(f,"rw").getChannel()){
			
			
			ByteBuffer buffer = ByteBuffer.allocate(60);
			CharBuffer cBuffer = CharBuffer.allocate(60);
			CharsetDecoder decoder = Charset.forName("utf-16BE").newDecoder();
			
			
			String a = "hello\n";
			String b = "world\n";
			buffer.put(a.getBytes("utf-16BE"), 0, a.length()*2);
			buffer.put(b.getBytes("utf-16BE"), 0, b.length()*2);
			
			buffer.flip();
			
			while(buffer.hasRemaining()){
				channel.write(buffer);
			}
			
			int bytesRead = channel.read(buffer);
			
			while(bytesRead !=-1){
				System.out.println("read "+ bytesRead);
				buffer.flip();
				decoder.decode(buffer, cBuffer, false);
				cBuffer.flip();
				
				System.out.println(cBuffer);
				buffer.clear();
				cBuffer.clear();
				bytesRead = channel.read(buffer);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
