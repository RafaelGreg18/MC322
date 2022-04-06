public class AppLab03{
    public static void main(String[] args){
        Animacao anim = new Animacao("010101MCMMV");
        for(int i = 0; i < 4; i++){
            anim.passo();
            anim.apresenta();
        }
    }
}