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

		System.out.println("teste");
		
		sc.close();
	}
}
