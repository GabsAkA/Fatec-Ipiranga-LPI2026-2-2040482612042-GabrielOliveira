//Neste exercício optei por usar a estrutura do for pois
//o número de repetições é conhecido, afinal, é informado pelo usuário.

import java.util.Scanner;
public class Turma {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        double somaTotal = 0;
        double nota;
        double maiorNota = 0;
        System.out.print("Quantidade de alunos na turma: ");
        int quantidadeAlunos = sc.nextInt();
    
        for (int i = 0; i < quantidadeAlunos; i++) {
        System.out.print("Nota do aluno: ");
         nota = sc.nextDouble();
        if (nota > maiorNota) {
            maiorNota = nota;
        }
         somaTotal = somaTotal + nota;
    }
    double mediaTurma = (somaTotal / quantidadeAlunos);

    System.out.println("Soma total das notas: " + somaTotal);
    System.out.print("Média da turma: " + mediaTurma);
    System.out.print("Maior nota da turma: " + maiorNota);
    sc.close();
    }
}
