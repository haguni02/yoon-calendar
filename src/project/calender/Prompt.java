package project.calender;

import java.util.Scanner;

public class Prompt {

//	private static final String PROMPT = "cal>";
	
	private Scanner scanner = new Scanner(System.in);



	public void runPrompt() {

		// 입력받은 월의 최대 일수 출력하기
		int month; // 달 입력
		int year; // 년도 입력
		Calendar cal = new Calendar();
		

		month = 1;

		while (true) {
			System.out.println("년도를 입력하세요.(-1:종료)");
			System.out.print("YEAR>");
			year = scanner.nextInt();

			if (year == -1)
				break;

			System.out.println("달을 입력하세요.");
			System.out.print("MONTH>");
			month = scanner.nextInt();


			if (month > 12 || month < 1) {
				System.out.println("달은 1월부터 12월까지 입력하실 수 있습니다.");
				continue;
			}
			

			cal.printCalendar(year, month);
		}
		System.out.println("Have a nice day");

		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
