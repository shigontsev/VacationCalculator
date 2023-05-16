package com.neoflextest.vacationcalculator.model;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;

public class CalculateVacation {

    private Holiday holiday;
    public CalculateVacation()
    {
        holiday = new Holiday();
    }
    public CalculateVacation(Holiday new_holiday)
    {
        holiday = new_holiday;
    }

    public double calculateVacation(
            double averageSalary,
            int vacationDays) {

        if (vacationDays <= 0)
            throw new IllegalArgumentException("Argument vacationDays "+ vacationDays+ " <= 0");

        double basicVacationPay = (averageSalary / 12) * vacationDays;

        //return Math.round(basicVacationPay * 100.0) / 100.0;
        return BigDecimal.valueOf(basicVacationPay)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public double calculateVacation(
            double averageSalary,
            int vacationDays,
            LocalDate departureDate,
            LocalDate returnDate) {
        if (vacationDays <= 0)
            throw new IllegalArgumentException("Argument vacationDays "+ vacationDays+ " <= 0");

        double basicVacationPay = (averageSalary / 12) * vacationDays;

        double vacationPayWithDates = calculateVacationPayWithDates(
                basicVacationPay,
                departureDate,
                returnDate);

        //return Math.round(vacationPayWithDates * 100.0) / 100.0;
        return BigDecimal.valueOf(vacationPayWithDates)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private double calculateVacationPayWithDates(
            double basicVacationPay,
            LocalDate departureDate,
            LocalDate returnDate) {
        double additionalDaysOff = calculateAdditionalDaysOff(
                departureDate,
                returnDate);

        double vacationPayWithDates = basicVacationPay + (basicVacationPay / 365) * additionalDaysOff;

        return vacationPayWithDates;
    }

    private int calculateAdditionalDaysOff(LocalDate departureDate, LocalDate returnDate) {
        int daysBetween = Period.between(departureDate, returnDate).getDays();

        if(daysBetween < 0)
            throw new ArithmeticException("Argument " + daysBetween + " < 0");

        int additionalDaysOff = 0;
        for (LocalDate date = departureDate.plusDays(1); date.isBefore(returnDate); date = date.plusDays(1)) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                additionalDaysOff++;
            } else if (isHoliday(date)) {
                additionalDaysOff++;
            }
        }

        return additionalDaysOff;
    }

    private boolean isHoliday(LocalDate date) {
        return holiday.isContains(date);
    }

    public  LocalDate addHoliday(LocalDate new_holiday)
    {
        holiday.add(new_holiday);
        return new_holiday;
    }

    public  LocalDate deleteHoliday(LocalDate old_holiday)
    {
        holiday.remove(old_holiday);
        return old_holiday;
    }
}
