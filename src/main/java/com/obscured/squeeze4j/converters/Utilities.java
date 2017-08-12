package com.obscured.squeeze4j.converters;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public class Utilities {

    /**
     * safe parse string to integer
     *
     * @param in the string to parse
     * @return integer or null
     */
    public static Integer tryParseInteger(String in) {
        return tryParseInteger(in, null);
    }

    /**
     * safe parse integer
     *
     * @param in  the string to parse
     * @param def default value if parse fails
     * @return parsed or default integer
     */
    public static Integer tryParseInteger(String in, Integer def) {
        Integer out;
        try {
            out = Integer.parseInt(in);
        } catch (NumberFormatException e) {
            out = def;
        }
        return out;
    }

    /**
     * Checks collection if null or empty
     *
     * @param c the collection to check
     * @return whether null or empty
     */
    public static <T> boolean isNullOrEmpty(Collection<T> c) {
        return c == null || c.isEmpty();
    }

    /**
     * Checks collection if null or empty
     *
     * @param c the collection to check
     * @return whether null or empty
     */
    public static <T> boolean isNotNullOrEmpty(Collection<T> c) {
        return !isNullOrEmpty(c);
    }

    /**
     * Checks collection if null or empty
     *
     * @param m the collection to check
     * @return whether null or empty
     */
    public static <K, V> boolean isNullOrEmpty(Map<K, V> m) {
        return m == null || m.isEmpty();
    }

    /**
     * Checks collection if null or empty
     *
     * @param m the collection to check
     * @return whether null or empty
     */
    public static <K, V> boolean isNotNullOrEmpty(Map<K, V> m) {
        return !isNullOrEmpty(m);
    }

    public static <T> boolean isNull(T v) {
        return v == null;
    }

    public static <T> boolean isNotNull(T v) {
        return !isNull(v);
    }

    /**
     * string is null or empty
     *
     * @param s the string to test
     * @return whether null or empty
     */
    public static boolean isNullOrEmpty(String s) {
        return StringUtils.isEmpty(s);
    }

    /**
     * string is not null or empty
     *
     * @param s the string to test
     * @returnwhether whether not null or empty
     */
    public static boolean isNotNullOrEmpty(String s) {
        return StringUtils.isNotEmpty(s);
    }

    public static boolean containsIgnoreCase(String s, String regex) {
        return contains(s, Pattern.compile(regex, Pattern.CASE_INSENSITIVE));
    }

    /**
     * String contains given regex with flags
     *
     * @param s     the input string
     * @param regex the regex
     * @param flags the pattern flags
     * @return whether contains regex
     */
    public static boolean contains(String s, String regex, int flags) {
        return contains(s, Pattern.compile(regex, flags));
    }

    /**
     * String contains given regex with default flags
     *
     * @param s     the input string
     * @param regex the regex
     * @return whether contains regex
     */
    public static boolean contains(String s, String regex) {
        return contains(s, Pattern.compile(regex));
    }

    /**
     * String contains pattern
     *
     * @param s   the input string
     * @param pat the regex pattern
     * @return whether contains pattern
     */
    public static boolean contains(String s, Pattern pat) {
        return pat.matcher(s).find();
    }
}
