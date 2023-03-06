

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class Robot extends TimedRobot {

  //Left Motors
  private final WPI_VictorSPX LeftFront = new WPI_VictorSPX(5);
  private final WPI_VictorSPX LeftBack = new WPI_VictorSPX(2);

  //Right Motors
  private final WPI_VictorSPX RightFront = new WPI_VictorSPX(4);  
  private final WPI_VictorSPX RightBack = new WPI_VictorSPX(3);

  //MotorControllers
  private final MotorControllerGroup LeftMotors = new MotorControllerGroup(LeftFront, LeftBack);
  private final MotorControllerGroup RightMotors = new MotorControllerGroup(RightFront, RightBack);

  //DriveTrain
  private final DifferentialDrive drivetrain = new DifferentialDrive(LeftMotors, RightMotors);
  private final Joystick stick = new Joystick(0);

  


  @Override
  public void robotInit() {
    RightMotors.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    double y = stick.getRawAxis(1);
    double x = -stick.getRawAxis(4);

    drivetrain.arcadeDrive(y, x);

  }
}
