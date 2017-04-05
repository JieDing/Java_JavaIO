package com.jieding.textIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextInputAndOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(PrintWriter out = new PrintWriter("abc.txt");) {
			
			out.print("¹þà¶");
			out.print(' ');
			out.println(12);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(Scanner in = new Scanner(new InputStreamReader(new FileInputStream("abc.txt")))){
			while(in.hasNext()){
				System.out.println(in.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
