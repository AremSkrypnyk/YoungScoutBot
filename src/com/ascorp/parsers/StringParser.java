package com.ascorp.parsers;

public class StringParser {

    public static String getTextBetweenString(String inputText, String string1, String string2) {
        return inputText
                .substring(inputText.indexOf(string1) +
                                string1.length(),
                        inputText.indexOf(string2));
    }

    public static long countNumberOfFirstSymbolInString(String sourceString) {
        String finalOutput = sourceString;
        return sourceString.chars().filter(ch -> ch == finalOutput.charAt(0)).count();
    }

    public static String removeFirstSymbolFromString(String sourceString) {
        return sourceString.replace(sourceString.charAt(0) + "", "");
    }
}
