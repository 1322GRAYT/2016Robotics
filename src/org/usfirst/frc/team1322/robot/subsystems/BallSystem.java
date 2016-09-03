package org.usfirst.frc.team1322.robot.subsystems;



import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.BallSystemTeleop;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;


public class BallSystem extends Subsystem {
    Victor ballShooter;
    private CANTalon ballHolder;
    
    public BallSystem(){
    	ballHolder = new CANTalon(RobotMap.CAN_Ball_Holder);
    	ballShooter = new Victor(RobotMap.PWM_Ball_Intake);
    }
    
	public void ballShooterIn(double powerIn){
		ballShooter.set(powerIn);
		ballHolder.set(powerIn);
	}
	
	public void ballShooterOut(double powerOut){
		ballShooter.set(-powerOut);
		ballHolder.set(-powerOut);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new BallSystemTeleop());
    }
}

