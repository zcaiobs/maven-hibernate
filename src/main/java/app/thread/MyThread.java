package app.thread;

public class MyThread implements Runnable {

    private final char letter;
    private final int count;

    public MyThread(char letter, int count) {
        this.letter = letter;
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for(int n = 0; n < count; n ++) {
            System.out.print(letter);
        }
    }
}
