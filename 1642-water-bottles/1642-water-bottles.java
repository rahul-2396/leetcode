class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank = numBottles; // Initial number of full bottles you can drink
        int emptyBottles = numBottles; // All initial bottles become empty after drinking

        while (emptyBottles >= numExchange) {
            int newBottles = emptyBottles / numExchange; // Number of new full bottles
            drank += newBottles; // Add these to the total number of bottles drunk
            emptyBottles = newBottles + (emptyBottles % numExchange); // Update empty bottles count
        }

        return drank;
    }
}
