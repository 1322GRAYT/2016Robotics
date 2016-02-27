package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoadShooter extends Command {

	boolean isShooterReady;
    public LoadShooter() {
        requires(Robot.shooterSystem);
        isShooterReady = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (!Robot.shooterSystem.GetLoadedLim()){
    		if(!Robot.shooterSystem.GetCamPosition()){
    			Robot.shooterSystem.SetEngage(Value.kForward);
    		}
    		
    		Robot.shooterSystem.SetWinchEngage();
    	}
    	else{
    		isShooterReady = true;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.shooterSystem.GetCamPosition()){
			Robot.shooterSystem.SetEngage(Value.kOff);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (isShooterReady || Robot.shooterSystem.GetLoadedLim());
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
