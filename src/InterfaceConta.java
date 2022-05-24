
public interface InterfaceConta {
	
	boolean sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, Conta contaDestino);
	
	void doar (double valor, Conta contaInstituicao);
	
	void imprimirExtrato();

}
