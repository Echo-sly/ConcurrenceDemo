/**
 * Demo ThreadDemo
 *
 * @author sunlianyu
 * @date 10月22日 22:01
 *
 * 两个线程交替打印
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Object o = new Object();
        Thread A = new Thread() {
            @Override
            public void run() {
                synchronized (o) {
                    while (true) {
                        System.out.println(this.getName());
                        o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread B = new Thread() {
            @Override
            public void run() {
                synchronized (o) {
                    while (true) {
                        System.out.println(this.getName());
                        o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        };
        A.start();
        B.start();
    }
}
