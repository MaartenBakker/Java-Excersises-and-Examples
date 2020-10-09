public class NumberToWords {

    public static void main(String[] args) {

        numberToWords(123446000);
    }

    public static void numberToWords(int number) {

        if (number < 0) System.out.println("Invalid Value");
        if (number == 0) System.out.println("Zero");

        int reverse = reverse(number);

        String[] countWords = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

        int missingDigits = getDigitCount(number) - getDigitCount(reverse);

        while (reverse > 0 ) {
            System.out.println(countWords[reverse % 10]);
            reverse /= 10;
        }

        for (int i = 0; i < missingDigits; i++) {
            System.out.println(countWords[0]);
        }
    }

    public static int getDigitCount(int number){
        if (number < 0) return -1;
        if (number == 0) return 1;

        int digitCounter = 0;

        while (number > 0) {
            number /= 10;
            digitCounter++;
        }
        return digitCounter;
    }



    public static int reverse (int number){
        int reverse = 0;
        int lastDigitOfNumber = 0;
        boolean wasNegative = false;

        if (number < 0) {
            number *= -1;
            wasNegative = true;
        }

        while (number > 0) {
            lastDigitOfNumber = number % 10;
            number /= 10;
            reverse *= 10;
            reverse += lastDigitOfNumber;
        }

        if (wasNegative) reverse *= -1;

        return reverse;
    }
}
