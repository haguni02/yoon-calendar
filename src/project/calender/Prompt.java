package project.calender;

import java.util.Scanner;

public class Prompt {

//	private static final String PROMPT = "cal>";

	public int parseWeekName(String week) {
		switch (week) {
		case "SU":
		case "su":
			return 0;
		case "MO":
		case "mo":
			return 1;
		case "TU":
		case "tu":
			return 2;
		case "WE":
		case "we":
			return 3;
		case "TH":
		case "th":
			return 4;
		case "FR":
		case "fr":
			return 5;
		case "SA":
		case "sa":
			return 6;
		default:
			return -1;
		}
	}

	public void runPrompt() {

		// 입력받은 월의 최대 일수 출력하기
		int month; // 달 입력
		int year; // 년도 입력
		int week; // 요일 입력
		Calendar cal = new Calendar();
		Scanner scanner = new Scanner(System.in);

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

			System.out.println("요일을 입력하세요.(SU, MO, TU, WE, TH, FR, SA)");
			System.out.print("WEEK>");
			String weekName = scanner.next();
			week = parseWeekName(weekName);
			
			if (week == -1) {
				System.out.println("요일을 잘 못 입력하셨습니다.");
				continue;
			}

			if (month > 12 || month < 1) {
				System.out.println("달은 1월부터 12월까지 입력하실 수 있습니다.");
				continue;
			}

			cal.printCalendar(year, month, week);
		}
		System.out.println("Have a nice day");

		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
