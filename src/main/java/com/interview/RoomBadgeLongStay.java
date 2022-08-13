package com.interview;

import java.util.*;

/*
We are working on a security system for a badged-access room in our company's building.

We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry times over a single day. Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".

Write a function that finds anyone who badged into the room three or more times in a one-hour period.
Your function should return each of the employees who fit that criteria,
plus the times that they badged in during the one-hour period.
If there are multiple one-hour periods where this was true for an employee, just return the earliest one for that employee.

badge_times = {
{"Paul", "1355"},
{"Jennifer", "1910"},
{"John", "835"},
{"John", "830"},
{"Paul", "1315"},
{"John", "1615"},
{"John", "1640"},
{"Paul", "1405"},
{"John", "855"},
{"John", "930"},
{"John", "915"},
{"John", "730"},
{"John", "940"},
{"Jennifer", "1335"},
{"Jennifer", "730"},
{"John", "1630"},
{"Jennifer", "5"}
}

Expected output (in any order)
John: 830 835 855 915 930
Paul: 1315 1355 1405

n: length of the badge records array

 */
public class RoomBadgeLongStay {

    public static void main(String[] args) {

        String ss = String.valueOf(1) + String.valueOf(3.001) ;
        System.out.println(ss);
        String[][] badge_times = {
                {"Paul", "1355"},
                {"Jennifer", "1910"},
                {"John", "835"},
                {"John", "830"},
                {"Paul", "1315"},
                {"John", "1615"},
                {"John", "1640"},
                {"Paul", "1405"},
                {"John", "855"},
                {"John", "930"},
                {"John", "915"},
                {"John", "730"},
                {"John", "940"},
                {"Jennifer", "1335"},
                {"Jennifer", "730"},
                {"John", "1630"},
                {"Jennifer", "005"}
        } ;
        List<String> result = f1(badge_times);
        System.out.println(result);
    }

    public static int getMins(String s) {
        while(s.length() < 4) {
            s = "0" + s;
        }
        int len = s.length();
        int mins = Integer.parseInt(s.substring(len-2)) + 60*Integer.parseInt(s.substring(0, len-2));
        return mins;
    }

    public static int diff(String s1, String s2) {
        int min1 = getMins(s1);
        int min2 = getMins(s2);
        return Math.abs(min1-min2);
    }

    public static String getFormatted(int min) {
        String num = String.valueOf(min/60) + String.valueOf(min%60);
        return num;
    }

    public static List<String> f1(String[][] badgeTimes) {
        Map<String, PriorityQueue<Integer>> badgeMap = new HashMap<>();
        for(String[] badgeTime:badgeTimes) {
            PriorityQueue<Integer> data = badgeMap.getOrDefault(badgeTime[0], new PriorityQueue<>());
            int len = badgeTime[1].length();
            int mins = Integer.parseInt(badgeTime[1].substring(len-2)) + 60*Integer.parseInt(badgeTime[1].substring(0, len-2));
            data.add(mins);
            badgeMap.put(badgeTime[0], data);
        }

        List<String> result = new ArrayList<>();

        Deque<Integer> dq;

        for(String key: badgeMap.keySet()) {
            dq = new LinkedList<>();
            dq.offerLast(badgeMap.get(key).poll());
            while(!badgeMap.get(key).isEmpty()) {
                int lastData = badgeMap.get(key).poll();

                if (lastData - dq.peekFirst() > 60) {
                    if (dq.size() >= 3) {
                        String text = key + ":" ;
                        while(!dq.isEmpty()) {
                            text += getFormatted(dq.pollFirst()) + ",";
                        }
                        result.add(text);
                        break;
                    } else {
                        dq.pollFirst();
                    }
                }
                dq.offerLast(lastData);
            }

            if (dq.size() >= 3) {
                String text = key + ":" ;
                while(!dq.isEmpty()) {
                    text += dq.pollFirst() + ",";
                }
                result.add(text);
            }
        }
        
        return result;
    }

}

























