public class EjemploHilos{
	public static void main(String[] args) {
		Factorial F1=new Factorial(5);
		Factorial F2=new Factorial(6);
		F1.start();
		F2.start();
		Factorial2 F3=new Factorial2(7);
		Factorial2 F4=new Factorial2(4);
		Thread t1=new Thread(F3);
		Thread t2=new Thread(F4);
		t1.start();
		t2.start();
	}

}

class Factorial extends Thread{

	int x;

	Factorial(int xVal){
		this.x=xVal;
	}
    
    public int computeFactorial(int x){
    	if (x<=1){
    		return x;
    	}
    	else{
    		return x*computeFactorial(x-1);
    	}
    }
    
	public void run(){
		int y=computeFactorial(x);
		System.out.println("Factorial de:"+x+" es:"+y);
	}
}


class Factorial2 implements Runnable{

	int x;

	Factorial2(int xVal){
		this.x=xVal;
	}

	public int computeFactorial(int x){
    	if (x<=1){
    		return x;
    	}
    	else{
    		return x*computeFactorial(x-1);
    	}
    }

	 @Override  
    public void run() {  
		int y=computeFactorial(x);
		System.out.println("Factorial de:"+x+" es:"+y);    
	}  

}

