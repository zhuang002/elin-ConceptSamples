
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		referenceSample();
		hashCodeSample();
	}

	private static void hashCodeSample() {
		// TODO Auto-generated method stub
		
	}

	private static void referenceSample() {
		// TODO Auto-generated method stub
		System.out.println("reference samples ...");
		int a=2;
		changeInt(a);
		System.out.println(a);
		
		AnInteger b = new AnInteger();
		b.b=2;
		changeInt(b);
		System.out.println(b);
		
		
		AnInteger i= new AnInteger();
		i.b=2;
		AnInteger j;
		j=i;
		System.out.println((i==j));
		
		j = new AnInteger();
		j.b = 2;
		System.out.println((i==j));
		
		
		System.out.println(i.equals(j));
	}

	private static void changeInt(AnInteger b) {
		// TODO Auto-generated method stub
		b.b = b.b+1;
	}

	private static void changeInt(int a) {
		// TODO Auto-generated method stub
		a=a+1;
	}

}



class AnInteger {
	int b;
	
	@Override
	public String toString() {
		return ""+b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + b;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnInteger other = (AnInteger) obj;
		if (b != other.b)
			return false;
		return true;
	}

	
	
	
}