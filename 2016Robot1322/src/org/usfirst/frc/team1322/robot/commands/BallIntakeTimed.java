package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

enum intakeDirection{kIn, kOut}

public class BallIntakeTimed extends Command {
	// Internal Resources Required:
	private Timer BallTimer2;
	private double pickupTimer; 
	private intakeDirection direction;
	
    public BallIntakeTimed(double PickupTimer, intakeDirection Direction) {
    	// What we need from the outside:
    	pickupTimer = PickupTimer;
    	direction = Direction;
    	
    	// What Subsystem is required?
    	requires(Robot.ballIntake);
    	
    	// What internal resources are required to be initialized?
    	BallTimer2 = new Timer();
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Start Resources that are needed
    	BallTimer2.reset();
    	BallTimer2.start();
    	if (direction == intakeDirection.kIn){
    		Robot.ballIntake.ballIntakeControl(true, false);
    	}
    	else {
    		Robot.ballIntake.ballIntakeControl(false, true);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Do I need to change initial parameters?
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Why does this command need to end?
        return BallTimer2.get() > pickupTimer;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Stop the resources that are being used
    	Robot.ballIntake.ballIntakeOff();
    	BallTimer2.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	// Break glass in case of emergency: What needs to happen?
    	end();
    }
}
