/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Developer
 */
public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public static Solenoid ballShifterSolenoid;
    
    public boolean stateOfShifter;

    
    Jaguar driveLeftMotor;
    Jaguar driveRightMotor;
    
    public Drive()
    {
        driveLeftMotor = new Jaguar(2);
        driveRightMotor = new Jaguar(1);
        
        ballShifterSolenoid = new Solenoid(3);
        
    }
    
    //public           
    //
    
    public boolean getStateOfShifter()
    {
       return(ballShifterSolenoid.get());
    }
   
    public void switchToHighGear()
    {
       ballShifterSolenoid.set(true);
        
    }
    
    public void switchToLowGear()
    {
        ballShifterSolenoid.set(false);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
        public void tankDrive(double leftJoy, double rightJoy)
    {
        //set motor speeds
        driveLeftMotor.set(leftJoy*-1.0);
        driveRightMotor.set(rightJoy*-1.0);
        //DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 3, "" + driveLeftMotor.getRaw());
        //DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 4, "" + driveRightMotor.getRaw());
        //DriverStationLCD.getInstance().updateLCD();
    }
    
     /**
     * Arcade drive implements single stick driving.
     * This function lets you directly provide joystick values from any source.
     * @param moveValue The value to use for forwards/backwards
     * @param rotateValue The value to use for the rotate right/left
     * @param squaredInputs If set, decreases the sensitivity at low speeds
     */
    public void arcadeDrive(double moveValue, double rotateValue, boolean squaredInputs) {
        // local variables to hold the computed PWM values for the motors
        double leftMotorSpeed;
        double rightMotorSpeed;

        if (squaredInputs) {
            // square the inputs (while preserving the sign) to increase fine control while permitting full power
            if (moveValue >= 0.0) {
                moveValue = (moveValue * moveValue);
            } else {
                moveValue = -(moveValue * moveValue);
            }
            if (rotateValue >= 0.0) {
                rotateValue = (rotateValue * rotateValue);
            } else {
                rotateValue = -(rotateValue * rotateValue);
            }
        }

        if (moveValue > 0.0) {
            if (rotateValue > 0.0) {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = Math.max(moveValue, rotateValue);
            } else {
                leftMotorSpeed = Math.max(moveValue, -rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
        } else {
            if (rotateValue > 0.0) {
                leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            } else {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
            }
        }

        tankDrive(leftMotorSpeed, rightMotorSpeed);
    }

}