package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "RedBuildZone", group = "Autonomous")
public class RedBuildZone extends LinearOpMode{
    public Robot R = new Robot();

    public void runOpMode(){
        R.init(hardwareMap);
        waitForStart();

        R.driveStraight(200, .7);
        R.waitFor();

        R.raiseLifter(-200, .7);
        R.waitLinearSlide();

        R.strafe("Right", 1200, 0.5);
        R.waitFor();

        R.turn("CCW", 400, .7);
        R.waitFor();

        R.driveStraight(3000, .7);
        R.waitFor();

        R.raiseLifter(300, .7);
        R.waitLinearSlide();

        R.driveStraight(-3500, .3);
        R.waitFor();
    }
}
