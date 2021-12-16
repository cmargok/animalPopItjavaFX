package application;

public class pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =(int) (Math.random() * 6);
		
		int b;
		do {
			b =(int) (Math.random() * 6);
		}while(a==b);
		
		System.out.println(a);
		System.out.println(b);

	}

}
