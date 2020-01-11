package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "BlueBuildZone", group = "Autonomous")
public class BlueBuildZone extends LinearOpMode{
    public Robot R = new Robot();

    public void runOpMode(){
        R.init(hardwareMap);
        waitForStart();

        R.driveStraight(400, .7);
        R.waitFor();

        R.raiseLifter(-200, .7);
        R.waitLinearSlide();

        R.turn("CCW", 300, .7);
        R.waitFor();

        R.driveStraight(2400, .7);
        R.waitFor();

        R.turn("CW", 300, .7);
        R.waitFor();

        R.driveStraight(400, .7);
        R.waitFor();

        R.raiseLifter(300, .7);
        R.waitLinearSlide();

        R.driveStraight(-3500, .3);
        R.waitFor();

    }
}
