package com.jaga;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCB {
	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(3,new Runnable(){

			@Override
			public void run() {
				System.out.println("Main cyclic barier completes");
			}
			
		});
		
		Thread t = new Thread(new CB(cb));
		Thread t1 = new Thread(new CB(cb));
		Thread t2 = new Thread(new CB(cb));
		
		t.start();
		t1.start();
		t2.start();
	}
}

class CB implements Runnable{
	CyclicBarrier barrier;
	CB(CyclicBarrier cb) {
		this.barrier = cb;
	}
	
	public void produce() throws InterruptedException, BrokenBarrierException{
		System.out.println("Staring barrier");
		 barrier.await();
		 System.out.println("All threads came");
	}

	@Override
	public void run() {
		System.out.println("Staring barrier");
		 try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		 System.out.println("All threads came");
	}
}
