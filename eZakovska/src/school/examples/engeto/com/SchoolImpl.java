package school.examples.engeto.com;

import java.util.ArrayList;

public class SchoolImpl implements School, Subject{

    private final String name = "ZŠ Javovská 14";

    ArrayList<StudentImpl> listOfStudents;
    ArrayList<ClassroomImpl> listOfClassrooms;

    public SchoolImpl(ArrayList<StudentImpl> listOfStudents, ArrayList<ClassroomImpl> listOfClassrooms){
        this.listOfStudents = listOfStudents;
        this.listOfClassrooms = listOfClassrooms;
    };

    @Override
    public void printAllStudents() {
        System.out.println(listOfStudents.toString());
    }

    @Override
    public void printStudentsCountOnSubject() {

    }

    @Override
    public void printAverageGradeOfSubjects() {

    }

    @Override
    public void printMandatoryClassroomSubjects() {

    }

    @Override
    public void printAllVoluntarySubjects() {

    }

    @Override
    public void AverageGradeAcrossClassYears() {

    }

    @Override
    public void StudentsCountAcrossClassYears() {

    }
}
