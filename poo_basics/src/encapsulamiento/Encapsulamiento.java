package encapsulamiento;

public class Encapsulamiento {
	public static void main(String[] args) {
		//Alumno alu = new Alumno();
		Alumno alu2 = new Alumno(17, "Angel", "Salas");
	
		System.out.println(alu2.returnInfo(alu2));
	}
}
