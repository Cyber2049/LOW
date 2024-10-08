package com.nameless.theforcelawtweaks.client.mobs.cowdevil.patch;

import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.model.Armature;

import java.util.Map;

public class CowDevilArmature extends Armature {
    //right leg
    public final Joint thighR;
    public final Joint legR;
    public final Joint footR;
    public final Joint kneeR;
    //left leg
    public final Joint thighL;
    public final Joint legL;
    public final Joint footL;
    public final Joint kneeL;
    //body
    public final Joint torso;
    public final Joint chest;
    public final Joint head;
    //right arm
    public final Joint shoulderR;
    public final Joint armR;
    public final Joint elbowR;
    public final Joint foreArmR;
    public final Joint handR;
    public final Joint toolR;
    //left arm
    public final Joint shoulderL;
    public final Joint armL;
    public final Joint elbowL;
    public final Joint foreArmL;
    public final Joint handL;
    public final Joint toolL;
    //right wing
    public final Joint wingSubR;
    public final Joint wing1R;
    public final Joint wing2R;
    public final Joint wingArm1R;
    public final Joint wingArm2R;
    public final Joint wingArm3R;
    //left wing
    public final Joint wingSubL;
    public final Joint wing1L;
    public final Joint wing2L;
    public final Joint wingArm1L;
    public final Joint wingArm2L;
    public final Joint wingArm3L;
    //tail
    public final Joint tail;
    public final Joint tail2;
    public final Joint tail3;
    public final Joint tail4;
    public final Joint tail5;
    public final Joint tail6;
    public CowDevilArmature(int jointNumber, Joint rootJoint, Map<String, Joint> jointMap) {
        super(jointNumber, rootJoint, jointMap);
        this.head = this.getOrLogException(jointMap, "Head");
        this.chest = this.getOrLogException(jointMap, "Chest");
        this.torso = this.getOrLogException(jointMap, "Torso");
        this.shoulderR = this.getOrLogException(jointMap, "Shoulder_R");
        this.armR = this.getOrLogException(jointMap, "Arm_R");
        this.elbowR = this.getOrLogException(jointMap, "Elbow_R");
        this.foreArmR = this.getOrLogException(jointMap, "ForeArm_R");
        this.handR = this.getOrLogException(jointMap, "Hand_R");
        this.toolR = this.getOrLogException(jointMap, "Tool_R");
        this.shoulderL = this.getOrLogException(jointMap, "Shoulder_L");
        this.armL = this.getOrLogException(jointMap, "Arm_L");
        this.elbowL = this.getOrLogException(jointMap, "Elbow_L");
        this.foreArmL = this.getOrLogException(jointMap, "ForeArm_L");
        this.handL = this.getOrLogException(jointMap, "Hand_L");
        this.toolL = this.getOrLogException(jointMap, "Tool_L");
        this.thighR = this.getOrLogException(jointMap, "Thigh_R");
        this.legR = this.getOrLogException(jointMap, "Leg_R");
        this.footR = this.getOrLogException(jointMap, "Foot_R");
        this.kneeR = this.getOrLogException(jointMap, "Knee_R");
        this.thighL = this.getOrLogException(jointMap, "Thigh_L");
        this.legL = this.getOrLogException(jointMap, "Leg_L");
        this.footL = this.getOrLogException(jointMap, "Foot_L");
        this.kneeL = this.getOrLogException(jointMap, "Knee_L");
        this.wing1R = this.getOrLogException(jointMap, "Wing_1_R");
        this.wing2R = this.getOrLogException(jointMap, "Wing_2_R");
        this.wingArm1R = this.getOrLogException(jointMap, "WingArm_R");
        this.wingArm2R = this.getOrLogException(jointMap, "WingArm_2_R");
        this.wingArm3R = this.getOrLogException(jointMap, "WingArm_3_R");
        this.wingSubR = this.getOrLogException(jointMap, "Wingsub_R");
        this.wing1L = this.getOrLogException(jointMap, "Wing_1_L");
        this.wing2L = this.getOrLogException(jointMap, "Wing_2_L");
        this.wingArm1L = this.getOrLogException(jointMap, "WingArm_L");
        this.wingArm2L = this.getOrLogException(jointMap, "WingArm_2_L");
        this.wingArm3L = this.getOrLogException(jointMap, "WingArm_3_L");
        this.wingSubL = this.getOrLogException(jointMap, "Wingsub_L");
        this.tail = this.getOrLogException(jointMap, "Tail");
        this.tail2 = this.getOrLogException(jointMap, "Tail2");
        this.tail3 = this.getOrLogException(jointMap, "Tail3");
        this.tail4 = this.getOrLogException(jointMap, "Tail4");
        this.tail5 = this.getOrLogException(jointMap, "Tail5");
        this.tail6 = this.getOrLogException(jointMap, "Tail6");
    }


}
