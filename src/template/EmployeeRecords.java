package template;

import java.util.ArrayList;

public class EmployeeRecords {
	private ArrayList<Employee> employees;
	
	public EmployeeRecords() {
		employees = new ArrayList<Employee>();
		createEmployees();
		
		// TODO:  Add whatever you want here (then delete this comment)
	}
	
	/***
	 * This method creates a list of 300 employees with ids from 0 to 300.
	 * These are the ids that will be in the actual swipes in the data file.
	 * 
	 * You may modify this method and/or the employee constructor if you wish.
	 */
	private void createEmployees() {
		for (int id = 0; id < 300; id++) {
			employees.add( new Employee(id) );
		}
	}
	
	/***
	 * get an Employee object from the list by id number.
	 * 
	 * @param id the id of the employee to return
	 * @return Employee the employee corresponding to the input id, or null if no such employee
	 */
	public Employee getEmployeeById(int id) {
		for (Employee e : employees) {
			if (e.getId() == id) return e;
		}
		
		return null;
	}
	
	/***
	 * register a new swipe with an id and a time
	 * @param id the id of the card that was swiped
	 * @param swipe_time the time (in seconds since midnight) when the swipe occured
	 */
	public void registerSwipe(int id, long swipe_time) {
		Employee employee = getEmployeeById(id);			// get the employee for this swipe
		
		System.out.println("registering swipe for " + id + " at: " + swipe_time);
		
		// TODO:  you complete the rest of this method
	}
	
	/***
	 * return the total time spent inside the building for employee id
	 * @param id the id of the employee you want to get the time for
	 * @return int the total seconds spent inside the building so far for employee id
	 */
  public int getTimeInBuildingFor(int id) {
  	return 0;
  }
	
  /***
   * return the time employee id first swiped in
   * @param id the id of the employee you want to get the time for
   * @return int the time in seconds after midnight employee id first swiped in
   */
  public int getTimeInFor(int id) {
  		return 0;
  }
  
  /***
   * return the employee with the most time in the building so far
   * @return Employee the employee with the most time in the building so far
   */
  public Employee getEmployeeWithMostTimeIn() {
  	return null;
  }
  
  /***
   * return the employee with the least time in the building so far
   * @return Employee the employee with the least time in the building so far
   */
  public Employee getEmployeeWithLeastTimeIn() {
  	return null;
  }
  
  /***
   * return a list of employees in the building at a particular time
   * @param time the time (seconds after midnight) you want an employee list for
   * @return the list of employees in the building at that time
   */
  public ArrayList<Employee> getEmployeesInBuildingAt(int time) {
  	return null;
  }
  
  /***
   * return a 2-element array with a start and end time for the time interval 
   * during which the most employees were in the building
   * 
   * @return int[] a 2-element array with a start and end time
   */
  public int[] timeIntervalWithMostEmployees() {
  	return null;
  }
}