package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random ran=new Random();
		int randomnum=ran.nextInt(5000);
		return randomnum;
	}
	
	public String getSystemDateYYYYDDMM() {
		Date d=new Date();  //it will date and time
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(d);
		return date;	
	}
	
	public String getRequiredDateYYYYDDMM(int days)
	{
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		//Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate=sim.format(cal.getTime());
		return reqDate;
		
		
	}
}
