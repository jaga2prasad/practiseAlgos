package com.jaga;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestRunReturn {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exe = Executors.newSingleThreadExecutor();
		Future<Integer> value = exe.submit(new Callable(){

			@Override
			public Integer call() throws Exception {
				return 2;
			}
			
		});
		
		System.out.println(value.get());
	}
}


