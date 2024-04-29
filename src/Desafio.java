import java.util.Scanner;

public class Desafio {

    public static void main(String[] args) {

        //Declaração da matriz
        int[][] matriz = null;

        //Método que cria matriz aleatória
        matriz = formaMatriz(5, 5);

        //Método que imprimi a Matriz
        imprimeMatriz(matriz);

        //Método que imprimi menu
        criaMenu();

        //informação responsável por armazenar a resposta do usuário, sendo usada no loop do Do-While;
        int n1;

        //Usado Do-while como comando de repetição para as opções do Menu, sendo o ínicio dela
        do {
            //Classe Scanner chamada para ler dados
            Scanner ler = new Scanner(System.in);
            // n1 usado para guardar informação que for lida pelo Scanner, de tipo int
            n1 = ler.nextInt();

            //A estrutura SWITCH será usada várias vezes até que seja realizado o comando de saída da repetição
            switch (n1) {
                case 1:
                    somaLinhasParesMatriz(matriz);
                    break;
                case 2:
                    somaColunaImparesMatriz(matriz);
                    break;
                case 3:
                    somaDaDiagonalPrincipalMatriz(matriz);
                    break;
                case 4:
                    aMediaDeTodosOsElementosDaMatriz(matriz);
                    break;
                case 5:
                    aQuantidadeDeElementosNegativosDaMatriz(matriz);
                    break;
                case 6:
                    multiplicaDiagonalPrincipalPelaMediaDaDiagonalSecundaria(matriz);
                    break;
                case -1://Comendo de saída da repetição;
                    System.out.println("Programa encerrado!");
                    break;

                default://Se digitarem outro número que não está no Menu, está mensagem aparecerá;
                    System.out.println("Opção inválida!Tente novamente! ");
                    break;
            }
        } while (n1 != -1);//Final do comando de repetição
    }

    public static int[][] formaMatriz(int linha, int coluna) {
        /* O método cria uma matriz 5 x 5 com valores aleatórios, dando para trocar o valor de ''linha'' e ''coluna''
       para criação da matriz*/
        int[][] matriz = new int[linha][coluna];
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                matriz[x][y] = (int) Math.floor(Math.random() * (-9 - 9 + 1)) + 9;

            }
        }
        //Utilizado o return, pois seria um método que retorna o valor
        return matriz;
    }

    public static void imprimeMatriz(int[][] matriz) {
        //o método imprimi a matriz criada anteriormente pelo outro método;
        System.out.println("A matriz:\n");

        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                System.out.printf("%2d", matriz[x][y]);
            }
            System.out.println();
        }
    }

    public static void criaMenu() {
        //Esse método imprimi visualmente o menu de escolhas
        System.out.println("---------------- MENU ----------------\n" +
                "1) a soma dos elementos de todas as linhas pares da matriz.\n" +
                "2) a soma dos elementos de todas as colunas ímpares da matriz.\n" +
                "3) a soma dos elementos da diagonal principal (une o canto" +
                " superior esquerdo ao canto inferior direito da matriz).\n" +
                "4) a média de todos os elementos da matriz.\n" +
                "5) a quantidade de elementos negativos da matriz.\n" +
                "6) o resultado da multiplicação dos elementos da diagonal" +
                " principal com a média dos elementos da diagonal secundária.\n" +
                "7) Coloque -1 para sair");
    }

    public static void somaLinhasParesMatriz(int[][] matriz) {
        /*Esse método usa a matriz gerada anteriormente pelo método "formaMatriz", somando apenas as linhas pares que
        são a segunda e a quarta linha, usei o comando for para isso, então imprimi no final a soma
        */
        int somaP = 0; // guarda a soma de todos os elementos das linhas pares
        for (int x = 1; x < matriz.length; x += 2) {
            for (int y = 0; y < matriz[x].length; y++) {
                somaP += matriz[x][y];

            }
        }
        System.out.printf("soma dos elementos das linhas pares: %d", somaP);
    }

    public static void somaColunaImparesMatriz(int[][] matriz) {
        /*Esse método usa a matriz gerada anteriormente pelo método "formaMatriz", somando apenas as colunas impares que
        são a primeira, terceira e quinta linha, usei o comando for para isso, então imprimi no final a soma
        */
        int somai = 0; // guarda a soma de todos os elementos das colunas impares

        for (int y = 0; y < matriz.length; y += 2) { //você começa repetindo sobre as colunas 'y' dessa vez
            for (int x = 0; x < matriz[y].length; x++) {
                somai += matriz[x][y];
            }
        }
        System.out.printf("soma dos elementos das colunas impares: %d", somai);
    }

    public static void somaDaDiagonalPrincipalMatriz(int[][] matriz) {
        /*Esse método usa a matriz gerada anteriormente pelo método "formaMatriz", para fazer a diagonal principal,
       apenas um laço vai passar por toda a matriz, já que na diagonal o valor da linha e da coluna sempre vão ser
       iguais "[z][z]"*/
        int somaD = 0;// guarda a soma da diagonal principal

        for (int z = 0; z < matriz.length; z++) {
            somaD += matriz[z][z];
        }
        System.out.printf("soma dos elementos da diagonal principal: %d", somaD);
    }

    public static void aMediaDeTodosOsElementosDaMatriz(int[][] matriz) {
        /*Esse método usa a matriz gerada anteriormente pelo método "formaMatriz", para fazer a média, os dois laços
        será necessário para passar por toda a matriz, guardando cada elemento da matriz em uma variável*/
        int somaM = 0;// guarda a soma de todos os elementos da matriz

        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                somaM += matriz[x][y];

            }
        }

        double mediaM = (double) somaM / 25;// mediaM guarda o valor do calculo, sendo a média da matriz
        System.out.printf("A média de todos os elementos da matriz: %.2f", mediaM);
    }

    public static void aQuantidadeDeElementosNegativosDaMatriz(int[][] matriz) {
         /*Esse método usa a matriz gerada anteriormente pelo método "formaMatriz", para mostrar quantos números
         negativos apresenta a matriz, os laços vão passar por toda a matriz, guardando apenas os elementos negativos
        dela*/
        int quantidadeN = 0;// guarda a quantidade de números negativos da matriz

        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                if (matriz[x][y] <= -1) {
                    quantidadeN++;

                }
            }
        }
        System.out.printf("A quantidade de elementos negativos da matriz: %d", quantidadeN);
    }

    public static void multiplicaDiagonalPrincipalPelaMediaDaDiagonalSecundaria(int[][] matriz) {
        /*Esse método usa a matriz gerada anteriormente pelo método "formaMatriz", primeiro iremos descobrir a diagonal
        secundária usando apenas um laço que vai passar por toda a matriz, já que na diagonal secundária o valor da
        linha e da coluna sempre vão ser iguais, mas de modo invertido "matriz[z][matriz.length -1 - z]"*/

        int[] diagonalP = new int[5]; // vetor criado para guardar os 5 elementos da diagonal principal
        double[] diagonalPxMS = new double[5]; // vetor criado para guardar os 5 elementos da diagonalP vezes a "medias'
        int somaS = 0; // guarda a soma dos elementos da diagonal secundária
        double mediaS = 0; // guarda os elementos da média da diagonal secundária

        for (int z = 0; z < matriz.length; z++) {
            somaS += matriz[z][matriz.length - 1 - z];
            mediaS = (double) somaS / 5;
        }

        // variável feita para transformar o número em inteiro e não dar erro na multiplicação
        int mediaSInt = (int) (mediaS * 100);

        for (int z = 0; z < matriz.length; z++) {
            diagonalP[z] = matriz[z][z];
            diagonalPxMS[z] = diagonalP[z] * mediaSInt / 100.0; /*transformando novamente para número com vírgula depois
            da multiplicação*/
        }

        System.out.print("Multiplicação dos elementos da diagonal principal com a média dos elementos da " +
                "diagonal secundária: ");

        /*Laço de repetição criado para repetir todos os elementos da diagonal principal a ser multiplicado pela média
        da diagonal secundária, junto do IF para limpeza visual das vírgulas quando não necessário, pois a média pode
         vir inteira ou decimal*/
        for (int z = 0; z < diagonalPxMS.length; z++) {
            if (mediaS == (int) mediaS) {
                System.out.printf("%d * %d = %.0f\n", diagonalP[z], (int) mediaS, diagonalPxMS[z]);
            } else {
                System.out.printf("%d * %.2f = %.2f\n", diagonalP[z], mediaS, diagonalPxMS[z]);
            }
        }
    }
}