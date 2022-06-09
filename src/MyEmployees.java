import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class MyEmployees {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        TreeSet<Employee> myCompany = new TreeSet<Employee>(new EmployeeComparator());
        System.out.println("Если хотите добавить сотрудника впишите add, если выйти то напишите exit");

        while (true) {
            String choice = scanner.nextLine();
            if (Objects.equals(choice, "add")) {
                System.out.println("Введите имя");
                String name = scanner.nextLine();
                System.out.println("Введите фамилию");
                String surname = scanner.nextLine();
                System.out.println("Введите тип сотрудника");
                String employeeType = scanner.nextLine();
                System.out.println("Введите зарплату");
                int salary = scanner.nextInt();
                myCompany.add(Employee.addEmployee(name,surname,salary,employeeType));
            }
            if (Objects.equals(choice, "exit")) {
                break;
            }

        }
//        myCompany.add(new Employee("Никита", "Лол", 7332, "Гений"));
//        myCompany.add(new Employee("Никита", "Лол", 7335, "Гений"));
//        myCompany.add(new Employee("Никита", "Лол", 7331, "Гений"));
//        myCompany.add(new Employee("Никита", "Лол", 7332, "Гений"));
        for (Employee e : myCompany) {
            System.out.println(e);
        }

    }


}

class EmployeeComparator implements Comparator<Employee> {

//        @Override
//    public int compare(Employee e1, Employee e2) {
//        if (e1.getSalary() > e2.getSalary()) {
//            return -2;
//
//        }
//        if (e1.getSalary() < e2.getSalary()) {
//            return 2;
//        } else {
//            return 1;
//        }
//
//    }
    @Override
    public int compare(Employee e1, Employee e2) {
//    return e1.getSalary().compareTo(e2.getSalary());

        if (e1.getSalary() < e2.getSalary())
            return 1;
        if (e1.getSalary() > e2.getSalary())
            return -1;
        else
            return 0;
    }
}


class Employee {

    private final String name;
    private final String surname;
    private final int salary;
    private final String employeeType;

    public static Employee addEmployee(String name,String surname,int salary,String employeeType) {



        System.out.println("Добавлено");
        return new Employee(name, surname, salary, employeeType);
    }

    public Employee(String name, String surname, int salary, String employeeType) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.employeeType = employeeType;
    }

    public int getSalary() {
        return salary;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "name= " + name + ", surname='" + surname + ", salary=" + salary + ", employeeType='" + employeeType;
    }

}


