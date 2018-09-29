package project.calender;

public class Calendar {

	private static final int[] END_OF_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getEndOfMonth(int month) {
		return END_OF_MONTH[month - 1];
	}

	public void printCalendar(int year, int month) {

		System.out.printf("   <<%4d년%3d월>> \n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("------------------------");
		
		int endOfMonth = getEndOfMonth(month);
		
		for(int i=1; i<=endOfMonth; i++) {
			System.out.printf("%3d",i);
			if ((i%7)==0) {
				System.out.println();
			}
		}
		
		System.out.println();
	}

}
