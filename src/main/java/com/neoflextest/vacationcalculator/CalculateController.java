package com.neoflextest.vacationcalculator;

import com.neoflextest.vacationcalculator.model.CalculateVacation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController("/calculate")
public class CalculateController {
    CalculateVacation cal;

    public CalculateController()
    {
        cal = new CalculateVacation();
    }

    public CalculateController(CalculateVacation new_cal)
    {
        cal = new_cal;
    }

    @GetMapping("*/calc")
    public double calculateVacation(
            @RequestParam double averageSalary,
            @RequestParam int vacationDays) {

        return cal.calculateVacation(averageSalary, vacationDays);
    }

    @GetMapping("*/calcwithdate")
    public double calculateVacation(
            @RequestParam double averageSalary,
            @RequestParam int vacationDays,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate) {

        return cal.calculateVacation(averageSalary, vacationDays,departureDate, returnDate);
    }

    @GetMapping("*/addholiday")
    public LocalDate addHoliday(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate holidayDate) {

        return cal.addHoliday(holidayDate);
    }

    @GetMapping("*/deleteholiday")
    public LocalDate deleteHoliday(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate holidayDate) {

        return cal.deleteHoliday(holidayDate);
    }

}
