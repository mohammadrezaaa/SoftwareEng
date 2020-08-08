package selab.mvc.models.entities;

import selab.mvc.models.Model;

import java.util.regex.Pattern;

public class Student implements Model {
    private String name;
    private String studentNo;

    @Override
    public String getPrimaryKey() {
        return this.studentNo;
    }

    public void setName(String value) { this.name = value; }
    public String getName() { return this.name; }

    public void setStudentNo(String value) {
        if (!validateStudentNo(value))
            throw new IllegalArgumentException("The format is not correct");

        this.studentNo = value;
    }
    public String getStudentNo() { return this.studentNo; }

    public float getAverage() {
        int total = 0;
        for (Float point : points){
            total += point.floatValue();
        }
        return total/points.size();
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public addCourse(Course cu, String pi){
        this.courses.add(c);
        this.points.add(Float.parseFloat(pi));
    }
    /**
     *
     * @param studentNo Student number to be checeked
     * @return true, if the format of the student number is correct
     */
    private boolean validateStudentNo(String studentNo) {
        Pattern pattern = Pattern.compile("^[8-9]\\d{7}$");
        return pattern.matcher(studentNo).find();
    }
}
