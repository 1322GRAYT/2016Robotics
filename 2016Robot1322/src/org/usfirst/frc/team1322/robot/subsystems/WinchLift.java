package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.WinchLiftTeleop;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class WinchLift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Victor m_Lift;
	Servo m_Brake;
	
	public WinchLift(){
		m_Lift = new Victor(RobotMap.PWM_Lift_Winch);
		m_Brake = new Servo(RobotMap.PWM_Servo_Brake);
	}
	
	public void LiftPower(double power){
		m_Lift.set(power);
	}
	
	public void ReleaseWinch(boolean out, boolean in){
		if(out){
        	m_Brake.set(0);
        	SmartDashboard.putString("Brake Status", "Out");
        } else if(in){
        	m_Brake.set(1);
        	SmartDashboard.putString("Brake Status", "Engaged");
        }
	}
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new WinchLiftTeleop());
    }
}

