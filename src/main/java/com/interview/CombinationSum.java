package com.interview;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candi = new int[] {2,3,6,7};
        int target = 7;
        cs.combinationSum(candi, target);
        for(List<Integer> r:cs.res ) {
            System.out.println(r);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        bt(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    List<List<Integer>> res;
    private void bt(int[] candidates, int target, int idx, int sum, List<Integer> arr) {
        //terminating condition
        if (idx >= candidates.length || sum > target) {
            return;
        }

        if (sum == target){
            res.add(new ArrayList<>(arr));
            return;
        }


        bt(candidates, target, idx+1, sum, arr);
        if (sum + candidates[idx] <= target) {
            arr.add(candidates[idx]);
            bt(candidates, target, idx, sum+candidates[idx], arr);
            arr.remove(arr.size()-1);
        }
        return;
    }
}
