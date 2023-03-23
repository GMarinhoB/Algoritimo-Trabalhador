package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import util.Department;
import util.HourContract;
import util.Worker;
import util.enu.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String dep = sc.nextLine();
		Department department = new Department(dep);
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		WorkerLevel lvl = WorkerLevel.valueOf(level);
		System.out.print("Base salary: ");
		Double salary = sc.nextDouble();
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		clearBuffer(sc);
		
		ArrayList<HourContract> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			System.out.println("Enter the contratc #" +(i+1)+ " data:");
			System.out.print("Date(DD/MM/YYYY): ");
			String dateUser = sc.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = sdf.parse(dateUser);
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			Integer hours = sc.nextInt();
			clearBuffer(sc);
			HourContract hc = new HourContract(date, valuePerHour, hours);
			list.add(hc);
		}
		
		Worker worker = new Worker(name, lvl, salary, list, department);
		
		System.out.print("Enter month and year to calculate income(MM/YYYY): ");
		String dateUser = sc.nextLine();
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
		Date date = sdf2.parse(dateUser);
		
		System.out.print(worker.toString(date));
		
		sc.close();
	}

	 private static void clearBuffer(Scanner scanner) {
	        if (scanner.hasNextLine()) {
	            scanner.nextLine();
	        }
	    }
	
}
