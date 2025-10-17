package org.example.comparator;

public class ComparisonResult {
    private final int lineNumber;
    private final String file1Line;
    private final String file2Line;

    public ComparisonResult(int lineNumber, String file1Line, String file2Line) {
        this.lineNumber = lineNumber;
        this.file1Line = file1Line;
        this.file2Line = file2Line;
    }

    private String highlightDifferences(String s1, String s2) {
        StringBuilder highlighted1 = new StringBuilder();
        StringBuilder highlighted2 = new StringBuilder();

        int maxLen = Math.max(s1.length(), s2.length());
        for (int i = 0; i < maxLen; i++) {
            char c1 = i < s1.length() ? s1.charAt(i) : ' ';
            char c2 = i < s2.length() ? s2.charAt(i) : ' ';

            if (c1 != c2) {
                highlighted1.append('*').append(c1).append('*');
                highlighted2.append('*').append(c2).append('*');
            } else {
                highlighted1.append(c1);
                highlighted2.append(c2);
            }
        }

        return String.format("""
                < %s
                > %s
                """, highlighted1, highlighted2);
    }

    @Override
    public String toString() {
        if (file1Line.equals(file2Line)) {
            return String.format("Строка %d: совпадает", lineNumber);
        } else {
            return String.format("""
                Строка %d отличается:
                %s
                """, lineNumber, highlightDifferences(file1Line, file2Line));
        }
    }
}
