package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.ArmTiltTeleop;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;


public class ArmTilt extends Subsystem {
    
	 private CANTalon armTilt;
    
    public ArmTilt(){
    	armTilt = new CANTalon(RobotMap.CAN_A_Pivot);
    	armTilt.enableBrakeMode(true);
    	//  	LiveWindow.addActuator("Arm Tilt", "Arm Tilt Motor", armTilt);
    }
    
	public void armPower(double power){
		armTilt.set(power);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ArmTiltTeleop());
    }
}

