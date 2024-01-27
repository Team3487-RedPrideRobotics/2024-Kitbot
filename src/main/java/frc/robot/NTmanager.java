
package frc.robot;

import edu.wpi.first.networktables.BooleanPublisher;
import edu.wpi.first.networktables.BooleanSubscriber;
import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooty;

public class NTmanager {
  
    public static DoublePublisher DriveSpeedPub;
    public static DoubleSubscriber DriveSpeedSub;

    public static DoublePublisher IntakeSpeedPub;
    public static DoubleSubscriber IntakeSpeedSub;

    public static DoublePublisher ShootSpeedPub;
    public static DoubleSubscriber ShootSpeedSub;

    public static DoublePublisher TimerPub;
    public static DoubleSubscriber TimerSub;

    public static void initialize(){
      var networkTable = NetworkTableInstance.getDefault();

      var driveSpeedTopic = networkTable.getDoubleTopic("Drive Speed"); 
      DriveSpeedPub = driveSpeedTopic.publish();
      DriveSpeedPub.setDefault(Constants.DriveEdits.DriveSpeed);
      DriveSpeedSub = driveSpeedTopic.subscribe(Constants.DriveEdits.DriveSpeed);

      var IntakeSpeedTopic = networkTable.getDoubleTopic("Intake Speed"); 
      IntakeSpeedPub = IntakeSpeedTopic.publish();
      IntakeSpeedPub.setDefault(Constants.Intake.IntakeSpeed);
      IntakeSpeedSub = IntakeSpeedTopic.subscribe(Constants.Intake.IntakeSpeed);

      var ShootSpeedTopic = networkTable.getDoubleTopic("Shoot Speed"); 
      ShootSpeedPub = ShootSpeedTopic.publish();
      ShootSpeedPub.setDefault(Constants.Intake.ShootSpeed);
      ShootSpeedSub = ShootSpeedTopic.subscribe(Constants.Intake.ShootSpeed);

      var TimerTopic = networkTable.getDoubleTopic("Timer");
      TimerPub = TimerTopic.publish();
      TimerPub.setDefault(Shooty.currentTime);
      TimerSub = TimerTopic.subscribe(Shooty.currentTime);

    }
}


