package pessoas;

//Classe Gerente
public class Gerente extends Funcionario {
 private int agenciaResponsavel;

 public Gerente(String cpf, String senha, String cargo, int agenciaResponsavel) {
     super(cpf, senha, cargo);
     this.agenciaResponsavel = agenciaResponsavel;
 }

 public int getAgenciaResponsavel() {
     return agenciaResponsavel;
 }
}