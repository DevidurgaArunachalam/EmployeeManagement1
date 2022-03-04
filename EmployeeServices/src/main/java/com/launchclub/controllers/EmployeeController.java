package com.launchclub.controllers;


import java.util.Map;

import com.launchclub.models.Employee;
import com.launchclub.services.EmployeeDetailsValidation;
import com.launchclub.services.EmployeeServiceImplVersion2;

/**
 * <p>
 *    This controller class is used for getting the request from main and 
 *    gives it to the service.
 *    The input data fetched in view are processed and then called in employee main class.
 * </p>   
 */
public class EmployeeController {
    private final static EmployeeServiceImplVersion2 EMPLOYEE_IMPL = new EmployeeServiceImplVersion2();
    
    /**
     * <p>
     *    Adds the employee details by getting the inputs from the user
     *    and stores in the database.
     * </p>
     *    
     * @param employee
     */
	public static boolean addEmployee(final Employee employee) {
	    return EMPLOYEE_IMPL.addEmployee(employee);
	}
	/**
     * <p>
     *    Shows the employee details that are available in the
     *    
     * </p>
     * @param employee
     */
	public static Map<Integer, Employee> viewEmployeeDetails() {
        return EMPLOYEE_IMPL.viewEmployeeData();  
	}
	/**
     * <p>
     *    Adds the employee details by getting the inputs from the user
     *    and stores in the database.
     * </p>
     * @param employee
     */ 
	public static boolean updateEmployeeDetails(Employee employee) {
	    return EMPLOYEE_IMPL.updateEmployeeDetails(employee);
	}
	/**
     * <p>
     *    Adds the employee details by getting the inputs from the user
     *    and stores in the database.
     * </p>
     * @param employee
     */
	public static boolean deleteEmployee(int employeeId) {
	    return EMPLOYEE_IMPL.deleteEmployee(employeeId);
    }
	/**
     * 
     * @param employee
     */
	public static boolean checkEmployeeName(final String employeeName) {
        return EmployeeDetailsValidation.checkEmployeeName(employeeName);
	}
	/**
     * <p>
     *    Adds the employee details by getting the inputs from the user
     *    and stores in the database.
     * </p> 
     * @param employee
     */
    public static boolean checkContactNumber(String contactNumber) {
        return EmployeeDetailsValidation.checkContactNumber(contactNumber);
    }
    /**
     * <p>
     *    Adds the employee details by getting the inputs from the user
     *    and stores in the database.
     * </p>
     * @param employee
     */
    public static boolean checkEmployeeId(String employeeId) {
        return EmployeeDetailsValidation.employeeIdValidation(employeeId);
    }
    /**
     * <p>
     *    Adds the employee details by getting the inputs from the user
     *    and stores in the database.
     * </p> 
     * @param employee
     */
    public static boolean checkSalary(String salary) {
        return EmployeeDetailsValidation.checkSalary(salary);
    }

    /**
     * <p>
     *    Adds the employee details by getting the inputs from the user
     *    and stores in the database.
     * </p>
     * @param employee
     */
    public static boolean dateValidation(String dateOfJoining) {
        return EmployeeDetailsValidation.dateValidation(dateOfJoining);
    }
    /**
     * <p>
     *    Adds the employee details by getting the inputs from the user
     *    and stores in the database.
     * </p> 
     * @param employee
     */
    public static boolean employeeIdCorrect(final int employeeId) {
        return EmployeeServiceImplVersion2.employeeIdCorrect(employeeId);
    }  
    /**
     * <p>
     *    Adds the employee details by getting the inputs from the user
     *    and stores in the database.
     * </p>
     * @param employee
     */
    public static boolean employeeIdCorrectUpdate(final int employeeId) {
        return EmployeeServiceImplVersion2.employeeIdCorrectUpdate(employeeId); 
    }
    /**
     * <p>
     *    Adds the employee details by getting the inputs from the user
     *    and stores in the database.
     * </p>
     * @param employee
     */
    public static boolean userChoiceValidation(final String userChoice) {
        return EmployeeServiceImplVersion2.validateUserChoice(userChoice);
        
    }
}
