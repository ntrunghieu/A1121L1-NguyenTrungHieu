package ss04_ClassObject_java.btap;

import java.util.Date;

public class ClassStopWatch {
    private Date startTime;
    private Date endTime;
    public  ClassStopWatch(){
         this.startTime=new Date();
    }
    public Date getStartTime(){
        return this.startTime;
    }
    public Date getEndTime(){
        this.endTime=new Date();
        return this.endTime;
    }
    public long getElapsedTime(Date start, Date end){
        long elapsed=end.getTime()-start.getTime();
        return elapsed;
    }

}
