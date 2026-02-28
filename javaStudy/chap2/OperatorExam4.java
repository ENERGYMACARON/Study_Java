package chap2;

public class OperatorExam4 {

	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		
		System.out.println(i == j);
		System.out.println(i != j);
		System.out.println(i < j);
		System.out.println(i <= j);
		System.out.println(i > j);
		System.out.println(i >= j);
		
		// 복합 대입 연산자
		i += 10; // i = i+10;
		System.out.println(i);
		
		System.out.println(i -=5);
		System.out.println(i);
		

	}

}
