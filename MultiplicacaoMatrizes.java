import java.util.Scanner;

public class MultiplicacaoMatrizes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Requisito 01: Informar o tamanho e os elementos das matrizes
        System.out.println("Informe o tamanho da matriz A (linhas colunas): ");
        int linhaA = scanner.nextInt();
        int colunaA = scanner.nextInt();
        int[][] matrizA = lerMatriz("A", linhaA, colunaA);

        System.out.println("Informe o tamanho da matriz B (linhas colunas): ");
        int linhaB = scanner.nextInt();
        int colunaB = scanner.nextInt();
        int[][] matrizB = lerMatriz("B", linhaB, colunaB);

        // Requisito 02: Verificar se é possível multiplicar as matrizes
        if (colunaA != linhaB) {
            System.out.println(
                    "Não é possível multiplicar as matrizes. O número de colunas de A deve ser igual ao número de linhas de B.");
            return;
        }

        // Requisito 03: Calcular a multiplicação das matrizes
        int[][] matrizC = multiplicarMatrizes(matrizA, matrizB);

        // Requisito 04: Apresentar as matrizes e o resultado
        exibirMatriz(matrizA, "A");
        exibirMatriz(matrizB, "B");
        exibirMatriz(matrizC, "C");

        scanner.close();
    }

    private static int[][] lerMatriz(String nome, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[linhas][colunas];

        System.out.println("Informe os elementos da matriz " + nome + ":");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(nome + "(" + (i + 1) + "," + (j + 1) + "): ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        return matriz;
    }

    private static int[][] multiplicarMatrizes(int[][] A, int[][] B) {
        int linhaA = A.length;
        int colunaA = A[0].length;
        int colunaB = B[0].length;

        int[][] resultado = new int[linhaA][colunaB];

        for (int i = 0; i < linhaA; i++) {
            for (int j = 0; j < colunaB; j++) {
                for (int k = 0; k < colunaA; k++) {
                    resultado[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return resultado;
    }

    private static void exibirMatriz(int[][] matriz, String nome) {
        System.out.println("Matriz " + nome + ":");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
