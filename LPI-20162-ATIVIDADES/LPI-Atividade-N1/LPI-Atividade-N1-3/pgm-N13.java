import java.util.Scanner;
public class pgmN13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantidade de leituras: ");
        int quantidadeLeituras = sc.nextInt();

        double[] temperaturas = new double[quantidadeLeituras];

        for(int i = 0; i < quantidadeLeituras; i++) {
            System.out.print("Temperatura (°C): ");
            temperaturas[i] = sc.nextDouble();
        }
        System.out.print("-- Leituras Registradas --");
        for(int i = 0; i < temperaturas.length; i++) {
            System.out.println("Leitura [" + i + "]: " + temperaturas[i] + "°C");
        
        }
        System.out.println("-- Acesso Direto --");
        System.out.println("Primeira leitura (índice 0): " + temperaturas[0] + "°C");
        System.out.println("Última leitura (índice "  + (temperaturas.length - 1) + "): " + temperaturas[temperaturas.length - 1] + "°C");

        double maior = temperaturas[0];
        int indiceMaior = 0;
        double menor = temperaturas[0];
        int indiceMenor = 0;

        for(int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > maior) {
                maior = temperaturas[i];
                indiceMaior = i;
            } else if (temperaturas[i] < menor) {
                menor = temperaturas[i];
                indiceMenor = i;
            }
        }

        System.out.println("-- Busca Linear: Extremos -- ");
        System.out.println("Maior temperatura: " + maior + "°C (índice " + indiceMaior + ")");
        System.out.println("Menor temperatura: " + menor + "°C (índice " + indiceMenor + ")");

        System.out.print("Temperatura crítica de alerta (°C): ");
        double temperaturaCritica = sc.nextDouble();

        int indiceCritico = -1;
        for(int i = 0; i < temperaturas.length; i++) {
            if(temperaturas[i] < temperaturaCritica) {
                indiceCritico = i;
                break;
            }
        }
        System.out.println("-- Busca Linear: Alerta --");
        if(indiceCritico != -1) {
            System.out.println("Alerta: temperatura crítica atingida na leitura de indice " + indiceCritico + " (" + temperaturas[indiceCritico] + "°C).");
        } else {
            System.out.println("Nenhuma leitura atingiu ou ultrapassou a temperatura crítica informada.");
        }

        sc.close();
    }
}
