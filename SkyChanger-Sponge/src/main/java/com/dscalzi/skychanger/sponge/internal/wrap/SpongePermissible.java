/*
 * This file is part of SkyChanger, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2017-2020 Daniel D. Scalzi <https://github.com/dscalzi/SkyChanger>
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

import com.dscalzi.skychanger.core.internal.wrap.IPermissible;
import org.spongepowered.api.service.permission.Subject;

public class SpongePermissible implements IPermissible {

    private final Subject s;

    protected SpongePermissible(Subject subject) {
        this.s = subject;
    }

    public static SpongePermissible of(Subject subject) {
        return subject == null ? null : new SpongePermissible(subject);
    }

    @Override
    public Object getOriginal() {
        return s;
    }

    @Override
    public boolean hasPermission(String perm) {
        return s.hasPermission(perm);
    }
}
