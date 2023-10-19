package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import static frc.robot.Robot.driveBaseSubsystem;


public class DefaultDrive extends CommandBase {
  public double speed;
  public DefaultDrive(double speed) {
    this.speed = speed;
    addRequirements(driveBaseSubsystem);
  }

  @Override
  public void execute() {
    driveBaseSubsystem.arcadeDrive(speed, 0.3);
  }
}
