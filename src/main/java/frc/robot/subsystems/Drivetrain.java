package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

    
public class Drivetrain extends SubsystemBase {

    
    private Spark left_Back_Motor;
    private Spark left_Front_Motor;
    private MotorControllerGroup leftDrive;

    private Spark right_Back_Motor;
    private Spark right_Front_Motor;
    private MotorControllerGroup rightDrive;

    private DifferentialDrive differentialDrive;


    
    public Drivetrain() {

        left_Back_Motor = new Spark(Constants.DriveConstants.left_Back_Motor_ID);
    

        left_Front_Motor = new Spark(Constants.DriveConstants.left_Front_Motor_ID);


        leftDrive = new MotorControllerGroup(left_Front_Motor, left_Back_Motor);
        

        right_Back_Motor = new Spark(Constants.DriveConstants.right_Back_Motor_ID);


        right_Front_Motor = new Spark(Constants.DriveConstants.right_Front_Motor_ID);


        rightDrive = new MotorControllerGroup(right_Back_Motor, right_Front_Motor);
        

        differentialDrive = new DifferentialDrive(leftDrive, rightDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);


    }

    public void tankDrive(double leftSpeed, double rightSpeed){
        differentialDrive.tankDrive(leftSpeed, rightSpeed, false);
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

