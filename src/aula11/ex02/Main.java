/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11.ex02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Crie uma classe SharedFifoQueue e use Conditions para controlar se a fila está vazia
 * ou cheia. Teste usando threads produtoras e consumidoras.
 * 
 * @author a1816420
 */
public class Main {
    
}

class SharedFifoQueue{
    final Lock l;
    final Condition c;
    final Object[] items;
    SharedFifoQueue(int size) {
        this.l = new ReentrantLock();
        this.c = l.newCondition();
        this.items = new Object[size];
    }
    boolean isFull(){
        
    }
    
    
    
}
