package school.examples.engeto.com;

public class SubjectImpl implements Subject {

    private String subjectName;
    private boolean isMandatory;
    private Grades studentsGrade;

    public SubjectImpl(String subjectName, boolean isMandatory,Grades studentsGrade){
        this.subjectName = subjectName;
        this.isMandatory = isMandatory;
        this.studentsGrade = studentsGrade;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public Grades getStudentsGrade() {
        return studentsGrade;
    }

    // výpis průměru napříč všemi ročníky
    @Override
    public void AverageGradeAcrossClassYears() {

    }

    // výpis počtu žáků napříč všemi ročníky
    @Override
    public void StudentsCountAcrossClassYears() {

    }
}
