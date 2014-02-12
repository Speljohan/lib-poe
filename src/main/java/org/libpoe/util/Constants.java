package org.libpoe.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.libpoe.model.mod.ExplicitMod;
import org.libpoe.model.mod.ImplicitMod;
import org.libpoe.model.property.Property;
import org.libpoe.model.socket.Sockets;
import org.libpoe.serial.ExplicitModDeserializer;
import org.libpoe.serial.ImplicitModDeserializer;
import org.libpoe.serial.PropertyDeserializer;
import org.libpoe.serial.SocketDeserializer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Johan
 * Date: 2013-12-03
 * Time: 18:15
 */
public class Constants {

    public static final Gson GSON_INSTANCE;

    // Data below is courtesy of thexyz, thanks!
    public static final String[] ITEM_MODS = {
            "+# to Armour",
            "#% increased Armour",
            "#% increased Block and Stun Recovery",
            "Adds #-# Cold Damage",
            "Adds #-# Fire Damage",
            "Adds #-# Lightning Damage",
            "Adds #-# Physical Damage",
            "Reflects # Physical Damage to Melee Attackers",
            "#% increased Physical Damage",
            "+# to Accuracy Rating",
            "+# to maximum Energy Shield",
            "#% increased Energy Shield",
            "+# to Evasion Rating",
            "#% increased Evasion Rating",
            "+# to Level of Cold Gems in this item",
            "+# to Level of Bow Gems in this item",
            "+# to Level of Fire Gems in this item",
            "+# to Level of Gems in this item",
            "+# to Level of Lightning Gems in this item",
            "+# to Level of Melee Gems in this item",
            "+# to Level of Minion Gems in this item",
            "#% increased Armour and Energy Shield",
            "#% increased Armour and Evasion",
            "#% increased Evasion and Energy Shield",
            "+# to maximum Life",
            "#% of Physical Attack Damage Leeched as Life",
            "+# to maximum Mana",
            "#% of Physical Attack Damage Leeched as Mana",
            "#% increased Movement Speed",
            "#% increased Spell Damage",
            "#% increased Elemental Damage with Weapons",
            "#% increased Attack Speed",
            "+# to all Attributes",
            "+# to Dexterity",
            "+# to Intelligence",
            "+# to Strength",
            "#% increased Cast Speed",
            "#% increased Global Critical Strike Multiplier",
            "#% increased Critical Strike Chance",
            "#% increased Cold Damage",
            "#% increased Fire Damage",
            "#% increased Lightning Damage",
            "#% increased Quantity of Items found",
            "#% increased Rarity of Items found",
            "+# Life gained for each enemy hit by your Attacks",
            "+# Life gained when you Kill an enemy",
            "# Life Regenerated per second",
            "+# Mana Gained when you Kill an enemy",
            "#% increased Mana Regeneration Rate",
            "+#% to Chaos Resistance",
            "+#% to Cold Resistance",
            "+#% to Fire Resistance",
            "+#% to Lightning Resistance",
            "+#% to all Elemental Resistances",
            "#% increased Stun Duration on enemies",
            "#% reduced Enemy Stun Threshold",
            "#% additional Block Chance",
            "#% increased Projectile Speed",
            "#% increased Global Critical Strike Chance",
            "#% increased maximum Energy Shield",
            "#% increased Charge Recovery",
            "Adds Knockback to Melee Attacks during flask effect",
            "#% increased Flask Charges gained",
            "#% increased Flask Mana recovery rate",
            "#% reduced Flask Charges used",
            "#% increased Flask Life recovery rate",
            "Adds #% Life Leech to Physical Attack Damage during flask effect",
            "Recharges 1 Charge when you deal a Critical Strike",
            "#% increased Flask effect duration",
            "#% increased Critical Strike Chance for Spells",
            "+#% to maximum Cold Resistance",
            "Reflects # Cold Damage to Melee Attackers",
            "#% increased Movement Speed when on Full Life",
            "Take # Physical Damage when hit by Attacks",
            "Pain Attunement",
            "+1 to Maximum number of Zombies",
            "+1 to Maximum number of Spectres",
            "#% reduced Movement Speed",
            "#% reduced Rarity of Items found",
            "#% reduced Experience gain",
            "#% increased Experience gain",
            "#% increased Elemental Damage",
            "#% increased Intelligence Requirement",
            "#% increased Burning Damage",
            "Enemies can have 1 additional Curse",
            "Adds #-# Chaos Damage",
            "#% Chance to Cause Monsters to Flee",
            "#% of Physical Damage Converted to Chaos Damage",
            "#% increased Accuracy Rating",
            "#% of Physical Damage taken as Chaos Damage",
            "#% increased Mana Cost of Skills",
            "Causes Bleeding on Hit",
            "You gain # Evasion Rating when on Full Life",
            "#% of Physical Damage Converted to Cold Damage",
            "You gain # Evasion Rating when on Low Life",
            "#% of Life Regenerated per Second while on Low Life",
            "#% less Weapon Damage",
            "#% reduced Freeze Duration on You",
            "#% reduced Movement Speed when on Low Life",
            "Cannot be Stunned when on Low Life",
            "#% increased Rarity of Items found when on Low Life",
            "-#% to Fire Resistance",
            "-#% to Cold Resistance",
            "#% increased Armour during flask effect",
            "#% additional Elemental Resistances during flask effect",
            "+# Extra Charges",
            "+1 to Level of Strength Gems in this item",
            "Culling Strike",
            "#% more Unarmed Physical Damage",
            "Extra gore",
            "#% increased Damage when on Low Life",
            "#% increased Attack Speed when on Full Life",
            "#% increased Movement Speed when on Low Life",
            "Cannot be Frozen",
            "Cannot Evade enemy Attacks",
            "Cannot be Shocked",
            "#% reduced maximum Life",
            "Cannot be Stunned",
            "#% reduced maximum Energy Shield",
            "#% of Block Chance applied to Spells",
            "Minions have #% increased maximum Life",
            "Minions have #% increased Movement Speed",
            "Minions deal #% increased Damage",
            "#% reduced maximum Mana",
            "Gain a Power Charge on Critical Strike",
            "#% reduced Cast Speed",
            "Adds an additional Arrow",
            "#% additional Block Chance while Dual Wielding",
            "#% increased maximum Life",
            "-# Physical Damage taken from Attacks",
            "#% increased Elemental Resistances while on Low Life",
            "#% reduced Mana Cost of Skills when on Low Life",
            "Conduit",
            "#% increased Movement Speed during flask effect",
            "#% increased Evasion Rating during flask effect",
            "Recharges 3 Charges when you take a Critical Strike",
            "Gain an Endurance Charge when an enemy Scores a Critical Strike on You",
            "Share Endurance Charges with nearby party members",
            "Adds #% Mana Leech to Physical Attack Damage during flask effect",
            "#% of Physical Damage Converted to Fire Damage",
            "Never deal Critical Strikes",
            "#% of Block Chance applied to Spells when on Low Life",
            "#% increased Stun Recovery during flask effect",
            "#% reduced Amount Recovered",
            "Instant Recovery when on Low Life",
            "Immunity to Curses during flask effect. Removes Curses on use",
            "Dispels Frozen and Chilled",
            "50% increased Amount Recovered",
            "33% reduced Recovery Speed",
            "Grants #% of Life Recovery to Minions",
            "135% increased Recovery Speed",
            "50% of Recovery applied Instantly",
            "Blood Magic",
            "+1 maximum Endurance Charge",
            "#% increased Ignite Duration on enemies",
            "#% chance to Ignite the enemy on hit with Fire Damage",
            "Reflects # Fire Damage to Melee Attackers",
            "#% of Physical Damage taken as Fire Damage",
            "100% More Bow Damage at Close Range",
            "Bow Knockback at Close Range",
            "60% increased Mana Recovered",
            "Removes 15% of Mana Recovered from Life when used",
            "100% increased Recovery when on Low Life",
            "Instant Recovery",
            "+2 to Maximum number of Skeletons",
            "#% increased Skeleton Duration",
            "25% increased Strength Requirement",
            "Curse Reflection",
            "30% of Melee Damage taken reflected to Attacker",
            "Enemies Cannot Leech Life From You",
            "10% chance to Blind enemies on hit",
            "Skill gems in this item are supported by level 5 Blind",
            "Dispels Burning",
            "Hits can't be Evaded",
            "+5% to all maximum Resistances",
            "Cannot Block Attacks",
            "-25 Physical Damage taken from Ranged Attacks",
            "Gems in this item are Supported by level 15 Added Chaos Damage",
            "Arrows always Pierce",
            "Cannot Leech"
    };

    public static final String[] ESCAPED_MODS;

    static {
        Pattern p1 = Pattern.compile("([%\\-\\+])");
        Pattern p2 = Pattern.compile("([#])");


        ESCAPED_MODS = new String[ITEM_MODS.length];
        for (int i = 0; i < ITEM_MODS.length; i++) {
            Matcher m = p1.matcher(ITEM_MODS[i]);
            ESCAPED_MODS[i] = m.replaceAll("\\\\$1");
            Matcher m2 = p2.matcher(ESCAPED_MODS[i]);
            ESCAPED_MODS[i] = m2.replaceAll("[^\\\\d]*([0-9]+[\\\\s]*[.,]{0,1}[\\\\s]*[0-9]*).*");
        }

        GSON_INSTANCE = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .registerTypeAdapter(Property.class, new PropertyDeserializer())
                .registerTypeAdapter(Sockets.class, new SocketDeserializer())
                .registerTypeAdapter(ExplicitMod.class, new ExplicitModDeserializer())
                .registerTypeAdapter(ImplicitMod.class, new ImplicitModDeserializer()).create();
    }

}
