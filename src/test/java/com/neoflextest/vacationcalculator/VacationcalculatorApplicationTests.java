package com.neoflextest.vacationcalculator;

import com.neoflextest.vacationcalculator.model.CalculateVacation;
import com.neoflextest.vacationcalculator.model.Holiday;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VacationcalculatorApplicationTests {

	@Test
	public void testCalculateVacation() {
		CalculateController controller = new CalculateController();
		double averageSalary = 2000.0;
		int vacationDays = 10;
		double expected = 1666.67;
		double result = controller.calculateVacation(averageSalary, vacationDays);
		assertEquals(expected, result, 0.01);
		System.out.println("Test1\n" + result);
	}

	@Test
	public void testCalculateVacationWithDates() {
		CalculateController controller = new CalculateController();
		double averageSalary = 2000.0;
		int vacationDays = 10;
		String departureDate = "2023-07-01";
		String returnDate = "2023-07-15";
		double expected = 1680.37;
		double result = controller.calculateVacation(averageSalary, vacationDays, LocalDate.parse(departureDate), LocalDate.parse(returnDate));
		assertEquals(expected, result, 0.01);
		System.out.println("Test2\n" + result);
	}

	@Test
	public void testCalculateVacationWithDates1() {
		Holiday holiday = new Holiday();
		CalculateController controller = new CalculateController(new CalculateVacation(holiday));
		holiday.add(LocalDate.parse("2023-07-10"));
		holiday.add(LocalDate.parse("2023-07-11"));
		holiday.add(LocalDate.parse("2023-07-12"));
		double averageSalary = 2000.0;
		int vacationDays = 10;
		String departureDate = "2023-07-01";
		String returnDate = "2023-07-15";
		double expected = 1694.06;
		double result = controller.calculateVacation(averageSalary, vacationDays, LocalDate.parse(departureDate), LocalDate.parse(returnDate));
		assertEquals(expected, result, 0.01);
		System.out.println("Test3\n" + result);
	}
	@Test
	public void testCalculateVacationWithDates2() {
		Holiday holiday = new Holiday();
		CalculateController controller = new CalculateController(new CalculateVacation(holiday));
		holiday.add(LocalDate.parse("2023-07-10"));
		holiday.add(LocalDate.parse("2023-07-11"));
		holiday.add(LocalDate.parse("2023-07-12"));
		double averageSalary = 2000.0;
		int vacationDays = 10;
		String departureDate = "2023-07-01";
		String returnDate = "2023-07-15";
		double expected = 1694.06;
		double result = controller.calculateVacation(averageSalary, vacationDays, LocalDate.parse(departureDate), LocalDate.parse(returnDate));
		assertEquals(expected, result, 0.01);
		System.out.println("Test3\n" + result);
	}
}
