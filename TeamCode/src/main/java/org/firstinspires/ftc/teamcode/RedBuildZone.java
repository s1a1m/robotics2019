//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//@Autonomous(name = "RedBuildZone", group = "Autonomous")
//public class RedBuildZone extends LinearOpMode{
//    public Robot R = new Robot();
//
//    public void runOpMode(){
//        R.init(hardwareMap);
//        waitForStart();
//
//        R.claw.setPosition(1);
//        R.claw2.setPosition(0);
//
//        R.strafe("Right", 1600, .3);
//        R.waitFor();
//
//        R.driveStraight(3000, .7);
//        R.waitFor();
//
//        sleep(1000);
//
//        R.claw.setPosition(0);
//        R.claw2.setPosition(1);
//
//        sleep(2500);
//
//        R.driveStraight(-3200, .3);
//        R.waitFor();
//
//        R.claw.setPosition(1);
//        R.claw2.setPosition(0);
//
//        sleep(1000);
//    }
//}
