
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.DriveSwitchToHighGear;
import edu.wpi.first.wpilibj.templates.commands.DriveSwitchToLowGear;
import edu.wpi.first.wpilibj.templates.commands.VisionProcessorFindHotGoal;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


 public class OI {
    Joystick xboxDriver = new Joystick(1);
    
    //Button Driverbutton1A = new JoystickButton(xboxDriver, 1); 
        
    Button Driverbutton2B = new JoystickButton(xboxDriver, 2);
    
    Button Driverbutton3X = new JoystickButton(xboxDriver, 3);
    
    Button Driverbutton4Y = new JoystickButton(xboxDriver, 4);
    
    //Button Driverbutton5LB = new JoystickButton(xboxDriver, 5);
    
    //Button Driverbutton6RB = new JoystickButton(xboxDriver, 6);
    
    //Button Driverbutton7SEL = new JoystickButton(xboxDriver, 7);
    
   // Button Driverbutton8STRT = new JoystickButton(xboxDriver, 8);
    
    //Button Driverbutton9LS = new JoystickButton(xboxDriver, 9);
    
    //Button Driverbutton10RS = new JoystickButton(xboxDriver, 10);
    
    //code = robot;
    
     public OI()
     {
        
         Driverbutton2B.whenPressed(new VisionProcessorFindHotGoal());
         Driverbutton3X.whenPressed(new DriveSwitchToHighGear());
         Driverbutton4Y.whenPressed(new DriveSwitchToLowGear());
     }
     
     
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public double getMoveValue()
    {
        return xboxDriver.getY();
    }
    public double getRotateValue()
    {
        return xboxDriver.getX();
    }
    public double getZValue()
    {
        return xboxDriver.getZ()*.25;
    }
    
    public double getHalfMoveValue()
    {
        return (xboxDriver.getRawAxis(5)/2.0);
    }
    public double getHalfRotateValue()
    {
        return ((xboxDriver.getRawAxis(4))*2.0/3.0);
    }
}
