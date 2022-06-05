import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class MyEmployees {
    public static void main(String[] args) {
        boolean lever=true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько вам нужно добавить сотрудников?");
        int howMany = scanner.nextInt();

        TreeSet<Empl> myCompany = new TreeSet<Empl>(new Employees());
        for(int i = 1 ;i<=howMany;i++){
            myCompany.add(Empl.addEmployee(scanner));

        }
        for (Empl e : myCompany) {
            System.out.println(e);
        }

    }



//    public static void print(TreeSet<Empl> myCompany) {
//        for (Empl e : myCompany) {
//            System.out.println(e);
//        }
//    }

}

class Employees implements Comparator<Empl> {

    @Override
    public int compare(Empl e1, Empl e2) {
        if (e1.getSalary() > e2.getSalary()) {
            return -1;
        } else {
            return  1;
        }
    }
}

class Empl {

    private String name;
    private String surname;
    private int salary;
    private String employeeType;

    public static Empl addEmployee(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String surname = scanner.nextLine();
        System.out.println("Введите тип сотрудника");
        String employeeType = scanner.nextLine();
        System.out.println("Введите зарплату");
        int salary = scanner.nextInt();


        System.out.println("Добавлено");
        return new Empl(name, surname, salary, employeeType);
    }

    public Empl(String name, String surname, int salary, String employeeType) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.employeeType = employeeType;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "name= " + name + ", surname='" + surname + ", salary=" + salary + ", employeeType='" + employeeType;
    }

}


