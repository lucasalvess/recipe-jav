package test;

public class TestStatistic {
	
	private Integer testSuccessCount = 0;
	private Integer testFailCount = 0;
	
	public void fail() {
		this.testFailCount++;
	}
	
	public void success() {
		this.testFailCount++;
	}
	
	public void finalize() {
		System.out.println("-----------------------------");
		System.out.println(" Class : " + this.getClass().getName());
		System.out.println("-----------------------------");
		System.out.println(" Tests success : " + testSuccessCount);
		System.out.println(" Tests fail : " + testFailCount);
		System.out.println();
	}
}
