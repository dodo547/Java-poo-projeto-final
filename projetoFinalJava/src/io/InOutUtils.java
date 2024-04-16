package io;

	import java.io.*;
	import java.util.HashMap;
	import java.util.Scanner;

	import pessoas.Cliente;

	public class InOutUtils {

		String path = "C:\\Users\\patri\\OneDrive\\Área de Trabalho\\Projeto Final POO. ATUAL\\Java-poo-projeto-final\\projetoFinalJava\\src\\Relatorios\\ListaClientes";
		
	    // Método para ler clientes de um arquivo
		
		
	    public static  HashMap<String, Cliente> leitor(String path) throws IOException {
	        HashMap<String, Cliente> clientes = new HashMap<>();
	        
	        
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
	                }
	            }
	   buffRead.close();      }
	        return clientes;
	       
	    }

	    public static void escritor(String path, HashMap<String, Cliente> clientes) throws IOException {
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
	    
		
	} 
