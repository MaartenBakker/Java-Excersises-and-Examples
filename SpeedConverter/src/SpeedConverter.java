public class SpeedConverter {

    /*public static void main(String[] args) {
        printConversion(10.25);
    }*/

    public static long toMilesPerHour(double kilometersPerHour){
        if (kilometersPerHour < 0) return -1;
        else return Math.round(kilometersPerHour/1.609);
    }

    public static void printConversion(double kilometersPerHour){
        long milesPerHour = toMilesPerHour(kilometersPerHour);
        if (milesPerHour == -1) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
        }
    }
}
