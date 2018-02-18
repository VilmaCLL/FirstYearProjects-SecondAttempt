//Vilma C. Lopez Lemoine. Student number: 2015210.
//These are the libraries imported for the program.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;
import java.io.IOException;

//This is the main class with the global variables and the vector declaration. 
public class Main {
	String option = null; 
	int idNumber = 0;
	String emploName = "";
	String emploSurname = "";
	int age = 0;
	String department = "";
	String fileName = "/Users/Vilmita/Desktop/test.txt";
	Vector myVector = new Vector ();
	
		//This is the constructor method, calling the two methods through which the whole program runs.
		public Main (){
			readText ();
			MainMenu();
		
		}
	
			//Method for the first and main options menu. This is the first text to appear for users. This method opens the program and initiates the web that interconnects the whole program.
			public void MainMenu (){
					
					System.out.println("Welcome to the Employees' Book");
					System.out.println("Please select an option");
					System.out.println("");
					System.out.println("a. Add new Employee");
					System.out.println("b. Employees' List");
					System.out.println("c. Exit the System");
					
					inputReader();
					
					if(option.equals("a")){
						AddEmployee();
					}
					else if (option.equals("b")){
						EmployeesList();
					}
					else if (option.equals("c")){
						Exit();
						
					}
				}	
			
		
			//This method only takes user inputs from keyboard. It will be called each time and user´s input is required.
			public String inputReader () {
						
						try {
							BufferedReader readingA = new BufferedReader(new InputStreamReader(System.in));
							option = (readingA.readLine());
						
						}catch (Exception e){}
						
						return option;
			}
		
			//This method only stores the organized employees´s information on a text file. It will be called when a new employee is added to the data base.
			public void writingList (){
			
				try {
				PrintWriter employeeList = new PrintWriter (new BufferedWriter (new FileWriter ("/Users/Vilmita/Desktop/test.txt", true)));
					
					employeeList.println("");
					employeeList.println(emploName);
					employeeList.println(emploSurname);
					employeeList.println(idNumber);
					employeeList.println(age);
					employeeList.println(department);
					employeeList.println("");
					
					
					employeeList.close();
					
				}catch (Exception e) 
				
				  { System.out.print(e); }
				
			}
		
			//This method offers to the user the option to return to any of the menus of the program or to exit from there. It is called after each of the functions offered by the system, so the user can keep navigating without getting stuck.
			public void backToMain (){
				
				int option=0;
				
				System.out.println("");
				System.out.println("Please select an option:");
				System.out.println("");
				System.out.println("1.Go to Employees´List Menu");
				System.out.println("2.Go to Main Menu");
				System.out.println("3.Exit the System");
				System.out.println("");
				
				option= Integer.parseInt(inputReader());
				
				if(option==(1)){
					EmployeesList ();
				}else if (option==(2)){
					MainMenu ();
				}else if (option==(3)){
					Exit ();
				}
				
				
			}
			
			//This method reads the information stored on the text file and organized in a vector (specifying Business Person and It Person) that can be manipulated by other methods. It is one of the methods called by the constructor, so getting the stored data is one of the first actions of the program.
			public void readText (){
				
				String line = "";
				
				try {
					
					BufferedReader in = new BufferedReader (new FileReader(fileName));
					do {
						
						emploName = in.readLine();
						emploSurname= in.readLine();
						idNumber = Integer.parseInt(in.readLine());
						age= Integer.parseInt(in.readLine());
						department= in.readLine();
						
						if (department.equals("IT")){
							itEmployee it1 = new itEmployee ();
							
							it1.setEmploName(emploName);
							it1.setEmploSurname(emploSurname);
							it1.setIdNumber(idNumber);
							it1.setAge(age);
							it1.setDepartment(department);
						
							myVector.add(it1);	
				
						}
						
						else if (department.equals("Business")){
							businessEmployee be1 = new businessEmployee ();
						
							be1.setEmploName(emploName);
							be1.setEmploSurname(emploSurname);
							be1.setIdNumber(idNumber);
							be1.setAge(age);
							be1.setDepartment(department);
							
							myVector.add(be1);
							
						
						}
						line = in.readLine();
					} while (line != null);
					
					
					in.close();
					
				} catch (Exception e1) {
					
					System.out.println(e1);
	
				}
				
			
			}

			//This method just shows the elements of the data base in the order in which they were added.
			public void fullList (){
				
				for (int i = 0; i< myVector.size(); i++) {
					
					Employee temp = (Employee) myVector.get(i);
					
					System.out.println("");
					System.out.println("Name: " + temp.getEmploName());
					System.out.println("Surname: " + temp.getEmploSurname());
					System.out.println("ID: " + temp.getIdNumber());
					System.out.println("Age:" + temp.getAge());
					System.out.println("Department:" + temp.getDepartment());
					System.out.println("");
				}
				
				backToMain ();
			}
			
			//This method exits the system.
			public void Exit () {
				
				System.out.println("Are you sure?");
				System.out.println("a. Yes");
				System.out.println("b. No");
				
				inputReader();
				
				if (option.equals ("a")){
					System.exit(0);
				}
				
				else if (option.equals("b")){
					 MainMenu ();
				}
			}
		
			//This method gets the information given by the user and stores it in a vector, specifying BusinessPerson and ITPerson. At the end, this information is written on a text file using the method writingList().
			public void AddEmployee (){
				
				boolean addAnother = true;
				String oneMore = "";
			
				do {
				
					System.out.println("");
					
					System.out.println("Please enter employee name");
					
						emploName = inputReader ();
						
					System.out.println("Please enter Employee Surname");
					
						emploSurname = inputReader ();
					
					System.out.println("Please enter Employee ID");
					
						idNumber = Integer.parseInt(inputReader());
					
					System.out.println("Please enter Employee Age");
					
						age = Integer.parseInt(inputReader());
					
					System.out.println("Please enter Department (Business or IT)");
					
						
						department = inputReader ();
					
				
				if (department.equals("IT")){
					itEmployee it1 = new itEmployee ();
					
					it1.setEmploName(emploName);
					it1.setEmploSurname(emploSurname);
					it1.setIdNumber(idNumber);
					it1.setAge(age);
					it1.setDepartment(department);
				
					myVector.add(it1);	
					
					writingList();
					
				}
				
				else if (department.equals("Business")){
					businessEmployee be1 = new businessEmployee ();
				
					be1.setEmploName(emploName);
					be1.setEmploSurname(emploSurname);
					be1.setIdNumber(idNumber);
					be1.setAge(age);
					be1.setDepartment(department);
					
					myVector.add(be1);
					
					writingList();
				
				}
				
				System.out.println("");
				System.out.println("Employee saved successfully!");
				System.out.println("");
				System.out.println("Employee name: " + emploName);
				System.out.println("Employee Surname: " + emploSurname);
				System.out.println("ID number: " + idNumber);
				System.out.println("Age: " + age);
				System.out.println("Department: " + department);
				System.out.println("");
				
				System.out.println("Do you want to add another employee?");
				System.out.println("1. Yes");
				System.out.println("2. No");	
					
					oneMore= inputReader();
				
					if (oneMore.equals ("1")){
						 addAnother = true;
						
					}else if (oneMore.equals ("2")) {
						System.out.println("");
						System.out.println("Employee saved successfully!");
						System.out.println("");
						System.out.println("Employee name: " + emploName);
						System.out.println("Employee Surname: " + emploSurname);
						System.out.println("ID number: " + idNumber);
						System.out.println("Age: " + age);
						System.out.println("Department: " + department);
						System.out.println("");
						
						backToMain ();
					}
				} while (addAnother);
			}
			
			//This method gives a menu to choose ways to find or see the information stored in the vector.
			public void EmployeesList (){
				
				System.out.println("Please select an option");
				System.out.println("");
				System.out.println("a. See Full Employees' List in Ascending Order");
				System.out.println("b. See Full Employees' List in Descending Order");
				System.out.println("c. Find Employee");
				System.out.println("d. See full list");
				System.out.println("e. Back to Main Menu");
				
				inputReader();
				
				if(option.equals("a")){
					AscendingOrder();
				}
				else if (option.equals("b")){
					DescendingOrder();
				}
				else if (option.equals("c")){
					FindEmployee();
				}
				else if (option.equals("d")){
					fullList ();;
				}
				else if (option == ("e")) {
					MainMenu ();
				}
				
			}
			
			//Based on the Id numbers of the employees, this method organizes the information stored from the higher to the lowest value (of the ID Number).
			public void AscendingOrder (){
				
				for (int i=0; i<myVector.size()-1; i++){
					for(int j = 0; j<myVector.size ()-1; j++){
						
						Employee temp1=(Employee) myVector.get(j);
						Employee temp2= (Employee) myVector.get (j+1);
	
							if (temp1.getIdNumber() > temp2.getIdNumber()){
								myVector.remove(j);
								myVector.add (j+1, temp1);
							} 
					} 
				
				}
				
				for(int k= 0; k< myVector.size(); k++){
					Employee temp = (Employee) myVector.get(k);
					
					System.out.println("");
					System.out.println("Name: " + temp.getEmploName());
					System.out.println("Surname: " + temp.getEmploSurname());
					System.out.println("ID: " + temp.getIdNumber());
					System.out.println("Age:" + temp. getAge());
					System.out.println("Department:" + temp.getDepartment());
					System.out.println("");
					
				}
				backToMain ();	
			}
			
			//Based on the Id numbers of the employees, this method organizes the information stored from the lowest to the highest value (of the ID Number).
			public void DescendingOrder (){
				for (int i=0; i<myVector.size()-1; i++){
					for(int j = 0; j<myVector.size ()-1; j++){
						
						Employee temp1=(Employee) myVector.get(j);
						Employee temp2= (Employee) myVector.get (j+1);
	
							if (temp1.getIdNumber() < temp2.getIdNumber()){
								myVector.remove(j);
								myVector.add (j+1, temp1);
							} 
					} 
				
				}
				
				for(int k= 0; k< myVector.size(); k++){
					Employee temp = (Employee) myVector.get(k);
					
					System.out.println("");
					System.out.println("Name: " + temp.getEmploName());
					System.out.println("Surname: " + temp.getEmploSurname());
					System.out.println("ID: " + temp.getIdNumber());
					System.out.println("Age:" + temp. getAge());
					System.out.println("Department:" + temp.getDepartment());
					System.out.println("");
					
				}
				backToMain ();
			}
		
			//This method allows the user to find a specific employee by typing name or last name. It takes the input of the user and compares it to the information stored in the vector.
			public void FindEmployee (){
			
			boolean findAnother = false;
			String continueSearching = "";
			String word = "";
		
			do{
				System.out.println("");
				System.out.println("Please enter employee´s name or surname");
				
					word = inputReader ();
					
					boolean j= false;
					
					for (int k=0; k < myVector.size(); k++){
						
						Employee temp = (Employee) myVector.get(k);
						
						if ((temp.getEmploName().contains(word)) || (temp.getEmploSurname().contains(word))){
							
							j = true;
							
							System.out.println("");
							System.out.println("Name: " + temp.getEmploName());
							System.out.println("Surname: " + temp.getEmploSurname());
							System.out.println("Id: " + temp.getIdNumber());
							System.out.println("Age: " + temp.getAge());
							System.out.println("Department: " + temp.getDepartment());
							System.out.println("");
						}
						
					}
					if (j= false) {
						System.out.println("No records found");
						
					}
				System.out.println("Would you like to find another employee?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				
				continueSearching = inputReader ();
				
					if(continueSearching.equals ("1")){
						findAnother = true;
						
					} else if (continueSearching.equals("2")){
						backToMain ();
					}
				
				
			}while (findAnother);
			
			}
			
			
	//Main method that runs the program by calling the constructor.
	public static void main(String[] args) {
			new Main();
	
	}
	
}
