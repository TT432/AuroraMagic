package net.teamaurorisla.auroramagic.registry;

import com.dark2932.darklib.item.ItemEntry;
import com.dark2932.darklib.register.item.FoodRegister;
import net.teamaurorisla.auroramagic.AuroraMagic;

public final class AMItem {

    public static final FoodRegister REGISTER = FoodRegister.of(AuroraMagic.MODID);

    public static final ItemEntry EXAMPLE_ITEM = REGISTER.newFood("example_item", REGISTER.newFoodProps(1, 2.0f, false, false, true));

}
