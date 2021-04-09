package calculadora;

import static org.junit.Assert.*;

import org.junit.Test;

public class metodoTest {

	@Test
	public void testMultiplicar() {
		int resultado = metodo.multiplicar(5, 2);
        int esperado = 10;

        assertEquals(resultado, esperado);
        
		int resultado2 = metodo.multiplicar(13, 10);
        int esperado2 = 130;

        assertEquals(resultado2, esperado2);

	}

	@Test
	public void testRestar() {
		int resultado3 = metodo.restar(3, 2);
        int esperado3 = 1;

        assertEquals(resultado3, esperado3);
        
		int resultado4 = metodo.restar(24, 10);
        int esperado4 = 14;

        assertEquals(resultado4, esperado4);

	}

	@Test
	public void testDividir() {
		int resultado5 = metodo.dividir(9, 3);
        int esperado5 = 3;

        assertEquals(resultado5, esperado5);
        
		int resultado6 = metodo.dividir(1000, 100);
        int esperado6 = 10;

        assertEquals(resultado6, esperado6);
	}
	
	@Test
	public void testResto() {
		int resultado7 = metodo.resto(7, 2);
        int esperado7 = 1;

        assertEquals(resultado7, esperado7);
        
		int resultado8 = metodo.resto(15, 6);
        int esperado8 = 3;

        assertEquals(resultado8, esperado8);
        
        int resultado9 = metodo.resto(100, 10);
        int esperado9 = 0;

        assertEquals(resultado9, esperado9);
	}

}
