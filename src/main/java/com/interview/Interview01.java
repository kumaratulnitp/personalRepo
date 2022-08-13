package com.interview;


import java.util.Arrays;

/*


 */
public class Interview01 {

    public static void main(String[] argv) {
        String s = "\"Sue,\" Tom smiles, \"Selim smote us.\"";
        System.out.println(isPalindrome(s));
    }

    public static boolean isValid(char c) {
        if (c >= 'a' && c <= 'z')
            return true;
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }
    //s = "A man, a plan, a canal: Panama"
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i=0;
        int j=s.length() - 1;

        while( i <= j && i < s.length() && j >= 0) {
            char l = s.charAt(i);
            char r = s.charAt(j);

            while( i < j){
                l = s.charAt(i);
                if (isValid(l)) {
                    break;
                }
                i++;
            }

            while( j > i){
                r = s.charAt(j);
                if (isValid(r)) {
                    break;
                }
                j--;
            }

            if (i > j)
                return false;

            if (i == s.length() || j < 0 )
                return true;

            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }

        }
        return true;
    }

    public static void main2(String[] argv) {
    /*
    String[] counts = {
      "900,google.com",
      "60,mail.yahoo.com",
      "10,mobile.sports.yahoo.com",
      "40,sports.yahoo.com",
      "300,yahoo.com",
      "10,stackoverflow.com",
      "20,overflow.com",
      "5,com.com",
      "2,en.wikipedia.org",
      "1,m.wikipedia.org",
      "1,mobile.sports",
      "1,google.co.uk"
    };
    Map<String, Integer> result = parseAndMapCounts(counts);
    for(String key : result.keySet()) {
      System.out.println(key + ", " + result.get(key));
    }
    */

        String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
        String[] user2 = {"a", "/one", "/two"};
        String[] user3 = {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
        String[] user4 = {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
        String[] user5 = {"a"};
        String[] user6 = {"/pink", "/orange", "/six", "/plum", "/seven", "/tan", "/red", "/amber"};

        String[] result = longestCoStrings(user0, user0);

        System.out.println(Arrays.toString(result));
    }

    public static String[] longestCoStrings(String[] user1, String[] user2) {
        String[] result = new String[user1.length];
        int max = Integer.MIN_VALUE;

        int user1Idx = 0;
        int user2Idx = 0;
        int tempIndex = 0;
        String[] tempResult = new String[user1.length];
        for(int i=0; i < user2.length; i++) {
            user2Idx = i;
            while (user1Idx < user1.length && user2Idx < user2.length) {
                int count;
                if (!user1[user1Idx].equals(user2[user2Idx])) {
                    user1Idx++;
                } else {
                    count = 0;
                    tempIndex = 0;
                    tempResult = new String[user1.length];
                    while (user1Idx < user1.length && user2Idx < user2.length && user1[user1Idx].equals(user2[user2Idx])) {
                        count++;
                        tempResult[tempIndex++] = user1[user1Idx];
                        user1Idx++;
                        user2Idx++;
                    }

                    if (count > max) {
                        max = count;
                        result = tempResult;
                        //System.out.println(Arrays.toString(tempResult));
                    }

                }
            }
        }
        return result;
    }
}
