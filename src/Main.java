import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		referenceSample();
		hashCodeSample();
	}

	private static void hashCodeSample() {
		// TODO Auto-generated method stub
		HashMap<Address, Student> students = new HashMap<>();
		
		Student student = new Student("0001", "Zheng Huang", 16, new Address(319, "Weldrick Road E", "Richmond Hill", "L4C 0A7"));
		students.put(student.address, student);
		
		student = new Student("0002", "Student 2", 16, new Address(2, "street 2", "city 2", "postcode 2"));
		students.put(student.address, student);
		
		student = new Student("0003", "Student 3", 16, new Address(2, "street 3", "city 3", "postcode 4"));
		students.put(student.address, student);
		
		
		student = new Student("0004", "Student 4", 16, new Address(2, "street 4", "city 2", "postcode 4"));
		students.put(student.address, student);
		
		student = new Student("0005", "Student 5", 16, new Address(2, "street 5", "city 2", "postcode 5"));
		students.put(student.address, student);
		
		Address key = new Address(2, "street 4", "city 2", "postcode 4");
		
		student = students.get(key);
		
		System.out.println(student);
		
		MyHashMap students2 = new MyHashMap();
		
		try {
			student = new Student("0001", "Zheng Huang", 16, new Address(319, "Weldrick Road E", "Richmond Hill", "L4C 0A7"));
			students2.put(student.address, student);
			
			student = new Student("0002", "Student 2", 16, new Address(2, "street 2", "city 2", "postcode 2"));
			students2.put(student.address, student);
			
			student = new Student("0003", "Student 3", 16, new Address(2, "street 3", "city 3", "postcode 4"));
			students2.put(student.address, student);
			
			
			student = new Student("0004", "Student 4", 16, new Address(2, "street 4", "city 2", "postcode 4"));
			students2.put(student.address, student);
			
			student = new Student("0005", "Student 5", 16, new Address(2, "street 5", "city 2", "postcode 5"));
			students2.put(student.address, student);
			
			key = new Address(2, "street 4", "city 2", "postcode 4");
			
			student = (Student)students2.get(key);
			
			System.out.println(student);
		} catch (HashMapFullException ex) {
			System.out.println(ex.getMessage());
		}
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



class Student {
	String id;
	String name;
	int age;
	Address address;
	
	public Student(String id, String name, int age, Address address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + "," + this.name +"," + this.age +","+this.address;
	}
	
	
}


class Address {
	int streetNo;
	String street;
	String city;
	String postcode;
	
	public Address(int streetNo, String street, String city, String postcode) {
		this.streetNo = streetNo;
		this.street = street;
		this.city = city;
		this.postcode = postcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + streetNo;
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (streetNo != other.streetNo)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.streetNo +","+this.street+","+this.city+","+this.postcode;
	}
	
	
	
}