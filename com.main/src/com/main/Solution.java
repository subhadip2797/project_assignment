package com.main;

import java.util.Scanner;
import java.util.ArrayList;



import com.employee.Employee;


public class Solution {
	
	public static void main(String[] args) throws Exception
	{
		ArrayList<Employee> empList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		char ch ;
		
		System.out.println("\n///*********** Welcome To Employee Registration System ***********///\n\n");
		do
		{
			System.out.println("1. Press 1 and Enter to ADD Employee details");
			System.out.println("2. Press 2 and Enter to UPDATE Employee details");
			System.out.println("3. Press 3 and Enter to DELETE Employee details");
			System.out.println("4. Press 4 and Enter to PRINT Employee details");
			System.out.println("5. Press 5 and Enter to SEARCH Employee details by ID\n");
			
			System.out.print("Enter your choice : ");
			int choice = sc.nextInt();sc.nextLine();
			System.out.println("\n");
			
			switch(choice)
			{
			case 1:
				empAdd(empList);
				break;
				
			case 2:
				System.out.print("Enter the Employee Id : ");
				long empIdUpdate = sc.nextLong();
				empDetailsUpdate(empList, empIdUpdate);
				break;
				
			case 3:
				System.out.print("Enter the Employee Id : ");
				long empIdDelete = sc.nextLong();
				empDelete(empList, empIdDelete);
				break;
				
			case 4:
				empGet(empList);
				break;
				
			case 5:
				System.out.print("Enter the Employee Id : ");
				long empIdSearch = sc.nextLong();
				empGet(empList, empIdSearch);
				break;
				
			default:
				System.out.println("Invalid Input");
			}
			System.out.print("Do you want to continue with the Registration System(Press Y/y and Enter for Yes and Press N/n and Enter for No) ? : ");
			ch = sc.next().charAt(0);
			
		}while(ch == 'Y' || ch == 'y');
		
		sc.close();
		
	}
	
	public static void empAdd(ArrayList<Employee> empList)
	{
		Scanner sc = new Scanner(System.in);
		
		if(empList.size()==0)
		{
			System.out.print("Enter Employee Name : ");
			String empName = sc.nextLine();
			System.out.print("\n");
			System.out.print("Enter Employee Age : ");
			int empAge = sc.nextInt();sc.nextLine();
			System.out.print("\n");
			System.out.print("Enter Employee Address : ");
			String empAddress = sc.nextLine();
			
			Employee emp = new Employee(100, empName, empAge, empAddress);
			empList.add(emp);
		}
		else
		{
			System.out.print("Enter Employee Name : ");
			String empName = sc.nextLine();
			System.out.print("\n");
			System.out.print("Enter Employee Age : ");
			int empAge = sc.nextInt();sc.nextLine();
			System.out.print("\n");
			System.out.print("Enter Employee Address : ");
			String empAddress = sc.nextLine();
			long empId = empList.get(empList.size()-1).getEmpId();
			
			Employee emp = new Employee(empId+1, empName, empAge, empAddress);
			empList.add(emp);
		}	
		//sc.close();
			
	}
	
	public static void empGet(ArrayList<Employee> empList)
	{
		System.out.println("Employee ID\t\tEmployee Name\t\tEmployee Age\t\tEmplyee Address\n");
		for(int i=0;i<empList.size();i++)
		{
			System.out.println(empList.get(i));
		}
		System.out.println();
	}
	
	public static void empGet(ArrayList<Employee> empList, long empId)
	{
		int flag = 0;
		
		for(int i=0; i<empList.size();i++)
		{
			if(empList.get(i).getEmpId() == empId)
			{
				System.out.println("Employee ID\t\tEmployee Name\t\tEmployee Age\t\tEmplyee Address\n");
				System.out.println(empList.get(i));
				flag = 1;
				break;
			}
			
		}
		if(flag == 0)
		{
			System.out.println("No employee is present with the given employee Id.\n");
		}
	}
	
	public static void empDelete(ArrayList<Employee> empList, long empId)
	{
		Scanner sc = new Scanner(System.in);
		int flag = 0;
		
		for(int i = 0; i<empList.size();++i)
		{
			if(empList.get(i).getEmpId() == empId)
			{
				System.out.print("Do you want to delete the record for "+empId+"(Press Y/y for Yes and Press N/n for No)? : ");
				char choice =  sc.next().charAt(0);
				if(choice == 'Y' || choice == 'y')
				{
					empList.remove(i);
					System.out.println("Record deleted");
					flag = 1;
				}
				else 
				{
					System.out.println("You chose not to delete the record for "+empId+"\n");
					flag = 1;
				}
				break;
			}
		}
		//sc.close();
		if(flag == 0)
		{
			System.out.println("No employee is present with the given employee Id.\n");
		}
	}
	
	public static void empDetailsUpdate(ArrayList<Employee> empList, long empId)
	{
		int flag = 0;
		char ch;
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<empList.size();i++)
		{
			if(empList.get(i).getEmpId() == empId)
			{
				do
				{
					System.out.println("Select the field you want to update for "+empId+" : \n");
					System.out.println("Press 1 and Enter for Employee Name\nPress 2 and Enter for Employee Age\nPress 3 and Enter for Employee Address\n");
					System.out.print("Enter your choice : ");
					int choice = sc.nextInt();sc.nextLine();
					
					switch(choice)
					{
					case 1:
						System.out.print("Enter the new value for Name field : ");
						String name = sc.nextLine();
						empList.get(i).setEmpName(name);
						System.out.println("Employee Name updated for "+empId+"\n");
						flag = 1;
						break;
					case 2:
						System.out.print("Enter the new value for Age field : ");
						int age = sc.nextInt();sc.nextLine();
						empList.get(i).setEmpAge(age);
						System.out.println("Employee Age updated for "+empId+"\n");
						flag = 1;
						break;
					case 3:
						System.out.print("Enter the new value for Name field : ");
						String address = sc.nextLine();
						empList.get(i).setEmpAddress(address);
						System.out.println("Employee Address updated for "+empId+"\n");
						flag = 1;
						break;
					default:
						System.out.println("Invalid input\n");
					}
					System.out.print("Do you want to Update any field again for "+empId+"(Press Y/y and Enter for Yes and Press N/n and Enter for No)? : ");
					ch = sc.next().charAt(0);
					
				}while(ch == 'Y' || ch == 'y');
				
			}
		}
		//sc.close();
		if(flag == 0)
		{
			System.out.println("No employee is present with the given employee Id.\n");
		}
	}
	

}
