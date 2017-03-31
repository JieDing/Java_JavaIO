package com.jieding.pipetest;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 
 * @ClassName: PipeIOStreamTest.java 
 * @author JieDing dingjwilliams@gmail.com
 *
 * @Description:
 */
public class PipeIOByteStreamTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final  PipedOutputStream out = new PipedOutputStream();
		final PipedInputStream in = new PipedInputStream(out);
		
		Thread writerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					out.write("helloWorld".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
		});
		
		Thread readerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try  {
					int data = in.read();
					while(data!=-1){
						System.out.print((char) data);
						data = in.read();
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
				finally{
					try {
						
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		writerThread.start();
		readerThread.start();
		
	}

}
