package project.calender;

public class Calendar {

	private static final int[] END_OF_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_YEAR_END_OF_MONTH = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

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

	public void printCalendar(int year, int month, int week) {

		System.out.printf("   <<%4d년%3d월>> \n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("------------------------");
		
		boolean leapYear = isLeapYear(year);
		int endOfMonth = getEndOfMonth(leapYear, month);
		
		
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
