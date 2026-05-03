package test;

import domain.Exercise;

public class TestResult {

    public static void main(String[] args) {
        String CIDR = "192.168.1.34/26";
        String[] result = Exercise.Calculate(CIDR);
        System.out.println("Ex №14\nSubnet mask: " + result[0] + "\nIP address range: " + result[1]);
    }
}
