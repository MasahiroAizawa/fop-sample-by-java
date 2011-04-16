package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	public static String getNowForFileTimeStamp(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}
}
