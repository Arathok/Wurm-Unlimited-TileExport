package org.arathok.wurmunlimited.mods.tilexport;

import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import org.gotti.wurmunlimited.modsupport.actions.ActionEntryBuilder;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPropagation;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

public class TileExportAction implements ActionPerformer
{

    public ActionEntry actionEntry;
    static int radius;

    public TileExportAction()
    {
        actionEntry = new ActionEntryBuilder((short) ModActions.getNextActionId(), "Survey Area", "Surveying",
                                             new int[]{
                                                     6 /* ACTION_TYPE_NOMOVE */,
                                                     48 /* ACTION_TYPE_ENEMY_ALWAYS */,
                                                     35 /* DONT CARE WHETHER SOURCE OR TARGET */,

                                             }).range(4).build();

        ModActions.registerAction(actionEntry);

    }


    @Override
    public short getActionId()
    {
        return (actionEntry.getNumber());
    }

    public static boolean canUse(Creature performer, Item target)
    {
        return performer.isPlayer() && target.getOwnerId() == performer.getWurmId() && !target.isTraded();
    }

    @Override
    public boolean action(Action action, Creature performer, Item source, Item target, short num, float counter)
    {
        return action(action, performer, target, num, counter);
    } // NEEDED OR THE ITEM WILL ONLY ACTIVATE IF YOU HAVE NO ITEM ACTIVE


    @Override
    public boolean action(Action action, Creature performer, Item target, short num, float counter)
    {

        //Alchemy.logger.log(Level.INFO, "BLAH BLAH HE PERFORMS");


        if (!canUse(performer, target))
        {
            performer.getCommunicator().sendAlertServerMessage("You are not allowed to do that");
            return propagate(action,
                             ActionPropagation.FINISH_ACTION,
                             ActionPropagation.NO_SERVER_PROPAGATION,
                             ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);

        }
        else
        {


         performer.getCommunicator().sendShowDeedPlan(0,"Planned Area",performer.getTileX(),performer.getTileY(),performer.getTileX()-radius,performer.getTileY()-radius,
                                                      performer.getTileX()+radius,performer.getTileY()+radius,0);
        }
        return propagate(action,
                         ActionPropagation.FINISH_ACTION,
                         ActionPropagation.NO_SERVER_PROPAGATION,
                         ActionPropagation.NO_ACTION_PERFORMER_PROPAGATION);
    }
}
