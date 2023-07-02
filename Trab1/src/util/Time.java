package util;

import java.time.LocalDateTime;

public class Time {
	public static String formatTime(LocalDateTime x) {
		return String.format("%s/%s/%s", Integer.toString(x.getDayOfMonth()), Integer.toString(x.getMonthValue()), Integer.toString(x.getYear()));
	}
}
