package com.sds.cleancode.restaurant;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MondayBookingScheduler extends BookingScheduler {

	public MondayBookingScheduler(int capacityPerHour) {
		super(capacityPerHour);
	}

	@Override
	public DateTime getNow() {
		DateTimeFormatter dateTimeFormatter= DateTimeFormat.forPattern("YYYY/MM/dd HH:mm");
		return dateTimeFormatter.parseDateTime("2018/09/10 17:00");
	}
}
