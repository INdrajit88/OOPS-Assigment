public class StringManipulator {
    /**
     * Deletes the m-th element (character) from the input string.
     *
     * @param str the input string
     * @param m   the index (0-based) of the character to be removed
     * @return the modified string with the m-th element removed
     * @throws IllegalArgumentException if m is out of bounds
     */
    public static String delete(String str, int m) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        if (m < 0 || m >= str.length()) {
            throw new IllegalArgumentException("Index m is out of bounds");
        }

        // Use substring to construct the new string without the m-th character
        return str.substring(0, m) + str.substring(m + 1);
    }

    public static void main(String[] args) {
        // Example usage
        String input = "Hello, World!";
        int indexToDelete = 7;

        try {
            String result = delete(input, indexToDelete);
            System.out.println("Original string: " + input);
            System.out.println("Modified string: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
