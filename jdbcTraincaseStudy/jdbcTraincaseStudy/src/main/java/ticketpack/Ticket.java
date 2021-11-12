package ticketpack;

import lombok.Setter;
import model.Passenger;
import model.Train;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Ticket<totalPrice> {
    private int count = 0;
    private String pnr;
    private  double totalPrice;
    @Setter
    private String travelData;
    private Train train;
    private TreeMap<Passenger, Double> passengers = null;
    private Connection connection;
    private ArrayList<Passenger> passengerArrayList = null;


    public Ticket(Train train, String date) {
        passengerArrayList = new ArrayList<>();
        passengers = new TreeMap<>();
        this.train = train;
        this.travelData = date;
        System.out.println(travelData);

    }

    public String getPnr() {
        return pnr;
    }
    
    private String generatePNR() {
        connection = DBManager.getConnection();
        File file = new File("C:\\Users\\user118\\Desktop\\count.txt");

        int count = new Random().nextInt(1000)+1000;

//

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "select *from trains where TRAIN_NO = " + train.getTrainNo());


            while (resultSet.next()) {


                ArrayList<String> arrayDate = new ArrayList<>();
                StringTokenizer stringTokenizer = new StringTokenizer(travelData, "/");

                while (stringTokenizer.hasMoreElements()) {
                    arrayDate.add(stringTokenizer.nextToken());
                }


                pnr = String.valueOf(resultSet.getString(3).charAt(0)).toUpperCase() +
                        String.valueOf(resultSet.getString(4).charAt(0)).toUpperCase()
                        + "_" + arrayDate.get(2) + arrayDate.get(1) + arrayDate.get(0) +
                        "_" + count;

                //System.out.println(pnr);
                return pnr;


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }

    private double calcPassengerFare(Passenger passenger) {


        if (passenger.getAge() <= 12) {
            return (train.getTicketPrice() * 0.5);
        }
        if (passenger.getAge() >= 60) {
            return (train.getTicketPrice() * 0.6);
        }
        if (passenger.getGender() == 'F' || passenger.getGender() == 'f') {
            return (train.getTicketPrice() * 0.75);
        } else {
            return train.getTicketPrice();
        }

    }

    public void addPassenger(String name, int age, char gender) {

        passengerArrayList.add(new Passenger(name, age, gender));
        passengers.put(new Passenger(name, age, gender), calcPassengerFare(new Passenger(name, age, gender)));

    }

    private double calculateTotalTicketPrice() {
        double totalPrice = 0.0;
        for (double p : passengers.values()) {
            totalPrice += p;
        }
        return totalPrice;
    }

    public double totalTicketPrice()
    {
        double totalTicketPrice = 0.0;
        System.out.println(passengers);
        for(double p : passengers.values())
        {

            totalTicketPrice += p;
        }

        return totalTicketPrice;
    }

    private StringBuilder generateTicket() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(generatePNR() + ","
                + train.getTrainNo() + ","
                + train.getTrainName() + ","
                + train.getSource() + ","
                + train.getDestination() + ","
                + travelData + ","
                + calculateTotalTicketPrice());


        return stringBuilder;
    }

    public void writeTicket() {
        //String pnr = generatePNR();
        StringBuilder stringBuilder = generateTicket();
        File file = new File("C:\\Users\\user118\\Desktop", pnr+".txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {




            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("PNR: " + stringBuilder.toString().split(",")[0]);
            bufferedWriter.newLine();
            bufferedWriter.write("Train no: " + stringBuilder.toString().split(",")[1]);
            bufferedWriter.newLine();
            bufferedWriter.write("Train name: " + stringBuilder.toString().split(",")[2]);
            bufferedWriter.newLine();
            bufferedWriter.write("From: " + stringBuilder.toString().split(",")[3]);
            bufferedWriter.newLine();
            bufferedWriter.write("To: " + stringBuilder.toString().split(",")[4]);
            bufferedWriter.newLine();
            bufferedWriter.write("Travel Date: " + stringBuilder.toString().split(",")[5]);
            bufferedWriter.newLine();

            bufferedWriter.write("Passengers: ");
            bufferedWriter.newLine();

            bufferedWriter.write("Name          Age         Gender          Fare");
            bufferedWriter.newLine();

            for (Passenger passenger : passengers.keySet()) {

                bufferedWriter.write(passenger.getName() + "      ");
                bufferedWriter.write(String.valueOf(passenger.getAge()) + "       ");
                bufferedWriter.write(passenger.getGender() + "        ");
                bufferedWriter.write(String.valueOf(passengers.get(passenger)) + "        ");
                bufferedWriter.newLine();


            }

            bufferedWriter.write("Total Price:  " + calculateTotalTicketPrice());


            //  bufferedWriter.write(String.valueOf(stringBuilder));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
