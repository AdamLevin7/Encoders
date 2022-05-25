package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends SubsystemBase {

  private final WPI_TalonSRX _leftDriveTalon;
  private final WPI_TalonSRX _rightDriveTalon;
  private double ticksToMeters  = (127.0/10581.0)/100.0; //converts from sensor units to meters

  private DifferentialDrive _diffDrive;


  /** Creates a new DriveTrain. */
  public DriveTrain() {
    _leftDriveTalon = new WPI_TalonSRX(Constants.DriveTrainPorts.LeftDriveTalonPort);
    _rightDriveTalon = new WPI_TalonSRX(Constants.DriveTrainPorts.RightDriveTalonPort);

    _leftDriveTalon.setInverted(false);
    _rightDriveTalon.setInverted(false);
    

    _diffDrive = new DifferentialDrive(_leftDriveTalon, _rightDriveTalon);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Position: ", getPos());
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    _diffDrive.tankDrive(leftSpeed, rightSpeed);
  }
  public void arcadeDrive(double speed, double rotation) {
    _diffDrive.tankDrive(speed, rotation);
  }
  public double getPos(){
    return (_leftDriveTalon.getSelectedSensorPosition()+_rightDriveTalon.getSelectedSensorPosition()
    /2*ticksToMeters);
  }
  public void setPos(double pos){
    _leftDriveTalon.setSelectedSensorPosition(pos);
  }
  public void resetEncoders(){
    _leftDriveTalon.setSelectedSensorPosition(0, 0, 10);
    _rightDriveTalon.setSelectedSensorPosition(0, 0, 10);
  }
}