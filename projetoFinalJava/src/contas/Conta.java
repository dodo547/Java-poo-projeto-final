package contas;

//Classe Conta (abstrata)

	public abstract class Conta {
	private String cpfTitular;
	private double saldo;
	private int agencia;

	public Conta(String cpfTitular, double saldo, int agencia) {
      this.cpfTitular = cpfTitular;
      this.saldo = saldo;
      this.agencia = agencia;
 }

     public String getCpfTitular() {
     return cpfTitular;
 }

     public double getSaldo() {
     return saldo;
 }

     public void depositar(double valor) {
     saldo += valor;
 }

      public abstract void sacar(double valor);
}

