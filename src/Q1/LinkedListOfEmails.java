//-----------------------------------------------------
// Title: Cmpe242 LinkedList
// Author: Tunç Gürsoy
// ID: 64521827274
// Section: 2
// Assignment: 1
// Description: This class defines Linkedlist and basic operations.
//-----------------------------------------------------
package Q1;

public class LinkedListOfEmails
{


    int size =0 ; // size of linked list of current linked list
     boolean isExists  = true ; // Shows that is node in that list

    Node getHead() {
        return head;
    }
    Email getData(Node a) {

        return a.data;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    private  Node head = null ;

    static private class Node
    {
        Email data ;

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }

        Node next ; //node that shows next node.

        Node(Email e )
        {


            data =  e ;
            next = null ;
        }

    }

    // This functions adds new node to the current linked list
  void addEmail(Email e) {
      //--------------------------------------------------------
      // Summary: This functions adds new node to the current linked list
      // e is given.
      // Precondition: s is an Email
      // Postcondition: Email add to List
      //--------------------------------------------------------
      Node a = new Node(e);
      int time = a.data.getTime();
      Node t = head;
      boolean iscontinue = true;
      if (t != null) {
          for (int i = 0; i < size; i++) {
              try {
                  if (t == null)
                  {

                      break;
                  }else {
                      if (a.data.getID() == t.data.getID()) {
                          iscontinue = false;
                          System.out.println("This Email id already in use");
                      }
                  }
              }catch (Exception e1)
              {
                  System.out.println("Line 55 : "+e);
              }
              t = t.getNext();
          }

      }
      if (iscontinue) {
          if (head == null) {
              head = a;
              size++;
          } else if (head.data.getTime() < time) {
              Node temp = head;
              size++;
              head = a;
              head.setNext(temp);
          } else {
              Node temp = head.getNext();
              Node temp1= head ;

              for (int i = 0 ; i<size; i++)
              {
                  if (size ==1)
                  {
                      head.setNext(a);
                      size++;
                      break;

                  }else if(temp1.data.getTime()== a.data.getTime())
                  {
                      temp1.setNext(a);
                      a.setNext(temp);
                      size++ ;
                      break;
                  }
                  else if ( temp1.data.getTime()>a.data.getTime()&&a.data.getTime()>temp.data.getTime())
                  {

                      temp1.setNext(a);
                      a.setNext(temp);
                      size++;
                      break;

                  }
                  temp = temp.getNext() ;
                  temp1 = temp1.getNext() ;
                  if (temp== null)
                  {
                      temp1.setNext(a);
                      size++;
                      break ;
                  }


              }
          }


      }
  }

  Email read(int id)
  //--------------------------------------------------------
  // Summary: This functions reads Email which is id equal to given id From current list
  // id is given.
  // Precondition: id is an Integer
  // Postcondition: print given email attributes and returns email
  //--------------------------------------------------------
  {
      Email s = new Email();
      Node a = head ;
      Node temp = a ;

     do {
         if (head != null) {
             if (a.data.ID == id) {
                 s = a.data ;


                 System.out.print("Email id: " + a.data.getID() + "\n" +
                         "Subject : " + a.data.getSubject() + "\n" +
                         "Body : " + a.data.getMessage() + "\n" +
                         "Time received : " + a.data.getTime() + "\n" +
                         "Status : Read.\n");


                 a.data.setFlag(true);
                 isExists = true;
                 break;
             } else if (a.getNext() != null) {
                 temp = a;
                 a = a.getNext();
             } else {
                 isExists = false;
                 break;
             }
         }else
             {
                 isExists = false ;
                 break;
             }
     }while (temp.data.getID() != id || temp.getNext() == null );

return s;
  }

  Email delete(int id )
  //--------------------------------------------------------
  // Summary: This functions delete Email which is id equal to given id From current list
  // id is given.
  // Precondition: id is an Integer
  // Postcondition: deletes the  returns email
  //--------------------------------------------------------
  {
      isExists = true ;
      if (head == null)
      {
          isExists = false ;
          return null ;
      }
      Node a = head ;
      Node temp = null ;

      do {
          if (a.data != null) {
              if (a.data.ID == id) {

                  break;

              } else if (a.getNext() != null) {


                  temp = a;
                  a = a.getNext();


              } else {

                  isExists = false;
                  break;
              }
          }else
              {
                  isExists = false ;
                  break;
              }
      }while (temp.data.ID != id );
      if (isExists) {
          if (temp == null) {
              size--;
              head = a.getNext();
          } else {
              size--;
              temp.setNext(a.getNext());
              a.setNext(null);
          }
      }
      return  a.data ;
  }

  void showAll( boolean flag)
  //--------------------------------------------------------
  // Summary: This functions  shows if flag is true all emails in given current list  else only shows not read values
  // flag is given.
  // Precondition: flag is an boolean
  // Postcondition: print all emails in current list or not read emails
  //--------------------------------------------------------
  {
      Node a = head;
      String e1 = "Email",e2 = "Subject",e3 = "Body", e4 = "Time",e5 = "Read";
      System.out.printf("%-8s"+"%-27s"+"%-27s"+"%-10s"+"%s",e1,e2,e3,e4,e5);
      System.out.println();
        if (flag ){
            try {
                do {

                    {

                        System.out.printf("%-8d",a.data.getID());
                        if (a.data.getSubject().length()>25)
                        {
                            System.out.printf("%-27.23s",a.data.getSubject());
                        }else
                            {
                                System.out.printf("%-27.25s",a.data.getSubject());
                            }
                        if (a.data.getMessage().length()>25)
                        {
                            System.out.printf("%-23.23s"+"..."+" ",a.data.getMessage());
                        }else
                        {
                            System.out.printf("%-27.25s",a.data.getMessage());
                        }
                        System.out.printf("%-10d",a.data.getTime());

                        if (a.data.isFlag()) {
                            System.out.print("Yes\n");
                        } else {
                            System.out.print("No\n");
                        }


                        a = a.next;
                    }
                } while (a != null);
            }catch (Exception e) {}
      }else
          {
              if (head!=null) {
                  do {


                      if (a.data.isFlag()) {

                          a = a.next;
                          continue;
                      } else {

                          System.out.printf("%-8d",a.data.getID());
                          if (a.data.getSubject().length()>25)
                          {
                              System.out.printf("%-23.23s"+"..."+" ",a.data.getSubject());
                          }else
                          {
                              System.out.printf("%-27.25s",a.data.getSubject());
                          }
                          if (a.data.getMessage().length()>25)
                          {
                              System.out.printf("%-23.23s"+"..."+" ",a.data.getMessage());
                          }else
                          {
                              System.out.printf("%-27.25s",a.data.getMessage());
                          }
                          System.out.printf("%-10d",a.data.getTime());

                          System.out.print("No\n");
                      }

                      a = a.next;


                  } while (a != null);
              }

          }
  }



}
