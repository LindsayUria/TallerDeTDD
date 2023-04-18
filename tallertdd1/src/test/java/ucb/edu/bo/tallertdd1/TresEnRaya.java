package ucb.edu.bo.tallertdd1;

import java.util.IllegalFormatCodePointException;
//siguiente paso despues de que pase una prueba: refactorizar o hacer prueba q falle
// seleccionar codigo seccion y darle opcion a refactor/extraer metodo
//que es hard code
//instalar jenkins
public class TresEnRaya {
    private Character[] [] tablero = {{'0','0','0'},
                                        {'0','0','0'},
                                        {'0','0','0'}};
    private char ultimoJUgador = '+';
    private final int TAMANHO = 3;

    public String jugar (int x, int y) throws Exception{
        VerificarEje(x);
        VerificarEje(y);

        ultimoJUgador = siguienteTurno();
        AsignarPosicion(x, y);

        if (hayGanador()){
            return ultimoJUgador + " es el ganador";
        }

        return "No hay ganador aun";

    }

    private boolean hayGanador(){
        int total = ultimoJUgador * TAMANHO;
        for (int i=0; i<TAMANHO; i++){
            //Logica columnas
            if (tablero[0][i] + tablero[1][i] + tablero[2][i] == total) {
                return true;
            }
            //Logica filas
            if (tablero[i][0] + tablero[i][1] + tablero[i][2] == total) {
                return true;
            }
            //Logica diagonal
            if (tablero[i][i] + tablero[i][i] + tablero[i][i] == total) {
                return true;
            }
            //Logica diagonal invertida
            if (tablero[0][2] + tablero[i][i] + tablero[2][0] == total) {
                return true;
            }
        }
        return false;
    }

    private void AsignarPosicion(int x, int y) throws Exception {
        if (tablero[x -1][y -1] != '0'){
            throw new Exception("La casilla esta ocupada");
        }else{
            tablero[x -1][y -1] = ultimoJUgador;
            System.out.println("Aisgnando posicion:"+ x +","+ y);
        }
    }

    public void VerificarEje(int eje)throws Exception{
        if (eje<1 || eje>3){
            throw new Exception("La coordenada"+eje+"esta fuera del tablero");
        }
    }

    public char siguienteTurno(){
        if (ultimoJUgador == 'X'){
            return '+';
        }
        return 'X';
    }

}
