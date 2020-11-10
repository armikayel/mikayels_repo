package school.examples.engeto.com;

import java.util.ArrayList;

public interface School {

        // výpisy žáků
        public void printAllStudents();

        // výpis počet žáků - předmět
        public void printStudentsCountOnSubject();

        // výpis průměrů za předměty
        public void printAverageGradeOfSubjects();

        // výpis společných předmětů pro třídu
        public void printMandatoryClassroomSubjects();

        // výpis všech volitelných předmětů
        public void printAllVoluntarySubjects();
}
