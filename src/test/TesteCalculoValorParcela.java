import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TesteCalculoValorParcela {
	private int n;
	private double i, P, PV;
	private financiamento f;
	
	@Before
	public void setup() {
		f = new financiamento(PV, i, n);
	}
	
	@Parameters
	public static Collection<Object[]> getParametros() {
        return Arrays.asList(new Object[][] {
            { 10000.0, 0.02, 5, 2121.58},
			{ 20000.0, 0.018, 10, 2203.30},
			{ 50000.0, 0.013, 24, 2438.61}
        });
	}
	
	public TesteCalculoValorParcela(double PV, double i, int n, double P) {
		this.PV = PV;
		this.i = i;
		this.n = n;
		this.P = P;
	}
	
	
	@Test
	@Category(Funcional.class)
	public void testCalculoParcela() throws PVNuloOuNegativoException, TxJurosNulaException, QtdePrestacoesInvalidaException {
		double valorParcela = f.calculoParcela();
		assertEquals(P, valorParcela, 0.01);
	}
	
}