package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBaseSubsystem extends SubsystemBase {
  private final CANSparkMax m_frontLeftMotor;
  private final CANSparkMax m_frontRightMotor;
  private final CANSparkMax m_backLeftMotor;
  private final CANSparkMax m_backRightMotor;
  private final MotorController leftSideGroup;
  private final MotorController rightSideGroup;
  private final DifferentialDrive drive;

  public DriveBaseSubsystem() {
    m_frontLeftMotor = new CANSparkMax(18, MotorType.kBrushed);
    m_frontRightMotor = new CANSparkMax(5, MotorType.kBrushed);
    m_backLeftMotor = new CANSparkMax(6, MotorType.kBrushed);
    m_backRightMotor = new CANSparkMax(7, MotorType.kBrushed);

    leftSideGroup = new MotorControllerGroup(m_frontLeftMotor, m_backLeftMotor);
    rightSideGroup = new MotorControllerGroup(m_frontRightMotor, m_backRightMotor);

    leftSideGroup.setInverted(true);

    drive = new DifferentialDrive(leftSideGroup, rightSideGroup);
  }

  public DifferentialDrive getDrive() {
    return drive;
  }

  public void arcadeDrive(double speed, double zRotation) {
    getDrive().arcadeDrive(speed, zRotation);
  }

  @Override
  public void periodic() {}
}
