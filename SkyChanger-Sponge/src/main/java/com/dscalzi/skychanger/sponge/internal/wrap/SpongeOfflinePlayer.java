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

import com.dscalzi.skychanger.core.internal.wrap.IOfflinePlayer;
import com.dscalzi.skychanger.core.internal.wrap.IPlayer;
import org.spongepowered.api.entity.living.player.User;

import java.util.UUID;

public class SpongeOfflinePlayer implements IOfflinePlayer {

    private final User u;

    private SpongeOfflinePlayer(User u) {
        this.u = u;
    }

    public static SpongeOfflinePlayer of(User u) {
        return u == null ? null : new SpongeOfflinePlayer(u);
    }

    @Override
    public UUID getUniqueId() {
        return u.uniqueId();
    }

    @Override
    public boolean isOnline() {
        return u.isOnline();
    }

    @Override
    public IPlayer getPlayer() {
        return SpongePlayer.of(u.player().orElse(null));
    }

    @Override
    public String getName() {
        return u.name();
    }

}
