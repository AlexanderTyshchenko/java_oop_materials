package pro.tyshchenko.oop.threads.waitnotify;

import java.io.RandomAccessFile;

/**
 * @author Alexander Tyshchenko.
 */
public class WaitNotifyExample1 {

    public static void main(String[] args) {
        Data data = new Data();

        Processor processor = new Processor(data, "src/main/resources/concurrency/out.txt");
        processor.start();

        Preparer preparer = new Preparer(data, "src/main/resources/concurrency/in.txt");
        preparer.start();
    }


    private static final class Data {
        private byte[] data;

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            this.data = data;
        }
    }

    private static final class Preparer extends Thread {
        private final Data data;
        private final String file;

        public Preparer(Data data, String file) {
            this.data = data;
            this.file = file;
        }

        public void run() {

            byte[] buffer;

            System.out.println("Data is being prepared....");

            try {
                RandomAccessFile fs = new RandomAccessFile(file, "r");
                try {
                    buffer = new byte[(int) fs.length()];
                    fs.read(buffer);
                } finally {
                    fs.close();
                }
            } catch (Exception e) {
                buffer = null;
            }

            synchronized (data) {
                data.setData(buffer);
                data.notifyAll();
            }
        }
    }

    private static final class Processor extends Thread {
        private final Data data;
        private final String file;

        public Processor(Data data, String file) {
            this.data = data;
            this.file = file;
        }

        public void run() {
            System.out.println("Waiting for data...");

            synchronized (data) {
                try {
                    if (data.getData() == null) {
                        data.wait();
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }

            System.out.println("Got data. Processing it...");

            byte[] buffer = data.getData();

            try {
                RandomAccessFile f = new RandomAccessFile(file, "rw");
                try {
                    f.write(buffer);
                } finally {
                    f.close();
                }
            } catch (Exception e) {

            }
        }
    }


}
