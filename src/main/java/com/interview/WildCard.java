package com.interview;

//Didn't work
public class WildCard {

    /*

    s = "adceb"
    p = "*a*b"

    if letter same, move fwd
    if letter match with ?, move fwd
    if * matches
        check next character after * in p and s
        if found in both, proceed further
        else if found in p and not in s, return false
        else if next character is not there, return true
     */
    public static void main(String[] args) {
        WildCard wc = new WildCard();
        String s = "acdcb";
        String p = "a*c?b";
        System.out.println( wc.isMatch(s, p));
        //System.out.println( wc.isMatch("aa", "*"));
        //System.out.println( wc.isMatch("cb", "?a"));
        //System.out.println( wc.isMatch("aabb", "*a*b"));
        //System.out.println(wc.isMatch("adceb", "*a*b"));
    }

    public boolean isMatch(String s, String p) {
        boolean flag = doMatch(s, p, 0,0);
        return flag;
    }

    public boolean doMatch(String s, String p, int si, int pi) {

        if (si == s.length()) {
            if (pi == p.length())
                return true;
            return false;
        }
        if (pi == p.length()) {
            return false;
        }

        if (s.charAt(si) == p.charAt(pi)) {
            return doMatch(s,p,si+1, pi+1);
        }
        if (p.charAt(pi) == '?') {
            return doMatch(s,p,si+1,pi+1);
        }
        if (p.charAt(pi) == '*') {
            int next = pi + 1 ;

            if (next == p.length()) {
                return true;
            } else {
                char nextInP = p.charAt(next);
                //String sSubString = s.substring(si);
                int indexOfNextInP = s.indexOf(nextInP, si);
                if (indexOfNextInP == -1 ) {
                    return false;
                } else {
                    return doMatch(s, p, indexOfNextInP + 1, pi) || doMatch(s,p,indexOfNextInP, pi+1);
                }
            }
        }
        return false;
    }
}
