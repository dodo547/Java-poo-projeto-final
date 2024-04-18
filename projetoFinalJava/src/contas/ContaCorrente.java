package contas;

import enums.ContasEnum;

// Classe ContaCorrente
public class ContaCorrente extends Conta {
    private ContasEnum tipo;
    private double custoOperacoes; // Variável para rastrear o custo total das operações

    // Construtor
    public ContaCorrente(String cpfTitular, double saldo, int agencia, ContasEnum tipo, double saldoInicial) {
        super(cpfTitular, saldo, agencia);
        this.tipo = tipo;
        this.custoOperacoes = 0.0;
    }


    // Método para exibir o relatório de tributação
    public void relatorioTributacao() {
        System.out.println("Relatório de Tributação da Conta Corrente:");
        System.out.printf("Total gasto nas operações: R$%.2f%n", custoOperacoes);
        System.out.printf("Taxa por saque: R$%.2f%n", 0.10); // Taxa fixa por saque
        System.out.printf("Taxa por depósito: R$%.2f%n", 0.10); // Taxa fixa por depósito
        System.out.printf("Taxa por transferência: R$%.2f%n", 0.20); // Taxa fixa por transferência
    }
}