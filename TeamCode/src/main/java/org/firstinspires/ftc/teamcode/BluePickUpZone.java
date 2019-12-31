//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//@Autonomous(name = "BluePickUpZone", group = "Autonomous")
//public class BluePickUpZone extends LinearOpMode{
//    public Robot R = new Robot();
//
//    public void runOpMode(){
//        R.init(hardwareMap);
//        waitForStart();
//
//        R.blockClaw.setPosition(0);
//
//        R.driveStraight(1500, .7);
//        R.waitFor();
//
//        R.turn("Right", 2250, .7);
//        R.waitFor();
//
//        R.driveStraight(500, .7);
//        R.waitFor();
//
//        R.blockClaw.setPosition(1);
//        sleep(1000);
//
//        R.driveStraight(-500, .7);
//        R.waitFor();
//
//        R.turn("Right", 2250, .7);
//        R.waitFor();
//
//        R.driveStraight(600, .7);
//        R.waitFor();
//
//        R.turn("Right", 2250, .7);
//        R.waitFor();
//
//        R.driveStraight(2000, .7);
//        R.waitFor();
//
//        R.blockClaw.setPosition(0);
//        sleep(1000);
//    }
//}
