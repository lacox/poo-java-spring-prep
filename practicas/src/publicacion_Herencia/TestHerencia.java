package publicacion_Herencia;

import java.util.Scanner;

/**
 * @author lacox(Angel David Salas M)
 */
public class TestHerencia {
	public static void main(String[] args) {
		int opcion, opcion2, n, contLibro = 0, contCD = 0;
		String t;
		double p;

		try (Scanner s = new Scanner(System.in)) {
			// Publicacion p1;
			System.out.println("Ingrese el tamaño de su almacen de libros: ");
			int AlmacenL = s.nextInt();
			System.out.println("Ingrese el tamaño de su almacen de CDs: ");
			int AlmacenC = s.nextInt();

			Libro registro[] = new Libro[AlmacenL];
			CD registroC[] = new CD[AlmacenC];
			do {
				System.out.println("\n---Practica IV---\n");
				System.out.println("1.Alta de Publicacion\n2.Visualizar almacen\n3.Buscar\n4.Salir");
				opcion = s.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("\n---ALTA DE PUBLICACIONES---\n");
					do {
						System.out.println("1.Alta de libro\n2.Alta de CD\n3.Volver");
						opcion = s.nextInt();
						switch (opcion) {
						case 1:
							System.out.println("¿Cuantos libros va a ingresar?");
							int numL = s.nextInt();
							if (numL <= 0) {
								System.out.println("No pueden ingresarse valores negativos");
								break;
							}
							if (numL + contLibro <= AlmacenL) {
								System.out.println("Ingrese los datos del libro");

								for (int i = 0; i < numL; i++) {
									System.out.println("Titulo: ");
									t = s.next();
									System.out.println("Precio: ");
									p = s.nextDouble();
									System.out.println("Numero de Paginas: ");
									n = s.nextInt();
									registro[i] = new Libro(n, t, p);
									System.out.println("\nRegistro Exitoso\n");
									contLibro++;
								}
							} else {
								System.out.println("No hay suficiente espacio en el almacen");
								int Sobra = AlmacenL - contLibro;
								System.out.println("Sobran: " + Sobra + " espacios");
							}
							break;
						case 2:
							System.out.println("¿Cuantos CDs va a ingresar?");
							int numC = s.nextInt();
							if (numC <= 0) {
								System.out.println("No pueden ingresarse valores negativos");
								break;
							}

							if (numC + contCD <= AlmacenC) {
								System.out.println("Ingrese los datos del CD");
								for (int i = 0; i < numC; i++) {
									System.out.println("Titulo: ");
									t = s.next();
									System.out.println("Precio: ");
									p = s.nextDouble();
									System.out.println("Tiempo de reproduccion: ");
									n = s.nextInt();

									registroC[i] = new CD(n, t, p);
									System.out.println("\nRegistro Exitoso\n");
									contCD++;
								}
							} else {
								System.out.println("No hay suficiente espacio en el almacen");
								int Sobra = AlmacenC - contCD;
								System.out.println("Sobran: " + Sobra + " espacios");
							}
							break;
						case 3:
							System.out.println("Regresando...");
							break;
						default:
							System.out.println("Opcion Incorrecta");
							break;
						}
					} while (opcion != 3);
					break;
				case 2:
					System.out.println("\n---Visualizar Almacenes---\n");
					do {
						System.out.println("1. Visualizar libros\n2. Visualizar CD’s\n3. Visualizar todo\n4.Volver");
						opcion2 = s.nextInt();
						switch (opcion2) {
						case 1:
							if (contLibro != 0) {
								for (int i = 0; i < contLibro; i++) {
									System.out.println(registro[i].toString());
								}
							} else {
								System.out.println("\nNo hay libros registrados");
							}
							break;
						case 2:
							if (contCD != 0) {
								for (int i = 0; i < contCD; i++) {
									System.out.println(registroC[i].toString());
								}
							} else {
								System.out.println("\nNo hay CDs registrados");
							}
							break;
						case 3:
							if (contLibro != 0 || contCD != 0) {
								System.out.println("\nEstos son sus libros: \n");
								for (int i = 0; i < contLibro; i++) {
									System.out.println(registro[i].toString());
								}
								System.out.println("\nEstos son sus CDs: \n");
								for (int i = 0; i < contCD; i++) {
									System.out.println(registroC[i].toString());
								}
							} else {
								System.out.println("\nNo hay libros o CDs registrados");
							}
							break;
						case 4:
							System.out.println("Regresando...");
							break;
						default:
							System.out.println("Opcion Incorrecta");
							break;
						}
					} while (opcion2 != 4);
					break;
				case 3:
					int ContC = 0;
					if (contLibro != 0 || contCD != 0) {
						System.out.println("Ingrese el nombre de: ");
						String nom = s.next();
						for (int i = 0; i < contLibro; i++) {
							if (registro[i].titulo.equals(nom)) {
								System.out.println(registro[i].toString());
								ContC++;
							}
						}
						for (int i = 0; i < contCD; i++) {
							if (registroC[i].titulo.equals(nom)) {
								System.out.println(registroC[i].toString());
								ContC++;
							}
						}
						System.out.println("Se encontraron " + ContC + " concidencias.");
					} else {
						System.out.println("\nNo hay libros o CDs registrados");
					}
					break;
				case 4:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opcion Incorrecta");
					break;
				}
			} while (opcion != 4);
		}
	}
}