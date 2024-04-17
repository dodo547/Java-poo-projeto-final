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

    // Método para depositar valor na conta
    public void depositar(double valor) {
        double custoDeposito = 0.10; // Custo de R$0,10 por depósito

        if (valor > 0) {
            // Deposite o valor na conta e desconte o custo do depósito
            saldo += (valor - custoDeposito);
            custoOperacoes += custoDeposito; // Atualiza o custo total das operações
        }
    }

    // Método para realizar um saque na conta
    public void sacar(double valor) {
        double custoSaque = 0.10; // Custo de R$0,10 por saque

        if (valor > 0 && saldo >= valor + custoSaque) {
            // Retira o valor da conta e desconta o custo do saque
            saldo -= (valor + custoSaque);
            custoOperacoes += custoSaque; // Atualiza o custo total das operações
        }else {
        	System.out.println("\nSaldo Insuficiente!!. \nOperaçao Cancelada");
        }

       }

    // Método para realizar uma transferência da conta
    public void transferir(double valor, ContaCorrente destino) {
        double custoTransferencia = 0.20; // Custo de R$0,20 por transferência

        if (valor <= 0) {
            System.out.println("Valor inválido para transferência.");
            return; // Sai do método sem realizar a transferência
        }

        if (saldo < valor + custoTransferencia) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return; // Sai do método sem realizar a transferência
        }
        if (destino.getCpfTitular().equals(this.getCpfTitular())) {
            System.out.println("Você não pode transferir dinheiro para a mesma conta.");
            return; // Sai do método sem realizar a transferência
        }

        // Retira o valor da conta e desconta o custo da transferência
        saldo -= (valor + custoTransferencia);
        custoOperacoes += custoTransferencia; // Atualiza o custo total das operações
        destino.depositar(valor); // Deposita o valor na conta de destino
        System.out.println("Transferência de " + valor + " realizada com sucesso!" );
    }

    // Método para exibir o saldo atual
    public void exibirSaldo() {
        System.out.printf("Saldo atual: R$%.2f%n", saldo);
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