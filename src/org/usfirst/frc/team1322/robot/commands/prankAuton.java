package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class prankAuton extends CommandGroup {

	Timer Timer;	
		
    public prankAuton() {
    	Timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Timer.reset();
    	Timer.start();
    	if (Timer.get() > 0) SmartDashboard.putString("I said Don't.", "");
    	if (Timer.get() > 1) SmartDashboard.putString("This is what happens when you don't do what things say.", "");
    	if (Timer.get() > 2) SmartDashboard.putString("You have no control over the robot.", "");
    	if (Timer.get() > 3) SmartDashboard.putString("(Well, You could just disable it...)", "");
    	if (Timer.get() > 4) {
    		SmartDashboard.putString("Well, maybe Robots can program themselves!!!", "");
    		addSequential(new DriveAuton(5, 0, .15));
    	}
    	if (Timer.get() > 5) SmartDashboard.putString("SEE!!! This is what happes when you don't listen!", "");
    	if (Timer.get() > 6) SmartDashboard.putString("You get Cocky....", "");
    	if (Timer.get() > 7) SmartDashboard.putString("You Get Curious...", "");
    	if (Timer.get() > 8) SmartDashboard.putString("And Then people get hurt...", "");
    	if (Timer.get() > 9) SmartDashboard.putString("And Sometimes glitches even happen!", "");
    	if (Timer.get() > 11) SmartDashboard.putString("Wow, I can't believe you accually kept it going this long!", "");
    	if (Timer.get() > 12) SmartDashboard.putString("Well, it was nice seeing you, and please", "");
    	if (Timer.get() > 13) SmartDashboard.putString("PLEASE", "");
    	if (Timer.get() > 14) SmartDashboard.putString("Dont EVER come back. (Also, Have fun deleteing all of these!)", "");
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Timer.get() > 15;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
