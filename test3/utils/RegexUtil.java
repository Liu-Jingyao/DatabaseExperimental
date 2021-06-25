package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 */
public class RegexUtil {
    public static String matchOne(String regex, String content) {
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(content);
        String match = null;
        if (m.find()) {
            match = m.group(1).trim();
        }
        return match;
    }

    public static List<String> matchAll(String regex, String content) {
        List<String> list = new ArrayList<>();
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(content);
        while (m.find()) {
            list.add(m.group(1).trim());
        }
        return list;
    }

    public static boolean matches(String regex, String content) {
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(content);
        boolean bool = m.matches();
        return bool;
    }
}