package project.calender;

import java.util.Scanner;

public class Prompt {

	private static final String PROMPT = "cal>";

	public void runPrompt() {

		// 입력받은 월의 최대 일수 출력하기
		int month; // 달 입력
		Calendar cal = new Calendar();
		Scanner scanner = new Scanner(System.in);

		month = 1;

		while (true) {
			System.out.println("달을 입력하세요.(-1:종료)");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if (month == -1)
				break;

			if (month > 12 || month < 1) {
				System.out.println("달은 1월부터 12월까지 입력하실 수 있습니다.");
				continue;
			}

			cal.printCalendar(2018, month);
		}
		System.out.println("Have a nice day");

		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
