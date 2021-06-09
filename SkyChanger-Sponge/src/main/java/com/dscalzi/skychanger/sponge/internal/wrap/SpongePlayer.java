/*
 * This file is part of SkyChanger, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2017-2021 Daniel D. Scalzi <https://github.com/dscalzi/SkyChanger>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.dscalzi.skychanger.sponge.internal.wrap;

import com.dscalzi.skychanger.core.internal.wrap.ILocation;
import com.dscalzi.skychanger.core.internal.wrap.IPlayer;
import com.dscalzi.skychanger.core.internal.wrap.IWorld;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;

import java.util.UUID;

public class SpongePlayer extends SpongeCommandSender implements IPlayer {

    private final ServerPlayer player;

    private SpongePlayer(ServerPlayer player) {
        super(player, player);
        this.player = player;
    }

    public static SpongePlayer of(ServerPlayer p) {
        return p == null ? null : new SpongePlayer(p);
    }

    @Override
    public Object getOriginal() {
        return this.player;
    }

    @Override
    public IWorld getWorld() {
        return SpongeWorld.of(player.world());
    }

    @Override
    public ILocation getLocation() {
        return SpongeLocation.of(player.location());
    }

    @Override
    public boolean teleport(ILocation loc) {
        return player.setLocation(ServerLocation.of((ServerWorld) loc.getWorld().getOriginal(), ((Location<?, ?>) loc.getOriginal()).blockPosition()));
    }

    @Override
    public UUID getUniqueId() {
        return player.uniqueId();
    }

    @Override
    public boolean isOnline() {
        return player.isOnline();
    }

    @Override
    public IPlayer getPlayer() {
        return this;
    }

    @Override
    public String getName() {
        return player.name();
    }

    @Override
    public boolean isConsole() {
        return false;
    }

    @Override
    public boolean isCommandBlock() {
        return false;
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public void sendMessage(String msg) {
        player.sendMessage(Identity.nil(), LegacyComponentSerializer.legacyAmpersand().deserialize(msg));
    }
}
