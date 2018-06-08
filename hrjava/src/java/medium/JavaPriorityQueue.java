package java.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.regex.Pattern;

class Student implements Comparable<Student> {
    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        if (this.cgpa == o.cgpa) {
            final int nameComp = this.getName().compareTo(o.getName());
            if (nameComp == 0)
                return this.id - o.id;

            return nameComp;
        }
        return (int) Math.signum(o.cgpa - this.cgpa);
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        final PriorityQueue<Student> queue = new PriorityQueue<>();

        for (String event : events) {
            final String[] params = event.split(Pattern.quote(" "));
            if (params[0].equals("ENTER")) {
                queue.add(new Student(Integer.valueOf(params[3]), params[1], Double.valueOf(params[2])));
            }

            if (params[0].equals("SERVED")) {
                queue.poll();
            }
        }

        final ArrayList<Student> students = new ArrayList<>();
        while (!queue.isEmpty())
            students.add(queue.poll());
        return students;
    }
}

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}