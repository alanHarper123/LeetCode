package leetCode.problems._1195_Fizz_Buzz_Multithreaded;

import java.util.function.IntConsumer;

class FizzBuzz {
	private int n;
	private int counter = 1;
	public FizzBuzz(int n) {
		this.n = n;
	}

	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		synchronized (this) {
			while (counter<=n) {
				if(counter%3==0&&counter%5!=0) {
					printFizz.run();
					counter++;
					this.notifyAll();
				}else {
					this.wait();
				}
			}	
		}
	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		synchronized (this) {
			while (counter<=n) {
				if(counter%3!=0&&counter%5==0) {
					printBuzz.run();
					counter++;
					this.notifyAll();
				}else {
					this.wait();
				}
			}	
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		synchronized (this) {
			while (counter<=n) {
				if(counter%5==0&&counter%3==0) {
					printFizzBuzz.run();
					counter++;
					this.notifyAll();
				}else {
					this.wait();
				}
			}	
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		synchronized (this) {
			while (counter<=n) {
				if(counter%5!=0&&counter%3!=0) {
					printNumber.accept(counter++);
					this.notifyAll();
				}else {
					this.wait();
				}
			}	
		}
	}
}
