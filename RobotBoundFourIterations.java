// ## Problem1: Bind Robot in a Circle (https://leetcode.com/problems/robot-bounded-in-circle/)

// Time: O(4*L). where L is the length of instructions
// Space: O(1)
// We'll use the fact that if a robot is bound in circle it will reach origin
// in max four sequences of instructions

class Solution {
    public boolean isRobotBounded(String instructions) {
        // clockwise dirs-N, E, S, W
        int[][] dirs = {{0,1}, {1,0},{0,-1},{-1,0}};
        int currDirIdx = 0; // pointing to north
        int currX=0, currY=0;

        for(int i=0;i<4;i++){
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
        }

        return false;
    }
}