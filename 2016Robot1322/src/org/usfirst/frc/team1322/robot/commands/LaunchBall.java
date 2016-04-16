package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LaunchBall extends Command {

	Timer LaunchTime;
    public LaunchBall() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.ballIntake);
        LaunchTime = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.ballIntake.IntakePower(1.0);
    	LaunchTime.reset();
    	LaunchTime.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return LaunchTime.get() > 5.0;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ballIntake.IntakePower(0);
    	LaunchTime.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
