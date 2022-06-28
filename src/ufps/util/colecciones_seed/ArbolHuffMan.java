/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.util.colecciones_seed;

/**
 *
 * @author madarme
 */
public class ArbolHuffMan {
    
    private NodoHuffman raiz;
    private String cadena;
    
    public ArbolHuffMan() {
    }

    public ArbolHuffMan(String cadena) {
        this.cadena = cadena;
    }
    
    
    
    /**
     * Dada una cadena que se paso como atributo de la clase, 
     * se crea el árbol y retorna la secuencia de pasos.
     * Ejemplo:
     * cadena= SISTEMAS
     * Retornaría:
     * Paso Frecuencia:  (S,3)->(I,1)->(T,1)->(E,1)->(M,1)->(A,1)->null
        Ordenar Frecuencia:  (I,1)->(T,1)->(E,1)->(M,1)->(A,1)->(S,3)->null
        Paso 1:  (E,1)->(M,1)->(A,1)->((null,2),((I,1)->(T,1)))->(S,3)->null
        Paso 2:  (A,1)->(( null,2)->((I,1)->(T,1))->((2, null), (E,1)->(M,1))->(S,3)-> null
        Paso 3:  ((null, 2), (E,1)->(M,1))->(S,3)->((null,3),(A,1)->(( null,2)->((I,1)->(T,1))-> null
        Paso 4:  ((null,3),(A,1)->(( null,2)->((I,1)->(T,1))-> ((null,5),((null, 2), ((E,1)->(M,1))->(S,3))-->null
        Paso 5:  (null, 8),((null,3),(A,1)->(( null,2)->((I,1)->(T,1))-> ((null,5),((null, 2), ((E,1)->(M,1))->(S,3))-->null
     * 
     * @return un String con la secuencia de pasos.
     */
    public String crear(NodoHuffman Nodo)
    {
    
    	if (cadena != null) {
    		
    		return "0";
    	}
    	
    	else
    		
    		return 1 + crear(Nodo.izquierdo)+ crear(Nodo.derecho);
    		
      
    
        
    }
    
    public boolean esVacio() {
    	return (raiz==null);
    }
    
    public String VerificarHijos(String s, String print) {
    	
    	if (raiz.izquierdo==null && raiz.derecho == null && Character.isLetter(raiz.getLetra())) {
        	
        	print += raiz.getLetra()+ ":" + s + "\n";
        }
    	
    	return print;
    }
    
    /**
     * Obtiene en una cadena todas las ramas del árbol.
     * Ejemplo: 
     * Si cadena= "SISTEMAS".
     * El String generado sería:
     *  Rama 1: (null, 8)- (null,3) -(A,1)
        Rama 2: (null, 8)-(null,3)-(null,2)-(I,1)
        Rama 3: (null, 8)-(null,3)-(null,2)-(T,1)
        Rama 4: (null, 8)-(null,5)-(null,2)-(E,1)
        Rama 5: (null, 8)-(null,5)-(null,2)-(M,1)
        Rama 6: (null, 8)-(null,5)-(S,3)

     * @return un String con las ramas del árbol generado
     */
    public String getRamas()
    {
        return ":)";
    }
    
    /**
     * Obtiene la codificaciòn representada en el árbol con la cadena que se pasa como argumento
     * Ejemplo: Si cadena="SISTEMAS"
     * El String generado sería:
     * S :  11
       I :  010
       T :  011
       E :  100
       M :  101
       A :  00
       SISTEMAS: 11010110111010011
     * @return un String con la codificación de la palabra
     */
    public String getCodificacion(String codigoHuffman)
    {
    	 String bites = "";
         String codigo = "";
         char c;
         int contador = 0;
         if (codigoHuffman.length() >= 8) {
             for (int i = 0; i < codigoHuffman.length(); i++) {
                 if (contador <= 8) {
                     bites = bites + codigoHuffman.charAt(i);
                     contador++;
                     if (contador == 8) {
                         c = toAscii(bites);
                         codigo = codigo + c;
                         contador = 0;
                         bites = "";
                     }
                 }
        return ":)";
    }
             
             public char toAscii(String s) {// obtiene un codigo de 8 o menor
                 String ascii = "";
                 int numero = 0;
                 int contador = 0;
                 for (int i = 0; i < s.length(); i++) {// binario es string
                     if (contador <= 8) {
                         ascii = ascii + s.charAt(i);
                         numero = Integer.parseInt(ascii, 2);
                         if (contador == 8) {
                             ascii = "";
                             contador = 0;
                         }
                     }
                 }
                 return (char) numero;
             }
    
    public ListaS juntarNodo(ListaS x) {
    	  Nodo<ArbolHuffMan> aux = x.getCabeza();
          
          Nodo<ArbolHuffMan> aux2 = null;
          while ((aux != null) && (aux.getSig() != null)) {
              x.setCabeza(aux.getSig());
              aux.setSig(null);
              aux2 = x.getCabeza();
              x.setCabeza(aux2.getSig());
              aux2.setSig(null);
              NodoHuffman nuevo = this.unirNodos(aux, aux2);
             
              x.insertarOrdenado(nuevo);
              aux = x.getCabeza();
        }
		
        return x;
    }
    
    public NodoHuffman unirNodos(Nodo<ArbolHuffMan> a, Nodo<ArbolHuffMan> b) {
        NodoHuffman c = new NodoHuffman('\u0000',((a.getInfo().getRaiz().getRepeticion()) + (b.getInfo().getRaiz().getRepeticion())));
        c.setIzquierdo(a.getInfo().getRaiz());
        c.setDerecho(b.getInfo().getRaiz());
        return c;
    }
    
     
    
}
