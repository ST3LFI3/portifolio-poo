/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.gerenciabanco;

import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class GerenciaBanco {

    public static void main(String[] args) {
        
        int escolha;
        
        Scanner scanner = new Scanner(System.in);
        
        ContaBanco contaBanco = new ContaBanco();
        
        contaBanco.pegaInformacoes();
        
        do{
            mostraMenu();
            
            escolha = scanner.nextInt();
            
            switch (escolha) {
                case 1: 
                    contaBanco.mostraSaldo();
                    break;                
                case 2: 
                    contaBanco.deposito();
                    break;                
                case 3: 
                    contaBanco.saque();
                    break;                
                case 4: 
                    contaBanco.dadosConta();
                    break;                
                default:
                    System.out.print("Escolha inválida. Tente novamente!"); 
                    
            }
        } while(escolha != 0);
        
        System.out.println("Nosso sistema bancário agradece!");
    }
    
    private static void mostraMenu(){
        System.out.println("\n+==========MENU==========+");
        System.out.println("| 1 - Consultar Saldo      |");
        System.out.println("| 2 - Realizar depósito    |");
        System.out.println("| 3 - Realizar saque       |");
        System.out.println("| 4 - Informações da conta |");
        System.out.println("| 0 - Encerrar             |");
        System.out.println("+==========================+");
        
    }
        
}

class ContaBanco {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo = 0.00;   
        
    public void pegaInformacoes(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite seu nome:");
        nome =  scanner.nextLine();
        
        System.out.println("Digite seu sobrenome:");
        sobrenome =  scanner.nextLine();
        
        System.out.println("Digite seu CPF:");
        cpf =  scanner.nextLine();
    }
    
    public void deposito(){
        double valorDeposito;
        
        Scanner scanner = new Scanner(System.in);  
        
        System.out.println("Digite o valor a depositar: ");
        
        valorDeposito = scanner.nextDouble();
        
        if(valorDeposito <= 0.00){
            System.out.println("O valor não pode ser negativo ou zero.");            
        }else{
            saldo += valorDeposito;
        }        
    }
    
    public void saque(){
        double valorSaque;
        
        Scanner scanner = new Scanner(System.in);  
        
        System.out.println("Digite o valor a sacar: ");
        
        valorSaque = scanner.nextDouble();
        
        if(valorSaque <= 0.00){
            System.out.println("O valor não pode ser negativo ou zero.");
        }
        
        if(saldo - valorSaque < 0){            
            System.out.println("Valor de saque maior que saldo em conta.");   
        }else{
            saldo -= valorSaque;
        }        
        
    }
    
    public void mostraSaldo(){
        System.out.printf("Seu saldo atual é de: R$ %.2f \n",saldo);         
    }
    
    public void dadosConta(){
        System.out.println("Nome:"+nome);
        System.out.println("Sobrenome:"+sobrenome);
        System.out.println("CPF:"+cpf);
    }
}