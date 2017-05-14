package FolhaDePagamento;

import FolhaDePagamento.Employee;
import FolhaDePagamento.SalariedEmployee;
import FolhaDePagamento.HourlyEmployee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimerTask;

public class HourlyEmployee extends Employee {
	public double hourlySalary; //salÃƒÂ¡
	public int workStart;
	public int workStop;
	public int diff;
	protected Chronometer chronometer;
	
	
	Scanner in = new Scanner(System.in);
	
	/**
	 * Construtor
	 */
	
	public HourlyEmployee() {
		this.chronometer = new Chronometer();
	}
	/*
	public HourlyEmployee(String name, String address, String type, String paymentMethod,
			String unionName, double unionTax, double totalSalary, boolean union,  id, 
			double hourlySalary) {
		
		this.name = name;
		this.address = address;
		this.type = type;
		this.paymentMethod = paymentMethod;
		this.unionName = unionName;
		this.unionTax = unionTax;
		this.totalSalary = totalSalary;
		this.union = union;
		this.ID = id;
		this.hourlySalary = hourlySalary;
	} */
	
	/**
	 * Getters e Setters
	 */
	
	public double getHourlySalary() {
		return hourlySalary;
	}
	
	public void setHourlySalary(double hourlySalary) {
		this.hourlySalary = hourlySalary;
	}
	
	public Chronometer getChronometer() {
		return chronometer;
	}

	public void setChronometer(Chronometer chronometer) {
		this.chronometer = chronometer;
	}
	
	public void setWorkStart(int workStart) {
		this.workStart = workStart;
	}
	
	public int getWorkStart() {
		return workStart;
	}
	
	public void setWorkStop(int workStop) {
		this.workStop = workStop;
	}
	
	public int getWorkStop() {
		return workStop;
	}
	
	public void setDiff() {
		this.diff = this.workStop - this.workStart;
	}
	
	public int getDiff() {
		return this.workStop - this.workStart;
	}
	/**
	 * MÃ©todos
	 * @param stack1 
	 */
	
	public void employeeRegister(String type, ArrayList<Employee> employeeList) {
		
		HourlyEmployee hEmployee = new HourlyEmployee();
		Scanner sc = new Scanner(System.in);
		
		hEmployee.setType(type);
		
		System.out.println("===============================");
		System.out.println("---- CADASTRO DE EMPREGADO ----");
		System.out.println("===============================");
		
		System.out.println("NOME: ");
		hEmployee.setName(in.nextLine());
		
		System.out.println("ENDEREÃ‡O: ");
		hEmployee.setAddress(in.nextLine());
		
		double salary;
		boolean ready = false;
		while(!ready) {
			try {
				System.out.println("SALÃ�RIO POR HORA: ");
				salary = Double.parseDouble(sc.next());
				hEmployee.setHourlySalary(salary);
				ready = true;
			} catch (NumberFormatException n) {
				System.out.println("FALHA!" + 
			" O Valor digitado nÃ£o Ã© um double." + n.getMessage());
			}
		}
		
		int method = 0;
		ready = false;
		while(!ready) {
			try {
				System.out.println("MÃ‰TODO DE PAGAMENTO DO SALÃ�RIO: ");
				System.out.println("[1]Cheque pelos correios.");
				System.out.println("[2]Cheque em mÃ£os.");
				System.out.println("[3]DepÃ³sito em conta banÃ¡ria.");
				method = Integer.parseInt(sc.next()); 
				ready = true;
			} catch (NumberFormatException n) {
				System.out.println("FALHA!" + 
			" O Valor digitado nÃ£o Ã© um inteiro." + n.getMessage());
			}
		}
		
		switch(method) {
			case 1:
				hEmployee.setPaymentMethod("Cheque pelos correios.");
				break;
			case 2:
				hEmployee.setPaymentMethod("Recebimento em mÃ£os.");
				break;
			case 3:
				hEmployee.setPaymentMethod("DepÃ³sito em conta bancÃ¡ria.");
				break;
		}
		
		
		method = 0;
		ready = false;
		while(!ready) {
			try {
				System.out.println("SELECIONE: ");
				System.out.println("[1]Sindicalizado.");
				System.out.println("[2]NÃ£o sidicalizado.");
				method = Integer.parseInt(sc.next()); 
				ready = true;
			} catch (NumberFormatException n) {
				System.out.println("FALHA!" + 
			" O Valor digitado nÃ£o Ã© um inteiro." + n.getMessage());
			}
		}
		
		switch(method) {
			case 1:
				hEmployee.setUnion(true);
				System.out.println("NOME DO SINDICATO: ");
				hEmployee.setUnionName(in.nextLine());
				
				salary = 0;
				ready = false;
				while(!ready) {
					try {
						System.out.println("TAXA SINDICAL: ");
						salary = Double.parseDouble(sc.next());
						hEmployee.setUnionTax(salary);
						ready = true;
					} catch (NumberFormatException n) {
						System.out.println("FALHA!" + 
					" O Valor digitado nÃ£o Ã© um double." + n.getMessage());
					}
				}
				break;
			case 2:
				hEmployee.setUnion(false);
				break;
		}
		
		Calendar today = Calendar.getInstance();
		int daysOfWeek = today.get(Calendar.DAY_OF_WEEK);
		int daysUntilNextFriday = Calendar.FRIDAY - daysOfWeek;
		
		Calendar nextFriday = (Calendar) today.clone();
		nextFriday.add(Calendar.DAY_OF_WEEK, daysUntilNextFriday);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		hEmployee.setPaymentDate(nextFriday);
		
		hEmployee.setDateFormat(dateFormat.format(nextFriday.getTime()));
		
		System.out.println("Empregado Cadastrado com Sucesso!");
		System.out.printf("Nome: %s.\n", hEmployee.name);
		System.out.printf("EndereÃ§o: %s.\n", hEmployee.address);
		System.out.printf("Tipo: %s.\n", hEmployee.type);
		System.out.printf("SalÃ¡rio/Hora: %f.\n", hEmployee.hourlySalary);
		System.out.println("Dia do Pagamento: "+ hEmployee.getDateFormat());
		in.nextLine();
		
		employeeList.add(hEmployee);
	}
	
	public void pointSet(ArrayList<Employee> employeeList) {
		Scanner sc = new Scanner(System.in);
		String name;
		int choose;
		
		System.out.println("=================================");
		System.out.println("---- LANÃ‡AR UM CARTÃƒO DE PONTO -----");
		System.out.println("=================================");
		System.out.println("Digite seu nome: ");
		name = sc.nextLine();
		
		for(int i=0; i<employeeList.size(); ++i) {
			Employee e  = employeeList.get(i);
			
			if(e.getName().equals(name)) {
				if(e instanceof HourlyEmployee) {
					if(((HourlyEmployee) e).getDiff() == 0) {
						
						System.out.println("SEU TEMPO FOI MARCADO");
						Calendar time = Calendar.getInstance();
						//SECOND para fins didÃ¡ticos
						((HourlyEmployee) e).setWorkStart(time.get(Calendar.SECOND));
						((HourlyEmployee) e).setWorkStop(0);
					}	
					else {
						Calendar time = Calendar.getInstance();
						//SECOND PARA FINS DIDÃ�TICOS
						((HourlyEmployee) e).setWorkStop(time.get(Calendar.SECOND));
						
						System.out.println("Horas trabalhadas: "+ ((HourlyEmployee) e).getDiff()+ "h");
						System.out.println("OBS: Para fins 1 segundo representarÃ¡ 1 hora");
						
						if(((HourlyEmployee) e).getDiff() <= 8) {
							e.totalSalary = e.totalSalary + ((HourlyEmployee) e).getDiff() * ((HourlyEmployee) e).hourlySalary;
						}
						else if(((HourlyEmployee) e).getDiff()  > 8) {
							int value;
							value = ((HourlyEmployee) e).getDiff();
							value  = value - 8;
							e.totalSalary = e.totalSalary + (8 * ((HourlyEmployee) e).hourlySalary);
							e.totalSalary = e.totalSalary + (value * 1.5 * ((HourlyEmployee) e).hourlySalary);
						}
						((HourlyEmployee) e).setWorkStart(0);
						((HourlyEmployee) e).setWorkStop(0);
					}
				}
				
			}
		}
	}

	/**
	 * Classe relÃ³gio
	 */
	
	public class Chronometer {
		public double startValue;
		public double stopValue;
		public double timeDiff;
		
		public Chronometer() {
			this.startValue = 0;
		}
		
		public void start() {
			startValue = System.currentTimeMillis();
			startValue = (double) (startValue * 1000);
			stopValue = 0;
			timeDiff = 0;
		}
		
		public void stop() {
			stopValue = System.currentTimeMillis();
			stopValue = (double) (stopValue * 1000);
			timeDiff = stopValue - startValue;
			timeDiff = (double) (timeDiff * 1000);
			startValue = 0;
		}
		
		/**
		 * 
		 */
		public double eslapsedTime() {
			return timeDiff;
		}
	}
}
