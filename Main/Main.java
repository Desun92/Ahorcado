package Main;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String palabra="el verano del 73 fue increible, no me acuerdo de nada pero nunca lo olvidare";
		String copiaPalabra=palabra;
		String copia1;
		char[]palabraAdivinar=new char[palabra.length()];
		char[]ahorcado={'A','H','O','R','C','A','D','O'};
		char letraUsuario;
		int numPosicionLetra;
		int a�adirEspacios=0;
		int contador=0;
		boolean sonIguales=false;
		
		//Declaramos un array de chars y lo rellenamos con guiones. Si hay un espacio en la palabra,
		//en lugar de un gui�n lo rellenamos con un espacio en blanco para que el usuario vea que hay m�s de una palabra
		
		for(int i=0;i<palabraAdivinar.length;i++)
		{
			if(palabra.toCharArray()[i]==' ')
			{
				palabraAdivinar[i]=' ';
			}
			else if(palabra.toCharArray()[i]==',')
			{
				palabraAdivinar[i]=',';
			}
			else if(palabra.toCharArray()[i]=='?')
			{
				palabraAdivinar[i]='?';
			}
			else
			{
			palabraAdivinar[i]='-';
			}
		}
		
		//---------------------------------
		
		//El usuario introduce una letra y comprobamos si est� en la palabra original, de ser as�
		//sustituimos en nuestro array de caracteres rellenos por guiones, las posiciones de los guiones
		//que coincidan con las letras en la palabra a adivinar, por la letra del usuario. En caso contrario
		//incrementamos el contador de intentos.
		
		while(!sonIguales && contador!=8)
		{
			System.out.print("Introduce una letra ");
			letraUsuario=sc.next().charAt(0);
			
			System.out.println("");
			
			numPosicionLetra=palabra.indexOf(letraUsuario);
			
			if(numPosicionLetra!=-1)
			{
				a�adirEspacios=numPosicionLetra;
				
				while(numPosicionLetra!=-1)
				{
					palabraAdivinar[a�adirEspacios]=letraUsuario;
					copiaPalabra=copiaPalabra.substring(numPosicionLetra+1);
					numPosicionLetra=copiaPalabra.indexOf(letraUsuario);
					a�adirEspacios+=numPosicionLetra+1;
				}
				
				copiaPalabra=palabra;
			}
			else
			{
				contador++;
			}
		
			//---------------------------------
			
			//Mostramos al usuario si su letra est� o no en la palabra y la palabra ahorcado
			//en funci�n del n�mero de intentos que lleve el usuario. Adem�s comprobamos si ambas palabras
			//son iguales mediante la funcion equals. En caso de ser iguales, el booleano "sonIguales" valdr� verdadero
			//y saldr� del bucle While y terminar� la ejecuci�n del programa.
			
			copia1=String.copyValueOf(palabraAdivinar);
			sonIguales=palabra.equals(copia1);
			System.out.print(copia1+"    ");
			for(int i=0;i<contador;i++)
			{
				System.out.print(" "+ahorcado[i]);
			}
			System.out.println("");
			System.out.println("");
		}	
		
		if(sonIguales)
		{
			System.out.println("Enhorabuena, has acertado =D \nVuelve a jugar cuando te apetezca!!");
		}
		else
		{
			System.out.println("Vaya, no has tenido suerte =( \nint�ntalo de nuevo en otra ocasi�n");
		}

	}

}
