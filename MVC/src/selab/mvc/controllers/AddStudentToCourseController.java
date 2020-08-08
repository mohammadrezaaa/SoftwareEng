package selab.mvc.controllers;

import org.json.JSONObject;
import selab.mvc.models.DataContext;
import selab.mvc.views.View;

import java.io.IOException;
import java.io.InputStream;

public class AddStudentToCourseController extends Controller {
    ArrayList<Student> students;
    ArrayList<course> courses;


    public AddStudentToCourseController(DataContext dataContext) {

        super(dataContext);
        courses = dataContext.getCourses().getAll();
        students = dataContext.getStudents().getAll();

    }

    @Override
    public View exec(String method, InputStream body) throws IOException {
        if (!method.equals("POST"))
            throw new IOException("Method not supported");

        JSONObject input = readJson(body);
        String studentNo = input.getString("studentNo");
        String courseNo = input.getString("courseNo");
        String points = input.getString("points");

        student st = null;
        course C = null;
        for (Course course : courses){
            if (course.getCourseNo().equals(courseNo)){
                C = course;
                break;
            }
        }


        for (Student student : students){
            if (student.getStudentNo().equals(studentNo)){
                st = student;
                break;
            }
        }
        st.addCourse(c, points);
        C.addStudent(st,points );
        Map<String, String> result = new HashMap<>();
        result.put("success", "true");
        return new JsonView(new JSONObject(result));
    }
}
