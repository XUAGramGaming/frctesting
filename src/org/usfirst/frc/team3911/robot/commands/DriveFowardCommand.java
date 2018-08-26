package org.usfirst.frc.team3911.robot.commands;

import org.usfirst.frc.team3911.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveFowardCommand extends Command {
	private Subsystem arm;
	private float endTime;
	private float currentTime;
	
	public DriveFowardCommand(double seconds) {
		requires(Robot.driveTrain);
	}
	
	public DriveFowardCommand() {
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}

}
