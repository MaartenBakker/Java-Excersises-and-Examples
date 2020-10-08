import java.util.ArrayList;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        new Thread(()-> {
            System.out.println("Printing from Lambda");
            System.out.println("Line 2");
        }).start();

        Employee john = new Employee("John Doe", 30);
        Employee maarten = new Employee("Maarten Bakker", 37);
        Employee bert = new Employee("Bert Banjo", 24);
        Employee brutus = new Employee("Brutus Bakker", 64);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(maarten);
        employees.add(bert);
        employees.add(brutus);

//        employees.sort((e1,  e2) -> e1.getName().compareTo(e2.getName()));

        employees.sort((employee1, employee2)-> employee1.getName().compareTo(employee2.getName()));


//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        for(Employee employee: employees) {
            System.out.println(employee.getName());
        }

        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        String sillyString = doStringStuff(uc,
                employees.get(0).getName(), employees.get(1).getName());

        System.out.println(sillyString);
        
        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething("Bello", "Bakker");
        System.out.println(s);
        
        
        
        
    }
    
    
    

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.UpperConcat(s1, s2);
    }


}

