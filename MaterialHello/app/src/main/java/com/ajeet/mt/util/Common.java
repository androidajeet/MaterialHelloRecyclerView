package com.ajeet.mt.util;



		import java.text.SimpleDateFormat;
		import java.util.Calendar;
		import java.util.Date;
		import java.util.concurrent.TimeUnit;

public class Common {

	public static String getCurrentDate() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			/* sdf.setTimeZone(TimeZone.getTimeZone("UTC")); */
			String date = sdf.format(new Date());
			return date;

		} catch (Exception exce) {
			exce.printStackTrace();
		}

		return null;
	}

	public static String getFormatedDateIn_DD_MM_YYYY() {
		try {
			String formatedDate = null;
			try {
				SimpleDateFormat date = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");

				formatedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);

			} catch (Exception e) {

			}

			return formatedDate;

		} catch (Exception exce) {
			exce.printStackTrace();
		}

		return null;
	}

	public static String getFormatedDateIn_DD_MM_YYYY(String assignedDate) {
		try {
			String formatedDate = null;
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(assignedDate);

				formatedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);

			} catch (Exception e) {

			}

			return formatedDate;

		} catch (Exception exce) {
			exce.printStackTrace();
		}

		return null;
	}

	public static String getCurrentDateTime1() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss.SSS");
			/* sdf.setTimeZone(TimeZone.getTimeZone("UTC")); */

			String date = sdf.format(new Date());
			return date;

		} catch (Exception exce) {
			exce.printStackTrace();
		}

		return null;
	}

	public static String getCurrentDateTime() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss.SSS");
			/* sdf.setTimeZone(TimeZone.getTimeZone("UTC")); */

			String date = sdf.format(new Date());
			return date;

		} catch (Exception exce) {
			exce.printStackTrace();
		}

		return null;
	}

	public static String getCurrentLocalDateTime() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String date = sdf.format(new Date());

			return date;

		} catch (Exception exce) {
			exce.printStackTrace();
		}

		return null;
	}

	public static String getCurrentDateTimeWithMillis() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss.SSS");
			/* sdf.setTimeZone(TimeZone.getTimeZone("UTC")); */

			String date = sdf.format(new Date());

			return date;

		} catch (Exception exce) {
			exce.printStackTrace();
		}

		return null;
	}

	public static String convertLocalTimeToUTC() {
		String utcTimeInString = null;
		try {
			Date localTime = new Date();

			SimpleDateFormat converter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss.SSS");

			/* converter.setTimeZone(TimeZone.getTimeZone("UTC")); */

			utcTimeInString = converter.format(localTime);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return utcTimeInString;
	}

	public static String getLocalTimeFromUtc(String UTCTime) {
		return null;
	}

	public static String getFormatedString(String string) {

		return string.replace("\n", "");
	}

	public static String getDateBeforeCurrentDateByDays(int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_YEAR, -days);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			/* sdf.setTimeZone(TimeZone.getTimeZone("UTC")); */
			String date = sdf.format(cal.getTime());
			return date;
		} catch (Exception exce) {
			exce.printStackTrace();
		}
		return null;
	}



	public static String getFormatedDateIn_DD_MM_YYYY_hhmmss(String sheduledDate) {
		try {
			String formatedDate = null;
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(sheduledDate);

				formatedDate = new SimpleDateFormat("dd-MM-yyyy HH:mm")
						.format(date);

			} catch (Exception e) {

			}

			return formatedDate;

		} catch (Exception exce) {
			exce.printStackTrace();
		}

		return null;
	}


	public static String getDifferenceBetweenDate(String createdDate,String currentDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateCreated = null;
		Date dateCurrent = null;
		StringBuilder sb = new StringBuilder(64);
		try {
			dateCreated = format.parse(createdDate);
			dateCurrent = format.parse(currentDate);
			// in milliseconds

			long millis = dateCurrent.getTime() - dateCreated.getTime();

			if (millis < 0) {
				throw new IllegalArgumentException(
						"Duration must be greater than zero!");
			}

			long days = TimeUnit.MILLISECONDS.toDays(millis);
			millis -= TimeUnit.DAYS.toMillis(days);
			if (days != 0) {
				sb.append(days);
				sb.append(" Days ");
			}
			long hours = TimeUnit.MILLISECONDS.toHours(millis);
			millis -= TimeUnit.HOURS.toMillis(hours);
			if (hours != 0) {
				sb.append(hours);
				sb.append(" Hours ");
			}

		} catch (Exception e) {
			System.out.println(e);

		}

		sb.append("ago");
		sb.append(" ");
		return (sb.toString());
	}


}
