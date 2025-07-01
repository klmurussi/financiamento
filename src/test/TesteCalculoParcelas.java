import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TesteCalculoParcelas {
    private int mes;
    private double jurosEsperado;
    private double amortizacaoEsperada;
    private double saldoDevedorEsperado;
    private financiamento f;

    public TesteCalculoParcelas(int mes, double jurosEsperado, double amortizacaoEsperada, double saldoDevedorEsperado) {
        this.mes = mes;
        this.jurosEsperado = jurosEsperado;
        this.amortizacaoEsperada = amortizacaoEsperada;
        this.saldoDevedorEsperado = saldoDevedorEsperado;
    }

    @Before
    public void setUp() {
        double pv = 100000;
        double i = 0.015;
        int n = 5;
        f = new financiamento(pv, i, n);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> dados() {
        return Arrays.asList(new Object[][] {
            {1, 1500.00, 19408.93, 80591.07},
            {3, 913.37, 19995.56, 40895.44},
            {5, 309.00, 20599.93, 0.01}
        });
    }

    @Test
    @Category(Funcional.class)
    public void testeJurosEsperado() {
        double jurosCalculado = f.jurosEsperado(mes);
        assertEquals(jurosEsperado, jurosCalculado, 0.01);
    }

    @Test
    @Category(Funcional.class)
    public void testeAmortizacaoEsperada() {
        double amortizacaoCalculada = f.amortizacaoEsperada(mes);
        assertEquals(amortizacaoEsperada, amortizacaoCalculada, 0.01);
    }

    @Test
    @Category(Funcional.class)
    public void testeSaldoDevedorEsperado() {
        double saldoDevedorCalculado = f.saldoDevedorEsperado(mes);
        assertEquals(saldoDevedorEsperado, saldoDevedorCalculado, 0.01);
    }
    
}
