class Student {
  private int matrikelNr;
  private String name;

  public Student(int matrikelNr, String name) {
    this.setMatrikelNr(matrikelNr);
    this.setName(name);
  }

  public int getMatrikelNr() {
    return matrikelNr;
  }

  public void setMatrikelNr(int matrikelNr) {
    this.matrikelNr = matrikelNr;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static boolean add(Student[] students, Student student) {
	  if(students == null || students.length == 0) {
		  students = new Student[4];
	  }
	  for(int i = 0; i < students.length; i++) {
		  if(students[i] == null) {
			  students[i] = student;
			  return true;
		  }
	  }
	  return false;
  }
  
  public static void anonymize(Student[] students, int matrikelNr) {
	  for(Student s : students) {
		  if(s != null && s.getMatrikelNr() == matrikelNr){
			  s.setName("XXX");
		  }
	  }
  }

  public static Student anonymize2(Student[] students, int matrikelNr) {
	  for(Student s : students) {
		  if(s != null && s.getMatrikelNr() == matrikelNr){
			  return new Student(s.getMatrikelNr(),"XXX");
		  }
	  }
	  return null;
  }

  // Gibt alle Studenten eines übergebenen Arrays aus
  public static void printStudents(Student[] students) {
    if (students != null) {
      for (int i = 0; i < students.length; i++) {
        if (students[i] != null)
          System.out.println(students[i].toString());
      }
    }
  }

  public String toString() {
    return "Student mit Mat.Nr." + this.getMatrikelNr() + ": " + this.getName() + " angemeldet.";
  }

  public static void main(String[] args) {
    Student[] students = new Student[4];
    System.out.println(">>>> Ausgabe 1");
    add(students, new Student(1, "Harry Potter"));
    add(students, new Student(2, "Matthias chmidt"));
    printStudents(students);

    System.out.println("\n>>>> Ausgabe 2");
    add(null, new Student(3, "Martina Maier"));
    add(students, new Student(4, "Klaus Huber"));
    printStudents(students);

    System.out.println("\n>>>> Ausgabe 3");
    Student studentCp = anonymize2(students, 4);
    anonymize(students, 1);
    printStudents(students);

    System.out.println("\n>>>> Ausgabe 4");
    System.out.println(studentCp.toString());
  }
}