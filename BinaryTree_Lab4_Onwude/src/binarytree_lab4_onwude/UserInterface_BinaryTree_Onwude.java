
package binarytree_lab4_onwude;
/*
   Chiamaka Onwude
   CSCI 308 Spring 2023
   03/06/2023
*/
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface_BinaryTree_Onwude{
    static BinaryTreeNode_Onwude rootNode;
    static int number;
   
    public static void Interface()
    {
        System.out.println("---Welcome to the main menu.---");
        
        try(Scanner input=new Scanner(System.in))
        {
            int option =0;
            while(option !=7)
            {
                PrintMenuMessage(); //print menu
                CheckIntegerInput(input);//check if input is an integer
                option = input.nextInt(); 
               switch(option){
                    case 1:
                        //call the insert method
                        readFile();
                        System.out.println("Element correctly inserted");
                        break;
                    case 2:
                        //remove method call
                        System.out.println("Under Construction");
                        System.out.println("Element succesfully removed");
                        break;
                    case 3:
                        int userInput = input.nextInt();
                        if (BinaryTreeNode_Onwude.searchList(userInput) == true)
                            System.out.println(userInput+ "is in the tree");
                        else
                            System.out.println(userInput+ "is not in the tree");
                        break;
                    case 4:
                        if(BinaryTreeNode_Onwude.isEmpty() == true)
                            System.out.println("The tree is empty");
                        else
                            System.out.println("The tree is not empty");
                        break;
                    case 5:
                        System.out.println("The height of the tree is "+ BinaryTreeNode_Onwude.height());
                        break;
                    case 6: //Calculates content
                        System.out.println("Print Elements");
                        System.out.println("Under Construction");
                        //print method call
                        break;
                    case 7: //exit the program
                        System.out.println("Thanks for using our program");
                        System.exit(0);
                    default: //if 1<input>6 is provided
                        System.out.println("Error: "+option+" is not a correct choice\n"
                            + "please enter a new option. \n");
                        break;           
                }
            }
        }
        catch(Exception e){
            //handle errors-print message and exit
            System.out.println("An unknown error occured, "
                    + "contact your administrator at 555-555-5555.");
            System.exit(0);
        }
    }
    public static void CheckIntegerInput(Scanner input)
    {
        while(!input.hasNextInt())
        {
            String inp=input.next();
            System.out.println("Error: '"+inp+"' is not a valid input.");
            System.out.println("Enter Valid numbers and operands");
        }
    }
    public static void readFile()
    {
      //read user input from a csv file and make sure the file is in the project
      try(Scanner input = new Scanner(System.in))
      {
          System.out.println("Enter the file name with path. For instance: binary.txt");
          String fileName= input.nextLine();
          File userFile = new File(fileName);
          //scans the file and save each value
          Scanner userDocu= new Scanner(userFile);
          while(userDocu.hasNextInt()){
            number=userDocu.nextInt();
            ElementBinaryTree_Onwude element= new ElementBinaryTree_Onwude(number,' ');
            element.setIntData(number);
            BinaryTreeNode_Onwude newNode= new BinaryTreeNode_Onwude(element);
            newNode.setElement(element);
            BinaryTreeNode_Onwude.insert(newNode.element.getIntData());
          }
          input.close(); 
      }
      catch(IOException ex)
      {
          //handle errors: prints message and exit
          System.out.println("File does not exist. Enter correct File");
          System.exit(0);
      }
    }    
    public static void PrintMenuMessage()
    {
        System.out.println("\nPlease enter a number to choose option given below.");
        System.out.println("----------------------------");
        System.out.println("1  Insert Element");
        System.out.println("2  Remove Element");
        System.out.println("3  Search through Elements");
        System.out.println("4  Check whether content is empty");
        System.out.println("5  Find height");
        System.out.println("6  Print Elements");
        System.out.println("7  Quit");
    } 
}
