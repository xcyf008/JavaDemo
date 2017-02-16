package iodemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * JavaDemo
 * iodemo
 * Created by timothy on 16/8/13.
 */
public class ChannelDemo {

    public static void main(String[] args) {

        inputFileChannel();
    }

    private static void inputFileChannel() {

        File file = new File("./demo.txt");

        if (!file.exists() || !file.isFile()) {
            System.out.println("Invalid File");
            return;
        }

        try {
            try (FileInputStream fs = new FileInputStream(file);
                 FileChannel fc = fs.getChannel()) {

                ByteBuffer bu = ByteBuffer.allocate(100);
                long l = fc.read(bu);
                if (l > 0) {
                    bu.flip();
                    while (bu.hasRemaining()) {
                        System.out.println((char)bu.get());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
