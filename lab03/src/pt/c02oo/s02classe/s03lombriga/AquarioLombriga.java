public class AquarioLombriga {
    int Asize; //tamanho do aquario
    int Lsize; //tamanho da lombriga
    int headpos; //posicao da cabeca
    // HO -> Head Orientation
    boolean HO; //booleana indicando se cresce para esquerda (false) ou direita (true)
    char[] aquario;

    AquarioLombriga(int Asize, int Lsize, int headpos){
        this.Asize = Asize;
        this.Lsize = Lsize;
        this.headpos = headpos;
        this.HO = false;
        char[] aquario = new char[Asize];
        this.aquario = aquario;

        for (int i = 0; i < Asize; i++){
            aquario[i] = '#'; //inicializando o aquario
        }

        if (headpos - 1 >= 0  && headpos - 1 <= Asize - 1){
            aquario[headpos - 1] = 'O';
        } else{ // caso o input seja uma posicao invalida para a cabeca
            aquario[0] = 'O';
        }
        int j = 1;
        for (int i = headpos; (i < Asize) && (j < Lsize); i++){
            aquario[i] = '@'; //montando o resto do corpo da lombriga
            j++;
        }
    }

    //a acao virar inverte a posicao da cabeca da lombriga com o ultimo @ de seu corpo, exemplo:
    // ##O@@## -> ##@@O##
    public void virar(){
        if (this.HO == false){
            if((this.headpos - 1) + (this.Lsize - 1) < this.Asize - 1){
                this.aquario[this.headpos-1] = '@';
                this.aquario[(this.headpos - 1) + (this.Lsize - 1)] = 'O';
                this.headpos = (this.headpos - 1) + (this.Lsize - 1) + 1; //atualizando headpos
            } else{
                return;
            }
        } else{
            if ((this.headpos - 1) - (this.Lsize - 1) > 0){
                this.aquario[headpos-1] = '@';
                this.aquario[(this.headpos - 1) - (this.Lsize - 1)] = 'O';
                this.headpos = (this.headpos - 1) - (this.Lsize - 1) - 1 + 1; //atualizando headpos
            } else{
                return;
            }
        }
        this.HO = !(this.HO); //invertendo o sentido da cabeca
    }

    public void crescer(){
        if (this.HO == false){
            if (this.headpos - 1 + Lsize - 1 + 1 <= this.Asize - 1){ // this.headpos - 1 + Lsize - 1 + 1 retorna uma casa apos o ultimo @
                this.Lsize++;
                this.aquario[this.headpos - 1 + this.Lsize - 1] = '@';
            } else{
                return;
            }
        } else{
            if ((this.headpos - 1) - (this.Lsize - 1) - 1 >= 0 ){ //idem para o comentario acima, mas para a cabeca orientada p/ direita
                this.Lsize++;
                this.aquario[(this.headpos - 1) - (this.Lsize - 1)] = '@';
            } else{
                return;
            }
        }
    }

    //a funcao mover, primeiramente, checa se eh possivel mover. Caso nao seja, o metodo virar sera chamado;
    // caso seja, primeiro torna o ultimo @ em #, atualiza headpos, atribui O para a nova headpos, e torna # em @ uma posicao anterior à nova headpos
    // exemplo:
    // #O@@#
    // #O@## (I)
    // headpos vai de 2 para 1
    // OO@## (II)
    // O@@##
    public void mover(){
        if (this.HO == false){
            if(this.headpos - 1 == 0){
                this.virar();;
            } else{
                this.aquario[this.headpos - 1 + this.Lsize - 1] = '#';
                this.headpos -= 1;
                this.aquario[this.headpos - 1] = 'O';
                this.aquario[this.headpos - 1 + 1] = '@';
            }
        } else{
            if (this.headpos - 1 == this.Asize - 1){
                this.virar();
            } else{
                this.aquario[this.headpos - 1 - Lsize + 1] = '#';
                this.headpos += 1;
                this.aquario[this.headpos - 1] = 'O';
                this.aquario[this.headpos -1 -1] = '@';
            }
        }
    }

    public String apresenta(){
        String str = new String(this.aquario);
        return str;
    }
}
