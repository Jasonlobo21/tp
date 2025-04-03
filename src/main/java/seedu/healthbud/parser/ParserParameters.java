package seedu.healthbud.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * ParserParameters provides utility methods for parsing command parameters.
 * This class includes a method to extract key-value pairs from a command input string.
 */
public class ParserParameters {

    /**
     * Parses the parameters from the given input string.
     * The method splits the input by whitespace and extracts key-value pairs where keys start with a '/'.
     *
     * @param input the input string containing parameters; must not be null.
     * @return a Map containing parameter keys and their corresponding values.
     */
    public static Map<String, String> parseParameters(String input) {
        assert input != null : "Input should not be null";

        Map<String, String> params = new HashMap<>();
        String[] tokens = input.split("\\s+");

        String currentKey = null;
        StringBuilder currentValue = new StringBuilder();

        for (String token : tokens) {
            if (token.startsWith("/")) {
                // Save previous key-value pair
                if (currentKey != null) {
                    params.put(currentKey, currentValue.toString().trim());
                    currentValue.setLength(0);
                }
                currentKey = token.substring(1); // Remove the '/'
            } else if (currentKey != null) {
                if (currentValue.length() > 0) {
                    currentValue.append(" ");
                }
                currentValue.append(token);
            }
        }
        // Add the last parameter
        if (currentKey != null) {
            params.put(currentKey, currentValue.toString().trim());
        }
        return params;
    }
}
