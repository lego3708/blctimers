/*
 *       Copyright (C) 2019-present LlamaLad7 <https://github.com/lego3708>
 *
 *       This program is free software: you can redistribute it and/or modify
 *       it under the terms of the GNU General Public License as published
 *       by the Free Software Foundation, either version 3 of the License, or
 *       (at your option) any later version.
 *
 *       This program is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       GNU Lesser General Public License for more details.
 *
 *       You should have received a copy of the GNU Lesser General Public License
 *       along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.llamalad7.blctimers.command;

import cc.hyperium.Hyperium;
import cc.hyperium.commands.BaseCommand;
import cc.hyperium.event.EventBus;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.client.TickEvent;
import com.llamalad7.blctimers.BLCTimersMod;
import com.llamalad7.blctimers.gui.ConfigGui;
import com.llamalad7.blctimers.utils.CountdownTimer;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

import static java.lang.Integer.parseInt;

public class ConfigCommand implements BaseCommand {
    private BLCTimersMod mod;

    public ConfigCommand(BLCTimersMod mod) {
        this.mod = mod;
    }

    @Override
    public String getName() {
        return "timers";
    }

    @Override
    public String getUsage() {
        return "/timers";
    }

    @Override
    public void onExecute(String[] args) {
        EventBus.INSTANCE.register(this);
    }

    @InvokeEvent
    public void onClientTick(TickEvent event) {
        EventBus.INSTANCE.unregister(this);
        Minecraft.getMinecraft().displayGuiScreen(new ConfigGui(mod));
    }
}

