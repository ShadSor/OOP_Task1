package org.example.comparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileComparator {

    public static List<ComparisonResult> compareFiles(String path1, String path2) throws IOException {
        List<String> lines1 = FileUtils.readFileLines(path1);
        List<String> lines2 = FileUtils.readFileLines(path2);

        int max = Math.max(lines1.size(), lines2.size());
        List<ComparisonResult> results = new ArrayList<>();

        for (int i = 0; i < max; i++) {
            String l1 = i < lines1.size() ? lines1.get(i) : "<нет строки>";
            String l2 = i < lines2.size() ? lines2.get(i) : "<нет строки>";

            results.add(new ComparisonResult(i + 1, l1, l2));
        }

        return results;
    }

    public static void displayDifferences(String path1, String path2) throws IOException {
        List<ComparisonResult> results = compareFiles(path1, path2);

        System.out.println("Сравнение файлов " + path1 + " и " + path2 + ":");
        for (ComparisonResult result : results) {
            System.out.println(result);
        }
    }
}

