package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {

        StringBuilder stringBuilder = new StringBuilder();
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
            char currChar = source.charAt(i);
            boolean delimiterFound = false;

            for (String delimiter : delimiters) {
                if (source.startsWith(delimiter, i)) {
                    if (stringBuilder.length() > 0) {
                        substrings.add(stringBuilder.toString());
                        stringBuilder.setLength(0);
                    }

                    substrings.add(delimiter);
                    i += delimiter.length() - 1;
                    delimiterFound = true;
                    break;
                }
            }

            if (!delimiterFound) {
                stringBuilder.append(currChar);
            }
        }

        if (stringBuilder.length() > 0) {
            substrings.add(stringBuilder.toString());
        }

        return substrings;
    }
}
