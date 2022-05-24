
public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("Extrato da conta poupança:");
		super.imprimirInformacoesComuns();
		
	}
	
	
	@Override
	public void depositar(double valor) {
		super.depositar(valor);
		this.saldo = this.saldo + (this.saldo * this.rendimento);		
	}
}
