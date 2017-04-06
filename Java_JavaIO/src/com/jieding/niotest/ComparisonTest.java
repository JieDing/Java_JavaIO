package com.jieding.niotest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ComparisonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path workDirectory = Paths.get(System.getProperty("user.dir"));
		Path fromFilePath = workDirectory.resolve("tempFile/log.5e6");
		Path toFilePath = workDirectory.resolve("tempFile/lognew.5e6");
		File fromFile = new File(fromFilePath.toString());
		File toFile = new File(toFilePath.toString());
		if(!fromFile.exists()){
			try {
				fromFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!toFile.exists()){
			try {
				toFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		transferFileByChannel(fromFile,toFile);
		transferFileByBufferOutputStream(fromFile,toFile);
		transferFileByOutputStream(fromFile,toFile);
	}
	
	public static void transferFileByChannel(File from,File to){
		try(FileChannel fromChannel = new RandomAccessFile(from,"r").getChannel();
			FileChannel toChannel = new RandomAccessFile(to,"rw").getChannel();) {
			
			
			System.out.println("target file size is: "+fromChannel.size());
			
			long startTime = System.currentTimeMillis();
			fromChannel.transferTo(0, fromChannel.size(), toChannel);
			long finishTime = System.currentTimeMillis();
		    System.out.println("Channel Need time is:"+(finishTime - startTime));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void transferFileByOutputStream(File from,File to){
		try(	FileInputStream fis = new FileInputStream(from);
				FileOutputStream fos = new FileOutputStream(to);) {
			
			byte[] buff = new byte[2048];
			long startTime = System.currentTimeMillis();
			int len = fis.read(buff);
			
		        while(len != -1){
		        	
		            fos.write(buff, 0, len);
		            len = fis.read(buff);
		        }
	        long finishTime = System.currentTimeMillis();
		    System.out.println("Stream Need time is:"+(finishTime - startTime));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void transferFileByBufferOutputStream(File from,File to){
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(from));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(to));) {
			
			byte[] buff = new byte[2048];
			long startTime = System.currentTimeMillis();
			int len = bis.read(buff);
			while(len !=-1){
				bos.write(buff, 0, len);
				len = bis.read(buff);
			}
			 long finishTime = System.currentTimeMillis();
			 System.out.println("Buffer Need time is:"+(finishTime - startTime));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
