package Lab8;
import java.util.*;

class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    // Constructor to initialize an employee's details
    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    // Getter for employee salary
    public double getSalary() {
        return salary;
    }

    // Override toString to display employee details
    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + salary + ")";
    }
}

class Department {
    private String name;
    private Employee manager;
    private Set<Employee> employees;

    // Constructor to initialize a department's name and manager
    public Department(String name, Employee manager) {
        this.name = name;
        this.manager = manager;
        this.employees = new HashSet<>();
    }

    // Method to add an employee to the department
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Getter for the department manager
    public Employee getManager() {
        return manager;
    }

    // Getter for the set of employees in the department
    public Set<Employee> getEmployees() {
        return employees;
    }

    // Getter for the department name
    public String getName() {
        return name;
    }
}

class Firm {
    private String name;
    private Employee director;
    private Set<Department> departments;
    private Map<String, Department> departmentMap;

    // Constructor to initialize the firm's name and director
    public Firm(String name, Employee director) {
        this.name = name;
        this.director = director;
        this.departments = new HashSet<>();
        this.departmentMap = new HashMap<>();
    }

    // Method to add a department to the firm
    public void addDepartment(Department department) {
        departments.add(department);
        departmentMap.put(department.getName(), department);
    }

    // Getter for the firm's director
    public Employee getDirector() {
        return director;
    }

    // Getter for the set of departments in the firm
    public Set<Department> getDepartments() {
        return departments;
    }

    // Method to find a department by name using the map
    public Department findDepartmentByName(String name) {
        return departmentMap.get(name);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create employees
        Employee director = new Employee("John", "Doe", 150000); // Director of the firm
        Employee manager1 = new Employee("Jane", "Smith", 120000); // Manager of IT department
        Employee manager2 = new Employee("Alice", "Brown", 110000); // Manager of HR department

        Employee emp1 = new Employee("Bob", "Johnson", 60000); // IT department employee
        Employee emp2 = new Employee("Chris", "Davis", 65000); // IT department employee
        Employee emp3 = new Employee("Emma", "Wilson", 62000); // HR department employee
        Employee emp4 = new Employee("Jack", "Taylor", 58000); // HR department employee

        // Create departments
        Department department1 = new Department("IT", manager1); // IT department with manager
        department1.addEmployee(emp1); // Add employee to IT department
        department1.addEmployee(emp2); // Add another employee to IT department

        Department department2 = new Department("HR", manager2); // HR department with manager
        department2.addEmployee(emp3); // Add employee to HR department
        department2.addEmployee(emp4); // Add another employee to HR department

        // Create firm
        Firm firm = new Firm("TechCorp", director); // Firm with a director
        firm.addDepartment(department1); // Add IT department to the firm
        firm.addDepartment(department2); // Add HR department to the firm

        // Find maximum salary using a typed iterator
        double maxSalary = findMaxSalary(firm); // Calculate the maximum salary
        System.out.println("The maximum salary is: " + maxSalary); // Display the maximum salary

        // Find departments where an employee earns more than the manager
        List<String> departments = findDepartmentsWithHigherPaidEmployees(firm); // Find departments with condition
        System.out.println("Departments with employees earning more than their manager: " + departments); // Display departments

        // Get all employees using an untyped iterator
        List<Employee> allEmployees = getAllEmployees(firm); // Retrieve all employees in the firm
        System.out.println("All employees: " + allEmployees); // Display the list of all employees

        // Demonstrate additional functionality using departmentMap
        String searchDepartmentName = "IT";
        Department foundDepartment = firm.findDepartmentByName(searchDepartmentName);
        System.out.println("Details of department '" + searchDepartmentName + "': " + foundDepartment);
    }

    // Method to find the maximum salary in the firm
    public static double findMaxSalary(Firm firm) {
        double maxSalary = firm.getDirector().getSalary(); // Start with the director's salary

        // Iterate over all departments in the firm
        for (Department department : firm.getDepartments()) {
            maxSalary = Math.max(maxSalary, department.getManager().getSalary()); // Compare with manager's salary

            // Iterate over all employees in the department using a typed iterator
            for (Iterator<Employee> iterator = department.getEmployees().iterator(); iterator.hasNext(); ) {
                Employee employee = iterator.next(); // Get the next employee
                maxSalary = Math.max(maxSalary, employee.getSalary()); // Compare with employee's salary
            }
        }

        return maxSalary; // Return the maximum salary found
    }

    // Method to find departments with employees earning more than their manager
    public static List<String> findDepartmentsWithHigherPaidEmployees(Firm firm) {
        List<String> departmentsWithHigherPaidEmployees = new ArrayList<>(); // Initialize the result list

        // Iterate over all departments in the firm
        for (Department department : firm.getDepartments()) {
            Employee manager = department.getManager(); // Get the manager of the department
            for (Employee employee : department.getEmployees()) { // Iterate over employees using for-each loop
                if (employee.getSalary() > manager.getSalary()) { // Check if employee earns more than manager
                    departmentsWithHigherPaidEmployees.add(department.getName()); // Add department to the result list
                    break; // Stop checking further employees in this department
                }
            }
        }

        return departmentsWithHigherPaidEmployees; // Return the list of departments
    }

    // Method to retrieve all employees in the firm
    public static List<Employee> getAllEmployees(Firm firm) {
        List<Employee> allEmployees = new ArrayList<>(); // Initialize the result list
        allEmployees.add(firm.getDirector()); // Add the firm's director to the list

        // Iterate over all departments in the firm using an untyped iterator
        Iterator<Department> departmentIterator = firm.getDepartments().iterator();
        while (departmentIterator.hasNext()) {
            Department department = departmentIterator.next(); // Get the next department
            allEmployees.add(department.getManager()); // Add the department manager to the list

            // Iterate over all employees in the department using an untyped iterator
            Iterator<Employee> employeeIterator = department.getEmployees().iterator();
            while (employeeIterator.hasNext()) {
                allEmployees.add(employeeIterator.next()); // Add the next employee to the list
            }
        }

        return allEmployees; // Return the complete list of employees
    }
}