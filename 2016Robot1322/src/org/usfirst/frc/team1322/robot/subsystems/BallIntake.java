package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallIntake extends Subsystem {
	// pwm3
	
	Talon m_BallIntake;
	DigitalInput s_BallIn;
	
	public BallIntake() {
		m_BallIntake = new Talon(RobotMap.PWM_Ball_Intake);
		m_BallIntake.setInverted(true);
		s_BallIn = new DigitalInput(RobotMap.LIM_Ball_In);
	}
	
	public boolean BallVal(){
		return s_BallIn.get();
	}
	
	public void IntakePower(double power){
		m_BallIntake.set(power);
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//setDefaultCommand(new BallIntakeTeleop());
	}
}

