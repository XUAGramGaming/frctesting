/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3911.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3911.robot.commands.DriveFowardCommand;
import org.usfirst.frc.team3911.robot.commands.ExampleCommand;
import org.usfirst.frc.team3911.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team3911.robot.subsystems.DrivetrainSubsystem;

public class Robot extends TimedRobot {
	
	//WE HAVE ADDED ON TO THE ROBOT
	
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static final DrivetrainSubsystem driveTrain = new DrivetrainSubsystem();

	Command choosenCommand;
	SendableChooser<Command> autonomousCommandChooser = new SendableChooser<>();

	
	//120 inches (auto line)
	
	@Override
	public void robotInit() {
		oi = new OI();
		autonomousCommandChooser.addDefault("Default Auto", new ExampleCommand());
		autonomousCommandChooser.addObject("Drive Foward 1 Second", new DriveFowardCommand());
		//add more commands here
		//calls the "initalize" method in commands
		SmartDashboard.putData("Auto mode", autonomousCommandChooser);
	}


	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		choosenCommand = autonomousCommandChooser.getSelected();
		if (choosenCommand != null) {
			choosenCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (choosenCommand != null) {
			choosenCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
