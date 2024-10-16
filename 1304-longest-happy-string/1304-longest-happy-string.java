class Solution {

    public String longestDiverseString(int a, int b, int c) {
        int curra = 0, currb = 0, currc = 0;

        int totalIterations = a + b + c;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < totalIterations; i++) {
            if ((a >= b && a >= c && curra != 2) || (a > 0 && (currb == 2 || currc == 2))) {
                answer.append('a');
                a -= 1;
                curra += 1;
                currb = 0;
                currc = 0;
            } 
            else if ((b >= a && b >= c && currb != 2) || (b > 0 && (currc == 2 || curra == 2))) {
                answer.append('b');
                b -= 1;
                currb += 1;
                curra = 0;
                currc = 0;
            }
            else if ((c >= a && c >= b && currc != 2) || (c > 0 && (curra == 2 || currb == 2))) {
                answer.append('c');
                c -= 1;
                currc += 1;
                curra = 0;
                currb = 0;
            }
        }
        return answer.toString();
    }
}