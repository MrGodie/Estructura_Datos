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
    
    private static int asignarOperador(char operador) { 
        int valorOperador;
        switch (operador) {
            case '+':
            case '-':
                valorOperador = 1;
                break;
            case '*':
            case '/':
                valorOperador = 2;
                break;
            default:
                valorOperador = -1;
                break;
        }
        return valorOperador;
    }

    public static String convertirMetodoPolaca(String expresion) {
        String salida = "";
        ArrayStack pila = new ArrayStack(expresion.length());
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (Character.isDigit(c)) {
                salida+=c;
            }else if (c == '(') {
                pila.push(c);
            }else if (c == ')') {
                while (!pila.isEmpty() && (char)pila.peak() != '(') {
                    salida+=pila.pop();
                }
                pila.pop();
            }else {
                while (!pila.isEmpty() && asignarOperador(c) <= asignarOperador((char)pila.peak())) {
                	salida+=pila.pop();
                }
                pila.push(c);
            }
        }
        

        while (!pila.isEmpty()) {
        	salida+=pila.pop();
        }

        return salida;
    }


    public static int evaluarPolaca(String rpn) {
        ArrayStack pila = new ArrayStack(rpn.length());
        for (int i = 0; i < rpn.length(); i++) {
            char c = rpn.charAt(i);
            if (Character.isDigit(c)) {
                pila.push(c - '0');
            }else {
                int num2 = (int) pila.pop();
                int num1 = (int) pila.pop();
                int resultado = operacion(num1, num2, c);
                pila.push(resultado);
            }
        }

        return (int) pila.pop();
    }


    private static int operacion(int numero1, int numero2, char simbolo) {
        int resultado = 0;
        switch (simbolo) {
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                resultado = (numero2 != 0) ? numero1 / numero2 : 0; 
                break;
        }
        return resultado;
    }
}



