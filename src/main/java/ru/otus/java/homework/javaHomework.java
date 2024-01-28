package ru.otus.java.homework;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class javaHomework {
    public static void main(String[] args) {

        var file = new File(System.getProperty("user.dir"));

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".txt");
            }
        };

        System.out.println("Список файлов: " + Arrays.stream(file.listFiles(filter)).map(it -> it.getName()).collect(Collectors.<String>toList()));


        System.out.println("Введите имя файла:");
        Scanner txt = new Scanner(System.in);
        String name = txt.nextLine();

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(name))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char)n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Введите текст для записи:");
        String data = txt.nextLine();

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(name))) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
