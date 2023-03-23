package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import util.enu.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel workLevel;
	private Double baseSalary;
	private ArrayList <HourContract> contracts;
	private Department department;
	
	public Worker(String name, WorkerLevel workLevel, Double baseSalary, ArrayList<HourContract> contracts, Department department) {
		this.name = name;
		this.workLevel = workLevel;
		this.baseSalary = baseSalary;
		this.contracts = contracts;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public WorkerLevel getWorkLevel() {
		return workLevel;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public ArrayList<HourContract> getContract() {
		return contracts;
	}

	public Department getDepartment() {
		return department;
	}
	
	
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract (HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(Date date) {
		
		Double ret=baseSalary;
		
		for(int i=0; i<contracts.size(); i++)
		{
			if(contracts.get(i).getDateMonth() == date.getMonth() && contracts.get(i).getDateYear() == date.getYear())
			{
				Double sal = contracts.get(i).totalValue();
				ret += sal;
			}
			else if(i == contracts.size()-1)
			{
				System.out.println("No date found");
			}
		}
		return ret;
	}

	public String toString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		return "Name: " +name+
				"\nWorkLevel: " +workLevel+
				"\nDepartment: " +department.toString()+
				"\nIncome for " +sdf.format(date)+ ": " + String.format("%.2f", income(date)) ;
		
		
	}
	
	
	
}
