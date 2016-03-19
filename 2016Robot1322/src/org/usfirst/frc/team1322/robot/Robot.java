package org.usfirst.frc.team1322.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1322.robot.commands.AutonimousMode1;
import org.usfirst.frc.team1322.robot.subsystems.ArmTilt;
import org.usfirst.frc.team1322.robot.subsystems.BallIntake;
import org.usfirst.frc.team1322.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team1322.robot.subsystems.ShooterSystem;
import org.usfirst.frc.team1322.robot.subsystems.WinchLift;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**********************************************************
 * 
 * @author ericw
 *	Programming Team: Last code review 2/20/16
 *	
 */
public class Robot extends IterativeRobot {
	
	// Setup Subsystems
	public static final DriveSubsystem DriveSystem = new DriveSubsystem();
	public static final BallIntake ballIntake = new BallIntake();
	public static final ArmTilt armTilt = new ArmTilt();
	public static final ShooterSystem shooterSystem = new ShooterSystem();
	public static final WinchLift winchLift = new WinchLift();
	
	
	// Base Code
	public static OI oi;
    Command autonomousCommand;
    SendableChooser chooser;

    // Initialize Robot - First Cycle
    public void robotInit() {
		oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Drive Forward Auton", new AutonimousMode1());
        chooser.addObject("NULL AUTON", null);
        SmartDashboard.putData("Auto mode", chooser);
        CameraServer cams = CameraServer.getInstance();
        // set any cam parameters, then start capture
        cams.startAutomaticCapture("cam0");
        //SmartDashboard.getNumber("Drive_Time", 5.0);
        //SmartDashboard.getNumber("Arm_Down_Time", 1.0);
    }
	
	// Disabled Init
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	// Autonomous mode selection
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    // This function is called periodically during autonomous
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// Stops autonomous mode
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    // Teleop periodic
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    // Test Periodic
    public void testPeriodic() {
        LiveWindow.run();
    }
}
