// Log.java - Bukkit Plugin Logger Wrapper
// Copyright (C) 2012 Zarius Tularial
//
// This file released under Evil Software License v1.1
// <http://fredrikvold.info/ESL.htm>

package com.gmail.zariust.otherdrops;

import java.util.logging.Logger;

import com.gmail.zariust.common.Verbosity;

public class Log {
/*
	private static Logger log = Logger.getLogger("Minecraft");

	// LogInfo & Logwarning - display messages with a standard prefix
	public static void logWarning(String msg) {
		log.warning("["+OtherDrops.pluginName+":"+OtherDrops.pluginVersion+"] "+msg);
	}

	public static void low(String msg) {
		if (OtherDropsConfig.getVerbosity().exceeds(Verbosity.LOW)) logInfo(msg);
	}

	public static void normal(String msg) {
		if (OtherDropsConfig.getVerbosity().exceeds(Verbosity.NORMAL)) logInfo(msg);
	}

	public static void high(String msg) {
		if (OtherDropsConfig.getVerbosity().exceeds(Verbosity.HIGH)) logInfo(msg);
	}

	public static void highest(String msg) {
		if (OtherDropsConfig.getVerbosity().exceeds(Verbosity.HIGHEST)) logInfo(msg);
	}

	public static void extreme(String msg) {
		if (OtherDropsConfig.getVerbosity().exceeds(Verbosity.EXTREME)) logInfo(msg);
	}
	// LogInfo & LogWarning - if given a level will report the message
	// only for that level & above

	@Deprecated
	public static void logWarning(String msg, Verbosity level) {
		if (OtherDropsConfig.getVerbosity().exceeds(level)) logWarning(msg);
	}

	private static void logInfo(String msg) {
		log.info("["+OtherDrops.pluginName+":"+OtherDrops.pluginVersion+"] "+msg);
	}

	// TODO: This is only for temporary debug purposes.
	public static void stackTrace() {
		if(OtherDropsConfig.getVerbosity().exceeds(Verbosity.EXTREME)) Thread.dumpStack();
	}*/
}