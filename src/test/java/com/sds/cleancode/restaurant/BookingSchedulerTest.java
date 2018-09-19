package com.sds.cleancode.restaurant;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class BookingSchedulerTest {
	private static final int NUMBER_OF_PEOPLE = 1;
	private static final int CAPACITY = 3;
	private static final Customer CUSTOMER = new Customer("NAME", "010-1111-1111");
	private static final DateTime NOT_ON_THE_HOUR = new DateTime(2018,9,19,15,5);
	private static final DateTime ON_THE_HOUR = new DateTime(2018,9,19,15,0);
	
	private List<Schedule> schedules = new ArrayList<Schedule>();
	private BookingScheduler bookingScheduler = new BookingScheduler(CAPACITY);
	
	@Before
	public void setUp() {
		bookingScheduler.setSchedules(schedules );
	}
	
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
		Schedule fullSchedule 
			= new Schedule(ON_THE_HOUR, CAPACITY, CUSTOMER);
		schedules.add(fullSchedule );
		
		Schedule schedule = 
				new Schedule(ON_THE_HOUR, NUMBER_OF_PEOPLE, CUSTOMER);
		
		// act
		bookingScheduler.addSchedule(schedule);
		
		// assert
//		assertThat(bookingScheduler.hasSchedule(schedule),
//							is(true));
	}

	
	
	
}
