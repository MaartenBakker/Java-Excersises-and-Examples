public class DurationString {

    public static void main(String[] args) {


        System.out.println(getDurationString(121, 36));
        System.out.println(getDurationString(3604));
        System.out.println(getDurationString(61, 0));
        System.out.println(getDurationString(61, 71));
        System.out.println(getDurationString(10, 05));




    }

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";


    public static String getDurationString(int minutes, int seconds){

        if (minutes < 0 || seconds < 0 || seconds >= 60) return INVALID_VALUE_MESSAGE;

        int hours = minutes / 60;
        String hoursAsString = hours + "h ";
        if (hours < 10) hoursAsString = "0" + hoursAsString;

        int remainingMinutes = minutes % 60;
        String minutesAsString = remainingMinutes + "m ";
        if (remainingMinutes < 10) minutesAsString = "0" + minutesAsString;

        String secondsAsString = seconds + "s";
        if (seconds < 10) secondsAsString = "0" + secondsAsString;

        return hoursAsString + minutesAsString + secondsAsString;
    }

    public static String getDurationString(int seconds){
        if (seconds < 0 ) return INVALID_VALUE_MESSAGE;



        int minutesFromSeconds = seconds / 60;
        int remainingSeconds = seconds % 60;

        return getDurationString(minutesFromSeconds, remainingSeconds);
    }
}
