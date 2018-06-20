package org.java8.newfeature;

import java.util.ArrayList;

import java.util.function.Consumer;

public class ForEach {
	public static void main(String[] args) {
		ArrayList<Integer> arl = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			arl.add(i);
		}

		
		arl.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::" + t);
			}

		});
	}
}
