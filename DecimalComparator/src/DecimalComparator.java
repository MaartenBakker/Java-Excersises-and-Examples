public class DecimalComparator {

    public static void main(String[] args) {
        areEqualByThreeDecimalPlaces(3.1756, 3.175);
    }

    public static boolean areEqualByThreeDecimalPlaces(double x, double y){

        double x1000 = x * 1000;
        //System.out.println(x100);
        int xAsInt = (int) x1000;
        //System.out.println(xAsInt);
        double y1000 = y * 1000;
        //System.out.println(y100);
        int yAsInt = (int) y1000;
        //System.out.println(yAsInt);

        if (xAsInt == yAsInt) return true;
        else return false;

    }
}
