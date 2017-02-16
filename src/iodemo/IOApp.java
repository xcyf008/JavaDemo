package iodemo;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.file.Files;

import static java.lang.System.out;

/**
 * JavaDemo
 * iodemo
 * Created by timothy on 16/8/9.
 */
public class IOApp {

    public static void main(String[] args) {

        charBufferDemo();
    }

    private static void filePath() {

        try {
            Files.list((new File(".")).toPath()).forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileDemo() {

        File file = new File(".");

        out.println(file.getName());
        out.println("Is directory: " + file.isDirectory());
        out.println("Is file: " + file.isFile());
        out.println("Absolution path: " + file.getAbsolutePath());
        try {
            out.println("Canonical path: " + file.getCanonicalPath());
            out.println("Parent path: " + file.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileOutputStreamDemo() {

        File file = new File("./demo.txt");
        try {
            try(FileOutputStream ot = new FileOutputStream(file)) {
                ot.write("Hello world".getBytes());
                ot.write("\r\n".getBytes());
                ot.write("Hello world".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileInputStreamDemo() {

        File file = new File("./demo.txt");
        if (file.isFile() && file.exists()) {
            try {
                try (FileInputStream inputStream = new FileInputStream(file)) {
                    byte[] data = new byte[(int) file.length()];
                    int i = inputStream.read(data);
                    out.println(file.length());
                    out.println(new String(data));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {

            out.println("file not exist");
        }
    }

    private static void fileWriterDemo() {

        File file = new File("./demo.txt");
        try {
            try(FileWriter fw = new FileWriter(file)) {
                fw.write("Doom");
                fw.write("\r\n");
                fw.write("Doom");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileReaderDemo() {

        File file = new File("./demo.txt");

        if (file.isFile() && file.exists()) {
            try {
                try (FileReader fr = new FileReader(file)) {
                    char[] data = new char[100];
                    int i = fr.read(data);
                    if (i >= 0) {
                        out.println(new String(data, 0, i));
                    } else {
                        out.println("File is empty!");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void charBufferDemo() {

        CharBuffer buffer = CharBuffer.allocate(100);
        buffer.put("hello, world");
        buffer.flip();
        while (buffer.hasRemaining()) {
            out.println(buffer.get());
        }
        buffer.clear().flip();
        out.println(buffer.flip().toString());
    }

}
