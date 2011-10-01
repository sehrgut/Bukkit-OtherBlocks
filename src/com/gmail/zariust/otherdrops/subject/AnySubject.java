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

package com.gmail.zariust.otherdrops.subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;

import com.gmail.zariust.common.MaterialGroup;
import com.gmail.zariust.otherdrops.data.Data;
import com.gmail.zariust.otherdrops.options.ConfigOnly;
import com.gmail.zariust.otherdrops.options.ToolDamage;

@ConfigOnly({Agent.class, Target.class})
public class AnySubject implements Agent, Target {
	@Override
	public boolean equals(Object other) {
		return other instanceof AnySubject;
	}
	
	@Override
	public boolean matches(Subject other) {
		return true;
	}
	
	@Override
	public int hashCode() {
		return new HashCode(this).setData(7).get(-42);
	}
	
	@Override
	public ItemCategory getType() {
		return null;
	}
	
	public static Agent parseAgent(String name) {
		name = name.toUpperCase();
		if(name.equals("ANY") || name.equals("ALL")) return new AnySubject();
		else if(name.equals("ANY_OBJECT")) return new PlayerSubject();
		else if(name.equals("ANY_CREATURE")) return new CreatureSubject();
		else if(name.equals("ANY_DAMAGE")) return new EnvironmentAgent();
		else if(name.equals("ANY_PROJECTILE")) return new ProjectileAgent();
		MaterialGroup group = MaterialGroup.get(name);
		if(group != null) return new MaterialGroupAgent(group);
		return null;
	}

	public static Target parseTarget(String name) {
		if(name.endsWith("ANY") || name.equals("ALL")) return new AnySubject();
		else if(name.equals("ANY_BLOCK")) return new BlockTarget();
		else if(name.equals("ANY_CREATURE")) return new CreatureSubject();
		MaterialGroup group = MaterialGroup.get(name);
		if(group != null && group.isBlock()) return new BlocksTarget(group);
		else return null;
	}

	@Override
	public boolean overrideOn100Percent() {
		return false;
	}
	
	@Override public void damage(int amount) {}
	
	@Override public void damageTool(ToolDamage amount, Random rng) {}

	@Override
	public List<Target> canMatch() {
		List<Target> all = new ArrayList<Target>();
		all.addAll(new BlockTarget().canMatch());
		all.addAll(new CreatureSubject().canMatch());
		return all;
	}

	@Override
	public String getKey() {
		return null;
	}

	@Override
	public Location getLocation() {
		return null;
	}

	@Override
	public String toString() {
		return "ANY";
	}

	@Override // It's a wildcard, so we don't need anything here. The annotation should prevent it from being called.
	public void setTo(BlockTarget replacement) {}

	@Override
	public Data getData() {
		return null;
	}
}