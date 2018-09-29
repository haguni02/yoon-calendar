package project.calender;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {

		System.out.println("일 월 화 수 목 금 토");
		System.out.println("--------------------");
		System.out.println("1  2  3  4  5  6  7");
		System.out.println("8  9  10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		
		// 입력받은 월의 최대 일수 출력하기
		
		// 달마다 최대 일수 등록
		int[] months = new int[12];
		for(int i=0; i<months.length; i++) {
			if (i==1) {
				months[i] = 28;
			} else if (i==3 || i==5 || i==8 || i==10) {
				months[i] = 30;
			} else {
				months[i] = 31;
			}
		}
		// 입력 받기
		int month;
		System.out.println("달을 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		month = scanner.nextInt();
		
		// 출력 하기
		System.out.printf("%d월은 %d일까지 있습니다.",month,months[month-1]);
		scanner.close();
	}

}
