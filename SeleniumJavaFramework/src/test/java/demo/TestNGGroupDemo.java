package demo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

@Test(groups = {"AllClassTests"})
public class TestNGGroupDemo {

	@Test(groups = {"sanity"})
	public void test1(){
		System.out.println("This is Test 1 ");
	}
	@Test(groups = {"sanity", "windows.regression"})
	public void test2(){
		System.out.println("This is Test 2 ");
	}
	@Test(groups = {"linux.regression"})
	public void test3(){
		System.out.println("This is Test 3 ");
	}
	@Test
	public void test4(){
		System.out.println("This is Test 4 ");
	}
}
