import java.util.Scanner;
import java.util.Stack;


public class Main {

    public static void main(String[] args) {
        Character[] term={'a','b','c','d'};
        int [][] table={
                {0,0,0,0},
                {1,2,0,0},//állapot 1 S-nemterminális megfelelője
                {0,2,0,3},
                {0,0,0,3}//állapot 2 A terminális megfelelője
        };
        Scanner obj=new Scanner(System.in);
        String in=obj.nextLine();
        LL vegesauto=new LL(in,term,table);
        vegesauto.veremAlja();
        System.out.println(vegesauto.elFogado(in));

        /*
        *Ha 1 es állapotba vagyok és a jön akkor a verembe aS-t teszek és maradok 1 es állapotba
        * Ha 1 es állapotba vagyok és b jön akkor a verembe bAc-t teszek és átmegyek 2 es állapotba
        * Ha 2 es állapotba vagyok és c van a verem végén akkor c-t pusholom a veremből!
        * Ha 2 es állapotba vagyok és b jön akkor maradok 2 es állapotba és a verembe bAc-t teszek az A helyére
        * Ha 2 es állapotba vagyok és d jön akkor az A helyére d-t teszek és átmegyek 3-as állapotba ami végállapot
        * Vizsgálatképp elég ha a verem tartalmát összehasonlítom a bemenő string d karakteréig.
        * Ha az adott állapotokban bármilyen eltérő karakter jön errort dobok.
        */


        /*
        * S->aS|bAc
        * A->bAc|d
        */
    }
}
