/**
* Este programa simula um combate entre dois campeoes.
* cada campeao tem, para alem do nome, caracteristicas proprias de ataque e defesa.
* 
* A cada turno o campeao B inflige danos ao campeao B e viceversa
* 
* O combate termina quando um dos campeoes morrer
* 
* @author  Arnaldo Canelas
* @version 1.0
* @since   2023-12-04 
*/

package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Champion;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		//Objeto Scanner para entrada de dados, a partir de System.in 
		Scanner sc = new Scanner(System.in);
		
		// variaveis
		int nTurnos = 0;
		int turno = 0;
		String name = "";
		int vidaInicial = 0;
		int ataque = 0;
		int armadura = 0;
		
		int n = 0;
		String posicaoCampeao = "primeiro";
		
		Champion championA = null, championB = null;
		
		//pedir dados dos Champions
		
		do {
			System.out.println("Digite os dados do " + posicaoCampeao + " campeão: ");
			System.out.print("Nome: ");
			name = sc.nextLine();
			
			vidaInicial = askAndValidateIntInput("Vida inicial: ", sc);
			ataque = askAndValidateIntInput("Ataque: ", sc);
			armadura = askAndValidateIntInput("Armadura: ", sc);
			
			//Instanciacao dos Champions
			if(n<1) {
				championA = new Champion(name, vidaInicial, ataque, armadura);
				posicaoCampeao = "segundo";			
				System.out.println();
			}else {
				championB = new Champion(name, vidaInicial, ataque, armadura);
			}
			
			n++;
			
			//consumir quebra de linha
			sc.nextLine();
			
		}while(n<2);
		
		nTurnos = askAndValidateIntInput("\nQuantos turnos você deseja executar? ", sc);
		
		//torneio
		do {
			championA.takeDamage(championB);
			championB.takeDamage(championA);
			
			System.out.println("\nResultado do turno " + (turno + 1) + ":");
			System.out.println(championA.status());
			System.out.println(championB.status());
			
			turno ++;
			
			if(championA.getLife() == 0 || championB.getLife() == 0 ) 
			{
				break;
			}
			
		} while(turno < nTurnos); 

		System.out.println("\nFIM DO COMBATE");
		
		sc.close();
	}
		
		
	/**
	 * pede ao utilizador um número, valida-o e retorna-o
	 * 
	 * @param askMessage - String com o texto a apresentar ao utilizador
	 * @param scanner - objeto Scanner para entrada de dados, a partir de System.in 
	 * @return número inteiro
	 */
	public static int askAndValidateIntInput(String askMessage, Scanner scanner) {
		int value = 0;
		boolean askAgain = true;
		
		System.out.print(askMessage);
		while(askAgain) 
		{
			if (scanner.hasNextInt()) 
			{
				value = scanner.nextInt();
				if(value < 1) {
					System.out.println("Introduza um número >= 1.");
					askAgain = true;
				}
				else {
					askAgain = false;
					break;
				}
			} 
			else {
				System.out.println("Número inválido! Introduza novamente.");
				scanner.next();
				askAgain = true;
			}
		}
		
		return value;
	}
}
