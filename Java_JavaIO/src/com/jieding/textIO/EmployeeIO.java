package com.jieding.textIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EmployeeIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] emps = new Employee[5];
		
		for(int i=0; i<emps.length; i++)
			emps[i] = new Employee("jieding"+i, 24, 6500);
		
		File f = new File(System.getProperty("user.dir")+"/bin/com/jieding/textIO", "employee.data");
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try (PrintWriter out = new PrintWriter(f);){
			writeEmpArray(emps, out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (Scanner in = new Scanner(f);) {
			String firstLine = in.nextLine();
			int num = Integer.parseInt(firstLine.substring(0,firstLine.indexOf(" ")));
			Employee[] empss = new Employee[num];
			for(int i=0; i<num; i++){
				String lineData = in.nextLine();
				String[] data = lineData.split("\\|");
				String name = data[0];
				int age = Integer.parseInt(data[1]);
				double salary = Double.parseDouble(data[2]);
				empss[i] = new Employee(name, age, salary);
			}
			
			for(Employee e: empss)
				System.out.println(e.getName() +" " +e.getAge()+" "+e.getSalary());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeEmpArray(Employee[] emps, PrintWriter out){
		out.println(emps.length+" records in total");
		for(Employee e : emps){
			out.print(e.getName());
			out.print("|");
			out.print(e.getAge());
			out.print("|");
			out.print(e.getSalary());
			out.print("\n");
		}
	}

}
