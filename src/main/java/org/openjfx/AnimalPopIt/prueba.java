package org.openjfx.AnimalPopIt;

import javafx.scene.text.Text;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


private char[] resultado;

public Text procesar(String texto){
    resultado = texto.toCharArray();
   Text salida= new Text("");
    String resultadoP = "";
    try{
        for(int i = 0; i < resultado.length; i++){
            if(esVocal(resultado[i])){
                resultadoP += resultado[i];
                if(esVocal(resultado[i+1])){
                    if(esDiptongo(resultado[i],resultado[i+1]) || esInseparable(resultado[i],resultado[i+1])){
                        resultadoP += resultado[i+1];
                        try{
                            if(esConsonante(resultado[i+2]) && !esInseparable(resultado[i+2],resultado[i+3])){
                                if(esVocal(resultado[i+3])){
                                    resultadoP += "-";
                                    resultadoP += resultado[i+2];
                                }else{
                                    resultadoP += resultado[i+2];
                                    resultadoP += "-";
                                }
                                i = i+1;
                            }
                        }catch(ArrayIndexOutOfBoundsException e){}
                        i = i+1;
                    }else{
                        resultadoP += "-";
                    }
                }else{
                    if(esConsonante(resultado[i+1])){
                        try{
                            if(esVocal(resultado[i+2])){
                                resultadoP += "-";
                            }else 
                                if(esConsonante(resultado[i+2])){
                                    if(esInseparable(resultado[i+1], resultado[i+2])){
                                        resultadoP += "-";
                                        resultadoP += resultado[i+1]+""+resultado[i+2];
                                        i = i+2;
                                    }else{
                                        resultadoP += resultado[i+1];
                                        if(esConsonante(resultado[i+3]) && !esInseparable(resultado[i+2],resultado[i+3])){
                                            resultadoP += resultado[i+2];
                                            i = i+1;
                                        }
                                        resultadoP += "-";
                                        i = i+1;
                                    }
                                }
                        }catch(ArrayIndexOutOfBoundsException e){}
                    }
                }
            }else{
                resultadoP += resultado[i];
                if(esConsonante(resultado[i])){
                    if(esConsonante(resultado[i+1])){
                        resultadoP += resultado[i+1];
                        i = i +1;
                    }
                }
            }
            
        }
        
    }catch(ArrayIndexOutOfBoundsException e){}
    return salida;
}

		public boolean esVocal(char caracter){
		    
		    return caracter == 'Á' || caracter == 'É' 
		            || caracter == 'Í' || caracter == 'Ó' || caracter == 'Ú'
		            || caracter == 'á' || caracter == 'é'
		            || caracter == 'í' || caracter == 'ó' || caracter == 'ú' || caracter == 'A' || caracter == 'E' 
		            || caracter == 'I' || caracter == 'O' || caracter == 'U'
		            || caracter == 'a' || caracter == 'e'
		            || caracter == 'i' || caracter == 'o' || caracter == 'u';
		}
		public boolean esConsonante(char caracter){
		    return caracter == 'B' || caracter == 'C' 
		            || caracter == 'D' || caracter == 'F' || caracter == 'G'
		            || caracter == 'H' || caracter == 'J' 
		            || caracter == 'K' || caracter == 'L' || caracter == 'M'
		            || caracter == 'N' || caracter == 'P' 
		            || caracter == 'Q' || caracter == 'R' || caracter == 'S'
		            || caracter == 'T' || caracter == 'V' 
		            || caracter == 'Ñ' || caracter == 'ñ' 
		            || caracter == 'W' || caracter == 'X' || caracter == 'Y'
		            || caracter == 'Z' || caracter == 'b' || caracter == 'c' 
		            || caracter == 'd' || caracter == 'f' || caracter == 'g'
		            || caracter == 'h' || caracter == 'j' 
		            || caracter == 'k' || caracter == 'l' || caracter == 'm'
		            || caracter == 'n' || caracter == 'p' 
		            || caracter == 'q' || caracter == 'r' || caracter == 's'
		            || caracter == 't' || caracter == 'v' 
		            || caracter == 'w' || caracter == 'x' || caracter == 'y'
		            || caracter == 'z';
		}
		public boolean esDiptongo(char caracter1, char caracter2){
		    return (((caracter1 == 'A' || caracter1 == 'E' 
		            || caracter1 == 'O') && (caracter2 == 'I' || caracter2 == 'U')
		            || (caracter1 == 'a' || caracter1 == 'e'
		            || caracter1 == 'o') && (caracter2 == 'i' || caracter2 == 'u')) ||
		            (caracter2 == 'A' || caracter2 == 'E'
		            || caracter2 == 'O') && (caracter1 == 'I' || caracter1 == 'U')
		            || (caracter2 == 'a' || caracter2 == 'e'
		            || caracter2 == 'o') && (caracter1 == 'i' || caracter1 == 'u'))
		            || (((caracter1 == 'Á' || caracter1 == 'É' 
		            || caracter1 == 'Ó') && (caracter2 == 'I' || caracter2 == 'U')
		            || (caracter1 == 'á' || caracter1 == 'é'
		            || caracter1 == 'ó') && (caracter2 == 'i' || caracter2 == 'u')) ||
		            (caracter2 == 'Á' || caracter2 == 'É'
		            || caracter2 == 'Ó') && (caracter1 == 'I' || caracter1 == 'U')
		            || (caracter2 == 'á' || caracter2 == 'é'
		            || caracter2 == 'ó') && (caracter1 == 'i' || caracter1 == 'u'))
		            ;
		}
		public boolean esInseparable(char caracter1, char caracter2){
		    return ((caracter2 == 'l' || caracter2 =='r') && (caracter1 == 'b' || caracter1 == 'c'
		            || caracter1 == 'd'|| caracter1 == 'f'|| caracter1 == 'g'|| caracter1 == 'p'
		            || caracter1 == 't' || caracter1 == 'l' 
		            )) || (caracter1 == 'c' && caracter2 =='h') || (caracter2 == 'l' && caracter1=='l' ) 
		            || (caracter2 == 'r' && caracter1=='r' ) || (caracter1 == 'u' && caracter2=='i' )
		            || ((caracter2 == 'L' || caracter2 =='R') && (caracter1 == 'B' || caracter1 == 'C'
		            || caracter1 == 'D'|| caracter1 == 'F'|| caracter1 == 'G'|| caracter1 == 'P'
		            || caracter1 == 'T' || caracter1 == 'L' 
		            )) || (caracter1 == 'C' && caracter2 =='H') || (caracter2 == 'L' && caracter1=='L' ) 
		            || (caracter2 == 'R' && caracter1=='R' ) || (caracter1 == 'U' && caracter2=='I' );
		}
}
