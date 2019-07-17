/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras.aula11.ex01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Faça um programa usando Lock para simular a atualização de
 * um contador que  ́e acessado por múltiplas extras.threads.
 * O contador pode diminuir e aumentar.
 * 
 * @author a1816420
 */
public class Main {
    
    public static void main(String[] args) {
        Counter c = new Counter();
        for(int i = 0;i<10;i++){
            int finalI = i;
            new Thread(()->{
                c.add();
                if(finalI%2 == 0)
                    c.add();
                else
                    c.sub();
                System.out.println(c.get());
            }).start();
        }
        // TODO code application logic here
    }
}

class Counter{
    private Lock l = new ReentrantLock();
    private int cont = 0;
    
    public void add(){
        l.lock();
        try {
            cont++;
        } finally {
            l.unlock();
        }
    }
    public void sub(){
        l.lock();
        try {
            cont--;
        } finally {
            l.unlock();
        }
    }
    public int get(){
        l.lock();
        try {
            return cont;
        } finally {
            l.unlock();
        }
    }
    
}