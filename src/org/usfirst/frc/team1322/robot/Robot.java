
package org.usfirst.frc.team1322.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1322.robot.commands.AutonimousMode1;
import org.usfirst.frc.team1322.robot.commands.prankAuton;
import org.usfirst.frc.team1322.robot.subsystems.ArmTilt;
import org.usfirst.frc.team1322.robot.subsystems.BallSystem;
import org.usfirst.frc.team1322.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team1322.robot.subsystems.WinchLift;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**********************************************************
 * 
 * @author SorenZaiser
 *	
 */


public class Robot extends IterativeRobot {
	
	// Setup Subsystems
	public static final DriveSubsystem DriveSystem = new DriveSubsystem();
	public static final ArmTilt armTilt = new ArmTilt();
	public static final BallSystem ballSystem = new BallSystem();
	public static final WinchLift winchLift = new WinchLift();
	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;


    public void robotInit() {
		oi = new OI();
		chooser = new SendableChooser();
        chooser.addDefault("Drive Forward Auton", new AutonimousMode1());
        //chooser.addObject("No Arm Drop", new AutonNoArmDrop());
        //chooser.addObject("DONT USE THIS, BAD THINGS WILL HAPPEN!!! #SarahSaysHi!", new AutonShoot());
        chooser.addObject("NULL AUTON", null);
        chooser.addObject("DON'T DO IT", new prankAuton());
        SmartDashboard.putData("Auto mode", chooser);
//        chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putString("Soren Wrote This Code, This is Version ", "1.2");
        SmartDashboard.putData("Auto mode", chooser);
        CameraServer cams = CameraServer.getInstance();
        // set any cam parameters, then start capture
        cams.startAutomaticCapture("cam0");
    }
	
    
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	//Cancel Autonomous Mode
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
