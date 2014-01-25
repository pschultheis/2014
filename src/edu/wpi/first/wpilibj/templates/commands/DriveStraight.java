/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Developer
 */
public class DriveStraight extends CommandBase {
    
    double speed;
    double time;
    
    public DriveStraight(double speed, double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        requires(drive);
        this.speed = speed;
        this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        this.setTimeout(this.time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.tankDrive(this.speed, this.speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         if(isTimedOut())
        {
            return true;
        }else
        {
            return false;
        }
        
    }

    // Called once after isFinished returns true
    protected void end() {
        drive.tankDrive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
