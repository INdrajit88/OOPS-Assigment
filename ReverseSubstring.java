public class ReverseSubstring {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java ReverseSubstring <string> <start> <end>");
            System.exit(1);
        }

        String str = args[0];
        try {
            int start = Integer.parseInt(args[1]);
            int end = Integer.parseInt(args[2]);

            // Validate input indices
            if (start < 0 || end < 0 || start >= str.length() || end >= str.length() || start > end) {
                throw new IllegalArgumentException("Invalid indices: " + start + ", " + end);
            }

            // Extract substring and reverse it
            String subStr = str.substring(start, end + 1); // Include end index
            StringBuilder reversed = new StringBuilder(subStr).reverse();

            System.out.println(reversed.toString());

        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid input for start or end index. Please enter integers.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}