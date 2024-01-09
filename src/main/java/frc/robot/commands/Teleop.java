package frc.robot.commands;



import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class Teleop extends CommandBase {


    private Drivetrain m_drive;

    public Teleop(Drivetrain drive){

        m_drive = drive;
        addRequirements(m_drive);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
              
        XboxController drive_controller = RobotContainer.getInstance().getDriveController();

        if(drive_controller.getLeftY() >= 0.05 || drive_controller.getRightY() >= 0.05) {
            m_drive.tankDrive(drive_controller.getLeftY(), drive_controller.getRightY());
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