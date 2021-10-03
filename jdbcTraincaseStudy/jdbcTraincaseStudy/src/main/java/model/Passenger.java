package model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Passenger implements Comparable<Passenger> {
    private String name;
    private int age;
    private char gender;

    @Override
    public int compareTo(Passenger o) {
        if ((o.getName()).compareTo(name) > 0) {
            return 1;
        } else {
            if ((o.getName()).equals(name)) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
