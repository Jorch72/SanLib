/*******************************************************************************************************************
 * Authors:   SanAndreasP
 * Copyright: SanAndreasP
 * License:   Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International
 *                http://creativecommons.org/licenses/by-nc-sa/4.0/
 *******************************************************************************************************************/
package de.sanandrew.mods.sapmanpack.sanplayermodel.client.model;

import de.sanandrew.mods.sapmanpack.lib.client.ModelBoxBuilder;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * Created using Tabula 4.1.1
 */
public class ModelSanPlayer
        extends ModelPlayer
{
    public ModelRenderer legLeft;
    public ModelRenderer legRight;
    public ModelRenderer body;
    public ModelRenderer breast;
    public ModelRenderer skirt1;
    public ModelRenderer skirt2;
    public ModelRenderer head;
    public ModelRenderer hair;
    public ModelRenderer quadTail1;
    public ModelRenderer quadTail2;
    public ModelRenderer quadTail3;
    public ModelRenderer quadTail4;
    public ModelRenderer hatBase;

    public boolean hideTails;

    private boolean isArmor;

    public ModelSanPlayer(float scaling, boolean isArmor) {
        super(scaling, isArmor);
        this.isArmor = isArmor;

        this.textureWidth = 64;
        this.textureHeight = 64;
        this.legLeft = ModelBoxBuilder.newBuilder(this).setTexture(0, 16, true).setLocation(2.5F, 12.0F, 0.0F).setRotation(0.0F, 0.0F, 0.0F)
                                      .getBox(-1.5F, 0.0F, -1.5F, 3, 12, 3, scaling);
        this.legRight = ModelBoxBuilder.newBuilder(this).setTexture(0, 16, false).setLocation(-2.5F, 12.0F, 0.0F).setRotation(0.0F, 0.0F, 0.0F)
                                       .getBox(-1.5F, 0.0F, -1.5F, 3, 12, 3, scaling);
        this.bipedLeftArm = ModelBoxBuilder.newBuilder(this).setTexture(40, 16, true).setLocation(5.0F, 2.0F, 0.5F).setRotation(-0.00331613F, 0.0F, -0.09983283F)
                                      .getBox(-1.0F, -2.0F, -2.0F, 3, 12, 3, scaling);
        this.bipedRightArm = ModelBoxBuilder.newBuilder(this).setTexture(40, 16, false).setLocation(-4.0F, 2.0F, 0.5F).setRotation(0.0F, 0.0F, 0.09983283F)
                                       .getBox(-3.0F, -2.0F, -2.0F, 3, 12, 3, scaling);
        this.bipedLeftArmwear = ModelBoxBuilder.newBuilder(this).setTexture(40, 32, true).setLocation(5.0F, 2.0F, 0.5F).setRotation(-0.00331613F, 0.0F, -0.09983283F)
                                       .getBox(-1.0F, 5.0F, -2.0F, 3, 5, 3, scaling + 0.05F);
        this.bipedRightArmwear = ModelBoxBuilder.newBuilder(this).setTexture(40, 32, false).setLocation(-4.0F, 2.0F, 0.5F).setRotation(0.0F, 0.0F, 0.09983283F)
                                        .getBox(-3.0F, 5.0F, -2.0F, 3, 5, 3, scaling + 0.05F);
        this.body = ModelBoxBuilder.newBuilder(this).setTexture(16, 16, false).setLocation(0.0F, 0.0F, 0.0F).setRotation(0.0F, 0.0F, 0.0F)
                                   .getBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scaling);
        this.breast = ModelBoxBuilder.newBuilder(this).setTexture(0, 54, false).setLocation(0.0F, 3.0F, -3.5F).setRotation(0.87266463F, 0.0F, 0.0F)
                                     .getBox(-3.5F, 0.0F, 0.0F, 7, 3, 3, scaling);
        this.skirt1 = ModelBoxBuilder.newBuilder(this).setTexture(16, 36, false).setLocation(0.0F, 0.0F, 0.0F).setRotation(0.0F, 0.0F, 0.0F)
                                     .getBox(-4.5F, 8.0F, -2.5F, 9, 3, 5, 0.0F);
        this.skirt2 = ModelBoxBuilder.newBuilder(this).setTexture(16, 44, false).setLocation(0.0F, 0.0F, 0.0F).setRotation(0.0F, 0.0F, 0.0F)
                                     .getBox(-4.5F, 11.0F, -3.0F, 9, 4, 6, 0.0F);
        this.head = ModelBoxBuilder.newBuilder(this).setTexture(28, 0, false).setLocation(0.0F, 0.0F, 0.0F).setRotation(0.0F, 0.0F, 0.0F)
                                   .getBox(-3.5F, -7.0F, -3.5F, 7, 7, 7, scaling);
        this.hair = ModelBoxBuilder.newBuilder(this).setTexture(0, 0, false).setLocation(0.0F, 0.0F, 0.0F).setRotation(0.0F, 0.0F, 0.0F)
                                   .getBox(-3.5F, -7.4F, -3.5F, 7, 7, 7, scaling + 0.4F);
        this.quadTail1 = ModelBoxBuilder.newBuilder(this).setTexture(0, 40, true).setLocation(0.0F, -3.0F, 0.0F).setRotation(0.52359878F, 0.0F, -2.26892803F)
                                        .getBox(-1.5F, 3.0F, 1.0F, 3, 10, 3, scaling);
        this.quadTail2 = ModelBoxBuilder.newBuilder(this).setTexture(0, 40, false).setLocation(0.0F, -3.0F, 0.0F).setRotation(0.52359878F, 0.0F, 2.26892803F)
                                        .getBox(-1.5F, 3.0F, 1.0F, 3, 10, 3, scaling);
        this.quadTail3 = ModelBoxBuilder.newBuilder(this).setTexture(0, 32, true).setLocation(0.0F, -3.0F, 0.0F).setRotation(0.63739424F, 0.0F, -0.61086524F)
                                        .getBox(-0.5F, 3.0F, 0.9F, 2, 6, 2, scaling);
        this.quadTail4 = ModelBoxBuilder.newBuilder(this).setTexture(0, 32, false).setLocation(0.0F, -3.0F, 0.0F).setRotation(0.63739424F, 0.0F, 0.61086524F)
                                        .getBox(-1.5F, 3.0F, 0.9F, 2, 6, 2, scaling);

        this.body.addChild(this.breast);
        this.head.addChild(this.quadTail1);
        this.head.addChild(this.quadTail2);
        this.head.addChild(this.quadTail3);
        this.head.addChild(this.quadTail4);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float rotFloat, float rotYaw, float rotPitch, float partTicks) {
        this.setRotationAngles(limbSwing, limbSwingAmount, rotFloat, rotYaw, rotPitch, partTicks, entity);

        this.quadTail1.isHidden = this.hideTails;
        this.quadTail2.isHidden = this.hideTails;
        this.quadTail3.isHidden = this.hideTails;
        this.quadTail4.isHidden = this.hideTails;

        if( !this.isArmor ) {
            GL11.glPushMatrix();
            GL11.glTranslatef(this.head.offsetX, this.head.offsetY, this.head.offsetZ);
            GL11.glTranslatef(this.head.rotationPointX * partTicks, this.head.rotationPointY * partTicks, this.head.rotationPointZ * partTicks);
            GL11.glScaled(1.1D, 1.1D, 1.1D);
            GL11.glTranslatef(-this.head.offsetX, -this.head.offsetY, -this.head.offsetZ);
            GL11.glTranslatef(-this.head.rotationPointX * partTicks, -this.head.rotationPointY * partTicks, -this.head.rotationPointZ * partTicks);
            this.head.render(partTicks);
            GL11.glPopMatrix();

            this.hair.render(partTicks);
        } else if( this.hatBase != null ) {
            this.hatBase.render(partTicks);
        }

        this.bipedLeftArm.render(partTicks);
        this.bipedRightArm.render(partTicks);
        this.legLeft.render(partTicks);
        this.legRight.render(partTicks);
        this.body.render(partTicks);
        this.skirt1.render(partTicks);
        this.skirt2.render(partTicks);

//        GL11.glPushMatrix();
//        GL11.glTranslatef(this.bipedLeftArmwear.offsetX, this.bipedLeftArmwear.offsetY, this.bipedLeftArmwear.offsetZ);
//        GL11.glTranslatef(this.bipedLeftArmwear.rotationPointX * partTicks + 0.025F, this.bipedLeftArmwear.rotationPointY * partTicks, this.bipedLeftArmwear.rotationPointZ * partTicks);
//        GL11.glScaled(1.05D, 1.05D, 1.05D);
//        GL11.glTranslatef(-this.bipedLeftArmwear.offsetX, -this.bipedLeftArmwear.offsetY, -this.bipedLeftArmwear.offsetZ);
//        GL11.glTranslatef(-this.bipedLeftArmwear.rotationPointX * partTicks - 0.025F, -this.bipedLeftArmwear.rotationPointY * partTicks, -this.bipedLeftArmwear.rotationPointZ * partTicks);
        this.bipedLeftArmwear.render(partTicks);
//        GL11.glPopMatrix();
//        GL11.glPushMatrix();
//        GL11.glTranslatef(this.bipedRightArmwear.offsetX, this.bipedRightArmwear.offsetY, this.bipedRightArmwear.offsetZ);
//        GL11.glTranslatef(this.bipedRightArmwear.rotationPointX * partTicks - 0.025F, this.bipedRightArmwear.rotationPointY * partTicks, this.bipedRightArmwear.rotationPointZ * partTicks);
//        GL11.glScaled(1.05D, 1.05D, 1.05D);
//        GL11.glTranslatef(-this.bipedRightArmwear.offsetX, -this.bipedRightArmwear.offsetY, -this.bipedRightArmwear.offsetZ);
//        GL11.glTranslatef(-this.bipedRightArmwear.rotationPointX * partTicks + 0.025F, -this.bipedRightArmwear.rotationPointY * partTicks, -this.bipedRightArmwear.rotationPointZ * partTicks);
        this.bipedRightArmwear.render(partTicks);
//        GL11.glPopMatrix();
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float rotFloat, float rotYaw, float rotPitch, float partTicks, Entity entity) {
        float prevHeadPosY = this.bipedHead.rotationPointY;
        super.setRotationAngles(limbSwing, limbSwingAmount, rotFloat, rotYaw, rotPitch, partTicks, entity);
        float deltaHeadPosY = this.bipedHead.rotationPointY - prevHeadPosY;

        this.hair.rotationPointY += deltaHeadPosY;
        this.head.rotationPointY += deltaHeadPosY;

        if( this.hatBase != null ) {
            this.hatBase.rotationPointY += deltaHeadPosY;
            this.setRotateAngle(this.hatBase, this.bipedHead.rotateAngleX, this.bipedHead.rotateAngleY, this.bipedHead.rotateAngleZ);
        }

        this.setRotateAngle(this.head, this.bipedHead.rotateAngleX, this.bipedHead.rotateAngleY, this.bipedHead.rotateAngleZ);
        this.setRotateAngle(this.hair, this.bipedHead.rotateAngleX, this.bipedHead.rotateAngleY, this.bipedHead.rotateAngleZ);
        this.setRotateAngle(this.body, this.bipedBody.rotateAngleX * 0.5F, this.bipedBody.rotateAngleY, this.bipedBody.rotateAngleZ);
        this.setRotateAngle(this.skirt1, this.bipedBody.rotateAngleX * 0.5F, this.bipedBody.rotateAngleY, this.bipedBody.rotateAngleZ);
        this.setRotateAngle(this.skirt2, this.bipedBody.rotateAngleX * 0.5F, this.bipedBody.rotateAngleY, this.bipedBody.rotateAngleZ);
        this.setRotateAngle(this.bipedLeftArmwear, this.bipedLeftArm.rotateAngleX, this.bipedLeftArm.rotateAngleY, this.bipedLeftArm.rotateAngleZ);
        this.setRotateAngle(this.bipedRightArmwear, this.bipedRightArm.rotateAngleX, this.bipedRightArm.rotateAngleY, this.bipedRightArm.rotateAngleZ);

        if( this.isRiding ) {
            this.setRotateAngle(this.legLeft, this.bipedLeftLeg.rotateAngleX, this.bipedLeftLeg.rotateAngleY, this.bipedLeftLeg.rotateAngleZ);
            this.setRotateAngle(this.legRight, this.bipedRightLeg.rotateAngleX, this.bipedRightLeg.rotateAngleY, this.bipedRightLeg.rotateAngleZ);
        } else {
            this.setRotateAngle(this.legLeft, this.bipedLeftLeg.rotateAngleX * 0.5F, this.bipedLeftLeg.rotateAngleY, this.bipedLeftLeg.rotateAngleZ);
            this.setRotateAngle(this.legRight, this.bipedRightLeg.rotateAngleX * 0.5F, this.bipedRightLeg.rotateAngleY, this.bipedRightLeg.rotateAngleZ);
        }

        this.bipedLeftArm.rotateAngleZ -= 0.1F;
        this.bipedRightArm.rotateAngleZ += 0.1F;
        this.bipedLeftArmwear.rotateAngleZ -= 0.1F;
        this.bipedRightArmwear.rotateAngleZ += 0.1F;

        if( this.isSneak ) {
            this.legLeft.rotationPointZ = 3.0F;
            this.legRight.rotationPointZ = 3.0F;
            this.legLeft.rotateAngleX -= 0.15F;
            this.legRight.rotateAngleX -= 0.15F;
            this.bipedLeftArm.rotateAngleX += 0.2F;
            this.bipedLeftArmwear.rotateAngleX += 0.2F;
            this.bipedRightArm.rotateAngleX += 0.2F;
            this.bipedRightArmwear.rotateAngleX += 0.2F;
        } else {
            this.legLeft.rotationPointZ = 0.0F;
            this.legRight.rotationPointZ = 0.0F;
        }

        setRotationPoint(this.bipedLeftArm, 5.0F, 2.0F, 0.5F);
        setRotationPoint(this.bipedRightArm, -4.0F, 2.0F, 0.5F);
        setRotationPoint(this.bipedLeftArmwear, 5.0F, 2.0F, 0.5F);
        setRotationPoint(this.bipedRightArmwear, -4.0F, 2.0F, 0.5F);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationPoint(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotationPointX = x;
        modelRenderer.rotationPointY = y;
        modelRenderer.rotationPointZ = z;
    }
}