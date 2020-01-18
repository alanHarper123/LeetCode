package leetCode.problems._1115_Print_FooBar_Alternately;


class FooBar {
	private int n;
	private boolean flag=true;
	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			synchronized (this) {
				while (!flag) {
					try {
						wait();
					} catch (InterruptedException e) {}
				}
				// printFoo.run() outputs "foo". Do not change or remove this line.
				printFoo.run();
				flag = false;
				notifyAll();
			}

		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			synchronized (this) {
				while (flag) {
					try {
						wait();
					} catch (InterruptedException e) {}
				}
				// printBar.run() outputs "bar". Do not change or remove this line.
				printBar.run();
				flag = true;
				notifyAll();
			}
			
		}
	}
}