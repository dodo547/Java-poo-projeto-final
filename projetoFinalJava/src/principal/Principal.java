package principal;

import menus.Menu;
import io.InOutUtils;
import pessoas.Cliente;

import java.io.IOException;
import java.util.HashMap;

public class Principal {
    public static void main(String[] args) {

        // Inicia o menu de login
        Menu.menuLogin(); 
        
        // Caminho para o arquivo de texto com os dados dos clientes
        String path = "/home/administrador/Documentos/Java-poo-projeto-final/projetoFinalJava/src/arquivo/arquivos.txt";
         
        try {
            // Carregar os clientes do arquivo de texto
            HashMap<String, Cliente> clientes = InOutUtils.leitor(path);
            System.out.println("Clientes foram lidos do arquivo com sucesso!");

            // Atualize a referência de clientes em Cliente para usar o HashMap carregado
            Cliente.setClientes(clientes);

            // Após executar o menu de login, salve os clientes de volta ao arquivo de texto
            InOutUtils.escritor(path, clientes);
            System.out.println("Clientes foram salvos no arquivo com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao ler ou salvar os clientes: " + e.getMessage());
        }
    }
}
