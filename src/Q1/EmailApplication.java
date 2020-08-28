//-----------------------------------------------------
// Title: Cmpe242 EmailApp
// Author: Tunç Gürsoy
// ID: 64521827274
// Section: 2
// Assignment: 1
// Description: This class is main and basic operation class
//-----------------------------------------------------
package Q1;
import java.util.Scanner;

public class EmailApplication
{


    static LinkedListOfEmails INBOX = new LinkedListOfEmails();
    static LinkedListOfEmails ARCHIVE = new LinkedListOfEmails();
    static LinkedListOfEmails THRASH = new LinkedListOfEmails();
   private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome To The Email Application\nCommands :\n1=> N//subject//id//message//time//\nNew email arrived.\n2=> R <id>\nRead an email with the given id.\n3=> A <id>\nArchive the email with the given id. \n4=> D <id>\nDelete the email.\n5=> S <Folder>\nShow the contents of the folder." +
                "\n6=> U <Folder>\nShow all unread emails in the folder.\n7=> C <Folder>\nClear the contents of the folder." + "\n<Folder> = Inbox, Archive, Thrash.\n8=>Exit");
    boolean iscontinue = true ;
        while (iscontinue) {

            System.out.print("Please Enter The Input: ");
            String input = keyboard.nextLine();
            String[] list = input.split("//");
            String[] list1 = input.split(" ");
            if (list.length > 1) {

            add(list);

            }else if (list1 != null)
                {
                    switch (list1[0].toUpperCase())
                    {
                        case "R":
                             read(Integer.parseInt(list1[1]) );

                            break;
                        case "A":
                            archive(Integer.parseInt(list1[1]));
                            break;
                        case "D":
                            delete(Integer.parseInt(list1[1]));
                            break;
                            case "S":
                                showall(list1[1]);
    break;
                        case "U":
                            show(list1[1]);
                            break;
                        case "C":
                            deleteall(list1[1]);
                            break;
                        case "EXIT":
                        case "EXİT":
                            iscontinue = false;

                            break;

                    }
                }


        }
    }
    static void read(int i)
    //--------------------------------------------------------
    // Summary: execute read function of linkedListOfEmail
    // i is given. id = i
    // Precondition: i is an integer
    // Postcondition: prints given email which is id equal to i or if no email equal to given id prints No such Email
    //--------------------------------------------------------
    {
        INBOX.read(i);
        if (!INBOX.isExists)
        {
            ARCHIVE.read(i);
            if (!ARCHIVE.isExists)
            {
                THRASH.read(i);
                if (!THRASH.isExists)
                {
                    System.out.println("No such email");
                }
            }
        }
    }
    static void archive(int i )
    //--------------------------------------------------------
    // Summary: add given email which is equal to i to the archive list
    // i is given. id = i
    // Precondition: i is an integer
    // Postcondition: added given email which is equal to i to the archive list or  if no email equal to given id prints No such Email
    //--------------------------------------------------------
    {
        Email newEmail;
        newEmail =  INBOX.delete(i);
        if (!INBOX.isExists)
        {
            newEmail =ARCHIVE.delete(i);
            if (!ARCHIVE.isExists)
            {
                newEmail = THRASH.delete(i);
                if (!THRASH.isExists)
                {
                    System.out.println("No such email");
                }
            }
        }
        if (INBOX.isExists||ARCHIVE.isExists|| THRASH.isExists)
        {
            ARCHIVE.addEmail(newEmail);
        }
    }
    static void delete(int i )
    //--------------------------------------------------------
    // Summary: delete the email from list if e mail in Archive or Inbox List if in Trash list delete permanently
    // i is given. id = i
    // Precondition:  i is an integer
    // Postcondition: delete the email from list if e mail in Archive or Inbox List if in Trash list delete permanently or if no email equal to given id prints No such Email
    //--------------------------------------------------------
    {
        Email newEmail  ;
        newEmail = INBOX.delete(i);
        if (!INBOX.isExists) {
            newEmail = ARCHIVE.delete(i);
            if (!ARCHIVE.isExists) {

                newEmail = THRASH.delete(i);

                if (!THRASH.isExists) {
                    System.out.println("No such email");
                }
            }
        }
        if (INBOX.isExists || ARCHIVE.isExists) {
            THRASH.addEmail(newEmail);
        }
    }

    static void showall(String s)
    //--------------------------------------------------------
    // Summary: shows the all email in given list
    // s is given.
    // Precondition: s is an String
    // Postcondition: Showed the all Email in given List
    //--------------------------------------------------------
    {
        if (s.equalsIgnoreCase("INBOX"))
        {
            INBOX.showAll(true);
        }else if (s.equalsIgnoreCase("ARCHIVE"))
        {
            ARCHIVE.showAll(true);
        }else  if (s.equalsIgnoreCase("THRASH"))
        {
            THRASH.showAll(true);
        }

    }
    static void show(String s )
    //--------------------------------------------------------
    // Summary: shows the not read email in given list
    // s is given.
    // Precondition: s is an String
    // Postcondition: Showed the read  Email in given List
    //--------------------------------------------------------
    {
        if (s.equalsIgnoreCase("INBOX"))
        {
            INBOX.showAll(false);
        }else if (s.equalsIgnoreCase("ARCHIVE"))
        {
            ARCHIVE.showAll(false);
        }else  if (s.equalsIgnoreCase("THRASH"))
        {
            THRASH.showAll(false);
        }
    }
    static void deleteall(String s)
    //--------------------------------------------------------
    // Summary: delete all email in given list if list is equal to inbox or archive adds in Trash list if given list is
    //thrash delete all email in thrash permanently
    // s is given.
    // Precondition: s is an String
    // Postcondition: Email all  deleted in given list
    //--------------------------------------------------------
    {
        Email newEmail ;
        long size ;
        if (s.equalsIgnoreCase("INBOX"))
        {

            size =  INBOX.size;
            for (int i = 0 ; i<size; i++)
            {
                newEmail = INBOX.delete(INBOX.getData(INBOX.getHead()).ID);
                THRASH.addEmail(newEmail);
            }
        }else if (s.equalsIgnoreCase("ARCHIVE"))
        {
            size =  ARCHIVE.size;
            for (int i = 0 ; i<size; i++)
            {
                newEmail = ARCHIVE.delete(ARCHIVE.getData(ARCHIVE.getHead()).ID);
                THRASH.addEmail(newEmail);
            }
        }else  if (s.equalsIgnoreCase("THRASH"))
        {
            size =  THRASH.size;
            for (int i = 0 ; i<size; i++)
            {
                THRASH.delete(THRASH.getData(THRASH.getHead()).ID);
            }

        }
        size = 0 ;
    }
    static void  add(String[] s)
    //--------------------------------------------------------
    // Summary: creates a email object and pushes the given values to the e mail object and adds that email object to
    // to the Inbox List
    // s is given.
    // Precondition: s is an String array
    // Postcondition: New Email Added
    //--------------------------------------------------------
    {
        Email newEmail = new Email();
        if (s[0].trim().equalsIgnoreCase("N"))
        {
            try {
                newEmail.setSubject(s[1]);
                newEmail.setID(Integer.parseInt(s[2]));
                newEmail.setMessage(s[3]);
                newEmail.setTime(Integer.parseInt(s[4]));
                INBOX.addEmail(newEmail);
            }catch (Exception e )
            {
                System.out.println("You make a Error while giving input to system please try again");
            }
        }else
        {
            System.out.println("unknown command please try again!!");
        }

    }
}
