package project.calender;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	private static final int[] END_OF_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_YEAR_END_OF_MONTH = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private HashMap<Date, String> planList;
	private Management management;
	
	public Calendar() {
		management = new Management();
		
		File file = new File("C:\\yoon\\Study\\Programming\\java_workspace\\calendar\\save.txt");
		
		if (file.exists()) {
			planList = management.loadFile();
		} else {
			planList = new HashMap<>();
		}
		
		
	}

	public void registerPlan(String strDate, String plan) { // 일정 등록
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			planList.put(date, plan);
			management.saveFile(strDate, plan);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String searchPlan(String strDate) {
		Date date;
		String plan = "";
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			plan = planList.get(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plan;
	}
	
	public boolean isLeapYear(int year) {
		if((year%4)==0 && ((year%100)!=0 || (year%400)==0)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public int getEndOfMonth(boolean leapYear, int month) {
		if(leapYear) {
			return LEAP_YEAR_END_OF_MONTH[month - 1];
		} else {
			return END_OF_MONTH[month - 1];
		}
	}
	
	public int getWeekDay(int year, int month) { // 요일 알고리즘을 이용한 요일 구하기
		
		int standardYear = 1800; // 기준년도
		int standardWeek = 3; // 1800년 1월 1일은 수요일
		
		int days = 0; // 입력한 날짜에서 기준년도의 월까지 지난 일수들
		
		int weekDay; // 구하는 요일 (0:sun~ 6:sat)
		
		for(int i=standardYear; i<year; i++) {
			if(isLeapYear(i)) {
				days += 366;
			} else {
				days += 365;
			}
		}
		
		for(int j=0; j<month-1; j++) {
			if(isLeapYear(standardYear)) {
				days += LEAP_YEAR_END_OF_MONTH[j];
			} else {
				days += END_OF_MONTH[j];
			}
		}
		
		weekDay = (standardWeek + (days%7)) %7;
		
		
		return weekDay;
	}

	public void printCalendar(int year, int month) {
		

		System.out.printf("   <<%4d년%3d월>> \n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("------------------------");
		
		boolean leapYear = isLeapYear(year);
		int endOfMonth = getEndOfMonth(leapYear, month);
		
		int week = getWeekDay(year, month);
		
		
		for(int j=0; j<week; j++) {
			System.out.print("   ");
		}
		
		for(int i=1; i<=endOfMonth; i++) {
			
			System.out.printf("%3d",i);
			if((i+week)%7 == 0) {
				System.out.println();
			}
		}
		
		
		
		System.out.println();
	}

}
