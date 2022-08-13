package com.practice;

import com.personal.trees.TreeNode;

import java.util.*;

public class Roughwork {

    private static int minHeight;
    public static int minDepth(TreeNode root) {
        /*
        if (root == null) {
            return 0;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        return Math.min(l, r) + 1;
        */
        minHeight = Integer.MAX_VALUE;
        computeMinHeight(root, 0);
        return minHeight;

    }

    /*
    word  = [a t u l]
    permut(word, 0);
    a
     */
    public static void permut(char[] word, int startIdx) {
        //terminal condition
        if (startIdx == word.length-1) {
            System.out.println(word);
        }

        for (int i=startIdx ; i < word.length; i++) {
            //change something
            char temp = word[startIdx];
            word[startIdx] = word[i];
            word[i] = temp;
            //recursion
            permut(word, startIdx+1);
            //revert changed value
            temp = word[startIdx];
            word[startIdx] = word[i];
            word[i] = temp;
        }

    }

    /*
    1 -> 2 -> 3 -> 4

    nextNode 2
      nextNode 3
        nextNode 4

     */
    private static LLnode reverse(LLnode start) {
        //TODO: complete this later
        if (start == null) {
            return null;
        }
        LLnode nextNode = reverse(start.next);

        return null;
    }

    private static void computeMinHeight(TreeNode root, int pathLength) {
        if (root == null) {
            minHeight = Math.min(pathLength, minHeight);
            return;
        }
        if (root.left == null && root.right == null) {
            minHeight = Math.min(pathLength, minHeight);
            return;
        }
        computeMinHeight(root.left, pathLength + 1);
        computeMinHeight(root.right, pathLength + 1);
    }

    public static int findJudge(int n, int[][] trust) {
        if (trust.length < n-1) {
            return -1;
        }
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();

        for(int i =0; i < trust.length; i++) {
            out.put(trust[i][0], out.getOrDefault(trust[i][0], 0) + 1);
            in.put(trust[i][1], in.getOrDefault(trust[i][1], 0) + 1);
        }
        for(Integer i: in.keySet()) {
            if (in.get(i) == n-1 && out.getOrDefault(i, 0) == 0) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        //int[] forbidden = {-10,-5,-2,0,4,5,6,7,8,9,10};
        //int ans = fixedPoint(forbidden);
        //System.out.println(ans);
        Map<Integer, Integer> m = new HashMap<>();

        int[][] trust = new int[][] {
                {1, 2}
        };
        int i = findJudge(2, trust);
        System.out.println(i);

        char[] word = {'a', 't', 'u', 'l'};
        permut(word, 0);

    }
    public static int fixedPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left)/ 2;
            if (arr[mid] == mid) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] > mid) {
                right = mid -1 ;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main2(String[] args) {

        int[] forbidden = {8,3,16,6,12,20};
        int a = 15;
        int b = 13;
        int x = 11;
        int result = minimumJumps(forbidden, a, b, x);
        System.out.println(result);
    }

    /*

           |--------------11--------------|
     */
    public static int isNeighbor(int a, int b, int x, int currentPos) {
        int neighbor = 0;
        if (currentPos >= x-a && currentPos <= x + b) {
            neighbor = 1;
        }
        System.out.println("a = " + a + ",b=" + b + ",x=" + x + ",currentPos=" + currentPos + ",neighbor="+neighbor);
        return neighbor;
    }

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        int totalNeighborCount = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i:forbidden) {
            totalNeighborCount += isNeighbor(a, b, x, i);
            visited.add(i);
        }

        Queue<PosDir> q = new LinkedList<>();
        q.offer(new PosDir(0, 0, 0));
        //visited.add(0);
        while(!q.isEmpty()) {
            PosDir currentPosition = q.poll();
            if (currentPosition.pos == x) {
                return currentPosition.stepCount;
            }

            visited.add(currentPosition.pos);

            totalNeighborCount += isNeighbor(a, b, x, currentPosition.pos);


            if (totalNeighborCount >= a + b + 1) {
                System.out.println(totalNeighborCount);
               // System.out.println(visited);
               // return -1;
            }


            if (!visited.contains(currentPosition.pos + a)) {
                q.offer(new PosDir(currentPosition.pos + a, 0, currentPosition.stepCount + 1));
                visited.add(currentPosition.pos+a);
            }
            if (currentPosition.dir != -1 && !visited.contains(currentPosition.pos - b)) {
                q.offer(new PosDir(currentPosition.pos -b, -1, currentPosition.stepCount + 1));
                visited.add(currentPosition.pos-b);
            }
        }
        return -1;

    }

    public static void knightMoves(String[] args) {
        Queue<XY> cells = new LinkedList<>();
        XY init = new XY(0,0);
        cells.offer(init);

        int[] pathx = {2,  2, -2, -2, 1,  1, -1, -1};
        int[] pathy = {1, -1,  1, -1, 2, -2,  2, -2};

        XY dest = new XY(4,2);

        XY dd = new XY(4,2);
        System.out.println(dd.equals(dd));
        Set<XY> visited = new HashSet<>();
        //visited.add(init);
        while(true) {

            XY current = cells.poll();
            visited.add(current);
            System.out.println(current);
            if (current.equals(dest)) {
                System.out.println("found");
                break;
            }

            for(int i=0; i < pathx.length; i++) {
                XY temp = new XY(current.x + pathx[i], current.y + pathy[i]);
                if (!visited.contains(temp)) {
                    cells.offer(temp);
                }
            }
        }
    }


}

class XY {
    public int x;
    public int y;
    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XY xy = (XY) o;
        return x == xy.x && y == xy.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "XY{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}


class PosDir {
    public int pos;
    public int dir; //direction -1 mean back
    public int stepCount;
    public PosDir(int pos, int dir, int stepCount) {
        this.pos = pos;
        this.dir = dir;
        this.stepCount = stepCount;
    }
}

class LLnode {
    int data;
    LLnode next;
}