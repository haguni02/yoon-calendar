package project.calender;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		String s1,s2;
		int num1, num2;
		// 입력: 두 수의 입력을 받는다.
		System.out.println("두 수를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		
		s1 = scanner.next();
		s2 = scanner.next();
		num1 = Integer.parseInt(s1);
		num2 = Integer.parseInt(s2);
		
		// 출력: 두 수의 합을 출력한다.
		System.out.printf("두 수의 합은 %d입니다.", num1 + num2);
		scanner.close();
	}

}
