import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteCalculoParcelas.class, TesteExcecoes.class, TesteCalculoValorParcela.class})
@IncludeCategory({Excecao.class, Funcional.class})
public class allTestes {

}
