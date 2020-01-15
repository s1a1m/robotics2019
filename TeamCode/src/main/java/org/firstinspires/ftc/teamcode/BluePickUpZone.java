package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Blue2", group = "Autonomous")
public class BluePickUpZone extends LinearOpMode{
    public Robot R = new Robot();

    public void runOpMode(){
        R.init(hardwareMap);
        waitForStart();

        R.raiseLifter(-200, .7);
        R.waitLinearSlide();

        R.driveStraight(3200, .7);
        R.waitFor();

        R.raiseLifter(300, .7);
        R.waitLinearSlide();

        R.driveStraight(-3500, .3);
        R.waitFor();




    }
}
