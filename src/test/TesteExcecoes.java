import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TesteExcecoes {
	private financiamento f;

    @Test(expected = PVNuloOuNegativoException.class)
    @Category(Excecao.class)
    public void testPVInvalido() {
		f = new financiamento(-100000, 0.02, 5);
		f.calculoParcela();
	}

	@Test(expected = PVNuloOuNegativoException.class)
	@Category(Excecao.class)
	public void testPVNulo() {
		f = new financiamento(0, 0.02, 5);
		f.calculoParcela();
	}

	@Test(expected = QtdePrestacoesInvalidaException.class)
	@Category(Excecao.class)
	public void testQtdePrestacoesInvalida() {
		f = new financiamento(100000, 0.02, 1);
		f.calculoParcela();
	}

	@Test(expected = TxJurosNulaException.class)
	@Category(Excecao.class)
	public void testTaxaJurosNula() {
		f = new financiamento(100000, 0, 10);
		f.calculoParcela();
	}
}
