package net.teamaurorisla.auroramagic.registry;

import com.dark2932.darklib.register.CreativeTabRegister;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.RegistryObject;
import net.teamaurorisla.auroramagic.AuroraMagic;

import static net.teamaurorisla.auroramagic.registry.AMBlockItem.ARCANE_PEDESTAL_ITEM;
import static net.teamaurorisla.auroramagic.registry.AMItem.EXAMPLE_ITEM;

public final class AMCreativeModeTab {

    public static final CreativeTabRegister REGISTER = CreativeTabRegister.of(AuroraMagic.MODID);

    public static final RegistryObject<CreativeModeTab> TAB = REGISTER.newTab("example_tab", EXAMPLE_ITEM,
            (parameters, output) -> {
                output.accept(EXAMPLE_ITEM.item());
                output.accept(ARCANE_PEDESTAL_ITEM.get());
            });

}
