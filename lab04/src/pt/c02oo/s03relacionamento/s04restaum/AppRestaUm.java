package pt.c02oo.s03relacionamento.s04restaum;

/* Entenda:
is -> linha origem
js -> coluna origem
id -> linha destino
jd -> coluna destino
 */

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      Tabuleiro tab = new Tabuleiro();
      String commands[] = tk.retrieveCommands();
      


      System.out.println("=== Entrada");
      for (int l = 0; l < commands.length; l++) {
         System.out.println(commands[l]);
      }

      System.out.println("=== Primeira Saída");
      char board[][] = {
              {' ', ' ', 'P', 'P', 'P', ' ', ' '},
              {' ', ' ', 'P', 'P', 'P', ' ', ' '},
              {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
              {'P', 'P', 'P', '-', 'P', 'P', 'P'},
              {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
              {' ', ' ', 'P', 'P', 'P', ' ', ' '},
              {' ', ' ', 'P', 'P', 'P', ' ', ' '}
      };
      tk.writeBoard("1° estágio do tabuleiro", board);
      for (int l = 0; l < commands.length; l++) {
         String curr = commands[l];
         int curr_js = curr.charAt(0) - 'a';
         int curr_is = curr.charAt(1) - '1';
         int curr_jd = curr.charAt(3) - 'a';
         int curr_id = curr.charAt(4) - '1';
         (Tabuleiro.pecas[curr_is][curr_js]).mover(curr_is, curr_id, curr_js, curr_jd, tab);
         tk.writeBoard((char)(l+2 + '0') + "° estágio do tabuleiro", tab.montaTabuleiro());
      }
      tk.stop();
   }

}
