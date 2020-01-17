package leetCode.problems._1114_Print_in_Order;

import java.util.concurrent.atomic.AtomicInteger;

class Foo {
	AtomicInteger count=new AtomicInteger(0);
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count.set(2);
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	
        while(count.get()!=2) {
        	
        }
        	
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        count.set(3);
    }

    public void third(Runnable printThird) throws InterruptedException {
    	while(count.get()!=3){
    		
    	}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}