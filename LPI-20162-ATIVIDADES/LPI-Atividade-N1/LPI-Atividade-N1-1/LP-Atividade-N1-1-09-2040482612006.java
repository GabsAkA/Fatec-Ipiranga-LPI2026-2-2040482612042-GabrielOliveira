import java.util.Scanner;
public class Nota { 
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe a nota final do aluno: ");
        double notaFinal = sc.nextDouble();

        System.out.println("--- Abordagem 1: Estrutura Condicional Tradicional (if-else) ---");
        String situacaoIfElse;
        if (notaFinal >= 6) {
            situacaoIfElse = "Aprovado";
        } else {
            situacaoIfElse = "Reprovado";
        }
        System.out.println("Situação (if-else): " + situacaoIfElse);
        System.out.println();

        System.out.println("--- Abordagem 2: Operador Ternário Simples ---");
        String situacaoTernario = (notaFinal >= 6) ? "Aprovado" : "Reprovado";
        System.out.println("Situação (ternário): " + situacaoTernario);

        sc.close();

        //Exemplo de ternário ENCADEADO (nested ternary), caso houvesse um terceiro 
        //estado (ex.: Exame), variando de Reprovado (<4), Exame (4 a <6) e Aprovado (>=6):
        //String situacaoComExame = (notaFinal >= 6) ? "Aprovado" 
        //: (notaFinal >= 4) ? "Exame" 
        //: "Reprovado"; 
        
        //Essa forma DEVE SER EVITADA porque empilha várias condições em uma única 
        //expressão, tornando a leitura confusa (é preciso desmembrar cada ternário 
        //para entender a lógica), dificulta a depuração (não dá para colocar um 
        //breakpoint em um caso específico) e aumenta o risco de erro ao adicionar 
        //ou alterar condições. Um if/else if tradicional comunica a mesma lógica 
        //de forma muito mais clara quando há mais de dois desfechos possíveis.
    }
}