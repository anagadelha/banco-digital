import java.util.Scanner;

public abstract class Conta implements InterfaceConta {
	
	private static int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia, numero, avaliacao;
	protected double saldo, taxa, rendimento;
	protected Cliente cliente;
	

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;	
		this.rendimento = 0.05;
		this.taxa = 10;
	}
	
	@Override
	public boolean sacar(double valor) {
		if (valor <= this.saldo) {
			saldo = saldo - valor - taxa;
			return true;
		} else {
			System.out.println("Saldo insuficiente!");
		}
		return false;
	}

	@Override
	public void depositar(double valor) {
		saldo = saldo + valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		boolean sacou = this.sacar(valor);
		if (sacou) {
			contaDestino.depositar(valor);
		}
	}
	
	@Override
	public void doar(double valor, Conta contaInstituicao) {
		
		if (valor <= this.saldo) {
		this.sacar(valor);
		contaInstituicao.depositar(valor);
		}
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	

	protected void imprimirInformacoesComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println("Avalie o atendimento de 1 a 10: ");
		Scanner in = new Scanner(System.in);
		avaliacao = in.nextInt();
		System.out.println("Sua nota para nosso atendimento foi " + avaliacao + ".");
		
		if (avaliacao > 0 && avaliacao < 11) { 
			System.out.println("Agradecemos a avaliação!");
		} else {
			System.out.println("Por favor, digite uma nota de 1 a 10.");
		}
		
	}
	


}
