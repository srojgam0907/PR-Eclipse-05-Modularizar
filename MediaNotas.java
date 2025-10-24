package tema2_debug;
import java.util.Scanner;
//PROYECTO depuracionErrores

public class MediaNotas {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String mensaje= "Introduce el número de alumnos: ";
		String error= "Error: el numero de alumnos debe ser mayor a 0";
		
        int numAlumnos= pedirNumero(sc, mensaje , error);
        double media= calcularMedia(numAlumnos, sc);
        
        System.out.printf("La media del grupo es: %.2f", media); //Se imprime el valor recibido de calcularMedia()

        sc.close();

	}
	/*A la función pedirNumero se le pasan como parámetros el objeto scanner para crearlo solo 
	 *una vez en el main, las variables mensaje y error contienen un String para no tener que 
	 *escribirlo en el System.out.println. 
	 *
	 *QUE HACE: pide al usuario el numero de alumnos. Si el número es menor o igual a 0, lanza 
	 *un mensaje de error y vuelve a pedirselo hasta que introduzca un numero válido. Devuelve
	 *el numAlumnos a la variable en el main. 
	 * */
	private static int pedirNumero(Scanner sc, String mensaje, String error) {
		int numAlumnos; 
		
		do {
			System.out.println(mensaje);
			numAlumnos= sc.nextInt();
			
			if(numAlumnos <=0) {
				System.out.println(error);
			}
			
		}while(numAlumnos <= 0);
		
		return numAlumnos;
	}
	
	/*A la función pedirNotas se le pasan como parámetros el objeto scanner para crearlo solo 
	 *una vez en el main, y la variable numAlumnos ya pedida anteriormente para usarla en el While.
	 *
	 *QUE HACE: Compara contador con el numAlumnos y mientras contador sea menor o igual al 
	 *numAlumnos le pide al usuario introducir un nota, comprueba si la nota es válida 
	 *(mayor que 0 y menor que 10), si no es valida lanza un mensaje de error y vuelve a perdir 
	 *la nota, si la nota es válida suma la nota a lo que haya dentro de la variable suma e 
	 *incrementa el contador para que el bucle pueda acabar. Devuelve la variable suma a la función
	 *calcularMedia. 
	 **/
	private static double pedirNotas(int numAlumnos, Scanner sc) {
		int contador = 1;
        double suma = 0;
		
		while (contador <= numAlumnos) {
            System.out.printf("Introduce la nota del alumno %d: ", contador); 
            double nota = sc.nextDouble();

            if (nota < 0 || nota > 10) {
                System.out.println("Error: la nota debe estar entre 0 y 10");
            
            } else {
            	suma = suma + nota;
            	contador++;
            }
            
        }
		return suma; 
	}
	
	/*La función calcularMedia recibe el numero de alumnos y el objeto scanner.
	 * 
	 *QUE HACE: la variable suma llama a la función pedirNotas, esta le devuelve el total de las 
	 *notas sumadas entre sí. En la variable media se guarda la division de la suma de las notas entre 
	 *el número de alumnos y devuelve la media al main.
	 **/
	private static double calcularMedia(int numAlumnos, Scanner sc) {
		double media;
		double suma= pedirNotas(numAlumnos, sc);
		
		media = suma / numAlumnos;
         
		return media;

	}

}
