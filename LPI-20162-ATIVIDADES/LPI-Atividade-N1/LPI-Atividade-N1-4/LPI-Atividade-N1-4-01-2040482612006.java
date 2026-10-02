/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*
 * Disciplina : Linguagem de Programacao I                                                                          *
 * Prof . Verissimo                                                                                                 *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*
 * Objetivo do Programa : Simular, por meio de uma matriz bidimensional, o tabuleiro de xadrez  *
 *                        e reproduzir a sequencia de lances conhecida como Xeque Pastor.        *
 * Data - 03/09/2026                                                                                                *
 * Autor : Lucas Viana                                                                                                *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/

/**
 * Classe responsavel por simular o Xeque Pastor em um tabuleiro de xadrez
 * representado por uma matriz bidimensional de Strings.
 * Estrutura de metodos alinhada ao diagrama de blocos: criarTabuleiro(),
 * mostrarTabuleiro() e mover(), chamados em sequencia a partir do main().
 */
public class XequePastor {

    // ----- Constantes imutaveis -----
    // Dimensao do tabuleiro (8x8), conforme um tabuleiro de xadrez padrao
    private static final int TAMANHO_TABULEIRO = 8;

    // Representacao textual de uma casa vazia / posicao de origem apos o movimento
    private static final String CASA_VAZIA = "...";

    // Letra da primeira coluna do tabuleiro, usada para montar o rodape (a-h)
    private static final char COLUNA_INICIAL = 'a';

    // Ordem das pecas de maior valor na fileira de fundo (torre, cavalo, bispo, dama, rei...)
    private static final String[] ORDEM_PECAS_MAIORES = {"T", "C", "B", "D", "R", "B", "C", "T"};

    public static void main(String[] args) {
        String[][] tabuleiro = criarTabuleiro();

        System.out.println("=== TABULEIRO INICIAL ===");
        mostrarTabuleiro(tabuleiro);

        System.out.println("\n=== JOGADA 1 ===");
        System.out.println("Brancas jogam Peao do Rei: e2-e4");
        mover(tabuleiro, 6, 4, 4, 4);
        System.out.println("Pretas jogam Peao do Rei: e7-e5");
        mover(tabuleiro, 1, 4, 3, 4);
        mostrarTabuleiro(tabuleiro);

        System.out.println("\n=== JOGADA 2 ===");
        System.out.println("Brancas jogam Bispo do Rei: Bc4");
        mover(tabuleiro, 7, 5, 4, 2);
        System.out.println("Pretas jogam Cavalo da Dama: Cc6");
        mover(tabuleiro, 0, 1, 2, 2);
        mostrarTabuleiro(tabuleiro);

        System.out.println("\n=== JOGADA 3 ===");
        System.out.println("Brancas jogam Dama: Dh5");
        mover(tabuleiro, 7, 3, 3, 7);
        System.out.println("Pretas jogam Cavalo do Rei: Cf6");
        mover(tabuleiro, 0, 6, 2, 5);
        mostrarTabuleiro(tabuleiro);

        // Lance final: apenas movimento das brancas, com captura e xeque mate
        System.out.println("\n=== JOGADA 4 (LANCE FINAL) ===");
        System.out.println("Brancas capturam o Peao do Rei e dao Xeque Mate: Dxf7#");
        mover(tabuleiro, 3, 7, 1, 5);
        mostrarTabuleiro(tabuleiro);

        System.out.println("\n>>> XEQUE MATE! Fim de jogo. <<<");
    }

    /**
     * Cria a matriz 8x8, inicializa todas as casas com "..." e, em seguida,
     * coloca as pecas nas posicoes iniciais de uma partida de xadrez.
     */
    private static String[][] criarTabuleiro() {
        String[][] tabuleiro = new String[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];

        // Inicializar todas as casas com "..."
        for (int linha = 0; linha < TAMANHO_TABULEIRO; linha++) {
            for (int coluna = 0; coluna < TAMANHO_TABULEIRO; coluna++) {
                tabuleiro[linha][coluna] = CASA_VAZIA;
            }
        }

        // Colocar as pecas nas posicoes iniciais
        for (int coluna = 0; coluna < TAMANHO_TABULEIRO; coluna++) {
            tabuleiro[0][coluna] = ORDEM_PECAS_MAIORES[coluna] + "N"; // pecas maiores pretas
            tabuleiro[1][coluna] = "PN";                              // peoes pretos
            tabuleiro[6][coluna] = "PB";                              // peoes brancos
            tabuleiro[7][coluna] = ORDEM_PECAS_MAIORES[coluna] + "B"; // pecas maiores brancas
        }

        return tabuleiro; // retorna tabuleiro inicializado
    }

    /**
     * Percorre a matriz e imprime no console o estado atual do tabuleiro,
     * finalizando com as letras das colunas (a a h).
     */
    private static void mostrarTabuleiro(String[][] tabuleiro) {
        System.out.println();
        for (int linha = 0; linha < TAMANHO_TABULEIRO; linha++) {
            for (int coluna = 0; coluna < TAMANHO_TABULEIRO; coluna++) {
                System.out.print(tabuleiro[linha][coluna] + " ");
            }
            System.out.println(); // quebra de linha
        }

        // Imprimir letras das colunas (a ate h)
        for (int coluna = 0; coluna < TAMANHO_TABULEIRO; coluna++) {
            char letraDaColuna = (char) (COLUNA_INICIAL + coluna);
            System.out.print(letraDaColuna + "   ");
        }
        System.out.println();
    }

    /**
     * Move uma peca da posicao de origem para a posicao de destino na matriz,
     * marcando a origem como vazia ("...") e exibindo a movimentacao no console.
     */
    private static void mover(String[][] tabuleiro, int linhaOrigem, int colunaOrigem,
                               int linhaDestino, int colunaDestino) {
        String peca = tabuleiro[linhaOrigem][colunaOrigem];

        tabuleiro[linhaOrigem][colunaOrigem] = CASA_VAZIA; // posicao de origem
        tabuleiro[linhaDestino][colunaDestino] = peca;      // posicao final

        System.out.println("Posicao origem: " + CASA_VAZIA + "   |   Posicao final: " + peca);
    }
}