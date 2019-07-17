package extras.onidimensional_stencil;

import java.util.ArrayList;
import java.util.Arrays;

public class Sequential {
    private ArrayList<Float> data;
    private ArrayList<Float> data_temp;
    private double err = 1.0E-06;

    Sequential(ArrayList<Float> A) {
        this.data = A;
    }

    private boolean recalculate(int index) {
        if (!(index == 0 || index == this.data.size() - 1)) {
            float temp = (this.data.get(index - 1) + this.data.get(index + 1)) / 2;
            this.data_temp.add(temp);

            return !(this.data.get(index) - temp < this.err);
        }
        else {
            this.data_temp.add(this.data.get(index));
            return false;
        }
    }
    private void start(){
        print();
        this.data_temp = new ArrayList<>();
        boolean next = false;
        for (int i = 0; i < this.data.size(); i++) {
            if (recalculate(i)){
                next= true;
            }
        }
        this.data = this.data_temp;
        if (next) start();
    }

    public void print() {
        for (float i : data) {
            System.out.printf("%f ", i);
        }
        System.out.printf("%n");
    }

    public static void main(String[] args) {
        Sequential a = new Sequential(new ArrayList<Float>(Arrays.asList(1f, 2f, 2f, 1f)));
        a.start();
    }
}