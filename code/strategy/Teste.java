package strategy;

public class Teste {
	public static void main(String[] args) {

		ContaStrategy clienteCorrente = new ContaStrategy("Corrente", 5000, 500, 7000);
		System.out.println(clienteCorrente.calcularSaque());
		
		ContaStrategy clienteSalario = new ContaStrategy("Salario", 2200, 2200, 40000);
		System.out.println(clienteSalario.calcularSaque());

        ContaStrategy clientePoupanca = new ContaStrategy("Poupanca", 900, 4344, 23233);
		System.out.println(clientePoupanca.calcularSaque());
	}
}