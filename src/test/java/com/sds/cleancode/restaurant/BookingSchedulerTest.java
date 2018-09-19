package com.sds.cleancode.restaurant;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.joda.time.DateTime;
import org.junit.Test;

public class BookingSchedulerTest {

	@Test(expected=RuntimeException.class)
	public void testName() throws Exception {
		// arrange
		BookingScheduler bookingScheduler
			= new BookingScheduler(3);
		DateTime dateTime 
			= new DateTime(2018,9,19,15,5);
		Customer customer 
			= new Customer("NAME", "010-1111-1111");
		Schedule schedule = 
				new Schedule(dateTime, 1, customer);
		
		// act
		bookingScheduler.addSchedule(schedule );
		
		// assert
	}
}
