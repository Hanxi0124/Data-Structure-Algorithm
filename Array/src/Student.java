public class Student {
    private String name;
    private int score;
    public Student(String studentName, int studentScore){
        name = studentName;
        score = studentScore;
    }

    @Override
    public String toString() {
        return String.format("Student Name = %s, Score = %d\n", name, score);
    }

    public static void main(String[] args) {

        Array<Student> array = new Array<>();
        array.addLast(new Student("c", 100));
        array.addLast(new Student("a", 50));
        array.addFisrt(new Student("b", 70));
        System.out.println(array);
    }
}
