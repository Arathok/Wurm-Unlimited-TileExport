package org.arathok.wurmunlimited.mods.tilexport;

import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.ItemList;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


    public class SetRadiusBehaviour implements BehaviourProvider
    {

        private List<ActionEntry> menu;

        public SetRadiusBehaviour() {
            menu = new LinkedList<>();
            menu.add(new ActionEntry((short) -6, "Set Survey Radius to:", ""));
            menu.add(new SetRadiusAction(Config.value1, "5 Tiles").actionEntry);
            menu.add(new SetRadiusAction(Config.value2, "10 Tiles").actionEntry);
            menu.add(new SetRadiusAction(Config.value3, "15 Tiles").actionEntry);
            menu.add(new SetRadiusAction(Config.value4, "20 Tiles").actionEntry);
            menu.add(new SetRadiusAction(Config.value5, "25 Tiles").actionEntry);
            menu.add(new SetRadiusAction(Config.value6, "50 Tiles").actionEntry);

        }

        @Override
        public List<ActionEntry> getBehavioursFor(Creature performer, Item target) {
            if (SetRadiusAction.canUse(performer,  target))
                return menu;
            else
                return null;
        }
        @Override
        public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item target) {
            return getBehavioursFor(performer, target);
        }
    }




