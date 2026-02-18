package tren;

import java.util.Scanner;
/**
*@author lacox(Angel David SM)
*/
public class TestTren {
	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		System.out.println("Dele nombre a su tren: ");
		String name = z.nextLine();

		Tren t = new Tren(name);
		System.out.println(t.toString());
		z.close();
	}
}