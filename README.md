/*1- Faça um algoritmo que leia a idade de uma pessoa expressa em anos, meses e dias e escreva a idade dessa pessoa expressa apenas em dias. Considerar ano com 365 dias e mês com 30 dias. */

/*import java.util.Scanner; public class idade {

 public static void main(String []args){
     //declaração de variável
     int anos,meses,dias; 
     float resultado;
     //atribuição de valor à variavel
     Scanner sc = new Scanner(System.in);
     
     System.out.print("Digite sua idade: ");
     anos= sc.nextInt();
     // calculos necessários
     meses= anos*12;
     dias= meses*30;
     
     // impressão de resultados
    System.out.println("Idade em anos: " + anos);
    
    System.out.println("Idade em meses: " + meses);
     
      System.out.println("Idade em dias: " + dias);
     
   
   
   
 }*/
 
 
 
 
 /* 2-
 Escreva um algoritmo para ler o número total de eleitores de um município, o número de votos brancos, nulos e válidos. Calcular e escrever o percentual que cada um representa em relação ao total de eleitores.   */
/*import java.util.Scanner;

public class idade {

public static void main(String[] args) {
    // Declaração de variáveis
    int eleitores, nulos, brancos, validos;
    double porcentagemNulos;
    double porcentagembrancos;
    double porcentagemvalidos;// Usando double para porcentagem

    // Atribuição de valor à variável
    Scanner sc = new Scanner(System.in);

    // Solicitar o número de eleitores
    System.out.print("Quantos eleitores tem na sua cidade? ");
    eleitores = sc.nextInt();

    // Solicitar o número de votos nulos
    System.out.print("Quantos votos foram nulos? ");
    nulos = sc.nextInt();

    // Solicitar o número de votos brancos
    System.out.print("Quantos votos foram brancos? ");
    brancos = sc.nextInt();

    // Calcular o número de votos válidos
    validos = eleitores - nulos - brancos;

    // Exibir o número de votos válidos
    System.out.println("Restam " + validos + " votos válidos.");

   
    // Calcular e exibir a porcentagem de votos nulos
    porcentagemNulos = ((double) nulos / eleitores) * 100;  
    
    System.out.println("A porcentagem de votos nulos é: " + porcentagemNulos + "%");
    
    porcentagembrancos = ((double) brancos / eleitores) * 100; 
    
    System.out.println("A porcentagem de votos brancos é: " + porcentagembrancos  + "%");
porcentagemvalidos= ((double) validos / eleitores) * 100;

System.out.println("A porcentagem de votos nulos é: " + porcentagemvalidos + "%"); // Fechar o scanner sc.close(); } }*/

/*3- Escreva um algoritmo para ler o salário mensal atual de um funcionário e o percentual de reajuste. Calcular e escrever o valor do novo salário. 8?*/

/*import java.util.Scanner;

public class idade{
    
    public static void main(String[] args){
        //declaração de variavel
        float diferenca,salario,reajuste,novosal;
        Scanner sc = new Scanner(System.in);
      System.out.print("Qual o seu salario? ");
     salario = sc.nextInt();
     
      System.out.print("Qual o seu novo reajuste em % ? ");
     reajuste = sc.nextInt();
     novosal= (reajuste/100)*salario;
     
      System.out.print("Você teve um aumento salarial de  "+ novosal+ " reais");
    
     
    }
} */




/*4- O custo de um carro novo ao consumidor é a soma do custo de fábrica com a porcentagem do distribuidor e dos impostos (aplicados ao custo de fábrica). Supondo que o percentual do distribuidor seja de 28% e os impostos de 45%, escrever um algoritmo para ler o custo de fábrica de um carro, calcular e escrever o custo final ao consumidor.*/



import java.ultil.Scanner;
    public class idade{
        public static void main (String[] args){
            
        }
    }
