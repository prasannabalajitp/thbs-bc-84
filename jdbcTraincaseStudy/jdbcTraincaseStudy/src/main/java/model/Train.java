package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Train
{
    private int trainNo;
    private String trainName;
    private String source;
    private String destination;
    private double ticketPrice;



}