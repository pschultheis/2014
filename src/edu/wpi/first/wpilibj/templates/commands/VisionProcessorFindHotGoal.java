/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.RGBImage;
import edu.wpi.first.wpilibj.templates.subsystems.VisionProcessor;

/**
 *
 * @author Developer
 */
public class VisionProcessorFindHotGoal extends CommandBase {
    
  
    
    public VisionProcessorFindHotGoal() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(visionProcessor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "command started");
        ColorImage image = visionProcessor.getImage();
        BinaryImage binaryImage = visionProcessor.filterImage(image);
        visionProcessor.findHotTarget(0 , 0, binaryImage);    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
