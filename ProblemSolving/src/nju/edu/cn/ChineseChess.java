package nju.edu.cn;

public class ChineseChess {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 9; i++) {
			
			if (i != 1 && i != 4 && i != 7) {
				System.out.print("A: ");
				System.out.print((char)('c'+i%3));
				System.out.print(10-i/3);
				System.out.print(";   B: ");
				System.out.println("d1");
				
				System.out.print("A: ");
				System.out.print((char)('c'+i%3));
				System.out.print(10-i/3);
				System.out.print(";   B: ");
				System.out.println("d2");
				
				System.out.print("A: ");
				System.out.print((char)('c'+i%3));
				System.out.print(10-i/3);
				System.out.print(";   B: ");
				System.out.println("d3");
			}
			
			if (i != 2 && i != 5 && i != 8) {
				System.out.print("A: ");
				System.out.print((char)('c'+i%3));
				System.out.print(10-i/3);
				System.out.print(";   B: ");
				System.out.println("e1");
				
				System.out.print("A: ");
				System.out.print((char)('c'+i%3));
				System.out.print(10-i/3);
				System.out.print(";   B: ");
				System.out.println("e2");
				
				System.out.print("A: ");
				System.out.print((char)('c'+i%3));
				System.out.print(10-i/3);
				System.out.print(";   B: ");
				System.out.println("e3");
			}
			
			if (i != 3 && i != 6 && i != 9) {
				System.out.print("A: ");
				System.out.print((char)('c'+i%3));
				System.out.print(10-i/3);
				System.out.print(";   B: ");
				System.out.println("f1");
				
				System.out.print("A: ");
				System.out.print((char)('c'+i%3));
				System.out.print(10-i/3);
				System.out.print(";   B: ");
				System.out.println("f2");
				
				System.out.print("A: ");
				System.out.print((char)('c'+i%3));
				System.out.print(10-i/3);
				System.out.print(";   B: ");
				System.out.println("f3");
			}
		}

	}

}