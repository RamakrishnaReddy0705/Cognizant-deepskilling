class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return employeeId + " " + name + " " + position + " " + salary;
    }
}

public class EmployeeManagment {

    Employee[] employees = new Employee[10];
    int size = 0;

    void add(Employee e) {
        employees[size++] = e;
    }

    Employee search(int id) {
        for (int i = 0; i < size; i++)
            if (employees[i].employeeId == id)
                return employees[i];
        return null;
    }

    void traverse() {
        for (int i = 0; i < size; i++)
            System.out.println(employees[i]);
    }

    void delete(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < size - 1; j++)
                    employees[j] = employees[j + 1];
                size--;
                break;
            }
        }
    }
}