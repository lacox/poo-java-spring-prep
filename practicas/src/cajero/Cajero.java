package cajero;

import java.util.Scanner;

/**
* @author lacox(Angel David SM)
*/
public class Cajero {
	private int nip;
	private double saldo;
	private String cliente;
	
	public Cajero(double saldo) {
		this.saldo = saldo;
	}
	
	public Cajero(int nip, String cliente, double saldo) {
		this.nip = nip;
		this.cliente = cliente;
		this.saldo = saldo;
	}
	
	//Getters y Setters
	public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
		this.nip = nip;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	//Metodos
	public String retirar() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("¿Desea retirar dinero de su cuenta?\n1. Si\n2. No");
		if (s.nextInt() == 1) {
			System.out.println("¿Cuanto dinero desea retirar? \nSalto actual: $"+ saldo);
			double retiro = s.nextDouble();
			if ((saldo - retiro) >= 0 && retiro <= 0) {
				saldo = saldo - retiro;
				return "Retiro Exitoso";
			} else { 
				return "Saldo insuficiente";
			}
		} else {
			return "Regresando al menu";
		}
	}
	public String retirar(double retiro) {
		if (retiro <= 0) {
			return "Cantidad inválida";
		}
		
		if (retiro <= saldo) {
			saldo -= retiro;
			return "Retiro Exitoso";
		} else {
			return "Saldo insuficiente";
		}
	}
	
	public void depositar(double d) {
		saldo = saldo+d;
		System.out.println("El dinero se deposito exitosamente");
	}
	
	public void imprimirTicket() {
		System.out.println("--------------Ticket------------------");
		System.out.println("*Estado de cuenta*");
		System.out.println("Nip: "+nip+" Nombre: "+cliente);
		System.out.println("Su saldo es: "+saldo);
		System.out.println("------Gracias por su preferencia------");
	}
}
