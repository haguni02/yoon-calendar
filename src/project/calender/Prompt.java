package project.calender;

import java.util.Scanner;

public class Prompt {

//	private static final String PROMPT = "cal>";

	
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록    ");
		System.out.println("| 2. 일정 검색  ");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
		
	}

	public void runPrompt() {
		
		printMenu();
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		String command;
		
		while (true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.print("COMMAND>");
			command = scanner.next();
			
			switch(command) {
			case "1":
				registerScheduel(scanner, cal);
				break;
			case "2":
				searchScheduel(scanner, cal);
				break;
			case "3":
				showCalendar(scanner, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				scanner.close();
				return;
			}
		}
		// 입력받은 월의 최대 일수 출력하기

	}

	private void showCalendar(Scanner scanner, Calendar cal) {
		
		int month; // 달 입력
		int year; // 년도 입력
		

		month = 1;

		System.out.println("년도를 입력하세요.");
		System.out.print("YEAR>");
		year = scanner.nextInt();


		System.out.println("달을 입력하세요.");
		System.out.print("MONTH>");
		month = scanner.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("달은 1월부터 12월까지 입력하실 수 있습니다.");
			return;
		}

		cal.printCalendar(year, month);
		
	}

	public static void main(String[] args) {
		Prompt prompt = new Prompt();
		prompt.runPrompt();
		System.out.println("Have a nice day");
	}


	private void searchScheduel(Scanner scanner, Calendar cal) {
		System.out.println("[일정 검색] 날짜를 입력하세요.");
		String key = scanner.next();
		
		String plan = cal.searchPlan(key);
		
		System.out.println(plan);
	}

	private void registerScheduel(Scanner scanner, Calendar cal) {
		System.out.println("[일정 등록] 날짜를 입력하세요 (yyyy-MM-dd).");
		String key = scanner.next();
		System.out.println("일정을 입력하세요(입력이 완료되었을 경우 ;를 입력).");
		scanner.nextLine();
		String value = "";
		while(true) {
			String add = scanner.next();
			value += add;
			if(add.endsWith(";")) {
				break;
			}
		}
		
		cal.registerPlan(key, value);
	}

}
