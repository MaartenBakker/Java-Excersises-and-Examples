import java.util.Scanner;

public class MinAndMaxInputChallenge {

    public static void main(String[] args) {

        int min = 0;
        int max = 0;
        boolean isFirstInput = true;
        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("Enter Number");
            boolean hasNextInt = scanner.hasNextInt();

            if (!hasNextInt) {

                //scanner.nextLine(); //handle last input (enter key)
                System.out.println("The minimum is : " + min);
                System.out.println("The maximum is : " + max);
                break;
            }

            int number = scanner.nextInt();

            if (isFirstInput) {
                min = number;
                max = number;
                isFirstInput = false;
            } else {
                if (number < min) min = number;
                if (number > max) max = number;
            }

            scanner.nextLine(); // handle input
        }

        scanner.close();


    }

}
