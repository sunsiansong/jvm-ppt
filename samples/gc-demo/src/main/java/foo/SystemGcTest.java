package foo;

import foo.domain.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by sunxiansong on 16/3/13.
 */
public class SystemGcTest {
    public static boolean pauseFlag = false;
    public static int sleep = 1;

    public static void main(String[] args) {
        RunThread runThread = new RunThread();
        runThread.start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String cmd = scanner.nextLine();
            if (cmd.equals("gc")) {
                System.gc();
            }else if (cmd.equals("pause")) {
                pauseFlag = !pauseFlag;
            }else if (cmd.equals("1")) {
                sleep = 1;
            }else if (cmd.equals("2")) {
                sleep = 2;
            }else {
                System.out.println("-");
            }
        }

    }
}

class RunThread extends Thread {

    private int count;

    @Override
    public void run() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File("RumThreadOut.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                Thread.sleep(SystemGcTest.sleep);
                if (!SystemGcTest.pauseFlag) {
                    new User("name" + count, count, "male", new Date());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                fileWriter.write(count+++"\r\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
