class Student{
    int studentId;
    String studentName;

    Subject korea;
    Subject math;

    Student() {}

    Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;

        this.korea = new Subject();
        this.math = new Subject();
    }

	void setKoreaSubject(String name, int score) {
		korea.subjectName = name;
		korea.score = score;
	}
	
	void setMathSubject(String name, int score) {
		math.subjectName = name;
		math.score = score;
	}
	
	void showStudentSocre() {
		int total = korea.score + math.score;
		System.out.println(studentName +  " 학생의 총점은 " + total + "점 입니다." );
		
	}

}