package red_ferroviaria_PilasColasListas;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author lacox(Angel David SM)
 */
public class ViaMuerta {
	public static void main(String[] args) {
		String nombre;
		boolean sentido = false;
		int capacidad, numeroV, opcion, cap, cont = 0;

		Stack<Vagon> pila = new Stack<>();
		Stack<Vagon> copia = new Stack<>();

		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Capacidad de la via muerta: ");
			cap = s.nextInt();
			do {
				System.out.println("\n1.Apacar vagón");
				System.out.println("2.Sacar vagón");
				System.out.println("3.Imprimir");
				System.out.println("4.Salir");
				opcion = s.nextInt();
				switch (opcion) {
				case 1:
					if (cont < cap) {
						System.out.println("\nNombre del vagon: ");
						nombre = s.next();
						System.out.println("Capacidad: ");
						capacidad = s.nextInt();
						System.out.println("Numero de vagon: ");
						numeroV = s.nextInt();
						Vagon v = new Vagon(nombre, capacidad, numeroV);
						pila.push(v);
						if (sentido != false) {
							System.out.println("Cambiando sentido de las agujas...");
							sentido = false;
						}
						System.out.println("Insertando en la Via muerta...");
						cont++;
					} else {
						System.out.println("La via muerta esta llena...");
					}
					break;
				case 2:
					if (!pila.empty()) {
						if (sentido != true) {
							System.out.println("Cambiando sentido de las agujas...");
							sentido = true;
						}
						System.out.println("Saliendo: ");
						System.out.println(pila.pop());
						cont--;
					} else {
						System.out.println("La via muerta esta vacia.");
					}
					break;

				case 3:
					if (!pila.empty()) {
						System.out.println("Vagones estacionados: ");
						while (!pila.empty()) {
							System.out.println("\n" + copia.push(pila.pop()));
						}
						while (!copia.empty()) {
							pila.push(copia.pop());
						}
					} else {
						System.out.println("No hay vagones estacionados en la via muerta.");
					}
					break;
				case 4:
					System.out.println("Finalizando..");
					break;
				default:
					System.out.println("Opcion Incorrecta-");
					break;
				}
			} while (opcion != 4);
		}
	}
}