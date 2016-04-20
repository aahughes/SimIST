/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Paul
 */
import java.awt.*;
public class CharacterSprite extends Rectangle{
    
    private String[] animation;
 
    
    public CharacterSprite(Dimension inf_FrameSize)
    {
        animation = new String [] {"right1.png" , "right2.png" , "left1.png" , "left2.png" , "up1.png" , "up2.png" , "down1.png" , "down2.png"};
        setSize(inf_FrameSize);
    }
    
    
    public String[] getAnimation()
    {
        return animation;
    }
    
    public void setSize(Dimension size){
        double tempHeight = size.height * .125;
        double tempWidth = size.width * .05;
        double tempX = size.width * .875;
        double tempY = size.height * .666;     
        height = (int) tempHeight;
        width = (int) tempWidth;
        x = (int) tempX;
        y = (int) tempY;
    }
}
