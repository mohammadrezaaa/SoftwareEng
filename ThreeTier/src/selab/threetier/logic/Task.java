package selab.threetier.logic;

import selab.threetier.storage.Storage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task extends Entity {
    private String title;
    private Date start;
    private Date end;

    public String getTitle() { return title; }
    public void setTitle(String value) { title = value; }

    public void setStart(Date value) { start = value; }
    public String getStartDate() {
        return new SimpleDateFormat("YYYY-MM-DD").format(start);
    }
    public String getStartTime() {
        return new SimpleDateFormat("HH:mm:ss").format(start);
    }

    public void setEnd(Date value) { end = value; }
    public String getEndTime() {
        return new SimpleDateFormat("HH:mm:ss").format(end);
    }
    public void getStart(){return this.start;}    //to get start time of the task
    public void getEnd(){return this.end;}

    public void save() {
        boolean has_overlap = false;
        for (Task task :getAll()){
            if (start.compareTo(task.getStart()) > 0){
                has_overlap = true;
                break;
            }
        }

        if (!has_overlap && start.compareTo(end) < 0 ){
            Storage.getInstace().getTasks().addOrUpdate(this);}
        }
    public static void deleteById(int id){
        Storage.getInstance().getTasks().addOrUpdate(this);
    }

    public static ArrayList<Task> getAll() {
        return Storage.getInstance().getTasks().getAll();
        Comparator<Task> cmp = new Comaparator<Task>(){
            @override
            public int compare(Task x, Task y){
                return (int) (x.getStart().compareTo(y.getStart()));
            }
        };
        tasks.sort(cmp);
        return tasks;




    }
}
