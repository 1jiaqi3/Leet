/*
There are n bulbs that are initially off. You first turn on all the bulbs. 
Then, you turn off every second bulb. 
On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). 
For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.
*/
public class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
/*
solution:
Ok, very verbose explanation, but clear enough for everyone to understand.

the initial state all bulbs are off.

if at last the bulb was toggled odd number of times, it is on. if toggled even number of times, it is off.

simple enough, and that number is determined by how many factors a number has. 
note that every number has 1 and itself as a factor. and if it has multiple times of a factor it only counted once.

1 --------- 1

2 --------- 1, 2

3 --------- 1, 3

4 --------- 1, 2, 4

5 --------- 1, 5

6 --------- 1, 2, 3, 6

7 --------- 1, 7

8 --------- 1, 2, 4, 8

9 --------- 1, 3, 9

see that only square numbers like 1, 4 and 9 has odd number of factors. 
bulbs at those numbers will left on after all the rounds of toggle.

so basically, we calculate how many square numbers are there within a given number. 
and we can get it simply by calculate the square root of that number. of course the decimal part is eliminated.
*/
