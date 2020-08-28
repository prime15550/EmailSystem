package Q1;//-----------------------------------------------------
// Title: Cmpe242 EmailApp tester
// Author: Tunç Gürsoy
// ID: 64521827274
// Section: 2
// Assignment: 1
// Description: This class is main and basic operation tester class
//-----------------------------------------------------
import org.junit.Test;
import java.io.ByteArrayOutputStream;

import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;


public class EmailApplicationTest {
    //----------------------------------------------------------------------------------------
    /*
    Because of the in Email Application, lists(INBOX,ARCHIVE,TRASH) are static, we must delete every thing in lists, to do
    this we must write this code after assert equals
    emailApplication.deleteall("Inbox");
    emailApplication.deleteall("ARCHIVE");
    emailApplication.deleteall("THRASH");
    */
    //-------------------------------------------------------------------------------------------
    // In this test I tested can we read email which is added to the inbox.
    //Result : It is passed.
    @Test
    public void readtest() {
         EmailApplication emailApplication = new EmailApplication();
         String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
         String[] s1 = s.split("//");
         emailApplication.add(s1);
         String test = "Email id: 1234\n" +
                 "Subject : Hello from CMPE242.\n" +
                 "Body : This is a welcome email from the course.\n" +
                 "Time received : 2364675\n" +
                 "Status : Read.\n";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        emailApplication.read(1234);
          assertEquals(test,outContent.toString());
        emailApplication.deleteall("Inbox");
        emailApplication.deleteall("ARCHIVE");
        emailApplication.deleteall("THRASH");

    }

    @Test
    //In this test I tested can we archive an email which is added from the inbox to the archive.
    //Result : It is passed.
    public void archivetest() {
        EmailApplication emailApplication = new EmailApplication();
        String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
        String[] s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.archive(1234);
        Email test = new Email(1234,"This is a welcome email from the course.","Hello from CMPE242.",2364675);
        Email testEmail = emailApplication.ARCHIVE.getData(emailApplication.ARCHIVE.getHead());
       assertEquals(test.getID(),testEmail.getID());
        emailApplication.deleteall("Inbox");
        emailApplication.deleteall("ARCHIVE");
        emailApplication.deleteall("THRASH");

    }

    @Test
    //In this test I tested can we delete an email which is added to inbox .
    //*!Note: I tried delete from other lists(Archive and Thrash) and its works and in extreme I showed, I write this
    //because in this test ı try to show only method is working
    //Result : It is passed.
    public void deletetest()
    {
        EmailApplication emailApplication = new EmailApplication();
        String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
        String[] s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.delete(1234);
        Email test = new Email(1234,"This is a welcome email from the course.","Hello from CMPE242.",2364675);
        Email testEmail = emailApplication.THRASH.getData(emailApplication.THRASH.getHead());
        assertEquals (test.getID(),testEmail.getID());
        emailApplication.deleteall("Inbox");
        emailApplication.deleteall("ARCHIVE");
        emailApplication.deleteall("THRASH");
    }

    @Test
    //In this test I tested can we see all emails in specific list regardless of is it read or not read.
    //Result : It is passed.
    public void showalltest()
    {
        EmailApplication emailApplication = new EmailApplication();
        String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
        String[] s1 = s.split("//");
        emailApplication.add(s1);
        s = "N //Homework 1 posted.//1237//This is your first homework for the course.//2264672//";
        s1 = s.split("//");
        emailApplication.add(s1);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        emailApplication.showall("inbox");
        String test = "Email   Subject                    Body                       Time      Read\r\n" +
                      "1234    Hello from CMPE242.        This is a welcome email... 2364675   No\n" +
                      "1237    Homework 1 posted.         This is your first home... 2264672   No\n";
       assertEquals(test,(outContent.toString()));
        emailApplication.deleteall("Inbox");
        emailApplication.deleteall("ARCHIVE");
        emailApplication.deleteall("THRASH");
    }

    @Test
    //In this test I tested can we see all emails which is not read in specific list .
    //Result : It is passed.
    public void showtest() {
        EmailApplication emailApplication = new EmailApplication();
        String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
        String[] s1 = s.split("//");
        emailApplication.add(s1);
        s = "N //Homework 1 posted.//1237//This is your first homework for the course.//2264672//";
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1234);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        emailApplication.show("inbox");
        String test = "Email   Subject                    Body                       Time      Read\r\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   No\n";
        assertEquals(test,(outContent.toString()));
        emailApplication.deleteall("Inbox");
        emailApplication.deleteall("ARCHIVE");
        emailApplication.deleteall("THRASH");
    }

    @Test
    //In this test I tested can we delete all email which is added to inbox .
    //Also I tested other list in extreme test.
    //Result : It is passed.
    public void deleteall() {
        EmailApplication emailApplication = new EmailApplication();
        String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
        String[] s1 = s.split("//");
        emailApplication.add(s1);
        s = "N //Homework 1 posted.//1237//This is your first homework for the course.//2264672//";
        s1 = s.split("//");
        emailApplication.add(s1);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        emailApplication.deleteall("inbox");
        emailApplication.showall("inbox");
        String test = "Email   Subject                    Body                       Time      Read\r\n" ;
        assertEquals(test,(outContent.toString()));
        emailApplication.deleteall("Inbox");
        emailApplication.deleteall("ARCHIVE");
        emailApplication.deleteall("THRASH");
    }

    @Test
    // In this test I tested can we read email which is added to the inbox.
    //Result : It is passed.
    public void addtest()
    {
        EmailApplication emailApplication = new EmailApplication();
        String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
        String[] s1 = s.split("//");
        emailApplication.add(s1);
        String test = "Email id: 1234\n" +
                "Subject : Hello from CMPE242.\n" +
                "Body : This is a welcome email from the course.\n" +
                "Time received : 2364675\n" +
                "Status : Read.\n";
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        emailApplication.read(1234);
        assertEquals(test,(outContent.toString()));
        outContent.reset();
        emailApplication.deleteall("Inbox");
        emailApplication.deleteall("ARCHIVE");
        emailApplication.deleteall("THRASH");


    }

    @Test
    //In this test I try to test is new e-mails added in or not.
    //Result : It is passed.
    public void extremeTest1()
    {
        EmailApplication emailApplication1 = new EmailApplication();
        String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
        String[] s1 = s.split("//");
        emailApplication1.add(s1);
         s = "N //Homework 1 posted.//1237//This is your first homework for the course.//2264672//" ;
         s1 = s.split("//");
        emailApplication1.add(s1);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        s = "N//Deneme1//1234//Deneme1//5621455//" ;
        s1 = s.split("//");
        emailApplication1.add(s1);
        emailApplication1.showall("inbox");
        s = "N//Deneme1//1237//Deneme1//5621455//" ;
        s1 = s.split("//");
        emailApplication1.add(s1);
        emailApplication1.showall("inbox");
        s = "N//Deneme1//1236//Deneme1//5621455//" ;
        s1 = s.split("//");
        emailApplication1.add(s1);
        emailApplication1.showall("inbox");
        String test = "This Email id already in use\r\n" +
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   No\n" +
                "This Email id already in use\r\n" +
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   No\n" +
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    5621455   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   No\n";
        assertEquals(test,outContent.toString());
        emailApplication1.deleteall("Inbox");
        emailApplication1.deleteall("ARCHIVE");
        emailApplication1.deleteall("THRASH");
    }

    @Test
    //In this test I try to test when we add new e mail already existing time and between two time.
    //Result : It is passed.(Changed after line change in 88-101 of LinkedListOfEmails)
    public void extremeTest2()
    {
        EmailApplication emailApplication = new EmailApplication();
        String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
        String[] s1 = s.split("//");
        emailApplication.add(s1);
        s = "N //Homework 1 posted.//1237//This is your first homework for the course.//2264672//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        s = "N//Deneme1//1236//Deneme1//2364676//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme2//1238//Deneme2//2364675//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme3//1239//Deneme3//12//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme4//1240//Deneme4//2264673//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.showall("inbox");
        String test = "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   No\n" +
                "\r" +
                "\n" +
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   No\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   No\n" +
                "\r" +
                "\n" +
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   No\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   No\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r" +
                "\n" +
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   No\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1240    Deneme4                    Deneme4                    2264673   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   No\n" +
                "1239    Deneme3                    Deneme3                    12        No\n";
        assertEquals(test,outContent.toString());
        emailApplication.deleteall("Inbox");
        emailApplication.deleteall("ARCHIVE");
        emailApplication.deleteall("THRASH");
    }

    @Test
    //In this test I try to read method and showall method to together to see e mail read status changed or not.
    //Result : It is passed.
    public void extremeTest3()
    {
        EmailApplication emailApplication = new EmailApplication();
        String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
        String[] s1 = s.split("//");
        emailApplication.add(s1);
        s = "N //Homework 1 posted.//1237//This is your first homework for the course.//2264672//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        s = "N//Deneme1//1236//Deneme1//2364676//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1234);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme2//1238//Deneme2//2364675//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1237);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme3//1239//Deneme3//12//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme4//1240//Deneme4//2264673//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1240);
        emailApplication.showall("inbox");
        String test = "Email id: 1234\n" +
                "Subject : Hello from CMPE242.\n" +
                "Body : This is a welcome email from the course.\n" +
                "Time received : 2364675\n" +
                "Status : Read.\n"+"Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   No\n" +
                "\r" +
                "\n" +
                "Email id: 1237\n" +
                "Subject : Homework 1 posted.\n" +
                "Body : This is your first homework for the course.\n" +
                "Time received : 2264672\n" +
                "Status : Read.\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "\r" +
                "\n" +
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r" +
                "\n" +
                "Email id: 1240\n" +
                "Subject : Deneme4\n" +
                "Body : Deneme4\n" +
                "Time received : 2264673\n" +
                "Status : Read.\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1240    Deneme4                    Deneme4                    2264673   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n";
        assertEquals(test,outContent.toString());
        emailApplication.deleteall("Inbox");
        emailApplication.deleteall("ARCHIVE");
        emailApplication.deleteall("THRASH");
    }

    @Test
    //In this test  I try to test when we delete an email from inbox list is email going to the trash.
    //Result : It is passed.
    public void extremeTest4()
    {
        EmailApplication emailApplication = new EmailApplication();
        String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
        String[] s1 = s.split("//");
        emailApplication.add(s1);
        s = "N //Homework 1 posted.//1237//This is your first homework for the course.//2264672//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        s = "N//Deneme1//1236//Deneme1//2364676//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1234);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme2//1238//Deneme2//2364675//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1237);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme3//1239//Deneme3//12//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme4//1240//Deneme4//2264673//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1240);
        emailApplication.delete(1238);
        emailApplication.showall("inbox");
        System.out.println();
        emailApplication.showall("thrash");
        System.out.println();
        emailApplication.delete(1234);
        emailApplication.showall("inbox");
        System.out.println();
        emailApplication.showall("thrash");
        String test = "Email id: 1234\n" +
                "Subject : Hello from CMPE242.\n" +
                "Body : This is a welcome email from the course.\n" +
                "Time received : 2364675\n" +
                "Status : Read.\n"+"Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   No\n" +
                "\r" +
                "\n" +
                "Email id: 1237\n" +
                "Subject : Homework 1 posted.\n" +
                "Body : This is your first homework for the course.\n" +
                "Time received : 2264672\n" +
                "Status : Read.\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "\r" +
                "\n" +
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r" +
                "\n" +
                "Email id: 1240\n" +
                "Subject : Deneme4\n" +
                "Body : Deneme4\n" +
                "Time received : 2264673\n" +
                "Status : Read.\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1240    Deneme4                    Deneme4                    2264673   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n\r\n"
                +"Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +

                "1240    Deneme4                    Deneme4                    2264673   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n"+
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" ;
        assertEquals(test,outContent.toString());
        emailApplication.deleteall("Inbox");
        emailApplication.deleteall("ARCHIVE");
        emailApplication.deleteall("THRASH");
    }

    @Test
    //In this test I try to test show method(show only not read emails in selected list )
    //Result : It is passed.
    public void extremeTest5()
    {
        EmailApplication emailApplication = new EmailApplication();
        String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
        String[] s1 = s.split("//");
        emailApplication.add(s1);
        s = "N //Homework 1 posted.//1237//This is your first homework for the course.//2264672//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        s = "N//Deneme1//1236//Deneme1//2364676//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1234);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme2//1238//Deneme2//2364675//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1237);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme3//1239//Deneme3//12//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme4//1240//Deneme4//2264673//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1240);
        emailApplication.delete(1238);
        emailApplication.showall("inbox");
        System.out.println();
        emailApplication.showall("thrash");
        System.out.println();
        emailApplication.delete(1234);
        emailApplication.showall("inbox");
        System.out.println();
        emailApplication.showall("thrash");
        System.out.println();
        emailApplication.show("inbox");
        System.out.println();
        emailApplication.show("thrash");
        String test = "Email id: 1234\n" +
                "Subject : Hello from CMPE242.\n" +
                "Body : This is a welcome email from the course.\n" +
                "Time received : 2364675\n" +
                "Status : Read.\n"+"Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   No\n" +
                "\r" +
                "\n" +
                "Email id: 1237\n" +
                "Subject : Homework 1 posted.\n" +
                "Body : This is your first homework for the course.\n" +
                "Time received : 2264672\n" +
                "Status : Read.\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "\r" +
                "\n" +
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r" +
                "\n" +
                "Email id: 1240\n" +
                "Subject : Deneme4\n" +
                "Body : Deneme4\n" +
                "Time received : 2264673\n" +
                "Status : Read.\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1240    Deneme4                    Deneme4                    2264673   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n\r\n"
                +"Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1240    Deneme4                    Deneme4                    2264673   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n"+
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n\r\n" +
                "Email   Subject                    Body                       Time      Read\r\n"+
                "1236    Deneme1                    Deneme1                    2364676   No\n"+
                "1239    Deneme3                    Deneme3                    12        No\n\r\n"+
                "Email   Subject                    Body                       Time      Read\r\n"+
                "1238    Deneme2                    Deneme2                    2364675   No\n";
        assertEquals(test,outContent.toString());
        emailApplication.deleteall("Inbox");
        emailApplication.deleteall("ARCHIVE");
        emailApplication.deleteall("THRASH");
    }

    @Test
    //In this test try to test delete an email from thrash list and the email is gone permanently.
    //Result : It is passed.
    public void extremeTest6()
    {
        EmailApplication emailApplication = new EmailApplication();
        String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
        String[] s1 = s.split("//");
        emailApplication.add(s1);
        s = "N //Homework 1 posted.//1237//This is your first homework for the course.//2264672//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        s = "N//Deneme1//1236//Deneme1//2364676//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1234);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme2//1238//Deneme2//2364675//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1237);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme3//1239//Deneme3//12//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme4//1240//Deneme4//2264673//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1240);
        emailApplication.delete(1238);
        emailApplication.showall("inbox");
        System.out.println();
        emailApplication.showall("thrash");
        System.out.println();
        emailApplication.delete(1234);
        emailApplication.showall("inbox");
        System.out.println();
        emailApplication.showall("thrash");
        emailApplication.delete(1234);
        System.out.println();
        emailApplication.showall("thrash");
        String test = "Email id: 1234\n" +
                "Subject : Hello from CMPE242.\n" +
                "Body : This is a welcome email from the course.\n" +
                "Time received : 2364675\n" +
                "Status : Read.\n"+"Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   No\n" +
                "\r" +
                "\n" +
                "Email id: 1237\n" +
                "Subject : Homework 1 posted.\n" +
                "Body : This is your first homework for the course.\n" +
                "Time received : 2264672\n" +
                "Status : Read.\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "\r" +
                "\n" +
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r" +
                "\n" +
                "Email id: 1240\n" +
                "Subject : Deneme4\n" +
                "Body : Deneme4\n" +
                "Time received : 2264673\n" +
                "Status : Read.\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1240    Deneme4                    Deneme4                    2264673   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n\r\n"
                +"Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +

                "1240    Deneme4                    Deneme4                    2264673   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n"+
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n\r\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n";

       assertEquals(test,outContent.toString());
        emailApplication.deleteall("Inbox");
        emailApplication.deleteall("ARCHIVE");
        emailApplication.deleteall("THRASH");
    }

    @Test
    //In this test I try to test deleteall method(Deletes everything in selected list )
    //Result : It is passed.
    public void extremeTest7()
    {
        EmailApplication emailApplication = new EmailApplication();
        String s = "N //Hello from CMPE242.//1234//This is a welcome email from the course.//2364675//" ;
        String[] s1 = s.split("//");
        emailApplication.add(s1);
        s = "N //Homework 1 posted.//1237//This is your first homework for the course.//2264672//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        s = "N//Deneme1//1236//Deneme1//2364676//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1234);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme2//1238//Deneme2//2364675//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1237);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme3//1239//Deneme3//12//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.showall("inbox");
        System.out.println();
        s = "N//Deneme4//1240//Deneme4//2264673//" ;
        s1 = s.split("//");
        emailApplication.add(s1);
        emailApplication.read(1240);
        emailApplication.showall("inbox");
        System.out.println();
        emailApplication.deleteall("inbox");
        emailApplication.showall("inbox");
        System.out.println();
        emailApplication.showall("Thrash");
        System.out.println();
        emailApplication.deleteall("Thrash");
        emailApplication.showall("thrash");
        String test = "Email id: 1234\n" +
                "Subject" +
                " : Hello from CMPE242.\n" +
                "Body : This is a welcome email from the course.\n" +
                "Time received : 2364675\n" +
                "Status : Read.\n"+"Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   No\n\r\n" +

                "Email id: 1237\n" +
                "Subject : Homework 1 posted.\n" +
                "Body : This is your first homework for the course.\n" +
                "Time received : 2264672\n" +
                "Status : Read.\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "\r" +
                "\n" +
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r" +
                "\n" +
                "Email id: 1240\n" +
                "Subject : Deneme4\n" +
                "Body : Deneme4\n" +
                "Time received : 2264673\n" +
                "Status : Read.\n"+
                "Email   Subject                    Body                       Time      Read\r\n" +
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1240    Deneme4                    Deneme4                    2264673   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r\n"+
                "Email   Subject                    Body                       Time      Read\r\n"+
                "\r\n"+
                "Email   Subject                    Body                       Time      Read\r\n"+
                "1236    Deneme1                    Deneme1                    2364676   No\n" +
                "1234    Hello from CMPE242.        This is a welcome email... 2364675   Yes\n" +
                "1238    Deneme2                    Deneme2                    2364675   No\n" +
                "1240    Deneme4                    Deneme4                    2264673   Yes\n" +
                "1237    Homework 1 posted.         This is your first home... 2264672   Yes\n" +
                "1239    Deneme3                    Deneme3                    12        No\n\r\n" +

                "Email   Subject                    Body                       Time      Read\r\n"
                ;
        assertEquals(test,outContent.toString());
        emailApplication.deleteall("Inbox");
        emailApplication.deleteall("ARCHIVE");
        emailApplication.deleteall("THRASH");
    }
}