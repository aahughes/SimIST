/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import sandbox.Clock;
import sandbox.ClockControl;

/**
 *
 * @author Allison
 */
public class ClockPanel extends JPanel implements ActionListener{
    private ClockControl clockControl;
    private Timer updater;
    private JButton speedUpButton;
    private JButton slowDownButton;
    private JButton pauseButton;
    private JLabel timeDisplay;
    private JLabel speedDisplay;
    
    
    public ClockPanel() throws ParseException{
        this.clockControl = new ClockControl();
        
        String display = clockControl.display();
        speedUpButton = new JButton("speed up");
        slowDownButton = new JButton("slow down");
        pauseButton = new JButton("pause");
        timeDisplay = new JLabel(clockControl.display());
        speedDisplay = new JLabel("Current Speed: " +Integer.toString(clockControl.getSpeed()));        
        
        speedUpButton.addActionListener(this);
        slowDownButton.addActionListener(this);
        pauseButton.addActionListener(this);

        
        updater = new Timer(60000,new UpdateTimer());
        updater.start();
        
        this.add(speedUpButton);
        this.add(slowDownButton);
        this.add(pauseButton);
        this.add(timeDisplay);
        this.add(speedDisplay);
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if (o == speedUpButton)
            clockControl.speedup();
        if (o == slowDownButton)
            clockControl.slowdown();
        if (o == pauseButton)
            clockControl.pause();
        
        speedDisplay.setText("Current Speed: " +Integer.toString(clockControl.getSpeed()));  
        speedDisplay.repaint();
    }
    
    class UpdateTimer implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String display = clockControl.display();
            timeDisplay.setText(display);
            timeDisplay.repaint();
            
        }
        
    }
    
}
