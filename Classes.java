package sample;
public class Classes {
    String semester, section, grade, lastName;
    int course_ID, student_ID, year;

    public Classes(int course_ID, int student_ID, String section, int year, String semester, String grade){
        this.course_ID = course_ID;
        this.student_ID = student_ID;
        this.section = section;
        this.year = year;
        this.semester = semester;
        this.grade = grade;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getSemester() {
        return semester;
    }

    public String getSection() {
        return section;
    }

    public String getgrade() {
        return grade;
    }

    public int getCourse_ID() {
        return course_ID;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public int getYear() {
        return year;
    }
}