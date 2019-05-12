package com.justplay1994.github.acm.leetcode;

class Solution5055 {
    public boolean isRobotBounded(String instructions) {
        int[] result = {0,0};
        int foward = 0; //上右下左 0、1、2、3

        for (int j = 0; j < 4; j++){
            for (int i = 0; i < instructions.length(); i++){
                char c = instructions.charAt(i);
                if (c == 'G'){
                    if (foward == 0){
                        result[1] += 1;
                    }else if (foward == 1){
                        result[0] +=1;
                    }else if (foward == 2){
                        result[1] -=1;
                    }else {
                        result[0] -=1;
                    }
                }else if (c == 'R'){
                    foward += 1;
                }else {
                    foward += 4;
                    foward -= 1;
                }
                foward = foward % 4;
            }
            if (result[0] == 0 && result[1] == 0){
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]){
        new Solution5055().isRobotBounded("GGLLGG");
    }
}