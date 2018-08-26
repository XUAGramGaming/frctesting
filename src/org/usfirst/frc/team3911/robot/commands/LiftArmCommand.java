/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3911.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3911.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class LiftArmCommand extends Command {
	
	private long currentTime;
	private long endTime;
	private double duration = 0.5;
	private double armMotorSpeed = 0.25;
	
	public LiftArmCommand() {
		requires(Robot.armSubsystem);
	}
	
	public LiftArmCommand(double duration) {
		requires(Robot.armSubsystem);
		this.duration = duration;
	}
	
	
	public LiftArmCommand(double duration, double speed) {
		requires(Robot.armSubsystem);
		this.duration = duration;
		this.armMotorSpeed = speed;
	}
	
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		currentTime = System.currentTimeMillis();
		endTime = (long) (currentTime + (duration * 1000));
		Robot.armSubsystem.setArmMotorSpeed(armMotorSpeed);
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
		Robot.armSubsystem.setArmMotorSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		System.out.println("ERROR LifeArmCommand - Command Interupted");
	}
}
