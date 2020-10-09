import java.security.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G60", "G49", "G50", "g64",
                "I26", "I17", "I29",
                "O71"
        );
//
//        List<String> gNumbers = new ArrayList<>();
//
//        someBingoNumbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
//            }
//        });
//
//        gNumbers.sort((string1, string2) -> string1.compareTo(string2));
//        gNumbers.forEach(string -> System.out.println(string));
//

        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);


        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumbersStream = Stream.of("I26", "I17", "I29", "N40", "N36", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumbersStream);
//        System.out.println(concatStream.count());
        System.out.println("==========");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        Supplier<Stream<String>> streamSupplier = () -> Stream.of("I26", "I17", "I29", "O71");

        Employee john = new Employee("John Doe", 30);
        Employee jack = new Employee("Jack Hill", 40);
        Employee jane = new Employee("Jane Deer", 25);
        Employee snow = new Employee("Snow White", 18);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);



        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter((string) -> string.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter((string) -> string.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);


        sortedGNumbers.forEach(System.out::println);


        departments.stream().
                flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

    }
}
