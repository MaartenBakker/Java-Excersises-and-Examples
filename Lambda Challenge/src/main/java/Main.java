import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        Runnable runnable = () -> {
//            String myString = "Let's split this string into an array";
//            String[] stringArray = myString.split(" ");
//            List<String> stringList = Arrays.asList(stringArray);
//            stringList.forEach(System.out::println);
//        };
//
//
//        Function<String, String> everySecondChar = inputString -> {
//            StringBuilder returnString = new StringBuilder();
//            for (int i = 0; i < inputString.length() ; i += 2) {
//                returnString.append(inputString.charAt(i));
//            }
//            return returnString.toString();
//        };
//
//        System.out.println(modifyString("MaartenBa", everySecondChar));
//        System.out.println(modifyString("MaartenBakker", everySecondChar));
//        System.out.println(everySecondChar.apply("Anna"));
//
//
//        Supplier<String> iLoveJava = () -> "I Love Java!";
//
//        String supplierResult = iLoveJava.get();
//        System.out.println(supplierResult);

        List<String> topnames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> list =
                topnames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());

                System.out.println("-------------------");



        list.forEach(System.out::println);


//        System.out.println("-------------------");
//
//
//        System.out.println(topnames2015.stream()
//               .map(string -> string.substring(0,1).toUpperCase() + string.substring(1))
//               .filter(string -> string.startsWith("A"))
//               .count());




    }

    static private String modifyString(String string, Function<String, String> function){
        return function.apply(string);
    }
}
