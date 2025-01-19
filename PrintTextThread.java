public class PrintTextThread extends Thread {

    private String text;
    private int count;

    public PrintTextThread(String text, int count) {
        this.text = text;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static void main(String[] args) {
        PrintTextThread thread1 = new PrintTextThread("I am in FY", 10);
        PrintTextThread thread2 = new PrintTextThread("I am in SY", 20);
        PrintTextThread thread3 = new PrintTextThread("I am in TY", 30);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}