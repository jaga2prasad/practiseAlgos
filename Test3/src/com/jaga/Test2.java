package com.jaga;

public class Test2 {
	public static void main(String[] args) {
		String deviceVersion = null;
		String[] deviceVersionArray = deviceVersion.split("\\.");
        String regex = "\\d+";
        Integer majorVersion = Integer.MIN_VALUE;
        Integer minorVersion = Integer.MIN_VALUE;
        if (deviceVersionArray != null && deviceVersionArray[0] != null
                && deviceVersionArray[0].matches(regex)) {
            majorVersion = Integer.parseInt(deviceVersionArray[0].trim());
        }
        if (deviceVersionArray != null && deviceVersionArray.length >= 2 && deviceVersionArray[1] != null
                && deviceVersionArray[1].matches(regex)) {
            minorVersion = Integer.parseInt(deviceVersionArray[1].trim());
        }
        
        if(majorVersion > 8) {
        	System.out.println("device version is greater than 8.5");
        } else if (majorVersion == 8 && minorVersion >= 5) {
        	System.out.println("device version is greater than 8.5 =====");
        } else {
        	System.out.println("device version is less than 8.5");
        }
	}
}
