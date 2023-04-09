package programmers.parking_fee;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {

    private static int BASIC_TIME;
    private static int BASIC_FEE;
    private static int UNIT_TIME;
    private static int UNIT_FEE;

    private static final int END_MINUTE = (60 * 24) - 1;
    private static final Map<Integer,Integer> parkingCarTimeMap = new ConcurrentHashMap<>();
    private static final Map<Integer,Integer> parkingTotalMinuteMap = new ConcurrentHashMap<>();


    public int[] solution(int[] fees, String[] records) {
        initParkingLotInformation(fees);

        for (String record : records) {
            String[] split = record.split(" ");

            int minute = timeConvertToMinute(split[0]);
            int carNumber = Integer.parseInt(split[1]);
            String inAndOut = split[2];

            if (inAndOut.equals("IN")) carIn(carNumber, minute);
            if (inAndOut.equals("OUT")) carOut(carNumber, minute);
        }

        parkingCarTimeMap.keySet().forEach(restCar -> carOut(restCar,END_MINUTE));
        List<Integer> result = new ArrayList<>();
        parkingTotalMinuteMap.keySet().stream().sorted().forEach(car -> result.add(calculateFee(car)));
        return result.stream().mapToInt(i->i).toArray();

    }

    private Integer calculateFee(Integer car) {
        Integer totalMinute = parkingTotalMinuteMap.get(car);
        if(totalMinute <= BASIC_TIME) return BASIC_FEE;
        int overTime = totalMinute - BASIC_TIME;
        int calcFee = (int) Math.ceil((double) overTime / UNIT_TIME) * UNIT_FEE;
        return BASIC_FEE + calcFee;
    }

    private void carIn(Integer carNumber, int minute) {
        parkingCarTimeMap.put(carNumber,minute);
    }

    private void carOut(Integer carNumber, int endMinute) {
        Integer startMinute = parkingCarTimeMap.get(carNumber);
        parkingCarTimeMap.remove(carNumber);
        Integer originMinute = parkingTotalMinuteMap.getOrDefault(carNumber, 0);
        parkingTotalMinuteMap.put(carNumber,originMinute + endMinute-startMinute);
    }

    private int timeConvertToMinute(String s) {
        String[] split = s.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        return hour * 60 + minute;
    }

    private void initParkingLotInformation(int[] fees) {
        BASIC_TIME = fees[0];
        BASIC_FEE = fees[1];
        UNIT_TIME = fees[2];
        UNIT_FEE = fees[3];
    }

}