package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FireShooter extends Command {

	
	boolean isShooterNotReady, hasCycled;
    public FireShooter() {
    	requires(Robot.shooterSystem);
    	isShooterNotReady = false;
    	hasCycled = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (!Robot.shooterSystem.GetLoadedLim()){
    		isShooterNotReady = true;
    		SmartDashboard.putString("FiredStatus 2", "No Go");
    	}
    	else{
    		SmartDashboard.putString("FiredStatus 2", "Yes, going");
    		Robot.shooterSystem.EngageCam();
    		isShooterNotReady = false;
    		hasCycled = false;
    	}
    	SmartDashboard.putString("FiredStatus", "What");
    	SmartDashboard.putBoolean("Cam Status", Robot.shooterSystem.GetCamPosition());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putString("FiredStatus", "Not Done");
    	SmartDashboard.putBoolean("Cycled?", hasCycled);
    	if(!hasCycled && !Robot.shooterSystem.GetCamPosition()){
    		hasCycled = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((Robot.shooterSystem.GetCamPosition() && hasCycled) || isShooterNotReady);
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putString("FiredStatus", "Fired");
    	Robot.shooterSystem.StopCam();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
