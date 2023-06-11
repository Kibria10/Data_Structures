package designgurus;

public class ShortestDistance {
    public static void main(String[] args) {
        ShortestDistance sd = new ShortestDistance();
        // Test case 1
        String[] words1 = { "the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog" };
        String word11 = "fox";
        String word21 = "dog";
        int expectedOutput1 = 5;
        int actualOutput1 = sd.shortestDistance(words1, word11, word21);
        System.out.println("Test case 1: " + (expectedOutput1 == actualOutput1));

        // Test case 2
        String[] words2 = { "a", "b", "c", "d", "a", "b" };
        String word12 = "a";
        String word22 = "b";
        int expectedOutput2 = 1;
        int actualOutput2 = sd.shortestDistance(words2, word12, word22);
        System.out.println("Test case 2: " + (expectedOutput2 == actualOutput2));

        // Test case 3
        String[] words3 = { "a", "c", "d", "b", "a" };
        String word13 = "a";
        String word23 = "b";
        int expectedOutput3 = 1;
        int actualOutput3 = sd.shortestDistance(words3, word13, word23);
        System.out.println("Test case 3: " + (expectedOutput3 == actualOutput3));

        // Test case 4
        String[] words4 = { "a", "b", "c", "d", "e" };
        String word14 = "a";
        String word24 = "e";
        int expectedOutput4 = 4;
        int actualOutput4 = sd.shortestDistance(words4, word14, word24);
        System.out.println("Test case 4: " + (expectedOutput4 == actualOutput4));

        // Test case 5
        String [] words5 = {"a", "k", "c", "b", "e", "f", "a", "g", "b"};
        String word15 = "a";
        String word25 = "b";
        int expectedOutput5 = 2;
        int actualOutput5 = sd.shortestDistance(words5, word15, word25);
        System.out.println("Test case 5: " + (expectedOutput5 == actualOutput5));
    }

    public int shortestDistance(String[] words, String word1, String word2) {
           int minDistance = Integer.MAX_VALUE;
            int word1Index = -1;
            int word2Index = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1))
                    word1Index = i;
                if (words[i].equals(word2))
                    word2Index = i;
                if (word1Index != -1 && word2Index != -1)
                    minDistance = Math.min(minDistance, Math.abs(word1Index - word2Index));
            }
            return minDistance;
    }
}
