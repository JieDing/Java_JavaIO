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
			
			
			ByteBuffer buffer = ByteBuffer.allocate(100);
			CharBuffer cBuffer = CharBuffer.allocate(100);
			CharsetDecoder decoder = Charset.forName("utf-16BE").newDecoder();
			
			
			String a = "hello\n";
			String b = "world\n";
			String c = "jie\n";
			/*
			 * 未插入数据前，buffer的position=0；limit = capacity=100；
			 */
			System.out.println("limit "+buffer.limit());
			System.out.println("position "+buffer.position());
			
			buffer.put(a.getBytes("utf-16BE"), 0, a.length()*2);
			buffer.put(b.getBytes("utf-16BE"), 0, b.length()*2);
			buffer.put(c.getBytes("utf-16BE"), 0, c.length()*2);
			
			/*
			 * 插入数据后，buffer的position=32；limit = capacity=100；
			 */
			
			System.out.println("limit "+buffer.limit());
			System.out.println("position "+buffer.position());
			
			/*
			 * 切换为读模式，buffer的limit = position=32；position=0；
			 */
			buffer.flip();
			System.out.println("limit "+buffer.limit());
			System.out.println("position "+buffer.position());
			
			
			/*
			 * 将buffer中的数据输出到channel中，buffer的limit = position=32；position=32；
			 */
			while(buffer.hasRemaining()){
				channel.write(buffer);
			}
			
			System.out.println("limit "+buffer.limit());
			System.out.println("position "+buffer.position());
			
			/*
			 * 重置position，buffer的limit = position=32；position=0；
			 */
			buffer.rewind();
			System.out.println("limit "+buffer.limit());
			System.out.println("position "+buffer.position());
			
			/*
			 * 将buffer中的数据输出到charbuffer中，buffer的limit = position=32；position=32；
			 */
			decoder.decode(buffer, cBuffer, false);
			System.out.println("limit "+buffer.limit());
			System.out.println("position "+buffer.position());
			cBuffer.flip();
			
			System.out.println(cBuffer);
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
