package strategy;

public class Teste {
	public static void main(String[] args) {

		Conta clienteCorrente = new Conta("Corrente", 5000, 500, 7000);
		System.out.println(clienteCorrente.calcularSaque());
		
		Conta clienteSalario = new Conta("Salario", 2200, 2200, 40000);
		System.out.println(clienteSalario.calcularSaque());

        Conta clientePoupanca = new Conta("Poupanca", 900, 4344, 23233);
		System.out.println(clientePoupanca.calcularSaque());
	}
}