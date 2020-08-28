//-----------------------------------------------------
// Title: Cmpe242 LinkedList
// Author: Tunç Gürsoy
// ID: 64521827274
// Section: 2
// Assignment: 1
// Description: This class defines Linkedlist and basic operation tester.
//-----------------------------------------------------
package Q1;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class LinkedListOfEmailsTester
{

    @org.junit.Test
    //Tests Email add
    //Result : It is passed.
    public void addEmail()
    {
        LinkedListOfEmails testInbox = new LinkedListOfEmails();
        Email newTestEmail = new Email(1234,"This is a welcome email from the course.","Hello from CMPE242.",2364675);
        testInbox.addEmail(newTestEmail);
        assertEquals(newTestEmail,testInbox.read(1234));

    }


    @org.junit.Test
    //Tests Email read
    //Result : It is passed.
    public void read()
    {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        LinkedListOfEmails testInbox = new LinkedListOfEmails();
        Email newTestEmail = new Email(1234,"This is a welcome email from the course.","Hello from CMPE242.",2364675);
        testInbox.addEmail(newTestEmail);

        System.setOut(new PrintStream(outContent));
        testInbox.read(1234);

        String s  = "Email id: 1234\n" +
                "Subject : " + "Hello from CMPE242.\n" +
                "Body : This is a welcome email from the course.\n" +
                "Time received : 2364675\n" +
                "Status : Read.\n";
        assertEquals(s , outContent.toString());

    }

    @org.junit.Test
    //Tests Email delete
    //Result : It is passed.
    public void delete()
    {


        LinkedListOfEmails testInbox = new LinkedListOfEmails();
        Email newTestEmail = new Email(1234,"This is a welcome email from the course.","Hello from CMPE242.",2364675);
        testInbox.addEmail(newTestEmail);


        Email test = testInbox.delete(1234);
        assertEquals(newTestEmail,test);

    }
    @org.junit.Test
    //Tests Email delete to see method effect to size
    //Result : It is passed.
    public void delete1()
    {
        LinkedListOfEmails testInbox = new LinkedListOfEmails();
        Email newTestEmail = new Email(1234,"This is a welcome email from the course.","Hello from CMPE242.",2364675);
        testInbox.addEmail(newTestEmail);
         newTestEmail = new Email(1237,"test","test2",2364674);
        testInbox.addEmail(newTestEmail);
        Email test = testInbox.delete(1234);
        assertEquals(1,testInbox.size);

    }

    @Test
    //Tests showall
    //Result : It is passed.
    public void showAll()
    {
        String s = "Email   Subject                    Body                       Time      Read\r\n" +
                   "1234    Hello from CMPE242.        This is a welcome email... 2364675   No\n";
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        LinkedListOfEmails testInbox = new LinkedListOfEmails();
        Email newTestEmail = new Email(1234,"This is a welcome email from the course.","Hello from CMPE242.",2364675);
        testInbox.addEmail(newTestEmail);
        System.setOut(new PrintStream(outContent));
        testInbox.showAll(true);


        assertEquals(s , outContent.toString());
    }
    @Test
    //tests only read emails
    //Result : It is passed.
    public void showAll1()
    {
        String s = "Email   Subject                    Body                       Time      Read\r\n" +
                   "1234    Hello from CMPE242.        This is a welcome email... 2364675   No\n";
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        LinkedListOfEmails testInbox = new LinkedListOfEmails();
        Email newTestEmail = new Email(1234,"This is a welcome email from the course.","Hello from CMPE242.",2364675);
        testInbox.addEmail(newTestEmail);
        newTestEmail = new Email(1237,"test","test2",2364674);
        testInbox.addEmail(newTestEmail);
        testInbox.read(1237);
        System.setOut(new PrintStream(outContent));
        testInbox.showAll(false);
        assertEquals(s , outContent.toString());
    }
}
