
public class Main {

	public static void main(String[] args) {
		Cliente ana = new Cliente();
		ana.setNome("Ana");
		
		Conta contaCorrente = new ContaCorrente(ana);
		Conta contaPoupanca = new ContaPoupanca(ana);
		
		contaPoupanca.depositar(100);
		contaCorrente.depositar(100);
		contaPoupanca.transferir(150, contaCorrente);
		
		contaCorrente.imprimirExtrato();
		contaPoupanca.imprimirExtrato();

	}

}
