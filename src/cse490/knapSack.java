package cse490;

public class knapSack {
    public static void main(String[]args) {
        int m = 41;
        int n = 467;
        int e = 1011011;
        int[] sik = {2, 6, 10, 23, 50, 110, 250};
        int[] gk = new int[sik.length];
        int[] keysEncryption = new int[sik.length];

        System.out.println("ENCRYPTING: ");
        int S = encryptKnapsack(m,n,e,sik,gk,keysEncryption);
        System.out.println("DECRYPTING: ");
        decryptKnapsack(S,sik);

    }
    static int encryptKnapsack(int m, int n, int e, int sik[], int gk[], int keysEncryption[]){

        //creating our General knapsack keys (public keys)
         for(int i =0; i< sik.length; i++)
        {
            gk[i] = sik[i] * m % n;
        }
        //converting given plain text(e) into an array named keys
        String temp = Integer.toString(e);
        int[] keys = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            keys[i] = temp.charAt(i) - '0';
        }
        //encrypting keys
        for (int i = 0; i < keysEncryption.length; i++) {
            keysEncryption[i] = gk[i]*keys[i];
        }

        int sum = 0;
        for(int i=0; i< keysEncryption.length; i++){
            sum = sum + keysEncryption[i];
        }
        // finding the inverse modular of m and n
        int inv=0;
        for (int x = 1; x < n; x++) {
            if (((m % n) * (x % n)) % n == 1) {
                System.out.println("Modular Inverse of m and n: "+ x);
                inv = x;
            }
        }
        //creating S
        int S = (sum * inv) % n;
        System.out.println("S: "+ S);

        return S;
        }

    static int[] decryptKnapsack(int S, int[] sik){
    int[] saved = new int [sik.length];
    int a=0;
    int b =0;
    //finding the first value, which is less than S
    for(int k = sik.length-1; k>0; k--){
        if (sik[k]<S){
            a = sik[k];
            b =k; //we need to start comparing from this index
            saved[k]=a;
            break;
        }
    }
    int temp = a;
        for (int i = b-1; i>=0; i--){
        if (S >=  temp + sik[i]) {
            saved[i] = sik[i];
            temp = sik[i]+temp;
        }
    }
        System.out.println("The Results After Decryption: ");
        for (int i = 0; i< saved.length; i++){
            System.out.println(saved[i]);
        }
        return saved;
    }

    }

