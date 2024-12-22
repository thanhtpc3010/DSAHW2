package com.example.dsahw2;

import Entity.Student;

public class InsertionSort {
    public static void sort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;

            // Di chuyển các phần tử có điểm lớn hơn `key` lên một vị trí
            while (j >= 0 && students[j].getScore() > key.getScore()) {
                students[j + 1] = students[j];
                j--;
            }

            // Chèn `key` vào vị trí đúng
            students[j + 1] = key;
        }
    }
}
