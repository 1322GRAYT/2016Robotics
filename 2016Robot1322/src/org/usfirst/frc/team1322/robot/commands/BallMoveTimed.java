package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallMoveTimed extends Command {
	
	// Internal Resources Required:
	private Timer BallTimer1;
	private double pickupTimer, pickupPower;
	
    public BallMoveTimed(double PickupTimer, double PickupPower) {
    	// What we need from the outside:
    	pickupTimer = PickupTimer;
    	pickupPower = PickupPower;
    	
    	// What Subsystem is required?
    	requires(Robot.ballPickup);
    	
    	// What internal resources are required to be initialized?
    	BallTimer1 = new Timer();
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Start Resources that are needed
    	BallTimer1.reset();
    	BallTimer1.start();
    	Robot.ballPickup.ballMovePower(pickupPower);
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Do I need to change initial parameters?
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Why does this command need to end?
        return BallTimer1.get() > pickupTimer;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Stop the resources that are being used
    	Robot.ballPickup.ballMoveStop();
    	BallTimer1.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	// Break glass in case of emergency: What needs to happen?
    	end();
    }
}
