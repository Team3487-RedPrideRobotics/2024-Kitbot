package frc.robot.commands;




import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooty;

public class Teleop extends Command {


    private Drivetrain m_drive;
    private Shooty m_intake;
    XboxController drive_controller;
    XboxController operator_Controller;

    public Teleop(Drivetrain drive, Shooty intake){

        m_drive = drive;
        addRequirements(m_drive);

        m_intake = intake;
        addRequirements(m_intake);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        drive_controller = RobotContainer.getInstance().getDriveController();
        operator_Controller = RobotContainer.getInstance().getOperatorController();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
              
        


        //drive code, no sprinting just get good
        if(drive_controller.getLeftY() >= 0.05 || drive_controller.getLeftY() <= -0.05 || 
        drive_controller.getRightY() >= 0.05 || drive_controller.getRightY() <= -0.05)
        {
            m_drive.TankDrive(drive_controller.getLeftY(), drive_controller.getRightY()); 
        }



        //intake code 
        //right trigger is shoot at max speed
        if(operator_Controller.getRightTriggerAxis() >= 0.01){
            m_intake.shoot(operator_Controller.getRightTriggerAxis());
        }

        //left trigger is intake;
        if(operator_Controller.getLeftTriggerAxis() >= 0.01){
            m_intake.intake(-1 * operator_Controller.getLeftTriggerAxis());
        }


    }
    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}