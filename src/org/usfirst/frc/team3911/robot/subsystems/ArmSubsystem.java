package org.usfirst.frc.team3911.robot.subsystems;


import org.usfirst.frc.team3911.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmSubsystem extends Subsystem {
	private Spark armMotor = new Spark(RobotMap.armMotor);
	
	private DoubleSolenoid clamper = new DoubleSolenoid(RobotMap.firstClampSolenoid, RobotMap.secondClampSolenoid);
	private DoubleSolenoid extender = new DoubleSolenoid(RobotMap.firstExtenderSolenoid, RobotMap.secondExtenderSolenoid);
	
	private boolean isClamped;
	private boolean isExtended;
	
	public void initDefaultCommand() {
		isClamped = false;
		isExtended = false;
	}
	
	public void setArmMotorSpeed(double speed){
		armMotor.setSpeed(speed);
	}
	
	public void toggleClamp(){
		if(isClamped){
			//TODO: UNCLAMP TASK
			
			System.out.println("UNCLAMPING");
			return;
		}
		//TODO: CLAMP TASK
		
		System.out.println("CLAMPING");
		isClamped = true;
		return;
	}
	
	public void toggleExtendor(){
		if(isExtended){
			//TODO: RETRACT TASK
			
			System.out.println("RETRACTING ARM");
			return;
		}
		//TODO: EXTEND TASK
		
		System.out.println("EXTENDING ARM");
		isExtended = true;
		return;
	}
	
}
