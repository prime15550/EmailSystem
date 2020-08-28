//-----------------------------------------------------
// Title: Cmpe242 Email
// Author: Tunç Gürsoy
// ID: 64521827274
// Section: 2
// Assignment: 1
// Description: This class defines Email class
//-----------------------------------------------------
package Q1;


public class Email
{
   private String subject ;
   int ID ;
   private String message ;
   private int time ; //milliSeconds
    private boolean flag ; //flag true read ; flag false not read.
    Email(){}
    Email(int ID , String message,String subject, int time ) {

        setID(ID);
        setTime(time);
        setSubject(subject);
        setMessage(message);
        flag = false;

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
