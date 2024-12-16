package org.scubakay.dynamic_resource_pack;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.scubakay.dynamic_resource_pack.command.ResourceCommand;
import org.scubakay.dynamic_resource_pack.util.ConfigFileHandler;
import org.scubakay.dynamic_resource_pack.util.ResourcePackHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicResourcePack implements ModInitializer {
    public static final String MOD_ID = "DynamicResourcePack";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ConfigFileHandler.registerEvents();
        CommandRegistrationCallback.EVENT.register(ResourceCommand::register);
    }
}
