package frc.robot.humanIO;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.button.Button;



public class Joysticks {
    
    private class POVButton extends Button{ 
      Joystick m_joystick;
      int m_deg;
  
      public POVButton(Joystick joystick, int deg){ 
        m_joystick = joystick;
        m_deg = deg;
        }
      
  
        public boolean get(){ 
        if (m_joystick.getPOV() == m_deg){ 
            return true;
            }
            return false;
        }
    }
    
    


    private Joystick _leftJoystick, _rightJoystick;
    private XboxController _operatorJoystick;
    public Joysticks () {
        this._leftJoystick = new Joystick(0);
        this._rightJoystick = new Joystick(1);
        this._operatorJoystick = new XboxController(2);
    }



public double getLeftY() {
    return this._leftJoystick.getY();
    
  }

  public double getRightY() {
    return this._rightJoystick.getY();
    
  }
  public void startRumble() {
    this._operatorJoystick.setRumble(RumbleType.kLeftRumble, 1);
    this._operatorJoystick.setRumble(RumbleType.kRightRumble, 1);
  }

  public void stopRumble() {
    this._operatorJoystick.setRumble(RumbleType.kLeftRumble,0);
    this._operatorJoystick.setRumble(RumbleType.kRightRumble,0);
  }
}
    
    








