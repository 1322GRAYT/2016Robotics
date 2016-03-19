package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallIntakeTeleop extends Command {

    public BallIntakeTeleop() {
    	requires(Robot.ballIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.oi.AuxStick.refresh();
    	Robot.ballIntake.ballIntakeControl(Robot.oi.AuxStick.Buttons.LB.current, Robot.oi.AuxStick.Buttons.RB.current);
    	Robot.ballIntake.ballIntakeUDPower(Robot.oi.AuxStick.RightStick.Y);
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
