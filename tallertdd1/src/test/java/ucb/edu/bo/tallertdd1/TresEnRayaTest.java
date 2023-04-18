package ucb.edu.bo.tallertdd1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class TresEnRayaTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    //Parte 1
    @Test
    public void cuandoFueraDeXlanzarException() throws Exception{
        TresEnRaya tresEnRaya = new TresEnRaya();
        exception.expect(Exception.class);
        tresEnRaya.jugar(5,2);
    }
    @Test
    public void cuandoFueraDeYlanzarException() throws Exception{
        TresEnRaya tresEnRaya = new TresEnRaya();
        exception.expect(Exception.class);
        tresEnRaya.jugar(2,5);
    }
    @Test
    public void cuandoLugarOcupadoLanzarException() throws Exception{
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar(1,3);
        exception.expect(Exception.class);
        tresEnRaya.jugar(1,3);
    }
    @Test
    public void cuandoLugarDiferenteNoLanzarException() throws Exception{
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar(1,3);
        tresEnRaya.jugar(2,3);
    }
    //Parte 2
    @Test
    public void siPrimerTurnoEntoncesJuegaX() throws Exception{
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar(1,3);
        assertEquals('X',tresEnRaya.siguienteTurno());
    }
    @Test
    public void siPrimerTurnoXESiguienteCruz() throws Exception{
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar(1,3);
        assertEquals('+',tresEnRaya.siguienteTurno());
    }
    @Test
    public void siUltimoTurnoCruzSiguienteX() throws Exception{
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar(1,3);
        assertEquals('+',tresEnRaya.siguienteTurno());
        tresEnRaya.jugar(2,3);
        assertEquals('X',tresEnRaya.siguienteTurno());
    }
    //Parte 3
    @Test
    public void cuandoNoHayGanador() throws Exception{
        TresEnRaya tresEnRaya = new TresEnRaya();
        String resultado = tresEnRaya.jugar(2,1);
        assertEquals("No hay ganador aun",resultado);
    }
    //TAREA:Jugador gana cuando llena toda la linea diagonal

    @Test
    public void siLLenaColumnaEntoncesGana() throws Exception{
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar(1,1);//x
        tresEnRaya.jugar(1,2);//+
        tresEnRaya.jugar(2,1);//x
        tresEnRaya.jugar(2,2);//+

        String resultado = tresEnRaya.jugar(3,1);//x
        assertEquals("X es el ganador",resultado);
    }

    @Test
    public void siLLenaFIlaEntoncesGana() throws Exception{
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar(2,1);//x
        tresEnRaya.jugar(1,1);//+
        tresEnRaya.jugar(3,1);//x
        tresEnRaya.jugar(1,2);//+
        tresEnRaya.jugar(2,2);//x

        String resultado = tresEnRaya.jugar(1,3);//+
        assertEquals("+ es el ganador",resultado);
    }

    @Test
    public void siLLenaDiagonalEntoncesGana() throws Exception{
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar(1,1);//x
        tresEnRaya.jugar(1,2);//+
        tresEnRaya.jugar(2,2);//x
        tresEnRaya.jugar(1,3);//+

        String resultado =  tresEnRaya.jugar(3,3);//x
        assertEquals("X es el ganador",resultado);
    }

    @Test
    public void siLLenaDiagonal2EntoncesGana() throws Exception{
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar(1,3);//x
        tresEnRaya.jugar(1,2);//+
        tresEnRaya.jugar(2,2);//x
        tresEnRaya.jugar(1,1);//+

        String resultado =  tresEnRaya.jugar(3,1);//x
        assertEquals("X es el ganador",resultado);
    }

}
