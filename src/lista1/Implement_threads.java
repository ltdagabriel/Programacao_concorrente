package lista1;

public class Implement_threads extends Thread {
    private Contador cnt;

    public Implement_threads(Contador cnt){
        this.cnt = cnt;
    }
    public Implement_threads(){
    }


    public void run() {
        try {
            sleep(1);
            System.out.println("-: " + cnt.plus());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
