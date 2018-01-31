package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDriveCommand extends Command {
	public static Timer timer;
	private double time;
	private double a;
	private double b;
	private double c;
	
    public AutoDriveCommand(double x, double y, double z) {
    	requires(Robot.autoDrive);
    	timer = new Timer();
    	
    	a = x;
    	b = y;
    	c = z;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("time", timer.get());
    	Robot.autoDrive.TimedDrive(a, b);
    	}
    	
    	
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(time >= timer.get()){
    		Robot.autoDrive.TimedDrive(a, b);
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
