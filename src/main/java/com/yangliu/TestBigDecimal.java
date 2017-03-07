package com.yangliu;

import java.math.BigDecimal;

public class TestBigDecimal {
	public static void main(String[] args) {
	    System.out.println(0.06+0.01);
	    System.out.println(1.0-0.42);
	    System.out.println(4.015*100);
	    System.out.println(303.1/1000);
	    
	    Double d = BigDecimal.valueOf(1.0).subtract(BigDecimal.valueOf(1.0)).doubleValue();
	    System.out.println( BigDecimal.valueOf(1.0).subtract(BigDecimal.valueOf(1.0)) );
	}
}
