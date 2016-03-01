package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.ArmTiltTeleop;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

// TODO: Investigate PID control for this subsystem

public class ArmTilt extends Subsystem {
    Victor armTilt;
    AnalogPotentiometer armPot;
	private static double currentLimit = 90;
    
    public ArmTilt(){
    	armTilt = new Victor(RobotMap.PWM_A_Pivot);
    	LiveWindow.addActuator("Arm Tilt", "Arm Tilt Motor", armTilt);
    	
    	armPot = new AnalogPotentiometer(RobotMap.POT_ArmLift, 90, 30); // TODO: Figure this line out
    	LiveWindow.addSensor("Arm Tilt", "Arm Tilt Angle", armPot);
    }
    
    public void armTiltPower(double power) {
    	// TODO: Insert Clause to go past 90 deg
    	double position = GetArmPosition();
    	
    	if ((position > currentLimit && power > 0) || (position > 0 && power < 0)){
    		armTiltStop();
    	}
    	else {
    		armTilt.set(power);
    	}
    }
    
    public void override(double power){
    	System.out.println(GetArmPosition());
    	armTilt.set(power*3/4);
    }
    
    public void setArmLimit(){
    	currentLimit = 120; // TODO: Investigate how far the tilt needs to go.
    }
    
    public void armTiltUp() {
    	armTiltPower(1);
    }
    public void armTiltStop() {
    	armTilt.set(0);
    }
    public void armTiltDown() {
    	armTiltPower(-1);
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new ArmTiltTeleop());
    }

	public double GetArmPosition() {
		return armPot.get();
	}
}

