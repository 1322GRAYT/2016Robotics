package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.commands.BallIntakeTeleop;
import org.usfirst.frc.team1322.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class BallIntake extends Subsystem {
    	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Relay ballIntake;
	Talon ballIntakeUD;
	DigitalInput LIM_Up, LIM_Down;
	//Ball Sucker
	public BallIntake() {
		ballIntake = new Relay(RobotMap.R_BallIntake);
		ballIntakeUD = new Talon(RobotMap.PWM_Intake_UD);
		
		LIM_Up = new DigitalInput(RobotMap.LIM_Intake_Up);
		LIM_Down = new DigitalInput(RobotMap.LIM_Intake_Down);
		
		LiveWindow.addActuator("Ball Intake", "Ball Intake", ballIntake);
	}
	
	
	
	public void ballIntakeIn() {
		if (ballIntake.get() != Value.kReverse){
			ballIntakePower(Value.kReverse);
		}
		ballIntakePower(Value.kOn);
	}
	public void ballIntakeOut() {
		if (ballIntake.get() != Value.kForward){
			ballIntakePower(Value.kForward);
		}
		ballIntakePower(Value.kOn);
	}
	public void ballIntakeOff() {
		ballIntakePower(Value.kOff);
	}
	
	public void ballIntakeUDPower(double power){
		ballIntakeUD.set(!LIM_Up.get() && (power < 0) ? 0 : (!LIM_Down.get() && power > 0 ? 0 : power));
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

