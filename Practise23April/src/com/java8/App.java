package com.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
	public static void main(String[] args) {
		List<Book> finalList = new ArrayList<>();
		finalList.addAll(createBookList());
		finalList.addAll(createBookListFlip());
		
		List<String> string = finalList.stream()
				                       .filter(b->b.getPrice()>4)
				                       .map(b->b.getName())
				                       .collect(Collectors.toList());
		
		Map<String, Object>test = finalList.stream().filter(b->b.getName().contains("jaga"))
		                  .collect(Collectors.groupingBy(Book::getPublisher,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingLong(b->b.getPrice())), Optional::get)));
		
		
		Map<String,Long> test1 = finalList.stream().collect(Collectors.groupingBy(Book::getPublisher,Collectors.summingLong(Book::getPrice)));
		
		
		//List<Book> test2 = finalList.stream().noneMatch(b->b.getPublisher().contains("Amazon"));
		//anyMatch,noneMatch,allMatch -> return boolean
		
		Optional<Book> test2 = finalList.stream().findAny().filter(b->b.getName().contains("Jaga"));
		
		if(test2.isPresent())
			System.out.println(test2+"jaga123456");

		
		System.out.println(test1);
		
		
		
		System.out.println(test);
		
		System.out.println(string);
		
		System.out.println(finalList);
		
		System.out.println("=====");
		
		finalList.forEach(d->System.out.println(d));
		
	}
	
	public static List<Book> createBookList(){
		List<Book> bookList = new ArrayList<>();
		Book b;
		for(int i=0;i<5;i++){
			b = new Book();
			b.setId(i);
			b.setName("jaga"+i);
			b.setPrice((long) (i+1));
			b.setPublisher("Amazon");
			bookList.add(b);
		}
		return bookList;
	}
	
	public static List<Book> createBookListFlip(){
		List<Book> bookList = new ArrayList<>();
		Book b;
		for(int i=0;i<5;i++){
			b = new Book();
			b.setId(i);
			b.setName("jaga"+i);
			b.setPrice((long)i+2);
			b.setPublisher("Flip");
			bookList.add(b);
		}
		return bookList;
	}
}
