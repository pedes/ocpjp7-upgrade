package com.andrespedes.ocpjp7.enhancements;

/**
 * Created by andresc on 21/06/2017.
 *
 * Test the enhancements for switch conditionals using Strings.
 */
public class StringSwitchStatement {

    static String[] sa = new String[]{"a", "b", "c"};

    public static enum Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }

    public String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
        String typeOfDay;
        switch (dayOfWeekArg.toLowerCase()) {
            case "monday":
                typeOfDay = "Start of work week";
                break;
            case "tuesday":
            case "wednesday":
            case "thursday":
                typeOfDay = "Midweek";
                break;
            case "friday":
                typeOfDay = "End of work week";
                break;
            case "saturday":
            case "sunday":
                typeOfDay = "Weekend";
                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
        }
        return typeOfDay;
    }

    public void testSwitchWithFor(String[] arrayOfStrings){
        for (String s : arrayOfStrings) {
            switch (s){
                case "a":
                    System.out.println("Got a");
                    break;
                case "b":
                    System.out.println("Got b");
                    break;
            } // Default case is not mandatory
        }
    }

    public static void main(String[] args) {
        StringSwitchStatement appInstance = new StringSwitchStatement();
        System.out.println(appInstance.getTypeOfDayWithSwitchStatement(Days.THURSDAY.toString()));
        appInstance.testSwitchWithFor(sa);
    }
}
