package theory.assignment02;

public class finaleRecursion
{
    public static void main(String[]args){
        int random = 17101319%26;
        String a = "abcd";
        encodeWord(a,0,random);
        for(int k =0;k<a.length();k++){

            System.out.println((char) saved[k]);
        }
    }
    public static int saved[];
    public static int[] encodeWord(String a, int i, int random) {
        if (saved == null) {
            saved = new int[a.length()];
        }

        if (i>a.length()){
            return saved;
        }
        else if (i<a.length()){

            char store =a.charAt(i);
            int asciiVal = store;
            saved[i]= asciiVal+random;
            encodeWord(a, i+1, random);
        }


        return saved;
    }
}
