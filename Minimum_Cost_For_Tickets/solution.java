class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1]; // Last travel day.
        int[] dp = new int[lastDay + 1]; // dp array to store the minimum cost for each day.
        boolean[] travelDays = new boolean[lastDay + 1]; // Array to mark the travel days.

        // This loop marks the days on which travel occurs in the travelDays array.
        for (int day : days) {
        travelDays[day] = true;
        }

        // This loop iterates through each day up to the last travel day.
        for (int i = 1; i <= lastDay; i++) {
        if (!travelDays[i]) { // If it's not a travel day.
            dp[i] = dp[i - 1]; // The cost remains the same as the previous day.
            continue;
        }
        // if it's a travel day. Calculate the cost for 1-day, 7-day, and 30-day tickets.
        int cost1 = dp[i - 1] + costs[0]; // Cost for 1-day ticket.
        int cost7 = dp[Math.max(0, i - 7)] + costs[1]; // Cost for 7-day ticket.
        int cost30 = dp[Math.max(0, i - 30)] + costs[2]; // Cost for 30-day ticket.
        dp[i] = Math.min(cost1, Math.min(cost7, cost30)); // Store the minimum cost for the current day.
        }

        // The minimum cost for the last day is the answer.
        return dp[lastDay];
    }
}