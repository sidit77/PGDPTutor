public class Person {
	private String vorname;
	private String nachname;

	Person(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}


	public boolean equals(Person obj) {
		return obj.vorname.equals(this.vorname) 
				&& obj.nachname.equals(this.nachname);
	}
	
	
	
}