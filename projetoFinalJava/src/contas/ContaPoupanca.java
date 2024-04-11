package contas;


//Classe ContaPoupanca
public class ContaPoupanca extends Conta {
 private String tipo;

 public ContaPoupanca(String cpfTitular, double saldo, int agencia, String tipo) {
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