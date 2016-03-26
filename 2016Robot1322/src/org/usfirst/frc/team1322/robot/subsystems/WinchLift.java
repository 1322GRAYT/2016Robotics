package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.WinchLiftTeleop;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchLift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Victor m_Left, m_Right;
	Servo m_RelLeft, m_RelRight;
	
	public WinchLift(){
		m_Left = new Victor(RobotMap.PWM_Lift_Winch);
		m_RelLeft = new Servo(RobotMap.PWM_Servo_Rel_Left);
		m_RelRight = new Servo(RobotMap.PWM_Servo_Rel_Right);
	}
	
	public void LiftPower(double power){
		m_Left.set(power);
		m_Right.set(power);
	}
	
	public void ReleaseWinch(boolean out, boolean in){
		if(out){
        	WinchReleaseOut();
        } else if(in){
        	WinchReleaseIn();
        }
	}
	
	void WinchReleaseIn(){
		m_RelLeft.set(0.0);
        m_RelRight.set(1.0);
	}
	
	void WinchReleaseOut(){
		m_RelLeft.set(1.0);
        m_RelRight.set(0.0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new WinchLiftTeleop());
    }
}

