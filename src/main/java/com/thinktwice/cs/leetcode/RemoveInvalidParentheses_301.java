package com.thinktwice.cs.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses_301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        dfs(res, s, new char[]{'(', ')'}, 0, 0);
        return res;
    }

    private void dfs(List<String> res, String s, char[] p, int iStart, int jStart) {
        // find 1st invalid p[1]
        int stack = 0, i;
        for (i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == p[0]) stack++;
            if (s.charAt(i) == p[1]) stack--;
            // remove each (not consecutive) p[1] from jStart to i to make valid
            if (stack < 0) {
                for (int j = jStart; j <= i; j++) // <=
                    if (s.charAt(j) == p[1] && (j == jStart || s.charAt(j - 1) != p[1])) {
                        String r = s.substring(0, j) + s.substring(j + 1);
                        dfs(res, r, p, i, j);
                    }
                return; // important!!
            }
        }
        // stack >= 0 : try reverse s and re-do DFS; if already reversed, then add to res
        String reverse = new StringBuilder(s).reverse().toString();
        if (p[0] == '(')
            dfs(res, reverse, new char[]{')', '('}, 0, 0); // important: 0, 0
        else
            res.add(reverse);
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses_301 a = new RemoveInvalidParentheses_301();
        a.removeInvalidParentheses("(5(0)(4)))))");
        System.out.println("");
    }
}
