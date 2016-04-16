package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallIntakeToGrab extends Command {

	Timer ReleaseTimer;
	boolean Releasing;
	
    public BallIntakeToGrab() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.ballIntake);
        ReleaseTimer = new Timer();
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.ballIntake.BallVal()){
    		Robot.ballIntake.IntakePower(-1.0);
    		ReleaseTimer.reset();
    		ReleaseTimer.start();
    		Releasing = true;
    	}
    	else {
    		Robot.ballIntake.IntakePower(.5);
    		Releasing = false;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((!Releasing && Robot.ballIntake.BallVal()) || (Releasing && (ReleaseTimer.get() > 2)));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ballIntake.IntakePower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
