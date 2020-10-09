import java.util.ArrayList;
import java.util.List;

public class Department {

    private final String name;
    private final List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

     public void addEmployee(Employee employee) {
        employees.add(employee);
     }

     public List<Employee> getEmployees() {
        return employees;
    }


}
