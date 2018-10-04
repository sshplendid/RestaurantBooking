package com.sds.cleancode.restaurant;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class SundayBookingScheduler extends BookingScheduler {

	public SundayBookingScheduler(int capacityPerHour) {
		super(capacityPerHour);
	}

	@Override
	public DateTime getNow() {
		DateTimeFormatter dateTimeFormatter= DateTimeFormat.forPattern("YYYY/MM/dd HH:mm");
		return dateTimeFormatter.parseDateTime("2018/09/09 17:00");
	}
}
