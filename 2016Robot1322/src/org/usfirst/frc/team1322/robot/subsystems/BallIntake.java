package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.commands.BallIntakeTeleop;
import org.usfirst.frc.team1322.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallIntake extends Subsystem {
    	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Relay ballIntake;
	//Ball Sucker
	public BallIntake() {
		ballIntake = new Relay(RobotMap.R_BallIntake);
		}
	
	public void ballIntakeIn() {
		ballIntakePower(Value.kReverse);
	}
	public void ballIntakeOut() {
		ballIntakePower(Value.kForward);
	}
	public void ballIntakeOff() {
		ballIntakePower(Value.kOff);
	}
	public void ballIntakeControl (boolean in, boolean out) {
		if (!in && !out){
			ballIntakeOff();
		}
		else if(in) {
			ballIntakeIn();
		}
		else if (out){
			ballIntakeOut();
		}
	}
	private void ballIntakePower(Value intakePower) {
		ballIntake.set(intakePower);
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new BallIntakeTeleop());
	}
}

