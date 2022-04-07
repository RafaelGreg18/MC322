package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < lombrigas.length; l++) {
    	  Animacao anim = new Animacao(lombrigas[l]);
    	  tk.gravaPasso("=====");
    	  tk.gravaPasso(anim.apresenta());
    	  while(anim.passo()) {
    		  tk.gravaPasso(anim.apresenta());
    	  }
      }      
      tk.stop();
   }

}
