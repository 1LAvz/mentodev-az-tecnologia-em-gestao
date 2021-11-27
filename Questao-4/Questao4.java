/* 
 * @author: Lucas Avanzi
 * JRE System Library used: JavaSE-1.8
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Questao4 {

	public static void main(String[] args) throws FileNotFoundException {
		
		try {
			File file = new File(args.length > 0 ? args[0] : "./Questao4.txt");
			Scanner scan = new Scanner(file);
			
			int n = Integer.parseInt(scan.nextLine().trim());
			
			while(n > 0) {
				String str = scan.nextLine();
				
				char letter = ' ';
				StringBuilder sb = new StringBuilder();

				//Separate '<>' from '.' so we can have a string like this '<<><>><'
				for(int i=0; i<str.length(); i++) {
					letter = str.charAt(i);
					if(letter == '<' || letter == '>') {
						sb.append(letter);
					}
				}
				
				Boolean subStr = true;
				int countDiamonds = 0;
				
				//As long as the sequence '<>' exits we delete and count the diamond
				while(subStr) {
					//If the sequence "<>" exists
					if(sb.indexOf("<>") >= 0){
						for(int i=0; i<sb.length(); i++) {
							if(sb.charAt(i) == '<') {
								if(sb.charAt(i+1) == '>') {
									sb.deleteCharAt(i);
									sb.deleteCharAt(i);
									countDiamonds++;
								}
							}
						}
					} else {
						subStr = false;
					}
				}
				System.out.println(countDiamonds);
				n--;
			}
		} catch (FileNotFoundException e) {
			System.out.println("O sistema nao pode encontrar o arquivo especificado.\nVerifique o diretorio informado.");
		}
	}

}
