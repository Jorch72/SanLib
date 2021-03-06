/* ******************************************************************************************************************
   * Authors:   SanAndreasP
   * Copyright: SanAndreasP
   * License:   Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International
   *                http://creativecommons.org/licenses/by-nc-sa/4.0/
   *******************************************************************************************************************/
package de.sanandrew.mods.sanlib.sanplayermodel.client.model;

import de.sanandrew.mods.sanlib.lib.client.ModelJsonHandler;
import de.sanandrew.mods.sanlib.lib.client.ModelJsonLoader;
import de.sanandrew.mods.sanlib.sanplayermodel.Resources;
import de.sanandrew.mods.sanlib.sanplayermodel.client.renderer.entity.RenderSanPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class ModelSanPlayer
        extends ModelPlayer
        implements ModelJsonHandler<ModelSanPlayer, ModelJsonLoader.ModelJson>
{
    private final float scaling;
    private final ModelJsonLoader<ModelSanPlayer, ModelJsonLoader.ModelJson> modelJson;

    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer leftArm;
    public ModelRenderer rightArm;
    public ModelRenderer leftLeg;
    public ModelRenderer rightLeg;

    public ModelSanPlayer(float scaling) {
        super(scaling, true);
        this.scaling = scaling;
        this.modelJson = ModelJsonLoader.create(this, Resources.MAIN_MODEL, "head", "body", "leftArm", "rightArm", "leftLeg", "rightLeg");
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        Arrays.asList(this.modelJson.getMainBoxes()).forEach((box) -> box.render(scale));
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float rotFloat, float rotYaw, float rotPitch, float partTicks, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, rotFloat, rotYaw, rotPitch, partTicks, entity);

        setRotateAngle(this.head, this.bipedHead.rotateAngleX, this.bipedHead.rotateAngleY, this.bipedHead.rotateAngleZ);
        setRotateAngle(this.body, this.bipedBody.rotateAngleX * 0.5F, this.bipedBody.rotateAngleY, this.bipedBody.rotateAngleZ);
        setRotateAngle(this.leftArm, this.bipedLeftArm.rotateAngleX, this.bipedLeftArm.rotateAngleY, this.bipedLeftArm.rotateAngleZ);
        setRotateAngle(this.rightArm, this.bipedRightArm.rotateAngleX, this.bipedRightArm.rotateAngleY, this.bipedRightArm.rotateAngleZ);

        if( this.isRiding ) {
            setRotateAngle(this.leftLeg, this.bipedLeftLeg.rotateAngleX * 0.95F, this.bipedLeftLeg.rotateAngleY, this.bipedLeftLeg.rotateAngleZ);
            setRotateAngle(this.rightLeg, this.bipedRightLeg.rotateAngleX * 0.95F, this.bipedRightLeg.rotateAngleY, this.bipedRightLeg.rotateAngleZ);
        } else {
            setRotateAngle(this.leftLeg, this.bipedLeftLeg.rotateAngleX * 0.5F, this.bipedLeftLeg.rotateAngleY, this.bipedLeftLeg.rotateAngleZ);
            setRotateAngle(this.rightLeg, this.bipedRightLeg.rotateAngleX * 0.5F, this.bipedRightLeg.rotateAngleY, this.bipedRightLeg.rotateAngleZ);
        }

        if( this.isSneak ) {
            this.leftLeg.rotationPointZ = 3.0F;
            this.rightLeg.rotationPointZ = 3.0F;
            this.leftLeg.rotationPointY = 10.0F;
            this.rightLeg.rotationPointY = 10.0F;
            this.leftLeg.rotateAngleX -= 0.05F;
            this.rightLeg.rotateAngleX -= 0.05F;
            this.leftArm.rotateAngleX += 0.2F;
            this.rightArm.rotateAngleX += 0.2F;
        } else {
            this.leftLeg.rotationPointZ = 0.0F;
            this.rightLeg.rotationPointZ = 0.0F;
            this.leftLeg.rotationPointY = 11.0F;
            this.rightLeg.rotationPointY = 11.0F;
        }

        if( RenderSanPlayer.hasCstChest ) {
            this.leftArm.rotateAngleZ -= RenderSanPlayer.armTilt;
            this.rightArm.rotateAngleZ += RenderSanPlayer.armTilt;
        }
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);

        Arrays.asList(this.modelJson.getMainBoxes()).forEach((box) -> box.showModel = visible);
    }

    private static void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void onReload(IResourceManager resourceManager, ModelJsonLoader<ModelSanPlayer, ModelJsonLoader.ModelJson> loader) {
        loader.load();

        this.head = loader.getBox("head");
        this.body = loader.getBox("body");
        this.leftArm = loader.getBox("leftArm");
        this.rightArm = loader.getBox("rightArm");
        this.leftLeg = loader.getBox("leftLeg");
        this.rightLeg = loader.getBox("rightLeg");
    }

    @Override
    public void setTexture(String textureStr) { }

    @Override
    public float getBaseScale() {
        return this.scaling;
    }
}
