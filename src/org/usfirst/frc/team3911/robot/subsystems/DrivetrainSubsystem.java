package org.usfirst.frc.team3911.robot.subsystems;

import org.usfirst.frc.team3911.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DrivetrainSubsystem  extends Subsystem {
	private Spark leftFrontMotor = new Spark(RobotMap.leftFrontMotor);
	private Spark leftRearMotor = new Spark(RobotMap.leftRearMotor);
	private SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
	
	private Spark rightFrontMotor = new Spark(RobotMap.rightFrontMotor);
	private Spark rightRearMotor = new Spark(RobotMap.rightRearMotor);
	private SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);
	
	private DifferentialDrive drivetrain = new DifferentialDrive(leftMotors, rightMotors);
	
	public void initDefaultCommand() {
		//NoneForNow
	}
	
	public void tankDrive(double leftSpeed, double rightSpeed){
		drivetrain.tankDrive(leftSpeed, rightSpeed);
	}
	
	public void arcadeDrive(double xSpeed, double zRotation){
		drivetrain.arcadeDrive(xSpeed, zRotation);
	}
	
}
