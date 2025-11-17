package utils;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class JdbcDateTimes {
	public static void main(String[] args) {

		/*
		 * JShell Exercise 1 (Java Date–Time API) Create a LocalDate representing
		 * today’s date and display it in JShell.s
		 */
		LocalDate localDate = LocalDate.now();
		// System.out.println(localDate);

		/*
		 * JShell Exercise 2 (Java Date–Time API)
		 * 
		 * Create a LocalTime that represents the current time and display it in
		 * JShell.sF
		 * 
		 */
		LocalTime localTime = LocalTime.now();
		// System.out.println(localTime);

		/*
		 * JShell Exercise 3 (Java Date–Time API)
		 * 
		 * Create a LocalDateTime that represents the current date and time, then
		 * display it in JShell.
		 * 
		 * 
		 */
		LocalDateTime localDateTime = LocalDateTime.now();
//		System.out.println(localDateTime);

		/*
		 * 
		 * JShell Exercise 4 (Java Date–Time API)
		 * 
		 * Create an OffsetTime with the current time and an offset of +02:00, then
		 * display it in JShell.
		 */

		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		System.out.println(offsetDateTime);

		/*
		 * JShell Exercise 5 (Java Date–Time API)
		 * 
		 * Create an OffsetDateTime representing this exact moment: 2025-01-10 at 14:30
		 * with offset +02:00 Then display it in JShell.
		 */

		OffsetDateTime of = OffsetDateTime.of(2025, 01, 20, 14, 30, 0, 0, ZoneOffset.of("+02:00"));
		System.out.println(of);

		/*
		 * JShell Exercise 6 (Java Date–Time API)
		 * 
		 * Create a ZoneOffset representing “+02:00” and display it in JShell.
		 */
		ZoneOffset ofHours = ZoneOffset.ofHours(02);
		// System.out.println(ofHours);

		/*
		 * JShell Exercise 7 (Java Date–Time API)
		 * 
		 * Create a LocalDate representing your birthday and then add 100 days to it.
		 * Display the result in JShell.
		 * 
		 */
		LocalDate dofb = LocalDate.of(1989, 10, 26);
		LocalDate plusDays = dofb.plusDays(100);
		System.out.println("PLUS 100 Days -->" + plusDays);

		/*
		 * 📝 JShell Exercise 8 (Java Date–Time API)
		 * 
		 * Create a LocalDateTime for the current moment, then convert it to an
		 * OffsetDateTime using an offset of +03:00. Display the result in JShell
		 */

		LocalDateTime localDateTimeCurrent = LocalDateTime.now();
		OffsetDateTime fromLocalDateTimeToOffsetDateTime = OffsetDateTime.of(localDateTimeCurrent,
				ZoneOffset.of("+03:00"));
		System.out.println(fromLocalDateTimeToOffsetDateTime);

		/*
		 * JShell Exercise 9 (Java Date–Time API)
		 * 
		 * Create a LocalDate representing today, then find out the day of the week for
		 * that date. Display the result in JShell.
		 */

		LocalDate currentDate = LocalDate.now();
		DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
		System.out.println(dayOfWeek);

		/**
		 * 
		 * JShell Exercise 10 (Java Date–Time API)
		 * 
		 * Create a LocalDateTime for your next birthday at 00:00 (midnight). Then
		 * calculate how many days are left from today until that date. Display the
		 * result in JShell.
		 * 
		 * 
		 * 
		 * 
		 */
		LocalDate currentLocalDate = LocalDate.now();
		LocalDate nextBirth = LocalDate.of(2026, 10, 26);
		long between = ChronoUnit.DAYS.between(currentLocalDate, nextBirth);
		System.out.println(between);
		/*
		 * JShell Exercise 11 (Java Date–Time API)
		 * 
		 * Create a LocalTime for 09:30 (9:30 AM). Then add 45 minutes to it and display
		 * the new time in JShell.
		 */
		LocalTime provivedTime = LocalTime.of(9, 30);
		LocalTime plusMinutes = provivedTime.plusMinutes(45);
		System.out.println(plusMinutes);

		/*
		 * 
		 * Exercise 12 (Challenge)
		 * 
		 * Task:
		 * 
		 * Create a LocalDateTime for the current moment.
		 * 
		 * Add 2 weeks and 3 hours to it.
		 * 
		 * Then subtract 15 minutes.
		 * 
		 * Display the final result.
		 */

		LocalDateTime currentDateTime = LocalDateTime.now();
		LocalDateTime minusMinutes = currentDateTime.plusWeeks(2).plusHours(3).minusMinutes(15);
		System.out.println(minusMinutes);

		/*
		 * Step 13: Convert to OffsetDateTime UTC
		 * 
		 * (You already know the logic)
		 * 
		 * OffsetDateTime odt = ts.toInstant().atOffset(ZoneOffset.UTC); Timestamp ts =
		 * Timestamp.valueOf("2024-01-05 14:22:00");
		 * 
		 */
		Timestamp ts = Timestamp.valueOf("2024-01-05 14:22:00");
		OffsetDateTime atOffset = ts.toInstant().atOffset(ZoneOffset.UTC);
		System.out.println(atOffset);

		/*
		 * Exercise 14 (Database-Style Challenge)
		 * 
		 * You very often convert timestamps from DB to OffsetDateTime. Now let's do the
		 * opposite.
		 * 
		 * ▶ Task:
		 * 
		 * Create an OffsetDateTime representing now in UTC.
		 * 
		 * Convert it to a Timestamp (for saving into a database).
		 * 
		 * Print both.
		 * 
		 */

	}
}