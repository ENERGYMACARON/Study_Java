package kr.ac.yc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
	
	public static void main(String[] args) {
		// (1) 클래스 객체 가져오기
		Calc calc = new Calc();
		Class<? extends Calc> clazz = calc.getClass();
		
		// (2) 필드 정보 확인
		System.out.println("필드 정보: ");
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field field : fields) {
			System.out.println("필드명 : " + field.getName() + ", 타입 : " + field.getType().getSimpleName());
		}
		
		System.out.println();
		
		// (3) 메소드 정보 확인
		System.out.println("메소드 정보 : ");
		Method[] methods = clazz.getDeclaredMethods();
		
		for (Method method : methods) {
			System.out.print("메소드명 : " + method.getName() + "(");
			
			Class<?>[] parameters = method.getParameterTypes();
			
			for (int i=0; i<parameters.length; i++) {
				System.out.print(parameters[i].getSimpleName());
				
				if(i<parameters.length-1) {
					System.out.print(", ");
				}
			}
			
			System.out.println(")");
			
		}
	}

}
