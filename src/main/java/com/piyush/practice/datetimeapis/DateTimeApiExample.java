package com.piyush.practice.datetimeapis;

import java.time.*;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class DateTimeApiExample {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("Todays date is ::: " + localDate);

        System.out.println("The day of the month is ::: " + localDate.getDayOfMonth());
        System.out.println("The month is ::: " + localDate.getDayOfMonth());
        System.out.println("The year is ::: " + localDate.getYear());

        LocalTime localTime = LocalTime.now();
        System.out.println("The time is ::: " + localTime);
        System.out.println("The seconds are ::: " + localTime.getSecond());
        System.out.println("The minutes are ::: " + localTime.getMinute());
        System.out.println("The hour are ::: " + localTime.getHour());

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("The zone id is ::: " + zoneId);

        ZoneId usZoneId = ZoneId.of("America/Los_Angeles");

        ZonedDateTime zonedDateTime = ZonedDateTime.now(usZoneId);
        System.out.println("The time in US is :::: " + zonedDateTime);
        System.out.println("The hour in US is :::: " + zonedDateTime.getHour());
        System.out.println("The minutes in US is :::: " + zonedDateTime.getMinute());
        System.out.println("The seconds in US is :::: " + zonedDateTime.getSecond());


        LocalDate birthdate = LocalDate.of(1990, Month.FEBRUARY, 13);

        Period p = Period.between(birthdate, localDate);
        System.out.printf("Age is %d years %d month %d days \n", p.getYears(), p.getMonths(), p.getDays());

        boolean isLeapYear = Year.now().isLeap();

        System.out.println(isLeapYear ? "Current year is leapyear" : "Current year is not leap year");
    }
}
