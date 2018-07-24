/* ******************************************************************************************************************
 * Authors:   SanAndreasP
 * Copyright: SanAndreasP
 * License:   Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International
 *                http://creativecommons.org/licenses/by-nc-sa/4.0/
 *******************************************************************************************************************/

import de.sanandrew.mods.sanlib.SanLib;
import de.sanandrew.mods.sanlib.lib.config.Category;
import de.sanandrew.mods.sanlib.lib.config.ConfigUtils;
import de.sanandrew.mods.sanlib.lib.config.EnumExclude;
import de.sanandrew.mods.sanlib.lib.config.Pattern;
import de.sanandrew.mods.sanlib.lib.config.Range;
import de.sanandrew.mods.sanlib.lib.config.Value;
import de.sanandrew.mods.sanlib.lib.util.MiscUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;

import java.io.File;

@SuppressWarnings("all")
@Mod(modid = "santest", dependencies = "required-after:" + SanLib.ID)
public class Test
{
    @Mod.Instance
    public static Test instance;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        testConfig(event.getSuggestedConfigurationFile());
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
//        testNbtMethods();
    }

    private static void testConfig(File path) {
        Configuration config = ConfigUtils.loadConfigFile(path, "1.0", "santest");
        ConfigUtils.loadCategories(config, TestConfig.class);
        config.save();
    }

    private static void testNbtMethods() {
        NBTTagCompound numericNbt1 = new NBTTagCompound(); numericNbt1.setInteger("num", 16); numericNbt1.setLong("num2", 32);
        NBTTagCompound numericNbt2 = new NBTTagCompound(); numericNbt2.setByte("num", (byte) 16);

        SanLib.LOG.log(Level.INFO,
                       String.format("MiscUtils.doesNbtContainOther(numericNbt1, numericNbt2, false) = %s, should be true",
                                     MiscUtils.doesNbtContainOther(numericNbt1, numericNbt2, false)));
        SanLib.LOG.log(Level.INFO,
                       String.format("MiscUtils.doesNbtContainOther(numericNbt2, numericNbt1, false) = %s, should be false",
                                     MiscUtils.doesNbtContainOther(numericNbt2, numericNbt1, false)));

        NBTTagCompound tagNbt1 = new NBTTagCompound(); tagNbt1.setTag("tag", numericNbt1);
        NBTTagCompound tagNbt2 = new NBTTagCompound(); tagNbt2.setTag("tag", numericNbt2);

        SanLib.LOG.log(Level.INFO,
                       String.format("MiscUtils.doesNbtContainOther(tagNbt1, tagNbt2, false) = %s, should be true",
                                     MiscUtils.doesNbtContainOther(tagNbt1, tagNbt2, false)));
        SanLib.LOG.log(Level.INFO,
                       String.format("MiscUtils.doesNbtContainOther(tagNbt2, tagNbt1, false) = %s, should be false",
                                     MiscUtils.doesNbtContainOther(tagNbt2, tagNbt1, false)));

        NBTTagList list1 = new NBTTagList(); list1.appendTag(numericNbt1); list1.appendTag(new NBTTagCompound());
        NBTTagList list2 = new NBTTagList(); list2.appendTag(numericNbt2);
        NBTTagCompound listNbt1 = new NBTTagCompound(); listNbt1.setTag("list", list1);
        NBTTagCompound listNbt2 = new NBTTagCompound(); listNbt2.setTag("list", list2);

        SanLib.LOG.log(Level.INFO,
                       String.format("MiscUtils.doesNbtContainOther(listNbt1, listNbt2, false) = %s, should be true",
                                     MiscUtils.doesNbtContainOther(listNbt1, listNbt2, false)));
        SanLib.LOG.log(Level.INFO,
                       String.format("MiscUtils.doesNbtContainOther(listNbt2, listNbt1, false) = %s, should be false",
                                     MiscUtils.doesNbtContainOther(listNbt2, listNbt1, false)));
    }

    public static final class TestConfig
    {
        @Category(value = "config_nrm", comment = "a test 1", reqMcRestart = true)
        public static final class Config1
        {
            @Value(value = "string_1", comment = "meh")
            public static String streng = "meh";

            @Value(value = "double_rng", range = @Range(minD = -5, maxD = 14))
            public static double double_rng = 3.0;

            @Value(value = "double_def")
            public static double double_def = 4.0;

            @Value(value = "int_array")
            public static int[] int_array = new int[] {5, 4, 3, 2, 1, 0};

            @Value(value = "int_array_fixed", range = @Range(listFixed = true))
            public static int[] int_array_fixed = new int[] {5, 4, 3, 2, 1, 0};

            @Value(value = "string_array_patterned", range = @Range(validationPattern = @Pattern(regex = "[\\d|\\w]+")))
            public static String[] string_array_pattern = new String[] {"1", "2", "3", "4"};

            private static void init() {
                System.out.println("init called!");
            }
        }

        @Category(value = "config_enum", comment = "haha", reqWorldRestart = true)
        public enum Config2
        {
            DEE1,
            DEE2,

            @EnumExclude
            UNKNOWN;

            @Value(value = "int_1", comment = "rofl", range = @Range(minI = -82, maxI = 69))
            public int ente;
            @Value(value = "float_1", range = @Range(minD = 1, maxD = 5))
            public float carnival;
        }
    }
}