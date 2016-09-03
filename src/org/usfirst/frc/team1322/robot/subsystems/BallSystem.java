package org.usfirst.frc.team1322.robot.subsystems;



import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.BallSystemTeleop;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class BallSystem extends Subsystem {
	DigitalInput ballSensor;
    Victor ballShooter;
    private CANTalon ballHolder;
    
    public BallSystem(){
		ballSensor = new DigitalInput(RobotMap.DIG_Ball_Sensor);
    	ballHolder = new CANTalon(RobotMap.CAN_Ball_Holder);
    	ballShooter = new Victor(RobotMap.PWM_Ball_Intake);
    }
	public void ballHolder(double power1) {
		ballHolder.set(power1);
	}
	public void ballShooter(double power2){
		ballShooter.set(power2);
	}	
	
	public boolean ballSensor(){
		return ballSensor.get();
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new BallSystemTeleop());
    }
}

