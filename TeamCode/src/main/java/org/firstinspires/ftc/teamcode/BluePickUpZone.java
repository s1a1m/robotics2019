package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "BluePickUpZone", group = "Autonomous")
public class BluePickUpZone extends LinearOpMode{
    public Robot R = new Robot();

    public void runOpMode(){
        R.init(hardwareMap);
        waitForStart();
        //Drive forward
        //Turn left
        //Sense special block
        //Grab block
        //Bring to build plate
        //Go back
        //Sense second block
        //Bring to build plate
        //Park under bar thing
    }
}
