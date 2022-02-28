package com.launchclub.view;

import com.launchclub.exception.CustomException.ConenctionNotFoundException;
import com.launchclub.exception.CustomException.InvalidInputException;
import com.launchclub.exception.CustomException.DataNotFoundException;
import com.launchclub.exception.CustomException.IdAlreadyExistsException;
import com.launchclub.exception.CustomException.IdNotFoundException;
import com.launchclub.controller.EmployeeController;
import com.launchclub.model.Employee;
import com.launchclub.service.EmployeeDetailsValidation;

import java.util.Map;
import java.util.Scanner;



import java.sql.Date;

/**
 * Used to obtain the input from the user
 * 
 * @author DeviDurga Arunachalam
 */
public class EmployeeDetails {
    
	public static final Scanner SCANNER = new Scanner(System.in);

	private static final EmployeeController EMPLOYEECONTROLLER = new EmployeeController();

    public static void selectChoice() {
        
    do {
            System.out.println("\n\nEMPLOYEE MANAGEMENT SYSTEM\n1.Add Employee\n2.View EmployeeList\n3.Update Employee Details\n4.Delete Employee details\n5.Exit\n\nEnter your choice :");
            int choice = Integer.parseInt(EmployeeDetails.getUserChoice());

            switch (choice) {
            case 1:
                EmployeeDetails.addEmployee();
                break;
            case 2:
                EmployeeDetails.viewEmployeeDetails();
                break;
            case 3:
                EmployeeDetails.updateEmployeeDetails();
                break;
            case 4:
                EmployeeDetails.deleteEmployee();
                break;
            case 5:
                EmployeeDetails.SCANNER.close();
                System.exit(0);
            }
        } while (true);
    }
    
    /**
	 * Used to get the user Id in the numerical values
	 * 
	 * @return employeeId
     */
	public static int getEmployeeId() {
        System.out.println("Enter the EmployeeId:\n[Back To Main: $ ]");
		final String employeeId = SCANNER.nextLine().trim();
		final boolean isIdCorrect = EmployeeController.checkEmployeeId(employeeId);

        if ("$".equals(employeeId)) {
            selectChoice();
        }
        
		if (isIdCorrect) {
            return Integer.parseInt(employeeId);
        } else {
            System.out.println("Invalid Input!!!... \tEnter Numerical Values from 0-9)");
            return getEmployeeId();
        }
	}

    /**
	 * <p>
	 *    Used to get the user name.
	 *    By calling the EmployeeDetailsValidation class to validate the input. 
	 * </p> 
	 *   
	 * @return employeeName
	 */
	public static String getEmployeeName() {
        System.out.println("Enter the EmployeeName :\n[Back To Main: $ ]");
	    final String employeeName = SCANNER.nextLine().trim();
		final boolean isNameCorrect = EmployeeController.checkEmployeeName(employeeName);

        if ("$".equals(employeeName)) {
            selectChoice();
        }
        
		if (isNameCorrect) {
		    return employeeName;
		} else {
            System.out.println("Invalid Input!!!...\tEnter Valid Alphabets(a-z)");
		    return getEmployeeName();
		}
	}

    /**
	 * <p>
	 *    Used to get the contact number.
	 *    By calling the EmployeeDetailsValidation class to validate the input.
	 * </p>   
	 * 
	 * @return contactNumber
	 */
	public static String getContactNumber() {
        System.out.println("Enter the Contact Number :\n[Back To Main: $ ]");
	    final String contactNumber = SCANNER.nextLine().trim();
		final boolean isNumberCorrect = EmployeeController.checkContactNumber(contactNumber);
		
		if ("$".equals(contactNumber)) {
		    selectChoice();
		}
		
		if (isNumberCorrect) {
            return contactNumber;
        } else {
            System.out.println("Invalid Input!!!...\tEnter Valid 10 Digit Number");
            return getContactNumber();
        }
	}

    /**
	 * <p>
	 *    Used to get employee salary details.
	 *    By calling the EmployeeDetailsValidation class to validate the input.
	 * </p>  
	 *  
	 * @return salary
	 */
	public static String getEmployeeSalary() {
        System.out.println("Enter the Salary :\n[Back To Main: $ ]");
	    final String salary = SCANNER.nextLine().trim();
        final boolean isSalaryCorrect = EmployeeController.checkSalary(salary);

        if ("$".equals(salary)) {
            selectChoice();
        }
        
        if (isSalaryCorrect) {
            return salary;
        } else {
            System.out.println("Invalid Input!!!...\tEnter Numerical Values(0-9)");
            return getEmployeeSalary();
        }
	}
	
	/**
     * <p>
     *    Used to get the user choice.
     *    By calling the EmployeeDetailsValidation class to validate the input.
     * </p> 
     *   
     * @return user choice
     */
	public static String getUserChoice() {

        final String userChoice = SCANNER.nextLine().trim();

        
        if (EmployeeController.userChoiceValidation(userChoice)) {
            return userChoice; 
        } else {
            System.out.println("Please Enter Valid Choice!!!...");
            return EmployeeDetails.getUserChoice();
        }
	}

    /**
	 * <p>
	 *    Used to get the date of birth of the employee
	 *    By calling the EmployeeDetailsValidation class to validat the input
	 * </p>
	 * 
	 * @return dateOfJoining    
	 */
	public static Date getDateOfJoining() {
        System.out.println("Enter employee date of joining (YYYY-MM-dd) :\t[Back To Main: $ ]");
	    String dateOfJoining = SCANNER.nextLine().trim();
		boolean isDateCorrect = false;

        if ("$".equals(dateOfJoining)) {
            EmployeeDetails.selectChoice();
        } 
        
		try {
		    isDateCorrect = EmployeeController.dateValidation(dateOfJoining);
		} catch (InvalidInputException exception) {
            System.out.println(exception);
		}
		
		if (isDateCorrect) {
		    return Date.valueOf(dateOfJoining);
		} else {
            System.out.println("Invalid Input!!!...");
		    return getDateOfJoining();
		}
	}	
	
    /**
     * <p>
     *     Used to add employee details as including employeeId,
     *     name of the employee, salary details,contact number and
     *     date of joining of the employee and pass it to the controller.
     * </p>   
     */
    public static void addEmployee() {
        final int employeeId = EmployeeDetails.getEmployeeId();
    
        try {
            EMPLOYEECONTROLLER.employeeIdCorrect(employeeId);
        } catch (IdAlreadyExistsException exception) {
            System.out.println(exception);
            addEmployee();
            selectChoice();
        }  
            final String employeeName = EmployeeDetails.getEmployeeName();
            final String salary = EmployeeDetails.getEmployeeSalary();
            final String contactNumber = EmployeeDetails.getContactNumber();
            final Date dateOfJoining = EmployeeDetails.getDateOfJoining();
            final Employee employee = new Employee(employeeId, employeeName, salary, contactNumber, dateOfJoining);
       try { 
            final boolean isAdded = EMPLOYEECONTROLLER.addEmployee(employee);
            
            if (isAdded) {
                System.out.println("Successfully Added");
            } 
        } catch (ConenctionNotFoundException exception) {
           System.out.println(exception);
            } 
        } 
    
    /**
     * Used to view the employee details
     */
    public static void viewEmployeeDetails() {
        
        try {
            Map<Integer, Employee> data = EMPLOYEECONTROLLER.viewEmployeeDetails();

            System.out.println(data);
        } catch (DataNotFoundException exception) {
            System.out.println(exception);
        } catch (ConenctionNotFoundException exception) {
            System.out.println(exception);
        } 
    }
    
    /**
     * Used to delete the employee details by checking the employeeId
     */
    public static void deleteEmployee() {
      
        try {
            EMPLOYEECONTROLLER.deleteEmployee(EmployeeDetails.getEmployeeId());
            System.out.println("Successfully Deleted");
        } catch (IdNotFoundException exception) {
            System.out.println(exception);
        } catch (ConenctionNotFoundException exception) {
            System.out.println(exception);
        }
    }
    
    /**
     * <p>
     *     Used to update the employee details by using iterator and 
     *     employeeId for checking the availability of the details of the employee
     *     and then update employee details using switch case 
     *     implemetation by user choice.
     * </p>  
     */   
    public static void updateEmployeeDetails() {
        Employee employee = new Employee();
        int employeeId = EmployeeDetails.getEmployeeId();
        
        try {
            EMPLOYEECONTROLLER.employeeIdCorrectUpdate(employeeId);
        } catch (IdNotFoundException exception) {
            System.out.println(exception);
            EmployeeDetails.updateEmployeeDetails();
            EmployeeDetails.selectChoice();
        } 
        employee.setEmployeeId(employeeId);
        String updateInput;
        System.out.println("Update Changes To Employee Name ?\t yes or no");
        
        while (true) {
            updateInput = EmployeeDetails.SCANNER.nextLine().trim();
            
            if (updateInput.equalsIgnoreCase("yes")) {
                employee.setEmployeeName(EmployeeDetails.getEmployeeName());
                break;
            } else if (updateInput.equalsIgnoreCase("no")) {
                break;
            } else {
                System.out.println("Enter Valid Input (yes or no)");
                continue;
            } 
        }
        System.out.println("Update Changes To Employee Salary ?\t yes or no");
        
        while (true) {
            updateInput = EmployeeDetails.SCANNER.nextLine().trim();
            
            if (updateInput.equalsIgnoreCase("yes")) {
                employee.setSalary(EmployeeDetails.getEmployeeSalary());
                break;
            } else if (updateInput.equalsIgnoreCase("no")) {
                break;
            } else {
                System.out.println("Enter Valid Input (yes or no)");
                continue;
            } 
        }
        System.out.println("Update Changes To Employee Contact Number ?\t yes or no");
       
        while (true) {
            updateInput = EmployeeDetails.SCANNER.nextLine().trim();
            
            if (updateInput.equalsIgnoreCase("yes")) {
                employee.setContactNumber(EmployeeDetails.getContactNumber());
                break;
            } else if (updateInput.equalsIgnoreCase("no")) {
                break;
            } else {
                System.out.println("Enter Valid Input (yes or no)");
                continue;
            } 
        }
        System.out.println("Update Changes To Employee DateOfJoining ?\t yes or no");

        while (true) {
            updateInput = EmployeeDetails.SCANNER.nextLine().trim();
            
            if (updateInput.equalsIgnoreCase("yes")) {
                employee.setDateOfJoining(EmployeeDetails.getDateOfJoining());
                break;
            } else if (updateInput.equalsIgnoreCase("no")) {
                break;
            } else {
                System.out.println("Enter Valid Input (yes or no)");
                continue;
            } 
        }
        
        try { 
          EMPLOYEECONTROLLER.updateEmployeeDetails(employee);
            System.out.println("Data Updated Successfully");
        }  catch (IdNotFoundException exception) {
            System.out.println(exception);
        } catch (ConenctionNotFoundException exception) {
            System.out.println(exception);
        }    
    }
}    
	   
	

