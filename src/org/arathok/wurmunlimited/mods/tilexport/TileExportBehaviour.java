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


public class TileExportBehaviour implements BehaviourProvider
{


    private final List<ActionEntry> survey;
    private final TileExportAction tileExport;

    public TileExportBehaviour() {
        this.tileExport = new TileExportAction();
        this.survey = Collections.singletonList(tileExport.actionEntry);
        ModActions.registerActionPerformer(tileExport);

    }


    @Override
    public List<ActionEntry> getBehavioursFor(Creature performer, Item target) {
        if (TileExportAction.canUse(performer,  target)&&target.getTemplateId()== ItemList.buildMarker)
            return new ArrayList<>(survey);
        else
            return null;
    }
    @Override
    public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item target) {
        return getBehavioursFor(performer, target);
    }
}




