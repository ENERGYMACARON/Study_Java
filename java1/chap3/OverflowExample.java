package chap3;

public class OverflowExample {

	public static void main(String[] args) {
		
		int x = 1000000;
		int y = 1000000;
		int z = x * y;
		System.out.println(z);
		
		long xL = 1000000;
		long yL = 1000000;
		long zL = xL * yL;
		System.out.println(zL);

	}

}
