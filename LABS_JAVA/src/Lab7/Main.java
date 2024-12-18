package Lab7;
import java.util.*;

class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    // Конструктор
    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    // Геттер
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
    private List<Employee> employees;

    public Department(String name, Employee manager) {
        this.name = name;
        this.manager = manager;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee getManager() {
        return manager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }
}

class Firm {
    private String name;
    private Employee director;
    private List<Department> departments;

    public Firm(String name, Employee director) {
        this.name = name;
        this.director = director;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public Employee getDirector() {
        return director;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create employees
        Employee director = new Employee("John", "Doe", 150000);
        Employee manager1 = new Employee("Jane", "Smith", 120000);
        Employee manager2 = new Employee("Alice", "Brown", 110000);

        Employee emp1 = new Employee("Bob", "Johnson", 60000);
        Employee emp2 = new Employee("Chris", "Davis", 65000);
        Employee emp3 = new Employee("Emma", "Wilson", 62000);
        Employee emp4 = new Employee("Jack", "Taylor", 58000);

        // Створення відділів
        Department department1 = new Department("IT", manager1);
        department1.addEmployee(emp1);
        department1.addEmployee(emp2);

        Department department2 = new Department("HR", manager2);
        department2.addEmployee(emp3);
        department2.addEmployee(emp4);

        // Створення фірм
        Firm firm = new Firm("TechCorp", director);
        firm.addDepartment(department1);
        firm.addDepartment(department2);

        double maxSalary = findMaxSalary(firm);
        System.out.println("The maximum salary is: " + maxSalary);

        List<String> departments = findDepartmentsWithHigherPaidEmployees(firm);
        System.out.println("Departments with employees earning more than their manager: " + departments);

        List<Employee> allEmployees = getAllEmployees(firm);
        System.out.println("All employees: " + allEmployees);
    }


    public static double findMaxSalary(Firm firm) {
        double maxSalary = firm.getDirector().getSalary(); // Start with the director's salary

        // Iterate over all departments in the firm
        for (Department department : firm.getDepartments()) {
            maxSalary = Math.max(maxSalary, department.getManager().getSalary()); // Compare with manager's salary

            // Ітерування по усіх працівниках у відділі використовуючи типізований ітератор
            for (Iterator<Employee> iterator = department.getEmployees().iterator(); iterator.hasNext(); ) {
                Employee employee = iterator.next();
                maxSalary = Math.max(maxSalary, employee.getSalary());
            }
        }

        return maxSalary;
    }

    public static List<String> findDepartmentsWithHigherPaidEmployees(Firm firm) {
        List<String> departmentsWithHigherPaidEmployees = new ArrayList<>(); // Initialize the result list

        // Ітерація по кожному відділу у фірмі
        for (Department department : firm.getDepartments()) {
            Employee manager = department.getManager();
            for (Employee employee : department.getEmployees()) { // Ітерація по працівниках
                if (employee.getSalary() > manager.getSalary()) { // Перевіряємо чи більша зп працівника ніж у начальника
                    departmentsWithHigherPaidEmployees.add(department.getName());
                    break;
                }
            }
        }

        return departmentsWithHigherPaidEmployees;
    }


    public static List<Employee> getAllEmployees(Firm firm) {
        List<Employee> allEmployees = new ArrayList<>();
        allEmployees.add(firm.getDirector());

        // Ітерація по відділах у фірмі використовуючи нетипізований ітератор
        Iterator<Department> departmentIterator = firm.getDepartments().iterator();
        while (departmentIterator.hasNext()) {
            Department department = departmentIterator.next();
            allEmployees.add(department.getManager());

            // Ітерація по працівниках у відділі використовуючи нетипізований ітератор
            Iterator<Employee> employeeIterator = department.getEmployees().iterator();
            while (employeeIterator.hasNext()) {
                allEmployees.add(employeeIterator.next());
            }
        }

        return allEmployees;
    }
}