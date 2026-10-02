import java.util.Scanner;
public class Calculadora {
    public static void main(String[] args) { 
      Scanner sc = new Scanner(System.in);
      
      System.out.print("Informe o valor total da compra em reais: ");
      double valorTotalReais = Double.parseDouble(sc.nextLine());
      System.out.print("Informe o número de parcelas: ");
      int numeroParcelas = Integer.parseInt(sc.nextLine());

      System.out.println("--- Calculadora Financeira Escalar (Mapeamento em Centavos) ---");
      long totalCentavos = Math.round(valorTotalReais * 100);
      System.out.println("Valor total convertido: " + totalCentavos + " centavos.");

      long parcelaCentavos = totalCentavos / numeroParcelas;
      System.out.println("Divisão de R$" + valorTotalReais + " por " + numeroParcelas + " em centavos: " + parcelaCentavos + " centavos por parcela.");

      double parcelaReais = parcelaCentavos / 100.0;
      System.out.println("Valor convertido para exibição: R$" + parcelaReais);

      sc.close();
      
      //Comparação com o BigDecimal
      //Vantagens da abordagem escalar com inteiros (centavos):
      //1. Operações com long são mais simples e rápidas que BigDecimal, que precisa alocar
      //objetos imutáveis a cada operação. 
      //2. Não há risco de erro de arredondamento, pois inteiros representam valores exatos.

      //Desvantagens da abordagem escalar com inteiros:
      //1. Só funciona bem para uma escala fixa e conhecida. Se a escala mudar, é preciso reescrever
      //a lógica de conversão.
      //2. A divisão inteira trunca o resto, então centavos "perdidos" no arredondamento
      //precisam ser tratados manualmente se a soma das parcelas tiver que bater exatamente com o total.
      //3. BigDecimal oferece controle explícito de escala e modo de arredondamento (que é o RoundingMode),
      //além de ser mais legível e seguro para cálculos financeiros complexos.

    }

}