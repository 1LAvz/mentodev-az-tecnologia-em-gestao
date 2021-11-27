/* 
 * @author: Lucas Avanzi
 * JRE System Library used: JavaSE-1.8
 */
 
public class Questao1 {

	public static void main(String[] args) {
		for(int i = 1; i <= 100; i++) {    
            if(i % 3 == 0 && i % 5 == 0) {
                System.out.print("AZ ");
            } else if (i % 3 == 0) {
                System.out.print("A ");
            } else if (i % 5 == 0) {
                System.out.print("Z ");
            } else { 
                System.out.print(i + " ");
            }
        }
	}
}
