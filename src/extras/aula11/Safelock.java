/*
 *  Learning Project.
 * Let's use Lock objects to solve the deadlock problem we saw in Liveness.
 * Alphonse and Gaston have trained themselves to notice when a friend is about
 * to bow. We model this improvement by requiring that our Friend objects must 
 * acquire locks for both participants before proceeding with the bow. Here is
 * the source code for the improved model, Safelock. To demonstrate the
 * versatility of this idiom, we assume that Alphonse and Gaston are so infatuated 
 * with their newfound ability to bow safely that they can't stop bowing to each other. 
 */
package extras.aula11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

public class Safelock {

    static class Friend {

        private final String name;
        private final Lock lock = new ReentrantLock();

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public boolean bloqueandoCurvar(Friend bower) {
            Boolean myLock = false;
            Boolean yourLock = false;
            try {
                myLock = lock.tryLock();
                yourLock = bower.lock.tryLock();
            } finally {
                if (!(myLock && yourLock)) {
                    if (myLock) {
                        lock.unlock();
                    }
                    if (yourLock) {
                        bower.lock.unlock();
                    }
                }
            }
            return myLock && yourLock;
        }

        public void curvar_se(Friend bower) {
            if (bloqueandoCurvar(bower)) {
                try {
                    System.out.format("%s: %s curvou-se para mim!%n",
                            this.name, bower.getName());
                    bower.curvar_se_devolta(this);
                } finally {
                    lock.unlock();
                    bower.lock.unlock();
                }
            } else {
                System.out.format("%s: %s começou"
                        + " curvar-se para mim, mas percebeu"
                        + " que eu já estava curvando para "
                        + " ele.%n",
                        this.name, bower.getName());
            }
        }

        public void curvar_se_devolta(Friend bower) {
            System.out.format("%s: %s curvou-se de volta para mim!%n",
                    this.name, bower.getName());
        }
    }

    static class BowLoop implements Runnable {

        private Friend bower;
        private Friend bowee;

        public BowLoop(Friend bower, Friend bowee) {
            this.bower = bower;
            this.bowee = bowee;
        }

        public void run() {
            Random random = new Random();
            for (;;) {
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                }
                bowee.curvar_se(bower);
            }
        }
    }

    public static void main(String[] args) {
        final Friend alphonse
                = new Friend("Alphonse");
        final Friend gaston
                = new Friend("Gaston");
        new Thread(new BowLoop(alphonse, gaston)).start();
        new Thread(new BowLoop(gaston, alphonse)).start();
    }
}
