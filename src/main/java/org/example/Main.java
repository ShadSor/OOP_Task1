package org.example;

import org.example.comparator.FileComparator;
import org.example.comparator.ComparisonResult;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к первому файлу: ");
        String file1 = scanner.nextLine();

        System.out.print("Введите путь ко второму файлу: ");
        String file2 = scanner.nextLine();

        try {
            List<ComparisonResult> results = FileComparator.compareFiles(file1, file2);
            for (ComparisonResult r : results) {
                System.out.println(r);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файлов: " + e.getMessage());
        }
    }
}