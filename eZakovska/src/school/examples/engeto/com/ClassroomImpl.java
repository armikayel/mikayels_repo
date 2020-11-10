package school.examples.engeto.com;

import java.util.ArrayList;

public class ClassroomImpl implements Classroom{

    private String name;
    ArrayList<StudentImpl> listOfStudents;

    public ClassroomImpl(String name, ArrayList<StudentImpl> listOfStudents){
        this.name = name;
        this.listOfStudents = listOfStudents;
    }

    public String getName() {
        return name;
    }

    public ArrayList<StudentImpl> getListOfStudents() {
        return listOfStudents;
    }

    @Override
    public void printAllSubjects() {

        ArrayList<SubjectImpl> listOfSubjects;
        ArrayList<String> finalArray = new ArrayList<String>();

        System.out.println("Výpis všech předmětů.");
        for (StudentImpl student: listOfStudents) {
            listOfSubjects = student.getListOfSubjects();
            for (SubjectImpl subject: listOfSubjects) {
                if (!finalArray.contains(subject.getSubjectName())) {
                    finalArray.add(finalArray.size() + 1, subject.getSubjectName());
                }
            }
        }
        System.out.println(finalArray.toString());
    }

    @Override
    public void printGradesOfSubjects() {

        ArrayList<SubjectImpl> listOfSubjects;
        ArrayList<String> finalArray = new ArrayList<String>();

        System.out.println("Výpis známek z předmětů.");
        for (StudentImpl student: listOfStudents) {
            listOfSubjects = student.getListOfSubjects();
            for (SubjectImpl subject: listOfSubjects) {
                System.out.println("student "+student.getName()+" má z"+subject.getSubjectName()+" známku: "+subject.getStudentsGrade());
            }
        }
    }

    @Override
    public void printAllStudents() {
        System.out.println("Výpis všech předmětů: "+listOfStudents.toString());
    }

    @Override
    public void printStudentsCountOnSubject() {

        ArrayList<SubjectImpl> listOfSubjects;
        ArrayList<String> finalArray = new ArrayList<String>();

        System.out.println("Výpis počtu žáků - předmět.");
        for (StudentImpl student: listOfStudents) {
            listOfSubjects = student.getListOfSubjects();
            for (SubjectImpl subject: listOfSubjects) {
                System.out.println("student "+student.getName()+" má z"+subject.getSubjectName()+" známku: "+subject.getStudentsGrade());
            }
        }
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
}
