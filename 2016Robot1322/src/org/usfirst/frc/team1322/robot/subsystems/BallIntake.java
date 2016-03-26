package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.commands.BallIntakeTeleop;
import org.usfirst.frc.team1322.robot.RobotMap;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallIntake extends Subsystem {
	Servo m_LeftGrab, m_RightGrab;
	
	//Ball Sucker
	public BallIntake() {
		m_LeftGrab = new Servo(RobotMap.PWM_Servo_Ball_Grab_Left);
		m_RightGrab = new Servo(RobotMap.PWM_Servo_Ball_Grab_Right);
	}
	
	public void ballIntakeControl (boolean open, boolean close) {
		if(open) {
			ballIntakeOpen();
		}
		else if (close){
			ballIntakeClose();
		}
	}
	
	private void ballIntakeClose() {
		m_LeftGrab.set(1.0);
		m_RightGrab.set(0.0);
		
	}

	private void ballIntakeOpen() {
		m_LeftGrab.set(0.0);
		m_RightGrab.set(1.0);
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new BallIntakeTeleop());
	}
}

