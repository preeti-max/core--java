package MultiThreading.Threading;

import java.util.ArrayList;

class Height {
    int feet;
    int inches;

    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

    @Override
    public String toString() {
        return "Height [feet=" + feet + ", inches=" + inches + "]";
    }

}

abstract class Student {
    String name;
    Height height;
    String branch;

    Student() {

    }

    public Student(String name, Height height) {
        this.name = name;
        this.height = height;

    }

    public int compareByHeight(Student s1, Student s2) {
        if (s1.height.feet > s2.height.feet) {
            return 1;
        } else if (s1.height.feet < s2.height.feet) {
            return -1;
        } else {
            if (s1.height.inches < s2.height.inches) {
                return -1;
            } else if (s1.height.feet > s2.height.feet) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    @Override
    public String toString() {
        return "Student [branch=" + branch + ", height=" + height + ", name=" + name + "]";
    }

}

class EEEStudent extends Student {
    EEEStudent() {

    }

    public EEEStudent(String name, Height height) {
        super(name, height);
        this.branch = "EEE";
    }

}

class ECEStudent extends Student {

    public ECEStudent(String name, Height height) {
        super(name, height);
        this.branch = "ECE";
    }

}

class CSEStudent extends Student {

    public CSEStudent(String name, Height height) {
        super(name, height);
        this.branch = "CSE";
    }

}

class StudentAdministration {
    EEEStudent e = new EEEStudent();
    Student students[];

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public StudentAdministration(Student[] students) {
        this.students = students;
    }

    public void sortByHeight(Student s[]) {

        int n = s.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (e.compareByHeight(s[i], s[j]) < 0) {
                    Student temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }

    }

    public void displaySortedEEEStudents() {
        ArrayList<Student> eee = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            if (students[i].branch.equals("EEE")) {
                eee.add(students[i]);

            }
        }
        Student a[] = eee.toArray(new Student[eee.size()]);
        sortByHeight(a);
        int i = 0;

        synchronized (this) {
            while (i < a.length) {
                System.out.println((i + 1) + ":" + a[i++]);
                notifyAll();

                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }

        }

    }

    public void displaySortedECEStudents() {
        ArrayList<Student> ece = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            if (students[i].branch.equals("ECE")) {
                ece.add(students[i]);

            }
        }
        Student a[] = ece.toArray(new Student[ece.size()]);
        sortByHeight(a);
        int i = 0;

        synchronized (this) {
            while (i < a.length) {
                System.out.println((i + 1) + ":" + a[i++]);
                notifyAll();

                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException caught");
                }

            }

        }

    }

    public void displaySortedCSEStudents() {
        ArrayList<Student> cse = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            if (students[i].branch.equals("CSE")) {
                cse.add(students[i]);

            }
        }
        Student a[] = cse.toArray(new Student[cse.size()]);
        sortByHeight(a);
        int i = 0;

        synchronized (this) {
            while (i < a.length) {
                System.out.println((i + 1) + ":" + a[i++]);

                notifyAll();

                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException caught");
                }

            }

        }

    }

}

public class UniversityDriver {
    public static void main(String[] args) {

        EEEStudent s1 = new EEEStudent("Divya", new Height(5, 2));
        EEEStudent s2 = new EEEStudent("Arpit", new Height(5, 8));
        CSEStudent s3 = new CSEStudent("Ayushi", new Height(5, 5));
        CSEStudent s4 = new CSEStudent("Chirag", new Height(5, 7));
        ECEStudent s5 = new ECEStudent("Laxmi", new Height(4, 5));
        ECEStudent s6 = new ECEStudent("Parag", new Height(6, 1));
        Student student[] = new Student[] { s1, s2, s3, s4, s5, s6 };
        StudentAdministration admin = new StudentAdministration(student);
        Thread cseDept = new Thread() {
            public void run() {
                admin.displaySortedCSEStudents();
            }
        };
        Thread eceDept = new Thread() {
            public void run() {
                admin.displaySortedECEStudents();
            }
        };
        Thread eeeDept = new Thread() {
            public void run() {
                admin.displaySortedEEEStudents();
            }
        };
        cseDept.start();
        eceDept.start();
        eeeDept.start();

    }

}