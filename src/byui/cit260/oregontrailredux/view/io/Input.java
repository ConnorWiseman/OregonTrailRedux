package byui.cit260.oregontrailredux.view.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Handles obtaining input from whichever stream the class is configured to use.
 * By default, uses a BufferedReader wrapped around the System.in stream.
 *
 * @author Connor
 */
public abstract class Input {

    private final static BufferedReader IN
            = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Prompts for a string of input, then returns only the first character.
     *
     * @param prompt
     * @return
     * @throws IOException
     */
    public static char getChar(final String prompt) throws IOException {
        return Input.getString(prompt).charAt(0);
    }

    /**
     * Prompts for a string of input, then parses the result as an integer.
     *
     * @param prompt
     * @return
     * @throws IOException
     */
    public static int getInt(final String prompt) throws IOException {
        int result = 0;
        boolean valid = false;

        // Continue prompting for input as long as it is not a valid integer.
        while (!valid) {
            String input = Input.getString(prompt);

            try {
                result = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException e) {
                Output.println("Invalid input - please enter an integer.");
            }
        }

        return result;
    }

    /**
     * Prompts for a string of input.
     *
     * @param prompt
     * @return
     * @throws IOException
     */
    public static String getString(final String prompt) throws IOException {
        String input = null;

        // Continue prompting for input as long as the input is null or empty.
        while (input == null || input.isEmpty()) {
            Output.print(" > " + prompt + ' ');
            input = Input.IN.readLine().trim();

            if (input.length() < 1) {
                Output.println("Invalid input - please enter something.");
            }
        }

        return input;
    }
}
