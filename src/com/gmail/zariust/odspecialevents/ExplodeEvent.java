// OtherDrops - a Bukkit plugin
// Copyright (C) 2011 Robert Sargant, Zarius Tularial, Celtic Minstrel
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.	 See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.	 If not, see <http://www.gnu.org/licenses/>.

package com.gmail.zariust.odspecialevents;

import java.util.List;

import com.gmail.zariust.otherdrops.event.OccurredDropEvent;
import com.gmail.zariust.otherdrops.event.SimpleDropEvent;
import com.gmail.zariust.otherdrops.special.SpecialResult;

public class ExplodeEvent extends SpecialResult {
	private float power = 4.0f;
	private boolean fire = false;

	public ExplodeEvent(ExplosionEvents source) {
		super("EXPLOSION", source);
	}

	@Override
	public void executeAt(OccurredDropEvent event) {
		event.getWorld().createExplosion(event.getLocation(), power, fire);
	}
	
	@Override
	public void interpretArguments(List<String> args) {
		boolean havePower = false, haveFire = false;
		for(String arg : args) {
			if(arg.equalsIgnoreCase("FIRE")) {
				haveFire = fire = true;
				used(arg);
			} else try {
				power = Float.parseFloat(arg);
				havePower = true;
				used(arg);
			} catch(NumberFormatException e) {}
			if(haveFire && havePower) break;
		}
	}
	
	@Override
	public boolean canRunFor(SimpleDropEvent drop) {
		return true;
	}
	
	@Override
	public boolean canRunFor(OccurredDropEvent drop) {
		return true;
	}
	
}
