/**
* Programa...
* 
* @author  Arnaldo Canelas
* @version 1.0
* @since   2023-12-04 
*/

package application;

import java.util.Locale;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		//Objeto Scanner para entrada de dados, a partir de System.in 
		Scanner sc = new Scanner(System.in);
		
		// variaveis
		int nTurnos = 0;
		int nRepeticoes = 0;
		String name = "";
		int vidaInicial = 0;
		int ataque = 0;
		int armadura = 0;
		
		//pedir dados dos Champions
		
		System.out.println("Digite os dados do primeiro campeão: ");
		System.out.print("Nome: ");
		name = sc.nextLine();
		System.out.print("Vida inicial: ");
		vidaInicial = sc.nextInt();
		System.out.print("Ataque: ");
		ataque = sc.nextInt();
		System.out.print("Armadura: ");
		armadura = sc.nextInt();
		
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
				if(value < 0) {
					System.out.println("Introduza um número >= 0.");
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
