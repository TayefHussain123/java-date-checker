package com.example;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.util.*;


import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

public class Main {

    public static void main(String[] args) throws ParseException {

            System.out.print("Enter a date using yyyy-MM-dd format: ");

            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();

            System.out.println();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(str);

            LocalDate localDate = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
            LocalDate startingDateOfWeek = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()).with(previousOrSame(DayOfWeek.MONDAY));
            LocalDate endingDateOfWeek = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()).with(nextOrSame(DayOfWeek.SUNDAY));
            LocalDate startingDateOfMonth = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()).withDayOfMonth(1);
            LocalDate endingDateOfMonth = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()).plusMonths(1).withDayOfMonth(1).minusDays(1);
            LocalDate startingDateOfYear = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()).withDayOfYear(1);
            LocalDate endingDateOfYear = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()).plusYears(1).withDayOfYear(1).minusDays(1);

            System.out.println("Starting date of the week for the given date is " + startingDateOfWeek);
            System.out.println("Ending date of the week for the given date is " + endingDateOfWeek);
            System.out.println();
            System.out.println("Starting date of the month for the given date is " + startingDateOfMonth);
            System.out.println("Ending date of the month for the given date is " + endingDateOfMonth);
            System.out.println();
            System.out.println("Starting date of the year for the given date is " + startingDateOfYear);
            System.out.println("Ending date of the year for the given date is " + endingDateOfYear);


    }
}
