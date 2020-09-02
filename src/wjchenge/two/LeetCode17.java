package wjchenge.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @author wjchenge
 */
public class LeetCode17 {

    private static final Map<Character, char[]> map = new HashMap();

    static {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        this.process(digits, 0, res, new char[digits.length()]);
        return res;
    }

    private void process(String digits, int i, List<String> res, char[] chars) {
        if (i == digits.length()) {
            res.add(new String(chars));
            return;
        }

        char[] letters = map.get(digits.charAt(i));
        for (char c : letters) {
            chars[i] = c;
            this.process(digits, i + 1, res, chars);
            chars[i] = Character.MIN_VALUE;
        }
    }


}
