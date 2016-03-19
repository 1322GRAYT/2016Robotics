package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CycleShooter extends CommandGroup {
    
    public  CycleShooter() {
        addSequential(new FireShooter());
        addSequential(new LoadShooter());
    }
}
