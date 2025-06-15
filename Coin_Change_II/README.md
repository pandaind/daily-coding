# Coin Change II

**Difficulty**: Medium

<p>You are given an integer array <code>coins</code> representing coins of different denominations and an integer <code>amount</code> representing a total amount of money.</p>

<p>Return <em>the number of combinations that make up that amount</em>. If that amount of money cannot be made up by any combination of the coins, return <code>0</code>.</p>

<p>You may assume that you have an infinite number of each kind of coin.</p>

<p>The answer is <strong>guaranteed</strong> to fit into a signed <strong>32-bit</strong> integer.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> amount = 5, coins = [1,2,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> amount = 3, coins = [2]
<strong>Output:</strong> 0
<strong>Explanation:</strong> the amount of 3 cannot be made up just with coins of 2.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> amount = 10, coins = [10]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= coins.length &lt;= 300</code></li>
	<li><code>1 &lt;= coins[i] &lt;= 5000</code></li>
	<li>All the values of <code>coins</code> are <strong>unique</strong>.</li>
	<li><code>0 &lt;= amount &lt;= 5000</code></li>
</ul>
---



### Visualizing the Process:

For the amount `5` and coins `[1, 2, 5]`, after processing each coin, the `dp` array evolves as follows:

1. **Initial State:** `dp = [1, 0, 0, 0, 0, 0]`
   - `dp[0] = 1` because there's one way to make the amount 0 (using no coins).
2. **Processing Coin `1`:**
   - For `i = 1 to 5`: Update `dp[i] += dp[i - 1]`.
   - `dp = [1, 1, 1, 1, 1, 1]` (each amount from 1 to 5 can be made by using only coin 1).
3. **Processing Coin `2`:**
   - For `i = 2 to 5`: Update `dp[i] += dp[i - 2]`.
   - `dp = [1, 1, 2, 2, 3, 3]` (we now include ways to make amounts using coin 2).
4. **Processing Coin `5`:**
   - For `i = 5`: Update `dp[i] += dp[i - 5]`.
   - `dp = [1, 1, 2, 2, 3, 4]` (we can now also make 5 using coin 5).
