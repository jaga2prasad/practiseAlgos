package com.jaga;

public class Test1 {
	public static void main(String[] args) {
		//String input = "(a b)";
		
		String[] arr = {"(a)","(a b)","(Manoj)","()","(a b(c d))","(a b (c d))"};
		for(int i=0;i<arr.length;i++){
			System.out.println(getModifiedString(arr[i]));
			System.out.println(flag(arr[i]));
		}
		
		System.out.println("======");
		
		for(int i=0;i<arr.length;i++){
			System.out.println(flag(arr[i]));
		}
		
		//System.out.println();
		
	}
	
	private static String getModifiedString(String input) {
		String output = input.replace("(", "[");
		output = output.replace(")", "]");
		output = output.replace(" ", ", ");	
		return output;
	}
	
	
	
	private static String flag(String input) {
		String output = "";
		String previous = "";
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)=='('){
				previous = Character.toString(input.charAt(i));
				
				if(previous.equals("^[Aa-zZ]")){
					output = output+", [";
				}else{
					output = output+"[";
				}
				
				
			} else if(input.charAt(i)==')'){
				previous = Character.toString(input.charAt(i));
				output = output+"]";
			} else if(input.charAt(i)==' '){
				previous = Character.toString(input.charAt(i));
				output = output+", ";
			} else {
				output = output+input.charAt(i);
			}
		}
		return output;
	}
	
	
}
