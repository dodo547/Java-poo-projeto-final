package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import pessoas.Cliente;
import pessoas.Usuario;

public class InOutUtils {
	// caminho dos arquivos com leitores e escritores
	String path = "..//projetoFinalJava/src/Relatorios/ListaClientes";
	String pathRendimento = "..//projetoFinalJava/src/Relatorios/RendimentoPoupança";
	String pathTransferencia = "..//projetoFinalJava/src/Relatorios/RelatorioTransferência";
	private static List<Cliente> ListaClientes;

	// Método para ler clientes de um arquivo

	
	

	public static HashMap<String, Cliente> leitorCliente(String path) throws IOException {
		HashMap<String, Cliente> clientes = new HashMap<>();
		List<Cliente> ListaClientes = new ArrayList<>();

		// Usar o bloco try-with-resources para abrir o arquivo de forma segura
		try (BufferedReader buffRead = new BufferedReader(new FileReader(path))) {
			String linha;

			// Ler cada linha do arquivo
			while ((linha = buffRead.readLine()) != null) {
				// Cada linha representa um cliente no formato: cpf,senha,nome
				String[] dados = linha.split(",");
				if (dados.length == 3) {
					// Obter CPF, senha e nome dos dados
					String cpf = dados[0];
					String senha = dados[1];
					String nome = dados[2];

					// Criar um objeto Cliente com esses dados
					Cliente cliente = new Cliente(cpf, senha, nome);

					// Adicionar o cliente ao HashMap
					clientes.put(cpf, cliente);
					ListaClientes.add(cliente);
				}
			}
			buffRead.close();
		}
		return clientes;

	}

// Metodo para escrever o Usuario no HashMap
	public static void escritorUsuario(String path, HashMap<String, Usuario> usuarios) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Scanner in = new Scanner(System.in);
		for (Usuario usuario : usuarios.values()) {
			// Escrever cpf, senha e nome separados por vírgula
			buffWrite.append(usuario.getCpf() + "," + usuario.getSenha() + "," + usuario.getNome());
			buffWrite.newLine();

		}
		buffWrite.close();

	}
	// Metodo para escrever o Cliente no HashMap
	public static void escritorCliente(String path, HashMap<String, Cliente> clientes) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Scanner in = new Scanner(System.in);
		for (Cliente cliente : clientes.values()) {
			// Escrever cpf, senha e nome separados por vírgula
			buffWrite.append(cliente.getCpf() + "," + cliente.getSenha() + "," + cliente.getNome());
			buffWrite.newLine();

		}
		buffWrite.close();

	}
	public static List<Cliente> getListaClientes() {
		return ListaClientes;
}}
