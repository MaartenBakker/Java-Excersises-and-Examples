public class FeetInchesCentimeters {

    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeters(6,0));
        System.out.println(calcFeetAndInchesToCentimeters(11, 5));
        System.out.println(calcFeetAndInchesToCentimeters(345));
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {

        if (feet < 0 || inches < 0 || inches > 12 ) return -1;

        return (feet * 12 * 2.54) + (inches * 2.54);

    }

    public static double calcFeetAndInchesToCentimeters(int inches) {

        if (inches < 0) return -1;

        int feet = inches / 12;
        int remainingInches = inches % 12;

        return calcFeetAndInchesToCentimeters(feet, remainingInches);

    }


}
