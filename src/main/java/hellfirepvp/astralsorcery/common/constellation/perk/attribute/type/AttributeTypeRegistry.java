/*******************************************************************************
 * HellFirePvP / Astral Sorcery 2018
 *
 * All rights reserved.
 * The source code is available on github: https://github.com/HellFirePvP/AstralSorcery
 * For further details, see the License file there.
 ******************************************************************************/

package hellfirepvp.astralsorcery.common.constellation.perk.attribute.type;

import com.google.common.collect.ImmutableList;
import hellfirepvp.astralsorcery.AstralSorcery;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: AttributeTypeRegistry
 * Created by HellFirePvP
 * Date: 08.07.2018 / 12:27
 */
public class AttributeTypeRegistry {

    public static final String ATTR_TYPE_DAMAGE = AstralSorcery.MODID + ".attackdamage";
    public static final String ATTR_TYPE_HEALTH = AstralSorcery.MODID + ".maxhealth";
    public static final String ATTR_TYPE_MOVESPEED = AstralSorcery.MODID + ".movespeed";
    public static final String ATTR_TYPE_FLYSPEED = AstralSorcery.MODID + ".movespeed";
    public static final String ATTR_TYPE_ARMOR = AstralSorcery.MODID + ".armor";

    public static final String ATTR_TYPE_INC_PERK_EFFECT = AstralSorcery.MODID + ".perkeffect";
    public static final String ATTR_TYPE_INC_HARVEST_SPEED = AstralSorcery.MODID + ".harvestspeed";
    public static final String ATTR_TYPE_INC_CRIT_CHANCE = AstralSorcery.MODID + ".critchance";

    private static Map<String, PerkAttributeType> typeMap = new HashMap<>();

    AttributeTypeRegistry() {}

    public static void registerPerkType(PerkAttributeType type) {
        if(typeMap.putIfAbsent(type.getTypeString(), type) == null) {
            type.init();
        }
    }

    public static Collection<PerkAttributeType> getTypes() {
        return ImmutableList.copyOf(typeMap.values());
    }

    @Nullable
    public static PerkAttributeType getType(String typeStr) {
        return typeMap.get(typeStr);
    }

}