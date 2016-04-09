/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Hint:

Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
Group the number by thousands (3 digits). 
You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? 
(middle chunk is zero and should not be printed out)
*/
class Solution {
private:
    string less20[20] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                           "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                           "Seventeen", "Eighteen", "Nineteen"};
    string tens[10] = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    string rest[3] = {"Thousand", "Million", "Billion"};
public:
    string numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int count = 0;
        string ret = everyThree(num % 1000);
        num /= 1000;
        while (num != 0) {
            if (num % 1000 != 0) {
                ret = rest[count] + " " + ret;
                ret = everyThree(num % 1000) + " " + ret;
            }
            count++;
            num /= 1000;
        }
        trim(ret);
        return ret;
    }
    string everyThree(int num) {
        string ret = "";
        if (num != 0) {
            if (num % 100 < 20) {
                ret = less20[num % 100] + ret;
                num /= 100;
            } else {
                ret = less20[num % 10] + ret;
                num /= 10;
                ret = tens[num % 10] + " " + ret;
                num /= 10;
            }
        }
        if (num != 0) {
            ret = less20[num % 10] + " " + "Hundred " + ret;
        }
        trim(ret);
        return ret;
    }
    void trim(string &s) {
        if (s[s.size() - 1] == ' ') {
            s.erase(s.size() - 1);
        }
    }
};
