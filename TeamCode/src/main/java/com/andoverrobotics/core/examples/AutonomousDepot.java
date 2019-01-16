package com.andoverrobotics.core.examples;


// this is maybe our autonomous
/* This is the version of the autonomous (team marker) where the robot is positioned
directly in front of the depot. */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

@Autonomous(name = "Depot Autonomous", group = "ARC")
public class AutonomousDepot extends LinearOpMode {
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
    /* can someone plz explain the negative signs? this might have actually been something I wrote,
    but is it intentional that the left motor is going backwards and the right motor is going
    forwards?*/
    private int markerTime = 3000;
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
        /* the above four lines of code are really redundant. Hopefully when I land I'll be able to
        figure out how to turn them into a function. */
        sleep(2520);
        FL_Motor.setPower(1.0);
        BL_Motor.setPower(1.0);
        Sweeper_Motor.setPower(1.0);

        // markerTime = amount of time it takes to get marker out of the sweeper.
        sleep(markerTime);
    }
}




