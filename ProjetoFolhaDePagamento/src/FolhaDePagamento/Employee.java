package FolhaDePagamento;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

//import FolhaDePagamento.Employee;

public abstract class Employee implements Cloneable {
	protected String name;
	protected String address;
	protected String type; //"hourly" "commissioned" "salaried"
	protected String paymentMethod; //"correios" "maos" "conta"
	protected boolean union;   //true = pertence ao sindicato; false = não pertence
	protected String unionName; //nome do sindicato
	protected double unionTax; //taxa sindical
	protected double totalSalary;
	protected int ID;
	
	protected Calendar paymentDate;
	protected String dateFormat;
	
	public Employee() {
	}
	
	/*
	public Employee(String name, String address, String type, String paymentMethod,
			String unionName, double unionTax, double totalSalary, boolean union, int id) {
		this.name = name;
		this.address = address;
		this.type = type;
		this.paymentMethod = paymentMethod;
		this.unionName = unionName;
		this.unionTax = unionTax;
		this.totalSalary = totalSalary;
		this.union = union;
		this.ID = id;
	}*/
	
	/**
	 * Setters e Getters
	 */
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public boolean getUnion() {
		return union;
	}
	
	public void setUnion(boolean union) {
		this.union = union;
	}
	
	public String getUnionName() {
		return unionName;
	}
	
	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}
	
	public double getUnionTax() {
		return unionTax;
	}
	
	public void setUnionTax(double unionTax) {
		this.unionTax = unionTax;
	}
	
	public Calendar getPaymentDate() {
		return paymentDate;
	}
	
	public void setPaymentDate(Calendar paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	public String getDateFormat() {
		return dateFormat;
	}
	/**
	 * M�todos abstratos
	 */
	public abstract void employeeRegister(String type, ArrayList<Employee> employeeList);
	
	/**
	 * M�todo clone 
	 */
	public Employee clone() {
        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {        
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
