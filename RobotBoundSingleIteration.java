// ## Problem1: Bind Robot in a Circle (https://leetcode.com/problems/robot-bounded-in-circle/)

// Time: O(L). where L is the length of instructions
// Space: O(1)
// We'll use the fact that if a robot did not reach origin after first iteration,
// and it faces North, then we'll never reach origin and will only move away from origin.
// The reverse, that we'll reach origin if we face any other direction than north after
// first set of instructions is also true

class Solution {
    public boolean isRobotBounded(String instructions) {
        // clockwise dirs-N, E, S, W
        int[][] dirs = {{0,1}, {1,0},{0,-1},{-1,0}};
        int currDirIdx = 0; // pointing to north
        int currX=0, currY=0;

        for(int j=0;j<instructions.length();j++){
            char instruction = instructions.charAt(j);

            if(instruction=='G'){
                // Move ahead in curr dir
                currX += dirs[currDirIdx][0];
                currY += dirs[currDirIdx][1];
            }else if(instruction=='L'){
                // move anti-clockwise
                currDirIdx = (currDirIdx -1 +4)%4;
            }else{
                // move clock-wise
                currDirIdx = (currDirIdx + 1)%4;
            }
        }

        //check if reached origin
        if(currX==0 && currY==0){
            return true;
        }

        //check curr dir is not north
        if(currDirIdx!=0){
            return true;
        }

        return false;
    }
}