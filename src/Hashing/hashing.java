package Hashing;
public class hashing {
    public char[] consonantsArr = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z',
            'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
    public int number[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public char[] stringToArr(String str) {
        char[] ch = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        // Printing content of array
//        for (char c : ch) {
//            System.out.println(c);
//        }
        return ch;
    }

    public int setValue(char[] input) {
        int constants = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < consonantsArr.length; j++) {

                if (input[i] == consonantsArr[j]) {
                    constants++;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < number.length; j++) {
                if (input[i] == number[j]) {
                    sum = sum + Character.getNumericValue(input[i]);
                }
            }
        }
        return (constants * 24 + sum)%9;
    }

    public void linearProbing(int indexOfInputStr[], String inputStr[]){
        String ultimate[]= new String[9];
        for (int i =0; i<inputStr.length;i++) {
            if (ultimate[indexOfInputStr[i]] == null) {
                ultimate[indexOfInputStr[i]] = inputStr[i];
            } else {
                int j = i;
                while (ultimate[j % ultimate.length] != null) {
                    j++;
                }
                ultimate[j%ultimate.length] = inputStr[i];
            }
        }
        //printing
        System.out.println("TASK:2");
        System.out.println("After Setting The Strings Into The Hash Table:");
        System.out.println();
        System.out.println("|Index|"+"\t"+"|Strings|");
        for (int i =0; i<ultimate.length;i++){
            System.out.println(i +"\t\t"+ ultimate[i]);
        }
//        System.out.println();
//        System.out.println("Index values: ");
//                for (int i =0; i<indexOfInputStr.length;i++){
//                    System.out.print(indexOfInputStr[i] + ", ");
//        }

    }
}

class tester{
    public static void main(String[]args){
        hashing h = new hashing();
        String inputStrArr[]  = {"ST1E89B8A32","ST1E89B8A","ST18A3267","ST1E898A32","T1E89xy3a","ST19B8Ak","E89B8A32","ST34A2222"};
        int indexOfInputStr[]= new int[9];
        for(int i =0; i<inputStrArr.length; i++){
            char[] input = h.stringToArr(inputStrArr[i]);
            indexOfInputStr[i]=h.setValue(input);
        }
        System.out.println("TASK:1");
        System.out.println("|Given String Inputs|"+"\t"+"|Hash values|"+"\t"+"|Index|");
        for (int k =0; k<indexOfInputStr.length-1;k++){
            System.out.println(inputStrArr[k]+ "\t\t\t\t\t" + indexOfInputStr[k] + "\t\t\t" + k);
        }
        System.out.println();
        System.out.println();
        h.linearProbing(indexOfInputStr, inputStrArr);
    }
}
