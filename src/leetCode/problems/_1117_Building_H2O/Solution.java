package leetCode.problems._1117_Building_H2O;

class H2O {
	private Boolean oxygenFlag;
	private Integer hydrogenCount;

	public H2O() {
		oxygenFlag = false;
		hydrogenCount = 0;
	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {


		synchronized (this) {
			while (hydrogenCount==2) {
				this.wait();
			}
			if (hydrogenCount<2) {
				hydrogenCount++;
				// releaseHydrogen.run() outputs "H". Do not change or remove this line.
				releaseHydrogen.run();
			}
			if(oxygenFlag&&hydrogenCount==2) {
				hydrogenCount=0;
				oxygenFlag=!oxygenFlag;
				this.notifyAll();
			}
		}
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		synchronized (this) {
			while (oxygenFlag) {
				this.wait();
			}
			if(!oxygenFlag) {
				// releaseOxygen.run() outputs "O". Do not change or remove this line.
				releaseOxygen.run();
				oxygenFlag=!oxygenFlag;
			}
			if(oxygenFlag&&hydrogenCount==2) {
				hydrogenCount=0;
				oxygenFlag=!oxygenFlag;
				this.notifyAll();
			}
		}
	}
}
