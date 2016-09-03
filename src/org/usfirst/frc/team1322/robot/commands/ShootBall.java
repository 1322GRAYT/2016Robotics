package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootBall extends Command {

	Timer PreRunTimer;
	
    public ShootBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.ballSystem);
    	PreRunTimer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	PreRunTimer.reset();
    	Robot.ballSystem.ballShooter(-1);
    	PreRunTimer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(PreRunTimer.get() > 1) Robot.ballSystem.ballHolder(-.75);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return PreRunTimer.get() > 2.5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ballSystem.ballHolder(0);
		Robot.ballSystem.ballShooter(0);
		PreRunTimer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
