package com.leetcode.section1;

/**
 Given an integer, convert it to a roman numeral.
 Input is guaranteed to be within the range from 1 to 3999.
 *
 * @author alexsong
 * @version $Id: Solution012.java, v 0.1 2017年11月21日 上午11:07:07 alexsong Exp $
 */
public class Solution012 {
    public String intToRoman(int num) {
        String[][] str = {{"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}};

        StringBuilder sb = new StringBuilder("");
        sb.append(str[3][num/1000%10]);
        sb.append(str[2][num/100%10]);
        sb.append(str[1][num/10%10]);
        sb.append(str[0][num%10]);

        return sb.toString();
    }

    public static void main(String[] args){
        Solution012 s012 = new Solution012();
        System.out.print(s012.intToRoman(1976));
    }
}
