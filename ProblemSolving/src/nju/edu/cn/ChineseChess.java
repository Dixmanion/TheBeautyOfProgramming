package nju.edu.cn;

public class ChineseChess {

	/**
	 * 注释掉的是我的代码
	 * 二者坐标的设定也不太一样，我沿用了书上的坐标，导致需要额外的转化
	 * @param args
	 */
	public static void main(String[] args) {
		
//		for (int i = 1; i <= 9; i++) {
//			
//			if (i != 1 && i != 4 && i != 7) {
//				System.out.print("A: ");
//				System.out.print((char)('c'+i%3));
//				System.out.print(10-i/3);
//				System.out.print(";   B: ");
//				System.out.println("d1");
//				
//				System.out.print("A: ");
//				System.out.print((char)('c'+i%3));
//				System.out.print(10-i/3);
//				System.out.print(";   B: ");
//				System.out.println("d2");
//				
//				System.out.print("A: ");
//				System.out.print((char)('c'+i%3));
//				System.out.print(10-i/3);
//				System.out.print(";   B: ");
//				System.out.println("d3");
//			}
//			
//			if (i != 2 && i != 5 && i != 8) {
//				System.out.print("A: ");
//				System.out.print((char)('c'+i%3));
//				System.out.print(10-i/3);
//				System.out.print(";   B: ");
//				System.out.println("e1");
//				
//				System.out.print("A: ");
//				System.out.print((char)('c'+i%3));
//				System.out.print(10-i/3);
//				System.out.print(";   B: ");
//				System.out.println("e2");
//				
//				System.out.print("A: ");
//				System.out.print((char)('c'+i%3));
//				System.out.print(10-i/3);
//				System.out.print(";   B: ");
//				System.out.println("e3");
//			}
//			
//			if (i != 3 && i != 6 && i != 9) {
//				System.out.print("A: ");
//				System.out.print((char)('c'+i%3));
//				System.out.print(10-i/3);
//				System.out.print(";   B: ");
//				System.out.println("f1");
//				
//				System.out.print("A: ");
//				System.out.print((char)('c'+i%3));
//				System.out.print(10-i/3);
//				System.out.print(";   B: ");
//				System.out.println("f2");
//				
//				System.out.print("A: ");
//				System.out.print((char)('c'+i%3));
//				System.out.print(10-i/3);
//				System.out.print(";   B: ");
//				System.out.println("f3");
//			}
//		}
		
		int index = 81;
		while (--index != 0) {
			if (index/9%3 == index%9%3) {
				continue;
			}
			System.out.println("A = " + (int)(index/9+1) + ", B= " + (int)(index%9+1));
		}

	}

}
