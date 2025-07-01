# Financiamento

Este projeto, desenvolvido como **prova 01 da matéria de Técnicas de Programação em Plataformas Emergentes**, consiste em uma aplicação Java para o cálculo de parcelas de financiamento utilizando o **Sistema Price (Sistema de Amortização Francês)**, acompanhada de um conjunto de testes unitários com JUnit.

## 🚀 Funcionalidades

A classe principal `financiamento.java` implementa a lógica para simular um financiamento, oferecendo os seguintes cálculos:

  * **Cálculo da Parcela Fixa (`calculoParcela()`):** Determina o valor de cada parcela, considerando o Valor Presente (capital inicial), a taxa de juros e o número de prestações.
  * **Juros Esperado (`jurosEsperado(int mes)`):** Calcula o valor dos juros para um determinado mês na tabela de amortização.
  * **Amortização Esperada (`amortizacaoEsperada(int mes)`):** Calcula o valor da amortização (redução do saldo devedor) para um determinado mês.
  * **Saldo Devedor Esperado (`saldoDevedorEsperado(int mes)`):** Calcula o saldo devedor ao final de um determinado mês.

A aplicação inclui validações para evitar cálculos com dados inválidos, lançando exceções específicas.

## 📁 Estrutura do Projeto

A estrutura do projeto está organizada de forma clara e padronizada:

  * **`src/main/`**: Contém a lógica principal da aplicação.

      * `financiamento.java`: Implementa a classe principal com os métodos de cálculo de financiamento.

  * **`src/test/`**: Abriga todos os testes unitários do projeto, organizados com JUnit.

      * `allTestes.java`: Uma **suite de testes** (`@RunWith(Suite.class)`) que agrupa e executa todos os testes do projeto, incluindo os de funcionalidade e os de exceção através de categorias (`@IncludeCategory`).
      * `Funcional.java` (interface): Usada como uma **categoria JUnit** (`@Category`) para marcar e agrupar testes relacionados à funcionalidade principal (cálculos corretos).
      * `Excecao.java` (interface): Usada como uma **categoria JUnit** (`@Category`) para marcar e agrupar testes que verificam o lançamento correto das exceções.
      * `TesteCalculoParcelas.java`: Testes parametrizados (`@RunWith(Parameterized.class)`) para validar a exatidão dos cálculos de juros, amortização e saldo devedor ao longo do tempo.
      * `TesteCalculoValorParcela.java`: Testes parametrizados para verificar se o cálculo do valor da parcela fixa está correto para diferentes cenários de entrada.
      * `TesteExcecoes.java`: Contém testes que verificam se as exceções customizadas são lançadas corretamente sob condições inválidas (PV nulo/negativo, quantidade de prestações inválida, taxa de juros nula).

  * **`src/exceptions/`**: Define as exceções customizadas para um tratamento de erros mais semântico.

      * `PVNuloOuNegativoException.java`: Lançada quando o Valor Presente (PV) é zero ou negativo.
      * `QtdePrestacoesInvalidaException.java`: Lançada quando o número de prestações é menor ou igual a um.
      * `TxJurosNulaException.java`: Lançada quando a taxa de juros é zero.

## 🛠️ Tecnologias e Ferramentas

  * **Java Development Kit (JDK)**
  * **JUnit 4**: Framework para testes unitários.

---
Feito por [Kathlyn Lara Murussi](klmurussi)
<div align="center">
  <img src="https://forthebadge.com/images/badges/built-with-love.svg" alt="Built with love" />
  <img src="https://forthebadge.com/images/badges/powered-by-coffee.svg" alt="Powered by coffee" />
</div>