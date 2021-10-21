package mainpack;


import com.sun.source.tree.Tree;
import model.Train;
import model.Passenger;
import ticketpack.Ticket;
import ticketpack.TrainDAO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

 class main {
    public static void main(String[] args)
    {
        int date=0, month=0, year = 0;
        int numOfPass=0;
        int trainNumber;
        Ticket ticket;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the train number : ");
        trainNumber = sc.nextInt();
        GregorianCalendar gregorianCalendar;

        while(true)
        {
            try
            {
                if(trainNumber > 1000 && trainNumber <= 1006)
                {
                    break;
                }
                else
                {
                    System.out.println("Enter the valid train number : ");
                    trainNumber = sc.nextInt();
                }

            }
            catch (Exception e)
            {
                System.out.println("Enter the valid train number.");
            }
        }
        Train train = null;
        try {
            train = TrainDAO.findTrain(trainNumber);
        } catch (SQLException e) {
            System.out.println("train not found");
        }

        System.out.println("Enter the Date of travel : ");
        while (true)
        {
            try
            {
                System.out.println("Enter the date (dd) of the travel : ");
                date = sc.nextInt();
                System.out.println("Enter the month (mm) of the travel : ");
                month = sc.nextInt();
                System.out.println("Enter the year (yyyy) of the travel :");
                year = sc.nextInt();
                gregorianCalendar=new GregorianCalendar(year, month,date);

                if((gregorianCalendar.compareTo(new GregorianCalendar()))>0)
                {
                    System.out.println("Your travel date is : "+date+"/"+month+"/"+year);
                    break;
                }
                else
                {
                    System.out.println("Please enter the day that is after today.");
                }
            }
            catch (Exception e)
            {
                System.out.println("Enter the valid date.");
            }

        }


        System.out.println("Enter the number of passengers : ");
        numOfPass = sc.nextInt();
        ticket=new Ticket(train, date +"/"+month+"/"+year);
        for(int i=0;i<numOfPass;i++)
        {
            System.out.println("Enter the NAME of the Passenger "+(i+1)+" : ");
            String passName = sc.next();

            System.out.println("Enter the AGE of the Passenger "+(i+1)+" : ");
            int passAge = sc.nextInt();

            System.out.println("Enter the GENDER of the Passenger "+(i+1)+" : (Type 'M' or 'F') : " );
            char passGen = sc.next().charAt(0);

            while(true)
            {
                if(Character.toString(passGen).equalsIgnoreCase("M") || Character.toString(passGen).equalsIgnoreCase("F"))
                {
                    ticket.addPassenger(passName, passAge, passGen);
                    break;
                }
                else
                {
                    System.out.println("Please enter 'M' or 'F' : ");
                    passGen = sc.nextLine().charAt(0);
                }


            }
        }

        ticket.writeTicket();
        System.out.println("Ticket Booked Successfully.");
        System.out.println("Total Ticket Price : "+ ticket.totalTicketPrice());
    }
}
