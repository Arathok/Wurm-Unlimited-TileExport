package org.arathok.wurmunlimited.mods.tilexport;

import com.wurmonline.server.creatures.Communicator;
import org.gotti.wurmunlimited.modloader.interfaces.*;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TileExport implements WurmServerMod, Initable, PreInitable, Configurable, ItemTemplatesCreatedListener, ServerStartedListener, ServerPollListener, PlayerMessageListener{

        public static final Logger logger = Logger.getLogger("TileExport");


        @Override
        public void configure(Properties properties) {

            Config.value1 = Integer.parseInt(properties.getProperty("Value1", "5"));
            Config.value2 = Integer.parseInt(properties.getProperty("Value2", "10"));
            Config.value3 = Integer.parseInt(properties.getProperty("Value3", "15"));
            Config.value4 = Integer.parseInt(properties.getProperty("Value4", "20"));
            Config.value5 = Integer.parseInt(properties.getProperty("Value5", "25"));
            Config.value6 = Integer.parseInt(properties.getProperty("Value6", "50"));


        }


        @Override
        public void preInit() {

            ModActions.init();

        }

        @Override
        public boolean onPlayerMessage(Communicator arg0, String arg1) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void onItemTemplatesCreated() {

            // TODO Auto-generated method stub

        }

        @Override
        public void onServerStarted() {
            // TODO Auto-generated method stub

            ModActions.registerBehaviourProvider(new SetRadiusBehaviour());
            ModActions.registerBehaviourProvider(new TileExportBehaviour());


            logger.log(Level.INFO, "Thank you Bdew!");

            logger.log(Level.INFO, "Hello, I'm the Alchemy mod and I have finished being loaded to your server! <3");
        }



        @Override
        public void init() {
            // TODO Auto-generated method stub

        }

        @Override
        public void onServerPoll() {



        }





}
