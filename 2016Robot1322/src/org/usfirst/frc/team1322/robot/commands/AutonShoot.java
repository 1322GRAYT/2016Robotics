package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonShoot extends CommandGroup {
    
    public  AutonShoot() {
    	addSequential(new ArmTiltTimed(1,-0.5));
    	addSequential(new DriveAuton(5, -0.75, 0));
    	addSequential(new DriveAuton(3,0,0.75));
    	addSequential(new ArmTiltTimed(1,0.5));
    	addSequential(new CycleShooter());
    }
}
