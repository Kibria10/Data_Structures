package theory.assignment02;

public class FinalQ {
    static void print(int[] array, int idx) {
        double profit = 0;
        if (idx < array.length) {
            profit = calcProfit(array[idx]);
        }
        System.out.println(profit);
    }

    static double calcProfit(double investment) {
        if (investment <= 25000) {
            return 0;
        } else if (investment > 25000 && investment <= 100000) {
            return calcProfit(investment - 100) + 4.5;
        } else if (investment > 100000) {
            return calcProfit(investment-100)+8;
        }
        return 0;
    }
}
class tester{
    public static void main(String[]args){
        int input[] = {25000, 100000, 250000, 350000};
        FinalQ a = new FinalQ();
        //System.out.println(a.calculate(input));
        a.print(input,3);
    }
}


//code without recursion(gives the total amount of profit of all the investments within the input[] array)

//    public double calculate(int input[]) {
//        double store = 0;
//        for (int i = 0; i < input.length; i++) {
//            if (input[i] <= 25000) {
//                store = 0;
//            } else if (input[i] > 25000 && input[i] <= 100000) {
//                store = (input[i] - 25000) * 0.045 + store;
//            } else if (input[i] > 100000) {
//                int extra = input[i] - 100000;
//                store = (75000) * 0.045 + store;
//                store = extra * 0.08 + store;
//            }
//        }
//        return store;
//    }