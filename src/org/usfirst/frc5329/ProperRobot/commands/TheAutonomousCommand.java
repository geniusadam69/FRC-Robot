package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.commands.balls.AutonomousShootBall;
import org.usfirst.frc5329.ProperRobot.commands.balls.ShootBall;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class TheAutonomousCommand extends CommandGroup {
	
	public final static int STARTING_POSITION = 3;
	
	public final static int DEFENSE_POSITION = 1;
	
	public final static int GOAL_POSITION = 1;
	
	public final static Obstacle OBSTACLE = Obstacle.LOW_BAR;
			

	
	
	public TheAutonomousCommand() {
	
	if (STARTING_POSITION == 1 && DEFENSE_POSITION == 1 && GOAL_POSITION == 1) {	
		double A = 4.25; // 4.917 ft actual
		double B = 4; // 4.33 ft actual
		double C = 44; // 44  actual
		double D = 4; // 4.125 ft actual
		addSequential(new DriveXForward(A));
		addSequential(getObstacleCommand(OBSTACLE));
		//addSequential(new DriveXForward(B));
		//addSequential(new TurnToNdegrees(C));
		//addSequential(new DriveXForward(D));
		//addSequential(new ShootBall());
	}
	else if(STARTING_POSITION == 2 && DEFENSE_POSITION == 1 && GOAL_POSITION == 1) {	
		double A = 4.5; // 4.917 ft actual
		double B = -90; 
		double C = 3.5; // 3.665 ft actual
		double D = 0;
		double E = 4;   // 4.33 ft actual
		double F = 44;  // 44 actual
		double G = 4;   // 4.125 ft actual
			addSequential(new DriveXForward(A));
			addSequential(new TurnToNdegrees(B));
			addSequential(new DriveXForward(C));
			addSequential(new TurnToNdegrees(D));
			addSequential(getObstacleCommand(OBSTACLE));
			addSequential(new DriveXForward(E));
			addSequential(new TurnToNdegrees(F));
			addSequential(new DriveXForward(G));
			addSequential(new ShootBall());
	}
		else if(STARTING_POSITION == 3 && DEFENSE_POSITION == 1 && GOAL_POSITION == 1) {	
			double A = 4.917; // 4.917 ft actual
			double B = -90;
			double C = 7.53; // 7.33 ft actual
			double D = 0;
			double E = 4.73;   // 4.33 ft actual
			double F = 44;  // 44 actual
			double G = 5.325;   // 4.125 ft actual
				addSequential(new DriveXForward(A));
				addSequential(new TurnToNdegrees(B));
				addSequential(new DriveXForward(C));
				addSequential(new TurnToNdegrees(D));
				addSequential(getObstacleCommand(OBSTACLE));
				addSequential(new TurnToNdegrees(0));
				addSequential(new DriveXForward(E));
				addSequential(new TurnToNdegrees(F));
				addSequential(new DriveXForward(G));
				addSequential(new AutonomousShootBall());
		}
		else if(STARTING_POSITION == 4 && DEFENSE_POSITION == 1 && GOAL_POSITION == 1) {	
				double A = 2.58;
				double B = -90;
				double C = 13.375;
				double D = 0;
				double E = 5; //fix later
				double F = 45; //fix later
				double G = 5; //fix later
					addSequential(new DriveXForward(A));
					addSequential(new TurnToNdegrees(B));
					addSequential(new DriveXForward(C));
					addSequential(new TurnToNdegrees(D));
					addSequential(getObstacleCommand(OBSTACLE));
					addSequential(new DriveXForward(E));
					addSequential(new TurnToNdegrees(F));
					addSequential(new DriveXForward(G));
					addSequential(new ShootBall());
			}
		else if(STARTING_POSITION == 5 && DEFENSE_POSITION == 1 && GOAL_POSITION == 1) {	
					double A = 2.58;
					double B = -90;
					double C = 17.833;
					double D = 0;
					double E = 5; //fix later
					double F = 45; //fix later
					double G = 5; //fix later
						addSequential(new DriveXForward(A));
						addSequential(new TurnToNdegrees(B));
						addSequential(new DriveXForward(C));
						addSequential(new TurnToNdegrees(D));
						addSequential(getObstacleCommand(OBSTACLE));
						addSequential(new DriveXForward(E));
						addSequential(new TurnToNdegrees(F));
						addSequential(new DriveXForward(G));
						addSequential(new ShootBall());
				}
	
		
		
		else if (STARTING_POSITION == 2 && DEFENSE_POSITION == 2 && GOAL_POSITION == 1) {	
			double A = 2.58;
			double B = 0;
			double C = 5;//fix later
			double H = 45;//fix later
			double I = 5; //fix later
				addSequential(new DriveXForward(A));
				addSequential(getObstacleCommand(OBSTACLE));
				addSequential(new TurnToNdegrees(B));
				addSequential(new DriveXForward(C));
				addSequential(new TurnToNdegrees(H));
				addSequential(new DriveXForward(I));
				//addSequential(new ShootBall()); // we dont want to shoot the ball and miss
		}
			


		/* else if (STARTING_POSITION == 2 && DEFENSE_POSITION == 2 && GOAL_POSITION == 2) {	
			double A = 2.58;
			double B = 0;
			double C = 5;//fix later
			double D = 90;
			double E = 13.3755;
			double F = 0;
			double G = 5;//fix later
			double H = -45;//fix later
			double I = 5; //fix later
				addSequential(new DriveXForward(A));
				addSequential(getObstacleCommand(OBSTACLE));
				addSequential(new TurnToNdegrees(B));
				addSequential(new DriveXForward(C));
				addSequential(new TurnToNdegrees(D));
				addSequential(new DriveXForward(E));
				addSequential(new TurnToNdegrees(F));
				addSequential(new DriveXForward(G));
				addSequential(new TurnToNdegrees(H));
				addSequential(new DriveXForward(I));
				addSequential(new ShootBall());
		} 
		// we cannnot complete this path within 15 seconds
	*/
	
		 else if (STARTING_POSITION == 3 && DEFENSE_POSITION == 3 && GOAL_POSITION == 1) {	
			 
			double A = 2.58;
			double B = 0;
			double C = 5;//fix later
			double D = -90;
			double E = 4.458;
			double F = 0;
			double G = 5;//fix later
			double H = 45;//fix later
			double I = 5; //fix later
				addSequential(new DriveXForward(A));
				addSequential(getObstacleCommand(OBSTACLE));
				addSequential(new TurnToNdegrees(B));
				addSequential(new DriveXForward(C));
				addSequential(new TurnToNdegrees(D));
				addSequential(new DriveXForward(E));
				addSequential(new TurnToNdegrees(F));
				addSequential(new DriveXForward(G));
				addSequential(new TurnToNdegrees(H));
				addSequential(new DriveXForward(I));
				addSequential(new AutonomousShootBall());  //we dont want to shoot the ball and miss
		}
		
		/* else if (STARTING_POSITION == 3 && DEFENSE_POSITION == 3 && GOAL_POSITION == 2) {	
			double A = 2.58;
			double B = 0;
			double C = 5;//fix later
			double D = 90;
			double E = 8.916;
			double F = 0;
			double G = 5;//fix later
			double H = -45;//fix later
			double I = 5; //fix later
				addSequential(new DriveXForward(A));
				addSequential(getObstacleCommand(OBSTACLE));
				addSequential(new TurnToNdegrees(B));
				addSequential(new DriveXForward(C));
				addSequential(new TurnToNdegrees(D));
				addSequential(new DriveXForward(E));
				addSequential(new TurnToNdegrees(F));
				addSequential(new DriveXForward(G));
				addSequential(new TurnToNdegrees(H));
				addSequential(new DriveXForward(I));
				addSequential(new ShootBall());
		}
		  // we cannot complete the path within 15 seconds
		*/
		else if (STARTING_POSITION == 4 && DEFENSE_POSITION == 4 && GOAL_POSITION == 1) {	
		double A = 2.58;
		double B = 0;
		double C = 5;//fix later
		double D = -90;
		double E = 8.916;
		double F = 0;
		double G = 5;//fix later
		double H = 45;//fix later
		double I = 5; //fix later
			addSequential(new DriveXForward(A));
			addSequential(getObstacleCommand(OBSTACLE));
			addSequential(new TurnToNdegrees(B));
			addSequential(new DriveXForward(C));
			addSequential(new TurnToNdegrees(D));
			addSequential(new DriveXForward(E));
			addSequential(new TurnToNdegrees(F));
			addSequential(new DriveXForward(G));
			addSequential(new TurnToNdegrees(H));
			addSequential(new DriveXForward(I));
			//addSequential(new ShootBall()); //we dont want to shoot the ball and miss
	}
		/* else if (STARTING_POSITION == 4 && DEFENSE_POSITION == 4 && GOAL_POSITION == 2) {	
			double A = 2.58;
			double B = 0;
			double C = 5;//fix later
			double D = 90;
			double E = 4.458;
			double F = 0;
			double G = 5;//fix later
			double H = -45;//fix later
			double I = 5; //fix later
				addSequential(new DriveXForward(A));
				addSequential(getObstacleCommand(OBSTACLE));
				addSequential(new TurnToNdegrees(B));
				addSequential(new DriveXForward(C));
				addSequential(new TurnToNdegrees(D));
				addSequential(new DriveXForward(E));
				addSequential(new TurnToNdegrees(F));
				addSequential(new DriveXForward(G));
				addSequential(new TurnToNdegrees(H));
				addSequential(new DriveXForward(I));
				addSequential(new ShootBall());
		}
		 // We cannot complete this path within 15 seconds
		*/
		/*else if (STARTING_POSITION == 5 && DEFENSE_POSITION == 5 && GOAL_POSITION == 1) {	
			double A = 2.58;
			double B = 0;
			double C = 5;//fix later
			double D = -90;
			double E = 17.833;
			double F = 0;
			double G = 5; //fix later
			double H = -45;//fix later
			double I = 5; //fix later
				addSequential(new DriveXForward(A));
				addSequential(getObstacleCommand(OBSTACLE));
				addSequential(new TurnToNdegrees(B));
				addSequential(new DriveXForward(C));
				addSequential(new TurnToNdegrees(D));
				addSequential(new DriveXForward(E));
				addSequential(new TurnToNdegrees(F));
				addSequential(new DriveXForward(G));
				addSequential(new TurnToNdegrees(H));
				addSequential(new DriveXForward(I));
				addSequential(new ShootBall());
		}
		 // we cannot complete this path within 15 seconds
		*/
		else if (STARTING_POSITION == 5 && DEFENSE_POSITION == 5 && GOAL_POSITION == 2) {	
			double A = 2.58;
			double B = 0;
			double C = 5;//fix later
			double D = -45;//fix later
			double E = 5; //fix later
				addSequential(new DriveXForward(A));
				addSequential(getObstacleCommand(OBSTACLE));
				addSequential(new TurnToNdegrees(B));
				addSequential(new DriveXForward(C));
				addSequential(new TurnToNdegrees(D));
				addSequential(new DriveXForward(E));
				//addSequential(new ShootBall()); // we dont want to shoot the ball and miss
		}
		
	}
		public static Command getObstacleCommand(Obstacle obstacle){
        switch(obstacle){
            case ROCK_WALL: return new CrossRockWall();
            case LOW_BAR: return new CrossLowBar();
            case MOAT: return new CrossMoat();
            case RAMPARTS: return new CrossRamparts();
            case ROUGH_TERRAIN: return new CrossRoughTerrain();
            default: return null;
        }
        
    }
    private static enum Obstacle{
        //write all of the obstacles as such:
        
        ROCK_WALL, 
        LOW_BAR,
        MOAT,
        RAMPARTS,
        ROUGH_TERRAIN,
    }
}