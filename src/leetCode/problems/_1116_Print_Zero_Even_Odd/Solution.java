package leetCode.problems._1116_Print_Zero_Even_Odd;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
	private int n;
	private boolean zeroFlag ,even;
	private int count;
	public ZeroEvenOdd(int n) {
		this.n = n;
		zeroFlag = true;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {

		synchronized (this) {
			while (count<n) {
				while (!zeroFlag) {
					wait();
				}
				if(count<n) {
					printNumber.accept(0);
				}
				zeroFlag = !zeroFlag;
				if(count%2==0)
					even = false;
				else
                    even = true;
				notifyAll();
			}
		}

	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		synchronized (this) {
			while (count<n) {
				while (!even) {
					wait();
				}
				if(count<n) {
					printNumber.accept(++count);
				}
				zeroFlag = !zeroFlag;
				even = !even;
				notifyAll();
			}
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		synchronized (this) {
			while (count<n) { 
				while (zeroFlag||even) {
					wait();
				}
				if(count<n) {
					printNumber.accept(++count);
				}
				zeroFlag = !zeroFlag;
				notifyAll();
			}
		}
	}
}