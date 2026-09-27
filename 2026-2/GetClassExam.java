package kr.ac.yc;

public class GetClassExam {

	private static final int state_init = 0;
	private static final int state_left = 1;
	private static final int state_op = 2;
	private static final int state_right = 3;
	private static final int state_result = 4;
	
	private int state = state_init;
	private int display = 0;
	private String op;
	private int left;
	private int right;
	
	// (1) 화면 출력용
	public int getDisplay() {
		return display;
	}
	
	// (2) 입력 처리
	public void click(String button) {
		// (2-1) 초기화
		if ("C".equals(button)) {
			display = 0;
			state = state_init;
			return;
		}
		
		// (2-2) 숫자, 연산자
		try {
			int digit = Integer.parseInt(button);
			onDigit(digit);
		} catch (NumberFormatException e) {
			onFunc(button);
		}
	}

	// (3) 연산 판별
	public boolean isOperator(String button) {
		return "pls".equals(button) || "min".equals(button) ||
				"mul".equals(button) || "div".equals(button);
	}
	
	// (4) 기호 처리
	private void onFunc(String button) {
		// (4-1) 상태가 좌항 혹은 결과일 때 -> 연산 검증
		if ((state == state_left || state == state_result) && isOperator(button)) {
			state = state_op;
			op = button;
			left = display;
		}
		
		// (4-2) 상태가 우항일 때 -> calc(=) 입력
		else if (state == state_right && "calc".equals(button)) {
			state = state_result;
			right = display;
			calc();
		}
		
		// (4-3) 상태가 결과일 때 -> calc(=) 입력
		else if (state == state_result && "calc".equals(button)) {
			left = display;
			display = right;
			calc();
		}
	}

	// (5) 사칙연산 수행
	private void calc() {
		if("pls".equals(op)) {
			display = left + right;
		} else if ("min".equals(op)) {
			display = left - right;
		} else if ("mul".equals(op)) {
			display = left * right;
		} else if ("div".equals(op)) {
			if(display == 0) {
				display = 0;
			} else {
				display = left / right;
			}
		}
	}
	
	// (6) 숫자 처리
	private void onDigit(int digit) {
		// (6-1) 상태가 초기 혹은 결과일 때
		if (state == state_init || state == state_result) {
			state = state_left;
			display = digit;
		}
		
		// (6-2) 상태가 연산자일 때 
		else if (state == state_op) {
			state = state_right;
			display = digit;
		}
		
		// (6-3) 상태가 좌항 혹은 우항일 때
		else if (state == state_left || state == state_right) {
			display = (display * 10) + digit;
		}
	}
	
}
