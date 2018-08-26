package org.usfirst.frc.team3911.robot.commands;

import org.usfirst.frc.team3911.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveFowardCommand extends Command {
	private long endTime;
	private long currentTime;
	private double duration = 0.5;
	public DriveFowardCommand(double seconds) {
		requires(Robot.driveTrain);
		duration = seconds;
	}
	
	public DriveFowardCommand() {
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		currentTime = System.currentTimeMillis();
		endTime = (long) (currentTime + (duration * 1000)); 
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		currentTime = System.currentTimeMillis();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (currentTime > endTime);
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
