package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		
		try {
			demo();
		} 
		catch(Exception exp){
			System.out.println("I am inside catch block");
			System.out.println("Message is : "+exp.getMessage());
			System.out.println("Cause is : "+exp.getCause());
			exp.printStackTrace();
		}
		finally{
			System.out.println("I am inside finally block");
		}
	}
	
	public static void demo() throws Exception{
			System.out.println("Hello World...!");
			int i = 1/0;
			System.out.println("Completed");

	}

}
