package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.WinchLiftTeleop;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchLift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Victor m_Left, m_Right;
	
	public WinchLift(){
		m_Left = new Victor(RobotMap.PWM_Lift_Winch);
		m_Right = new Victor(RobotMap.PWM_Lift_Winch2);
	}
	
	public void LiftPower(double power){
		m_Left.set(power);
		m_Right.set(power);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new WinchLiftTeleop());
    }
}

