package MultiThreading;

class Height {
    int feet;
    int inches;

    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

}

class Student {
    String name;
    int rollNo;
    int age;
    double marks;
    Height height;

    public Student(String name, int rollNo, int age, double marks, Height height) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.marks = marks;
        this.height = height;
    }

    public static int compareByAge(Student s1, Student s2) {
        if (s1.age < s2.age)
            return -1;
        else if (s1.age > s2.age)
            return 1;
        else
            return 0;
    }

    public static int compareByMarks(Student s1, Student s2) {
        if (s1.marks < s2.marks)
            return -1;
        else if (s1.marks > s2.marks)
            return 1;
        else
            return 0;

    }

    public static int compareByHeight(Student s1, Student s2) {
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

    public Student[] sortAge(Student[] s1) {
        Student s[] = new Student[3];
        for (int i = 0; i < 3; i++) {
            s[i] = s1[i];
        }

        int n = s.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (compareByAge(s[i], s[j]) < 0) {
                    Student temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }

        return s;

    }

    public Student[] sortMarks(Student[] s1) {
        Student s[] = new Student[3];
        for (int i = 0; i < 3; i++) {
            s[i] = s1[i];
        }

        int n = s.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (compareByMarks(s[i], s[j]) < 0) {
                    Student temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
        return s;

    }

    public Student[] sortHeight(Student[] s1) {
        Student s[] = new Student[3];
        for (int i = 0; i < 3; i++) {
            s[i] = s1[i];
        }
        int n = s.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (compareByHeight(s[i], s[j]) < 0) {
                    Student temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }

        return s;

    }

    synchronized public void display(Student[] a) {
        System.out.println("age" + " " + "Marks" + " " + "Feet" + " " + "Inches");

        for (int i = 0; i < 3; i++) {

            System.out.println(
                    a[i].age + " \t" + a[i].marks + "\t " + a[i].height.feet + "\t " + a[i].height.inches + "\n");

        }

    }

}

public class Comparator {
    public static void main(String[] args) throws InterruptedException {
        Student s1 = new Student("Preeti", 1, 21, 90, new Height(5, 4));
        Student s2 = new Student("Pihu", 2, 22, 97, new Height(4, 9));
        Student s3 = new Student("Shreya", 3, 23, 75, new Height(5, 7));
        Student s[] = new Student[3];
        s[0] = s1;
        s[1] = s2;
        s[2] = s3;
        Student nStudent[][] = new Student[3][];

        Thread t1 = new Thread() {
            public void run() {

                nStudent[0] = s1.sortAge(s);
            }
        };
        Thread t2 = new Thread() {
            public void run() {

                nStudent[1] = s1.sortMarks(s);
            }
        };
        Thread t3 = new Thread() {
            public void run() {

                nStudent[2] = s1.sortHeight(s);
            }
        };
        Thread t4 = new Thread() {
            public void run() {

                s1.display(nStudent[0]);
            }

        };
        Thread t5 = new Thread() {
            public void run() {

                s1.display(nStudent[1]);
            }

        };
        Thread t6 = new Thread() {
            public void run() {

                s1.display(nStudent[2]);
            }

        };
        t1.start();
        t2.start();
        t3.start();

        t4.start();
        t5.start();
        t6.start();

    }

}
