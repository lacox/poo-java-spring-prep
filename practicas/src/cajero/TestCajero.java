package cajero;

import java.util.Scanner;

public class TestCajero {
	public static void main(String[] args) {
		int usuario = 0;
		Cajero cliente0 = new Cajero(291, "Angel", 10000);
		
		try(Scanner a = new Scanner(System.in)) {	
			System.out.println("¿Es un cliente nuevo?\n1.Si\n2.No");
			Cajero c = new Cajero(0);
			if (a.nextInt() == 1) {
				usuario = 1;
				System.out.println("\nIngrese su nombre: ");
				c.setCliente(a.next());
				System.out.println("\nIntroduzca el nip que desee: ");
				c.setNip(a.nextInt());
			}
			int opcion;
			do {
				System.out.println("---Cajero---");
				System.out.println("\n1.Retirar dinero");
				System.out.println("\n2.Depositar dinero");
				System.out.println("\n3.Imprimir estado de cuenta");
				System.out.println("\n4.Salir");
				opcion = a.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("¿Desea retirar dinero de su cuenta?\n1. Si\n2. No");
					if (a.nextInt() == 1) {
						if (usuario == 1) {
							System.out.println("¿Cuanto dinero desea retirar? \nSalto actual: $"+ c.getSaldo());
							System.out.println(c.retirar(a.nextDouble()));
						} else {
							System.out.println("¿Cuanto dinero desea retirar? \nSalto actual: $"+ cliente0.getSaldo());
							double retiro = a.nextDouble();
							System.out.println(cliente0.retirar(retiro));
						}
					} else {
						System.out.println("Regresando al menu");
					}
					break;
				case 2:
					System.out.println("\nIngrese la cantidad de dinero a depositar: ");
					double deposito = a.nextDouble();
					if (usuario == 1) {
						c.depositar(deposito);
					} else {
						cliente0.depositar(deposito);
					}
					break;
				case 3:
					if (usuario == 1) {
						c.imprimirTicket();
					} else {
						cliente0.imprimirTicket();
					}
					break;
				case 4:
					System.out.println("Finalizando...");
					break;
				default:
					System.out.println("Opción incorrecta");
					break;
				}
			} while (opcion != 4);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}