package principal;

import java.util.Scanner;

import menus.Menu;

public class Principal {
   public static void main(String[] args) {
	  
       Scanner sc = new Scanner(System.in);
       while (true) {
       
	   System.out.println("\n*****************************");
	   System.out.println("Seja bem vindo ao Serra Bank.");
	   System.out.println("*****************************\n");
	   System.out.println("1- Para efetuar login.");
	   System.out.println("2- Para registrar-se.");
	   
	   int escolha = sc.nextInt();
	   
		   
	   switch (escolha) {
       case 1:
    	   Menu.menuLogin(); 
           
           break;
       case 2:
    	   Menu.registrarLogin();
    	 
    	   break;
           
	   }
   }
}
} 


		
	
	


	