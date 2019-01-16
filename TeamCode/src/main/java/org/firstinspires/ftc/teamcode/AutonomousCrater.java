package org.firstinspires.ftc.teamcode;
// this is maybe our autonomous
/* This is the version of the autonomous code that (hopefully!) moves the team marker to the depot.
 * Ideally it would start after we unhook from the lander and end with the robot and team marker
 * inside the depot. Variables have been used carelessly here: we hope to swap these in after we
 * test the robot's speed. Side note: I'm not sure how to do functions currently, so if you
 * have that knowledge, PLEASE put that in because those four lines of code setting wheel power are
 * becoming extremely redundant! - Jade */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

@Autonomous(name = "Crater Autonomous", group = "ARC")
public class AutonomousCrater extends LinearOpMode {
    private DcMotorController MC_Alpha;    // Motor Controller in port 0 of Core, alpha
    private DcMotorController MC_Beta;    // Motor Controller in port 1 of Core, also beta
    private DcMotorController MC_Gamma;    //Gamma, has the like not driving motors, port 2 of core
    private ServoController SC_Theta;    //theta, port 3, does servo thigns for dustpan

    private DcMotor FR_Motor;                         // port 1 in MC_Alpha
    private DcMotor FL_Motor;                         // port 2 in MC_Alpha
    private DcMotor BR_Motor;                         // port 1 in MC_Beta
    private DcMotor BL_Motor;                         // port 2 in MC_Beta
    private DcMotor Sweeper_Motor;                         // port 1 in MC_Gamma
    private DcMotor LS_Motor;                         // port 2 in MC_Gamma
    private Servo R_Dustpan;
    private Servo L_Dustpan;
    private int turnTime = 1500;
    /* can someone plz explain the negative signs? this might have actually been something I wrote,
    but is it intentional that the left motor is going backwards and the right motor is going
    forwards?*/

    @Override
    public void runOpMode() {
        MC_Alpha = hardwareMap.dcMotorController.get("MC_Alpha");
        MC_Beta = hardwareMap.dcMotorController.get("MC_Beta");
        MC_Gamma = hardwareMap.dcMotorController.get("MC_Gamma");
        SC_Theta = hardwareMap.servoController.get("SC_Theta");


        FR_Motor = hardwareMap.dcMotor.get("FR_Motor");
        FL_Motor = hardwareMap.dcMotor.get("FL_Motor");
        BR_Motor = hardwareMap.dcMotor.get("BR_Motor");
        BL_Motor = hardwareMap.dcMotor.get("BL_Motor");
        LS_Motor = hardwareMap.dcMotor.get("LS_Motor");
        Sweeper_Motor = hardwareMap.dcMotor.get("Sweeper_Motor");
        L_Dustpan = hardwareMap.servo.get("L_Dustpan");
        R_Dustpan = hardwareMap.servo.get("R_Dustpan");

        FR_Motor.setPower(1.0);
        FL_Motor.setPower(-1.0);
        BL_Motor.setPower(-1.0);
        BR_Motor.setPower(1.0);
        sleep(1000);
        FL_Motor.setPower(1.0);
        BL_Motor.setPower(1.0);
        // turnTime = how much time it takes to turn 360 degrees
        sleep(turnTime / 4);
        // the above code is the turn.
        FL_Motor.setPower(-1.0);
        BL_Motor.setPower(-1.0);
        // distanceB = distance from lander to depot, after turn
        sleep(2000);
        FL_Motor.setPower(1.0);
        BL_Motor.setPower(1.0);
        // turnTime = how much time it takes to turn 360 degrees
        sleep(turnTime / 4);
        // the above code is the turn.
        FL_Motor.setPower(-1.0);
        BL_Motor.setPower(-1.0);
        // distanceB = distance from lander to depot, after turn
        sleep(2500);
        Sweeper_Motor.setPower(1.0);
        sleep(3000);
    }
}
// Robot Motor Speed ~ 20 in/second. used that as an estimate for now.
// distance from lander out ~ 20 in...?/ time = 1 s
// distance after turn pt. 2 ~ 40 in. time = 2 s
// distance after turn pt. 3 ~ 50 in. time = 2.5 s
