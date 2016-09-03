package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BallSystemTeleop extends Command {

    public BallSystemTeleop() {
    	requires(Robot.ballSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.oi.AuxStick.refresh();
    	
    	double powerIn = Robot.oi.AuxStick.Triggers.Combined;
    	boolean ballSensor = Robot.ballSystem.ballSensor();
    	
		SmartDashboard.putBoolean("Is There a ball?", ballSensor);
		
		if (powerIn < 0){
			Robot.ballSystem.ballShooter(powerIn);
			Robot.ballSystem.ballHolder(powerIn);
		} else if (ballSensor == true){
			Robot.ballSystem.ballShooter(0);
			Robot.ballSystem.ballHolder(0);
			}
		else {
			Robot.ballSystem.ballShooter(powerIn);
			Robot.ballSystem.ballHolder(powerIn);
			
		}
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
