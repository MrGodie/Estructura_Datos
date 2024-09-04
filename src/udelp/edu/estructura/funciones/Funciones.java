package udelp.edu.estructura.funciones;
import udelp.edu.estructura.pilas.ArrayStack;

public class Funciones {
	
    public boolean validarParentesis (String cadena) {
        ArrayStack stack = new ArrayStack(cadena.length());
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (caracter == '(') {
                stack.push(caracter);
            }
            else if (caracter == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    public int revisarEcuacion (String cadena){
        ArrayStack pilaCadena = new ArrayStack(cadena.length());
        for(int i = 0; i < cadena.length(); i++){
            char caracter = cadena.charAt(i);
            
            if(caracter>='0' && caracter<='9'){
                
            	pilaCadena.push(caracter - '0');
            
            }else if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/') {
                
            	pilaCadena.push(caracter);
            
            }else if (caracter == ')'){
               
            	int numero2 = (int) pilaCadena.pop();
               
               char simbolo = (char) pilaCadena.pop();
               
               int numero1 = (int) pilaCadena.pop();
               
               int resultado = operacion(numero1,numero2,simbolo);
               
               pilaCadena.push(resultado);
            }
        }
        return (int) pilaCadena.pop();
    }
    
    private int operacion (int numero1, int numero2, char simbolo){
        int resultado = 0;
        
        if(simbolo == '+'){
            resultado = numero1 + numero2;
        } 
        if (simbolo == '-') {
            resultado = numero1 - numero2;
        }
        if (simbolo == '*') {
            resultado = numero1 * numero2;
        }
        if (simbolo == '/') {
            if (numero2 == 0) {
            	resultado = 0;
            }else
            	resultado = numero1/numero2;
        }
        return resultado;
    }
}



