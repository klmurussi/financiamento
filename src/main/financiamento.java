public class financiamento {
    private int n;
    private double i, PV;

    public financiamento(double PV, double i, int n) {
        this.PV = PV;
        this.i = i;
        this.n = n;
    }

    public double calculoParcela ()  {
        if (PV <= 0) throw new PVNuloOuNegativoException();
        if (n <= 1) throw new QtdePrestacoesInvalidaException();
        if (i == 0) throw new TxJurosNulaException();
        
        double valorParcela = PV *((
            Math.pow((1+i), n) * i)/(Math.pow((1+i), n) - 1));
        return valorParcela;
    }

    public double jurosEsperado (int mes) {
        double saldoDevedor = PV;
        double juros = 0, amortizacao = 0;
        for (int i = 1; i <= mes; i++) {
            juros = saldoDevedor * this.i;
            amortizacao = calculoParcela() - juros;
            saldoDevedor -= amortizacao;
        }
        return juros;
    }

    public double amortizacaoEsperada (int mes) {
        double saldoDevedor = PV;
        double juros = 0, amortizacao = 0;
        for (int i = 1; i <= mes; i++) {
            juros = saldoDevedor * this.i;
            amortizacao = calculoParcela() - juros;
            saldoDevedor -= amortizacao;
        }
        return amortizacao;
    }

    public double saldoDevedorEsperado (int mes) {
        double saldoDevedor = PV;
        double juros = 0, amortizacao = 0;
        for (int i = 1; i <= mes; i++) {
            juros = saldoDevedor * this.i;
            amortizacao = calculoParcela() - juros;
            saldoDevedor -= amortizacao;
        }
        return saldoDevedor < 0.01 ? 0.0 : saldoDevedor;
    }
}
