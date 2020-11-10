package school.examples.engeto.com;

import java.util.ArrayList;

public class StudentImpl implements Student {

    private String name;

    ArrayList<SubjectImpl> listOfSubjects;

    public StudentImpl (String name, ArrayList<SubjectImpl> listOfSubjects){
        this.name = name;
        this.listOfSubjects = listOfSubjects;
    }

    public String getName() {
        return name;
    }

    public ArrayList<SubjectImpl> getListOfSubjects() {
        return listOfSubjects;
    }

    @Override
    public void printAllSubjects() {
        System.out.println("Výpis všech předmětů: "+listOfSubjects.toString());
    }

    @Override
    public void printGradesOfSubjects() {
        System.out.println("Výpis známek z předmětů.");
        for (SubjectImpl subject: listOfSubjects) {
            System.out.println("Předmět: "+subject.getSubjectName()+" za "+subject.getStudentsGrade());
        }
    }

    @Override
    public void printAllStudents() {
        System.out.println("Výpis jména studenta.");
        System.out.println(name);
    }

    @Override
    public void printStudentsCountOnSubject() {
        System.out.println("Výpis počtu žák - předmět.");
        for (SubjectImpl subject: listOfSubjects) {
            System.out.println("Předmět: "+subject.getSubjectName()+" počet: 1");
        }
    }

    @Override
    public void printAverageGradeOfSubjects() {
        Grades subjectGrade;
        int numberGrade = 0;
        System.out.println("Výpis průměrů za předměty.");
        for (SubjectImpl subject: listOfSubjects) {
            subjectGrade = subject.getStudentsGrade();
            numberGrade += subjectGrade.ordinal();
        }
        System.out.println(numberGrade/listOfSubjects.size());
    }

    @Override
    public void printMandatoryClassroomSubjects() {
        System.out.println("Výpis společných předmětů studenta.");
        for (SubjectImpl subject: listOfSubjects) {
            if (subject.isMandatory()) {
                System.out.println(subject.getSubjectName());
            }
        }
    }

    @Override
    public void printAllVoluntarySubjects() {
        System.out.println("Výpis volitelných předmětů studenta.");
        for (SubjectImpl subject: listOfSubjects) {
            if (!subject.isMandatory()) {
                System.out.println(subject.getSubjectName());
            }
        }
    }
}
