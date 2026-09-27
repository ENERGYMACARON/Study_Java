package kr.ac.yc;

import java.util.Scanner;

public class Loader {
	public static void main(String[] args) {
		System.out.println("계산기 Ver 0.1");
		
		/*
		 * System.in -> 운영체제가 제공하는 표준 입력 스트림 -> 키보드와 연결된 통로
		 * -> 윈시 바이트 스트림을 사용자가 다루기 쉽게 -> 문자열 형태로 읽어와야 하기 때문에 -> Scanner 객체로 감싸는 라인
		 */
		
		Scanner input = new Scanner(System.in);
		
		Calc calc = new Calc();
		
		while(true) {
			System.out.print("입력: ");
			String button = input.next();
			
			if ("exit".equals(button)) {
				break;
			}
			
			calc.click(button);
			
			System.out.println(calc.getDisplay());
		}
		
		input.close();
	}

}
