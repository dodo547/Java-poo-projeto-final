package contas;


//Classe ContaCorrente
public class ContaCorrente extends Conta {
 private String tipo;

 public ContaCorrente(String cpfTitular, double saldo, int agencia, String tipo) {
     super(cpfTitular, saldo, agencia);
     this.tipo = tipo;
 }

 @Override
 public void sacar(double valor) {
     if (getSaldo() >= valor) {
         super.depositar(-valor);
     } else {
         System.out.println("Saldo insuficiente");
     }
 }
}