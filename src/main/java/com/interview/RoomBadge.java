package com.interview;

import java.math.BigDecimal;
import java.util.*;

public class RoomBadge {

    @FunctionalInterface
    public interface FI {
        void print(String s);
    }


    public static int findIslandCount(int[][] area) {
        int[][] visited = new int[area.length][area[0].length];
        System.out.println(visited[2][2]);

        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int max = 0;
        for(int i=0; i < area.length; i++) {
            for(int j=0; j < area[0].length; j++) {
                if (area[i][j] == 1) {
                    //do bfs
                    q.offer(new int[]{i, j});
                    count++;
                    int size = 0;
                    //mark adjacent land as single island
                    while (!q.isEmpty()) {
                        int[] cell = q.poll();
                        if (area[cell[0]][cell[1]] == 1) {
                            size++;
                            area[cell[0]][cell[1]] = 2;
                            max = Math.max(max, size);
                        }

                        if ( cell[0] + 1 >= 0 && cell[0] + 1 < area.length && area[cell[0]+1][cell[1]] == 1) {
                            q.offer(new int[]{cell[0]+1, cell[1]});
                        }
                        if ( cell[0] - 1 >= 0 && cell[0] - 1 < area.length && area[cell[0]-1][cell[1]] == 1) {
                            q.offer(new int[]{cell[0]-1, cell[1]});
                        }
                        if ( cell[1] + 1 >= 0 && cell[1] + 1 < area[0].length && area[cell[0]][cell[1]+1] == 1) {
                            q.offer(new int[]{cell[0], cell[1]  +1});
                        }
                        if ( cell[1] - 1 >= 0 && cell[1] - 1 < area[0].length && area[cell[0]][cell[1] - 1] == 1) {
                            q.offer(new int[]{cell[0], cell[1]-1});
                        }

                    }
                }
            }
        }
        System.out.println("max area of land is "+ max);
        return count;
    }

    public static void main(String[] args) {
        int[][] area = {
            {1,1,1},
            {0,0,0},
            {1,1,1}
        };
        System.out.println(findIslandCount(area));
    }

    public static String sortString(String data) {
        char[] charData = data.toCharArray();
        Arrays.sort(charData);
        return new String(charData);
    }

    public static Map<Integer, List<Character>> keys ;

    static {
        keys = new HashMap<>();
        keys.put(0, Arrays.asList(new Character[]{}));
        keys.put(1, Arrays.asList(new Character[]{}));
        keys.put(2, Arrays.asList(new Character[]{'a','b'}));
        keys.put(3, Arrays.asList(new Character[]{}));
        keys.put(4, Arrays.asList(new Character[]{}));
        keys.put(5, Arrays.asList(new Character[]{}));
        keys.put(6, Arrays.asList(new Character[]{}));
        keys.put(7, Arrays.asList(new Character[]{}));
        keys.put(8, Arrays.asList(new Character[]{}));
        keys.put(9, Arrays.asList(new Character[]{}));
    }
    public static void f1(FI fi, String s) {
        fi.print(s);
    }

    public static void main3(String[] args) {
        f1( (s)-> { System.out.println(s);}, "23" );


        float f = 3242.3f;
        double d = 2342.34;
        Double dd = 24234.0000003;
        Float ff = 24234.004f;
        System.out.println(dd);


        System.out.println(StrictMath.PI);
        System.out.println(Math.PI);
        String s = "atul" ;
        s = s + 'a';
        System.out.println(s);
        //s.concat('d');
        //for (char cs:s) {

        //}
        System.out.println(sortString(s));
        StringBuffer sb = new StringBuffer(s);
        char[] dst = new char[sb.length()];
        sb.getChars(0, sb.length(), dst, 0);
        System.out.println(Arrays.toString(dst));

        String[] strings = {
          "atul",
          "kumar",
          "kkk",
          "aaa"
        };

        System.out.println(Arrays.toString(s.getClass().getDeclaredFields()));
        Arrays.sort(strings);

        System.out.println(Arrays.toString(strings));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1]- b[1] : a[0] - b[0]);

        pq.add(new int[]{3,2});
        pq.add(new int[]{1,1});
        pq.add(new int[]{9,2});
        pq.add(new int[]{2,2});
        pq.add(new int[]{3,1});

        while(!pq.isEmpty()) {
            int[] data = pq.poll();
            System.out.println(data[0] + "," + data[1]);
        }
    }

    public static void main2(String[] args) {
        String[][] data = {{"Martha", "exit"},
                {"Paul", "enter"},
                {"Martha", "enter"},
                {"Steve", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Paul", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Paul", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Martha", "exit"},
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"}
        };

        String[][] result = badgeRead(data);
        System.out.println(Arrays.toString(result[0]));
        System.out.println(Arrays.toString(result[1]));
    }

    public static String[][] badgeRead(String[][] data) {
        Set<String> room = new HashSet<>();
        Set<String> enteredWrong = new HashSet<>();
        Set<String> exitedWrong = new HashSet<>();

        for(int i=0; i < data.length; i++) {
            String name = data[i][0];
            String logType = data[i][1];
            if (logType.equals("exit")) {
                if (room.contains(name)) {
                    room.remove(name);
                } else {
                    enteredWrong.add(name);
                }
            } else if (logType.equals("enter")) {
                if (room.contains(name)) {
                    exitedWrong.add(name);
                } else {
                    room.add(name);
                }
            }
        }
        for(String name:room) {
            exitedWrong.add(name);
        }

        String[][] result = new String[2][];
        result[0] = new String[exitedWrong.size()];
        result[1] = new String[enteredWrong.size()];
        int i = 0;
        for(String name:exitedWrong) {
            result[0][i++] = name;
        }
        i = 0;
        for(String name:enteredWrong) {
            result[1][i++] = name;
        }
        return result;
    }
}
