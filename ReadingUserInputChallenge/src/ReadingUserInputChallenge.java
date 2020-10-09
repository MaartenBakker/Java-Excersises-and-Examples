import java.util.Scanner;

public class ReadingUserInputChallenge {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int validNumberCounter = 0;

        while (validNumberCounter < 10) {

            int order = validNumberCounter + 1;
            System.out.println("Enter number #" + order + ":");
            boolean hasNextInt = scanner.hasNextInt();

            if (!hasNextInt) {
                System.out.println("Invalid Number");
                scanner.nextLine();// handle end of line (enter key)
                continue;
            }

            sum += scanner.nextInt();
            validNumberCounter++;

        }
        scanner.close();
        System.out.println("The sum of the entered numbers is : " + sum);


    }
}
