public class Animacao{
    String seq_acoes;
    int passo_atual;
    AquarioLombriga lombriga;

    
    Animacao(String seq_acoes){
        this.seq_acoes = seq_acoes;
        this.passo_atual = 6;
        this.lombriga = new AquarioLombriga(10*((int)seq_acoes.charAt(0) - 48) + ((int)seq_acoes.charAt(1) - 48) , 
                                            10*((int)seq_acoes.charAt(2) - 48) + ((int)seq_acoes.charAt(3) - 48), 
                                            10*((int)seq_acoes.charAt(4) - 48) + ((int)seq_acoes.charAt(5) - 48));
        
    }


    public void passo(){
        if (passo_atual >= seq_acoes.length()){
            return;
        }

        switch(this.seq_acoes.charAt(passo_atual)){
            case 'M':
                this.lombriga.mover();
                break;
            case 'C':
                this.lombriga.crescer();
                break;
            case 'V':
                this.lombriga.virar();
                break;
        }
        this.passo_atual++;
    }


    public void apresenta(){
        this.lombriga.apresenta();
    }


}