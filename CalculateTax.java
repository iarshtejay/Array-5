//## Problem2: Calculate Tax https://leetcode.com/problems/calculate-amount-paid-in-taxes/description/

// Linear solution
// Time: O(Number of tax brackets) --> O(Constant) --> O(1)
// Space: O(1)
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        double taxableInc = 0;
        double remainingInc = income;

        // starting from first tax bracket
        int idx=0;

        while(remainingInc>0){
            int currLimit = brackets[idx][0]; 
            int prevLimit = idx>0? brackets[idx-1][0] : 0; 
            int taxP = brackets[idx][1];

            taxableInc = Math.min(currLimit - prevLimit, remainingInc); 
            tax += taxableInc * taxP /100.0;  
            remainingInc -= taxableInc;     
            idx++;
        }

        return tax;
    }
}