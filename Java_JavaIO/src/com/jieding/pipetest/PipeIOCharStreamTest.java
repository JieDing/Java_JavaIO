package com.jieding.pipetest;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipeIOCharStreamTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final  PipedWriter out = new PipedWriter();
		final PipedReader in = new PipedReader();
		
		out.connect(in);
		
		Thread writeThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					out.write("hi girl");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread readThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					int data = in.read();
					while(data != -1){
						System.out.print((char) data);
						data = in.read();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		
		writeThread.start();
		readThread.start();
	}

}
