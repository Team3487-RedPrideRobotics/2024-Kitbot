package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

    
public class Drivetrain extends SubsystemBase {

    
    private Spark left_Motor;

    private Spark right_Motor;
   

    private DifferentialDrive differentialDrive;


    
    public Drivetrain() {

        left_Back_Motor = new Spark(Constants.DriveConstants.left_Drive_ID);

        right_Back_Motor = new Spark(Constants.DriveConstants.right_Drive_ID);
        right_Back_Motor.setInverted(Constants.DriveEdits.right_Drive_Inverse);


        differentialDrive = new DifferentialDrive(left_Motor, right_Motor);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);


    }

    public void TankDrive(double leftSpeed, double rightSpeed){
        differentialDrive.tankDrive(leftSpeed*Constants.DriveEdits.DriveSpeed, rightSpeed*Constants.DriveEdits.DriveSpeed, false);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

