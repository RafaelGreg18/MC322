package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
    public int i; //linha
    public int j; //coluna
    public boolean alive;

    Peca(int i, int j){
        this.i = i;
        this. j = j;
        this.alive = true;
    }

    public void mover(int is, int id, int js, int jd, Tabuleiro tab){
        int mov_type = tab.movimentoPossivel(is, id, js, jd);
        if (mov_type != 0){
            this.i = id;
            this.j = jd;
            tab.realizarMovimento(mov_type, is, id, js, jd);
        }
    }
}
