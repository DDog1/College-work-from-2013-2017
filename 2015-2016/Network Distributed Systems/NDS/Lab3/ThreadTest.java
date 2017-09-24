class A extends Thread
{
	public void run()
	{
		System.out.println("Thread A started");
		for(int i=1;i<=5;i++)
		{
			System.out.println("\t From ThreadA: i="+i);
		}
		System.out.println("Exit from A");
	}
}

class B extends Thread
{
	public void run()
	{
		System.out.println("Thread B started");
		for(int i=1;i<=5;i++)
		{
			System.out.println("\t From ThreadB: i="+i);
		}
		System.out.println("Exit from B");
	}
}

class C extends Thread
{
	public void run()
	{
		System.out.println("Thread C started");
		for(int i=1;i<=5;i++)
		{
			System.out.println("\t From ThreadC: i="+i);
		}
		System.out.println("Exit from C");
	}
}

class ThreadTest
{
	public static void main(String[]args)
	{
		A threadA = new A();
		B threadB = new B();
		C threadC = new C();
		threadC.setPriority(Thread.MAX_PRIORITY);
		threadB.setPriority(threadA.getPriority()+1);
		threadA.setPriority(Thread.MIN_PRIORITY);

		System.out.println("Started Thread A");
		threadA.start();
		time();
		System.out.println("Started Thread B");
		threadB.start();
		time();
		System.out.println("Started Thread C");
		threadC.start();
		time();
		System.out.println("End of main thread");

	}

	public static void time()
	{
		try{
			Thread.sleep(100);
		}
		catch(Exception x){

		}
	}
}