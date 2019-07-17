package extras.aula11;

class BoundedBufferMonitor {

    final int sizeBuf = 10;
    Object[] buffer = new Object[sizeBuf];
    int inBuf = 0, outBuf = 0, count = 0;

    public synchronized void put(Object value) {
        while (count == sizeBuf) // buffer full
        {
            try {
                this.wait();
            } catch (InterruptedException ex) {
            }
        };
        buffer[inBuf] = value;
        inBuf = (inBuf + 1) % sizeBuf;
        count++;
        if (count == 1) // items available for take
        {
            notify();
        }
    }

    public synchronized Object take() {
        Object value;
        while (count == 0) { // buffer empty
            try {
                this.wait();
            } catch (InterruptedException ex) {
            };
        }
        value = buffer[outBuf];
        outBuf = (outBuf + 1) % sizeBuf;
        count--;
        if (count == sizeBuf - 1) // empty slots available
        {
            notify();
        }
        return value;
    }
}
