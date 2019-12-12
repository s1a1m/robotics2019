package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


@TeleOp(name="TeleOp", group="Linear Opmode")
public class TeleopMode extends LinearOpMode {
    public Robot R = new Robot();
    public HardwareMap HwMap;

    @Override
    public void runOpMode() {
        R.init(hardwareMap);
        waitForStart();
        while(opModeIsActive()){

            double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
            double robotAngle = Math.atan2(-gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
            double rightX = gamepad1.right_stick_x;

            final double v1 = r * Math.cos(robotAngle) + rightX;
            final double v2 = r * Math.sin(robotAngle) - rightX;
            final double v3 = r * Math.sin(robotAngle) + rightX;
            final double v4 = r * Math.cos(robotAngle) - rightX;

            if(gamepad1.dpad_left){ // If Left D-Pad Arrow is pressed.
                R.left_front_motor.setPower(-0.7);
                R.right_front_motor.setPower(0.7);
                R.left_back_motor.setPower(0.7);
                R.right_back_motor.setPower(-0.7);
            }else if(gamepad1.dpad_right){ // If Right D-Pad Arrow is pressed.
                R.left_front_motor.setPower(0.7);
                R.right_front_motor.setPower(-0.7);
                R.left_back_motor.setPower(-0.7);
                R.right_back_motor.setPower(0.7);
            }else{ // If Left or Right D-Pad Arrows are NOT pressed.
                R.left_front_motor.setPower(v1);
                R.right_front_motor.setPower(v2);
                R.left_back_motor.setPower(v3);
                R.right_back_motor.setPower(v4);
            }
            //Claws
            if(gamepad2.y){
                R.claw.setPosition(1);
                R.claw2.setPosition(0);
            }
            if(gamepad2.a) {
                R.claw.setPosition(0);
                R.claw2.setPosition(1);
            }

            //Block Claw
            if(gamepad2.dpad_up){
                R.blockClaw.setPosition(1);
            }
            if(gamepad2.dpad_down){
                R.blockClaw.setPosition(0);
            }

            //linear slide
            R.linearSlide.setPower(gamepad2.left_stick_y);

            R.lazySusan.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            //Lazy Susan
            if(gamepad2.right_bumper){
                R.lazySusan.setPower(1);
            }else if(gamepad2.left_bumper){
                R.lazySusan.setPower(-1);
            }else{
                R.lazySusan.setPower(0);
            }
        }
    }
}