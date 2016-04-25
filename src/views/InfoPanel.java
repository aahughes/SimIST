/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.BuildingHVAC;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aah5307
 */
public class InfoPanel extends JPanel{
    private BuildingHVAC ac;
    // private int occupancy;
    // private int maxOccupancy;
    private double buildingTemp;
    private double outsideTemp;
    // private int players;
    private int roomsOpen;
    
    private JLabel tempout;
    private JLabel tempin;
    private JLabel rooms;
    
    public InfoPanel(){
        // change if/when BuildingHVAC is implemented elsewhere or finished,
        // uses default value for now
        ac = new BuildingHVAC(55);
        
        buildingTemp = ac.currentIndoorTemp;
        outsideTemp = ac.outsideTemp;
       
        // change to # of current accessible rooms in building
        roomsOpen = 4;
        
        tempout = new JLabel("Outdoor Temperature: "+Double.toString(outsideTemp));
        tempin = new JLabel("Indoor Temperature: "+Double.toString(buildingTemp));
        
        rooms = new JLabel("Current Rooms: " + Integer.toString(roomsOpen));
        
        this.add(tempout);
        this.add(tempin);
        this.add(rooms);
    }             
}
