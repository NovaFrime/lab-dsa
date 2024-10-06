public class Student
{
    public String fname, type, lname;
    public int grade;
    
    public Student(String fname, String lname, int grade)
    {
        this.fname = fname;
        this.lname = lname;
        this.grade = grade;
        if  (grade > 89) {
            this.type = "excellent";
        } else if  (grade >= 60) {
            this.type = "ok";
        } else this.type = "failure";

    }

    public String toString()
    {
        return fname + " " + lname + "\t" + grade + "\t" + type;
    }
}
