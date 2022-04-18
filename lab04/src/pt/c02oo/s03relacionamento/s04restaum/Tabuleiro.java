package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
    public static char[][] board;
    public static Peca[][] pecas;


    Tabuleiro(){
        Tabuleiro.board = new char[][]{
                {' ', ' ', 'P', 'P', 'P', ' ', ' '},
                {' ', ' ', 'P', 'P', 'P', ' ', ' '},
                {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
                {'P', 'P', 'P', '-', 'P', 'P', 'P'},
                {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
                {' ', ' ', 'P', 'P', 'P', ' ', ' '},
                {' ', ' ', 'P', 'P', 'P', ' ', ' '}
        };

        Tabuleiro.pecas = new Peca[7][7];

        for (int i = 0; i <= 1; i++){
            for (int j = 2; j <= 4; j++){
                Peca novapeca = new Peca(i, j);
                Tabuleiro.pecas[i][j] = novapeca;
            }
        }

        for (int i = 0; i < 7; i++){
            if (i == 3){
                Tabuleiro.pecas[3][i] = new Peca(3, i);
                Tabuleiro.pecas[3][i].alive = false;
            } else{
                Tabuleiro.pecas[3][i] = new Peca(3, i);
            }
            Tabuleiro.pecas[2][i] = new Peca(2, i);
            Tabuleiro.pecas[4][i] = new Peca(4, i);
        }

        for (int i = 5; i <= 6; i++){
            for (int j = 2; j <= 4; j++){
                Peca novapeca = new Peca(i, j);
                Tabuleiro.pecas[i][j] = novapeca;
            }
        }

    }

    //função que de fato troca os caracteres do tabuleiro, de acordo com a booleana "alive" de cada peça
    public char[][] montaTabuleiro(){
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                if (Tabuleiro.pecas[i][j] == null) Tabuleiro.board[i][j] = ' '; //se for null, apenas espaço
                else if (Tabuleiro.pecas[i][j].alive) Tabuleiro.board[i][j] = 'P'; //se estiver viva, P
                else Tabuleiro.board[i][j] = '-'; // se não, então -
            }
        }
        return Tabuleiro.board;
    }

    //recebe um int mov_type, que se for: 1, é horizontal direita; 2, horizontal esquerda; 3 vertical baixo; 4 vertical cima.
    public void realizarMovimento(int mov_type, int is, int id, int js, int jd){
        Tabuleiro.pecas[is][js].alive = false; //peça da posição source "morre", pois trocou de posicao
        Tabuleiro.pecas[id][jd].alive = true; //posição destino torna viva
        //eliminando uma peça
        switch (mov_type){
            case 1:
                Tabuleiro.pecas[is][jd-1].alive = false;
                break;
            case 2:
                Tabuleiro.pecas[is][jd+1].alive = false;
                break;
            case 3:
                Tabuleiro.pecas[id - 1][jd].alive = false;
                break;
            case 4:
                Tabuleiro.pecas[id+1][jd].alive = false;
                break;
        }
    }

    public int movimentoPossivel(int is, int id, int js, int jd){
        //coordenada invalida
        if (is < 0 || id < 0 || js < 0 || jd < 0 || is > 6 || id > 6 || js > 6 || jd > 6) return 0;
        // bloqueando movimentos na diagonal, em que nem is == id nem js == jd
        if (is != id && js != jd) return 0;
        //movimento horizontal (mesma linha)
        if (is == id){
            //pra direita
            if (jd - js > 0){
                if (Tabuleiro.pecas[is][jd-1].alive && !Tabuleiro.pecas[id][jd].alive){
                    return 1;
                } else{
                    return 0;
                }
            //pra esquerda
            } else{
                if (Tabuleiro.pecas[is][jd+1].alive && !Tabuleiro.pecas[id][jd].alive){
                    return 2;
                } else{
                    return 0;
                }
            }
        } else{ //movimento vertical (mesma coluna)
            //pra baixo
            if (id - is > 0){
                if (Tabuleiro.pecas[id - 1][jd].alive && !Tabuleiro.pecas[id][jd].alive){
                    return 3;
                } else{
                    return 0;
                }
            } else{
                // pra cima
                if (Tabuleiro.pecas[id + 1][jd].alive && !Tabuleiro.pecas[id][jd].alive){
                    return 4;
                } else{
                    return 0;
                }
            }
        }
    }

}
