/*
 *  Learning Project.
 */
package aula11;

public class Deadlock {

    static class Friend {

        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void curvar_se(Friend bower) {
            System.out.format("%s: %s" + "  curvou-se para mim!%n",
                    this.name, bower.getName());
            bower.curvar_se_devolta(this);
        }

        public synchronized void curvar_se_devolta(Friend bower) {
            System.out.format("%s: %s" + " curvou-se de volta para mim!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston  = new Friend("Gaston");

        new Thread(new Runnable() {
            public void run() {
                alphonse.curvar_se(gaston);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                gaston.curvar_se(alphonse);
            }
        }).start();
    }
}
