package ucb.edu.bo.tallertdd1;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CalculadoraTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void siCadenaVaciaRetornarCero() throws Exception{
        //PARTES DE UNA PRUEBA
        //1.preparacion de la prueba
        Calculadora c = new Calculadora();
        //2.logica de prueba
        String resultado= c.suma("");
        //3.verificacion o assert
        assertEquals("0",resultado);
    }

    @Test
    public void para2numerosRetornarSuma() throws Exception{
        //PARTES DE UNA PRUEBA
        //1.preparacion de la prueba
        Calculadora c = new Calculadora();
        //2.logica de prueba
       // String resultado= c.suma("2,3");
        //3.verificacion o assert
        //assertEquals("5",resultado);
        assertEquals("5",c.suma("2,3"));
        assertEquals("6",c.suma("3,3"));
        assertEquals("10",c.suma("7,3"));
    }

    @Test
    public void para3numerosRetornarSuma() throws Exception{
        //PARTES DE UNA PRUEBA
        //1.preparacion de la prueba
        Calculadora c = new Calculadora();
        //2.logica de prueba
        // String resultado= c.suma("2,3");
        //3.verificacion o assert
        //assertEquals("5",resultado);
        assertEquals("10",c.suma("2,3,5"));
        assertEquals("6",c.suma("3,3,0"));
    }

    @Test
    public void ignorarNumerosMayores1000() throws Exception{
        //PARTES DE UNA PRUEBA
        //1.preparacion de la prueba
        Calculadora c = new Calculadora();
        //2.logica de prueba
        // String resultado= c.suma("2,3");
        //3.verificacion o assert
        //assertEquals("5",resultado);
        assertEquals("7",c.suma("2,3000,5"));
        assertEquals("1099",c.suma("100,999"));
    }

    @Test
    public void paraNumeroNegativosLanzarExcepcion() throws Exception{
        //PARTES DE UNA PRUEBA
        //1.preparacion de la prueba
        Calculadora c = new Calculadora();
        //2.logica de prueba
        // String resultado= c.suma("2,3");
        //3.verificacion o assert
        //assertEquals("5",resultado);
        exception.expect(Exception.class);
        assertEquals("10",c.suma("1001,-10"));
    }

}
