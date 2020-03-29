package sample;

import Characters.Plant;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String name;
    private int CoinValues;
    private int SunTokens;
    private boolean SlotAvailable;
    private int No_of_Slots;
    private int SlotsLeft;
    private ArrayList<Plant> plants;
    private int Level;

    public User(){


    }

    public String getName(){
        return name;
    }

    public int getCoinValues() {
        return CoinValues;
    }

    public boolean isSlotAvailable() {
        return SlotAvailable;
    }

    public int getLevel() {
        return Level;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public int getSlotsLeft() {
        return SlotsLeft;

    }

    public int getNo_of_Slots() {
        return No_of_Slots;
    }

    public int getSunTokens() {
        return SunTokens;
    }

    public void setCoinValues(int coinValues) {
        CoinValues = coinValues;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNo_of_Slots(int no_of_Slots) {
        No_of_Slots = no_of_Slots;
    }

    public void setplant(Plant plants) {
        this.plants.add(plants);
    }

    public void setSlotAvailable(boolean slotAvailable) {
        SlotAvailable = slotAvailable;
    }

    public void setSlotsLeft(int slotsLeft) {
        SlotsLeft = slotsLeft;
    }

    public void setSunTokens(int sunTokens) {
        SunTokens = sunTokens;
    }


}
