package project.calender;

import java.util.Scanner;

public class Calendar {
	
	private static final int[] END_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int getEndOfMonth(int month) {
		return END_OF_MONTH[month-1];
	}
	
	public static void printSampleCalendar() {
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("--------------------");
		System.out.println("1  2  3  4  5  6  7");
		System.out.println("8  9  10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		
	}

	public static void main(String[] args) {

		
		// 입력받은 월의 최대 일수 출력하기
	
		
		// 입력 받기
		int month;
		Calendar cal = new Calendar();
		System.out.println("달을 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		month = scanner.nextInt();
		
		// 출력 하기
		System.out.printf("%d월은 %d일까지 있습니다.",month,cal.getEndOfMonth(month));
		scanner.close();
	}

}
