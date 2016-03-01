package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BallFireTele extends Command {

    public BallFireTele() {
        requires(Robot.shooterSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooterSystem.SetEngage((Robot.oi.AuxStick.Buttons.A.current ? Value.kForward : Value.kOff));
    	Robot.shooterSystem.SetWinchPower(Robot.oi.AuxStick.RightStick.Y);
    	SmartDashboard.putBoolean("Fired Limit", Robot.shooterSystem.GetFiredLim());
    	SmartDashboard.putBoolean("Loaded Limit", Robot.shooterSystem.GetLoadedLim());
    	SmartDashboard.putBoolean("Cam Value", Robot.shooterSystem.GetCamPosition());
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
