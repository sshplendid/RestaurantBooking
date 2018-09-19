package com.sds.cleancode.restaurant;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;

public class BookingSchedulerTest {
	private static final int NUMBER_OF_PEOPLE = 1;
	private static final int CAPACITY = 3;
	public static final Customer CUSTOMER = new Customer("NAME", "010-1111-1111");
	public static final DateTime NOT_ON_THE_HOUR = new DateTime(2018,9,19,15,5);
	public static final DateTime ON_THE_HOUR = new DateTime(2018,9,19,15,0);

	BookingScheduler bookingScheduler = new BookingScheduler(CAPACITY);
	
	@Test(expected=RuntimeException.class)
	public void throwAnExceptionWhenBookingTimeIsNotOnTheHour() throws Exception {
		// arrange
		Schedule schedule = 
				new Schedule(NOT_ON_THE_HOUR, NUMBER_OF_PEOPLE, CUSTOMER);
		
		// act
		bookingScheduler.addSchedule(schedule );
		
		// assert
	}
	
	@Test
	public void scheduleCanBeAddedWhenBookingTimeIsOnTheHour() throws Exception {
		// arrange
		Schedule schedule = 
				new Schedule(ON_THE_HOUR, NUMBER_OF_PEOPLE, CUSTOMER);
		
		// act
		bookingScheduler.addSchedule(schedule);
		
		// assert
		assertThat(bookingScheduler.hasSchedule(schedule),
							is(true));
	}
	
	
	@Test(expected=RuntimeException.class)
	public void throwAnExceptionWhenCapacityPerHourIsOver() throws Exception {
		// arrange
		
		List<Schedule> schedules 
			= new ArrayList<Schedule>();
		Schedule fullSchedule 
			= new Schedule(ON_THE_HOUR, CAPACITY, CUSTOMER);
		schedules.add(fullSchedule );
		bookingScheduler.setSchedules(schedules );
		
		Schedule schedule = 
				new Schedule(ON_THE_HOUR, NUMBER_OF_PEOPLE, CUSTOMER);
		
		// act
		bookingScheduler.addSchedule(schedule);
		
		// assert
//		assertThat(bookingScheduler.hasSchedule(schedule),
//							is(true));
	}
	
	
}
