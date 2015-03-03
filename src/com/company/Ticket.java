package com.company;
import java.util.*;

import static com.company.TicketManager.printAllTickets;

/**
 * Created by Edwin on 3/2/2015.
 */
public class Ticket {
    private int priority;
    private String reporter; //Stores person or department who reported issue
    private String description;
    private Date dateReported;

    //STATIC Counter - accessible to all Ticket objects.
//If any Ticket object modifies this counter, all Ticket objects will have the modified value
//Make it private - only Ticket objects should have access
    private static int staticTicketIDCounter = 1;



    //The ID for each ticket - instance variable. Each Ticket will have it's own ticketID variable
    protected int ticketID;

    public Ticket(String desc, int p, String rep, Date date) {
        this.description = desc;
        this.priority = p;
        this.reporter = rep;
        this.dateReported = date;
        this.ticketID = staticTicketIDCounter;
        staticTicketIDCounter++;
    }

    protected int getPriority() {
        return priority;
    }
    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String toString() {
        return ("ID= " + this.ticketID + " Issued: " + this.description + " Priority: " + this.priority + " Reported by: "
                + this.reporter + " Reported on: " + this.dateReported);
    }


    public static void deleteTicket(LinkedList<Ticket> ticketQueue) {
        printAllTickets(ticketQueue);   //display list for user

        if (ticketQueue.size() == 0) {    //no tickets!
            System.out.println("No tickets to delete!\n");
            return;
        }

        Scanner deleteScanner = new Scanner(System.in);
        System.out.println("Enter ID of ticket to delete");
        int deleteID = deleteScanner.nextInt();
            if(deleteScanner.hasNextInt()) {
            System.out.println("Valid Input");

        } else {
            System.out.println("Invalid Input");
                return;
        }



        //Loop over all tickets. Delete the one with this ticket ID
        boolean found = false;
        for (Ticket ticket : ticketQueue) {
            if (ticket.getTicketID() == deleteID) {
                ticketQueue.remove(ticket);
                System.out.println(String.format("Ticket %d deleted", deleteID));
                break; //don't need loop any more.
            }
        }

        if (!found) {
            System.out.println("Ticket ID does not exist. Please try again");
            return; //returns to main menu.
        }
        printAllTickets(ticketQueue);  //print updated list

    }
}



