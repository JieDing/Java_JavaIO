package com.jieding.serialtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee w = new Employee("w", 24, 100.0);
		Manager m1 = new Manager("m1", 25, 1000.0);
		m1.setSecretary(w);
		Manager m2 = new Manager("m2", 26, 2000.0);
		m2.setSecretary(w);
		
		Employee[] emps = new Employee[3];
		emps[0] = w;
		emps[1] = m1;
		emps[2] = m2;
		File f = new File(System.getProperty("user.dir")+"/bin/com/jieding/serialtest","emp.data");
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try (ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream(f))){
			oos.writeObject(emps);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(ObjectInputStream ois  = new ObjectInputStream(new FileInputStream(f))){
			Employee[] empss = (Employee[]) ois.readObject();
			Employee sec = empss[0];
			sec.setSalary(1212.12);
			System.out.println(sec.getId());
			Manager mm1 = (Manager) empss[1];
			System.out.println(mm1.getSecretary().getSalary());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
