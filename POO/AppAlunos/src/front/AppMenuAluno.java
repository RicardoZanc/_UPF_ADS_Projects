/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package front;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;

/**
 *
 * @author JaqsonUpf
 */
public class AppMenuAluno {

    // Atributo da "tela" que vai armazenar todos os alunos instanciados
    static List<Aluno> lista = new ArrayList<>();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        while (true) {            
            System.out.println("N=Novo L=Listar E=Excluir S=Sair");
            System.out.print("Sua Opção: ");
            String opcao = new Scanner(System.in).next();
            switch (opcao) {
                case "N":
                    criar();
                    break;
                case "L":
                    listar();
                    break;
                case "E":
                    excluir();
                    break;
                case "S":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        
    }

    private static void criar() {
       // 1 criar um scanner para ler do teclado 
       Scanner ler = new Scanner(System.in);
       // 2 instanciar o objeto
       
       // 3 ler os dados do objeto

       
        Aluno a = null;
        while (true) {            
            try {
                System.out.print("Matrícula: ");
                //a.matricula = ler.nextInt();
                a = new Aluno(new Scanner(System.in).nextInt()); // usando construtor para inicializar
                break;
            } catch (Exception e) {
                System.out.println("Matrícula inválida");
            }
        }
       
       System.out.print("Nome: ");
       a.setNome(new Scanner(System.in).nextLine());
       
       
        while (true) {            
            System.out.print("Nota 1: ");
            try {
                a.setNota1(ler.nextFloat());
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
       
        while (true) {            
            System.out.print("Nota 2: ");
            try {
                a.setNota2(ler.nextFloat());
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
       
       // 4 guardar o objeto na lista
       lista.add(a);
    }

    private static void listar() {
       // percorrer a lista
       for(Aluno a : lista){
          // pegar cada objeto e mostrar seus dados
           System.out.println(
              a.getMatricula() + " - " +
              a.getNome() + " - " +
              a.getNota1() + " - " +
              a.getNota2() + " - " +        
              a.calcularMedia()
           );
       }
    }

    private static void excluir() {
        
    }
    
}
