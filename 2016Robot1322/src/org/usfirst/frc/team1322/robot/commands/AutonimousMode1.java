package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonimousMode1 extends CommandGroup {
    
    public  AutonimousMode1() {

    	addSequential(new ArmTiltTimed(1,-0.5));
    	addSequential(new DriveAuton(5, -0.75, 0));
    }
}
