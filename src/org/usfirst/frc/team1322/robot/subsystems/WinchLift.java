package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.WinchLiftTeleop;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;


public class WinchLift extends Subsystem {
	 private CANTalon winchHookL, winchHookR;
	
	public WinchLift(){
		winchHookL = new CANTalon(RobotMap.CAN_Lift_WinchL);
		winchHookR = new CANTalon(RobotMap.CAN_Lift_WinchR);
		winchHookR.changeControlMode(TalonControlMode.Follower);
	}
	
	public void LiftPower(double power){
		winchHookL.set(power);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new WinchLiftTeleop());
    }
}

