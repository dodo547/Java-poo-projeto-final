package pessoas;

import java.util.ArrayList;


// Classe Cliente
    public class Cliente {
    private String cpf;
    private String senha;
    private String nome;

    public Cliente() {
		super();
	}

	public Cliente(String cpf, String senha, String nome) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome=nome;
    }

    public String getCpf() {
        return cpf;
    }
	public String getSenha() {
        return senha;
    }

    public String getNome() {
		return nome;
	}
    public static ArrayList<Cliente> listaClientes() {
    	
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    
    listaClientes.add (new Cliente("123456789-10", "12345678", "Felipe Amorim"));
    listaClientes.add (new Cliente("234567890-11", "23456789", "Douglas Tapajóz"));
    listaClientes.add (new Cliente("345678901-12", "34567890", "Patrick Lopes"));
    listaClientes.add (new Cliente("456789012-13", "45678901", "Jonas Bastos"));
    listaClientes.add (new Cliente("567890123-14", "56789012", "Bernardo Miloski"));
    listaClientes.add (new Cliente("678901234-15", "67890123", "Bruna Santos"));
    listaClientes.add (new Cliente("789012345-16", "78901234", "Gabriel Jesus"));
    listaClientes.add (new Cliente("890123456-17", "89012345", "Neymar Junior"));
    listaClientes.add (new Cliente("901234567-18", "90123456", "Jim Carrey"));
    listaClientes.add (new Cliente("012345678-19", "01234578", "Michael Jackson"));
    listaClientes.add (new Cliente("123456789-20", "87654321", "Arnold semtempo"));
return listaClientes;


}   
    
}
    