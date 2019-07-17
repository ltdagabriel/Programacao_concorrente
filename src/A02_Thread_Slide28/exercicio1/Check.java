package A02_Thread_Slide28.exercicio1;

class Check extends Thread {
    private Thread[] threads;

    Check(Thread[] threads) {
        this.threads = threads;
    }

    @Override
    public void run() {
        while (true) {
            for (Thread t : threads) {
                System.out.println(t.getState().toString());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
