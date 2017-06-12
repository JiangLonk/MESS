package java8.lambda;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class Print_ab {

	public static boolean sprinta() {
		System.out.print("a");
		return false;
	}
	
	private boolean innerfeild = false;
	
	public boolean getInnerfeild() {
		return innerfeild;
	}

	public void setInnerfeild(boolean innerfeild) {
		this.innerfeild = innerfeild;
	}

	public static void main(String[] args) {

		if (new Print_ab() { public boolean printa() { System.out.print("a"); return getInnerfeild(); } }.printa()) {
			System.out.println("a");
		} else {
			System.out.println("b");
		}
		
		if (!System.out.printf("a").equals(System.out.printf(""))) {
			System.out.println("a");
		} else {
			System.out.println("b");
		}
		
		if (sprinta()) {
			System.out.println("a");
		} else {
			System.out.println("b");
		}

		if (((BooleanSupplier) (() -> { System.out.print("a"); return false; })).getAsBoolean()) {
			System.out.println("a");
		} else {
			System.out.println("b");
		}
		if (((Supplier<Boolean>) (() -> { System.out.print("a"); return false; })).get()) {
			System.out.println("a");
		} else {
			System.out.println("b");
		}

		if (new Object() { public boolean printa() { System.out.println("ab"); throw new RuntimeException(); } }.printa()) {
			System.out.println("a");
		} else {
			System.out.println("b");
		}
	}
}
