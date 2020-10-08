import com.sun.jdi.Value;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("harry".replaceAll("[HhP]arry", "X"));

        String tvTest = "tstvtkt";
//        String tNotVRegEx = "t(?!v)";
        String tNotVRegEx = "t(?=v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegEx);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        int count = 0;

        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }


//        String usPhoneNumberRegEx = "^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-90{3}[\-]{1}[0-9]{4})$";
        String phone1 = "1234567890";
        String phone2 = "(123) 456-7890";
        String phone3 = "123 456-7890";
        String phone4 = "(123)456-7890";

        System.out.println(phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println(phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println(phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println(phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        System.out.println("=====");

        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        String regEx = "I want a \\w+.";

        Pattern regExPattern = Pattern.compile(regEx);
        Matcher regExMatcher = regExPattern.matcher(challenge1);
        System.out.println(regExMatcher.matches());

        regExMatcher = regExPattern.matcher(challenge2);
        System.out.println(regExMatcher.matches());

        String challenge4 = "Replace all blanks with underscores.";

        System.out.println(challenge4.replaceAll(" ", "_"));

        String challenge5 = "zaaabccccccccdddefffg";

        regEx = "^a{3}bc{8}d{3}ef{3}g$";
//        regEx = "[a-g]{20}+";
        regExPattern = Pattern.compile(regEx);
        regExMatcher = regExPattern.matcher(challenge5);

        System.out.println(challenge5.replaceAll("a{3}bc{8}d{3}ef{3}g$", "REPLACED"));

        regEx = "^[A-Za-z]+\\.\\d+$";

        String challenge7 = "abcd.135";

        System.out.println(challenge7.matches(regEx));

        String challenge8 = "abcd.135uvqz.7tzik.999";

        regEx = "[A-Za-z]+\\.(\\d+)";

        regExPattern = Pattern.compile(regEx);
        regExMatcher = regExPattern.matcher(challenge8);

        while (regExMatcher.find()) {
            System.out.println("Digits found : " + regExMatcher.group(1));
        }

        System.out.println("==================");

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";

//        regEx = "[A-Za-z]+\\.(\\d+)\\\\[tn]";
        regEx = "[A-Za-z]+\\.(\\d+)\\s"; //s is for whitespace characters.

        regExPattern = Pattern.compile(regEx);
        regExMatcher = regExPattern.matcher(challenge9);

        while (regExMatcher.find()) {
            System.out.println("Digits found : " + regExMatcher.group(1));
            System.out.println("Start : " + regExMatcher.start(1));
            System.out.println("End : " + (regExMatcher.end(1)-1));
        }

        System.out.println("==================");


        String challenge11 = "{0, 2}, {0, 56}, {1, 3}, {2, 4}";

        regEx = "\\{(\\d+, \\d+)}";
//        regEx = "\\{(.+?)}";

        regExPattern = Pattern.compile(regEx);
        regExMatcher = regExPattern.matcher(challenge11);

        while (regExMatcher.find()) {
            System.out.println("Digits found : " + regExMatcher.group(1));

        }

        System.out.println("==================");


        regEx = "^\\d{5}$";
        String challenge12 = "11111";

        System.out.println(challenge12.matches(regEx));

        regEx = "^\\d{5}-\\d{4}$";
        String challenge13 = "11111-1111";

        System.out.println(challenge13.matches(regEx));

        regEx = "^\\d{5}(-\\d{4})?$";

        String challenge13false = "11111-11111";

        System.out.println(challenge12.matches(regEx));
        System.out.println(challenge13.matches(regEx));
        System.out.println(challenge13false.matches(regEx));


    }
}
