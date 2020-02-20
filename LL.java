import java.util.Stack;

public class LL {
    private final String in;
    private final int[][] table;
    private int allapot=1;
    private int vegallapot=3;
    private Character ch;
    private int countc=0;
    private int countb=0;
    static Stack<Character> verem=new Stack<Character>();
    private final Character[] term;

    LL(String in, Character[] term, int[][] table){
    this.in=in;
    this.term=term;
    this.table=table;
    }

    public static void veremAlja()
    {
        verem.push('#');
    }

    public boolean elFogado(String in)
    {

        int temp;
        System.out.println("kezdődik");
        for (int i = 0; i <in.length() ; i++) {
            System.out.println(verem);
            if (in.charAt(i)=='a'&&verem.peek()=='#'){
                ch='a';
                verem.push('a');
                verem.push('S');
            }
            else if (in.charAt(i)=='a'&&verem.peek()=='S'){
                ch='a';
                verem.pop();
                verem.push('a');
                verem.push('S');
            }
            else if(in.charAt(i)=='b'&&verem.peek()=='#'){
                ch='b';
                ++countb;
                verem.push('b');
                verem.push('A');
                verem.push('c');
            }
            else if(in.charAt(i)=='b'&&verem.peek()=='S'){
                ch='b';
                ++countb;
                verem.pop();
                verem.push('b');
                verem.push('A');
                verem.push('c');
            }
            else if(in.charAt(i)=='b'&&verem.peek()=='c'){
                ch='b';
                ++countb;
                ++countc;
                verem.pop();
                verem.pop();
                verem.push('b');
                verem.push('A');
                verem.push('c');
            }
            else if(in.charAt(i)=='c'&&verem.peek()=='c'){
                ch='c';
            }
            else if(in.charAt(i)=='d'&&verem.peek()=='c'){
                ch='d';
                verem.pop();
                ++countc;
                verem.pop();
                verem.push('d');
            }
            else if(in.charAt(i)=='a'&&verem.peek()=='d'){
                ch='a';
            }
            else if(in.charAt(i)=='b'&&verem.peek()=='d'){
                ch='b';

            }


            temp=allapotKeres(ch);
            System.out.println(allapot);
            allapot=table[allapot][temp];
            System.out.println(verem);
            if(allapot==0){
                return false;
            }
        }
        System.out.println(verem);
        return elfogadoAllapot();
    }

    public int allapotKeres(Character c)
    {
        for (int i = 0; i < term.length; i++) {
            if(c.equals(term[i])){
                return i;
            }
        }
        return 0;
    }
    public boolean elfogadoAllapot()
    {
        if(allapot==vegallapot&&verem.peek()=='d'&&countb==countc){
            return true;
        }
        else{
            return false;
        }
    }

}
