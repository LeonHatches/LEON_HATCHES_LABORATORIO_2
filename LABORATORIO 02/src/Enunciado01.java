	// Version del ahorcado entregado al 70%, ahora 100%

	import java.util.Scanner; 
	public class Enunciado01
	{ 
	    public static void main (String [] args)
	    {
	        String ahor1 = "  +---+  \n"+ 
	                       "  |   |  \n" + 
	                       "      |  \n" +  
	                       "      |  \n" + 
	                       "      |  \n" +  
	                       "      |  \n" + 
	                       "========= "; 
	
	        String ahor2 = "  +---+    \n"+ 
	                       "  |   |    \n"+ 
	                       "  O   |    \n"+ 
	                       "      |    \n"+ 
	                       "      |    \n"+ 
	                       "      |    \n"+ 
	                       "========="; 
	
	        String ahor3 = "  +---+    \n"+ 
	                       "  |   |    \n"+ 
	                       "  O   |    \n"+ 
	                       "  |   |    \n"+ 
	                       "      |    \n"+ 
	                       "      |    \n"+ 
	                       "========="; 
	
	        String ahor4 = "  +---+    \n"+ 
	                       "  |   |    \n"+ 
	                       "  O   |    \n"+ 
	                       " /|   |    \n"+ 
	                       "      |    \n"+ 
	                       "      |    \n"+ 
	                       "========="; 
	
	        String ahor5 = "  +---+    \n"+ 
	                       "  |   |    \n"+ 
	                       "  O   |    \n"+ 
	                       " /|\\  |    \n"+ 
	                       "      |    \n"+ 
	                       "      |    \n"+ 
	                     "========="; 
	
	        String ahor6 = "  +---+    \n"+ 
	                       "  |   |    \n"+ 
	                       "  O   |    \n"+ 
	                       " /|\\  |    \n"+ 
	                       " /    |    \n"+ 
	                       "      |    \n"+ 
	                       "========="; 
	
	        String ahor7 = "  +---+    \n"+ 
	                       "  |   |    \n"+ 
	                       "  O   |    \n"+ 
	                       " /|\\  |    \n"+ 
	                       " / \\  |    \n"+ 
	                       "      |    \n"+ 
	                       "=========";
	        
	        int contador = 0;
	        String letra, palSecreta;
	        String [] figuras  = {ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7}; 
	        String [] palabras = {"programacion", "java", "indentacion", "clases"  ,   
	                              "objetos"     , "desarrollador"      , "pruebas"};
	        
	        // Palabra secreta en mayusculas
	        palSecreta = getPalabraSecreta(palabras).toUpperCase();
	        
	        // Arreglo para espacios en blancos para actualizar
	        String [] blancos = new String [palSecreta.length()];
	        
	        // Figura inicial
	        System.out.println ( figuras[0] );
	        
	        // INICIALIZA Y MUESTRA LOS BLANCOS
	        inicializarBlancos (blancos);
	        mostrarBlancos     (blancos); 
	        System.out.println ("\n"); 
	        
	        
	        while ( contador < 6 && !verificadorEspacios(blancos) )
	        {
	        	// Entrada de letra
	            letra = ingreseLetra(); 
	            
	            // Verificador de letra en palabra
	            if ( letraEnPalabraSecreta  (letra, palSecreta) )
	           			blancosActualizados (letra, blancos, palSecreta);
	            else
	                contador++;
	            
	            // Muestra datos del juego
	            System.out.println (figuras[contador]); 
	            mostrarBlancos (blancos);
	        }
	        
	        // Verificador de victoria
	        if ( verificadorEspacios(blancos) )
	        	 System.out.println("¡Usted GANA el juego del ahorcado!");
	        else
	        	System.out.println("Usted PIERDE el juego del ahorcado."
	        					 + "\nLa palabra era: "+palSecreta);
	    } 
	    
	    public static String getPalabraSecreta (String [] lasPalabras)
	    {  
	        int ind, indiceMayor = lasPalabras.length;
	        
	        ind = (int) ( Math.random()*indiceMayor );
	
	        return lasPalabras[ind];   
	     }
	  
	    public static void inicializarBlancos (String [] blancos)
	    { 
	    	for (int i = 0 ; i < blancos.length ; i++)
	    		blancos [i] = "_";
	    } 
	    
	    public static void mostrarBlancos (String [] blancos)
	    {  
	    	for (String espacio : blancos)
	    		System.out.print (espacio+" ");
	    	
	    	System.out.println();
	    } 
	    
	    public static String ingreseLetra ()
	    { 
	        Scanner sc = new Scanner(System.in); 
	        char laLetra; 
	        
	        System.out.println ("Ingrese letra: "); 
	        laLetra = sc.next().toUpperCase().charAt(0); 
	        
	        while ( Character.isDigit (laLetra) )
	        { 
	        	System.out.println("| CARACTER INVALIDO |\n");  
	            System.out.println("Ingrese letra: ");  
	            laLetra = sc.next().toUpperCase().charAt(0); 
	        } 
	        return Character.toString(laLetra);
	    }
	    
	    public static boolean letraEnPalabraSecreta (String letra, String palSecreta)
	    { 
	        for (int i = 0 ; i < palSecreta.length() ; i++)
	        {
	            if ( letra.equals (palSecreta.substring(i, i+1)) )
	                return true;
	        }
	        return false; 
	     } 
	   
	    public static void blancosActualizados (String letra, String [] blancos, String palSecreta)
	    { 
	        System.out.println("\nPROCESANDO.....\n"); 
	        
	        for (int i = 0 ; i < palSecreta.length() ; i++)
	        {
	            if ( letra.equals ( palSecreta.substring (i, i+1) ) )
	                blancos[i] = letra;  
	        } 
	    }
	    
	    public static boolean verificadorEspacios (String [] blancos)
	    {
	    	for (String espacio : blancos)
	    		if (espacio == "_")
	    			return false;
	    	
	    	return true;
	    }  
	}
	
	