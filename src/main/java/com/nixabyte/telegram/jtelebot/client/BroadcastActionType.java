/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package com.nixabyte.telegram.jtelebot.client;
/**
 * 
 * Type of action to broadcast. 
 * Choose one, depending on what the user is about to receive: 
 *
 */
public enum BroadcastActionType {

	  TYPING("typing"), //FOR TEXT MESSAGES, 
	  UPLOAD_PHOTO("upload_photo"),// FOR PHOTOS, 
	  RECORD_VIDEO("record_video"),
	  UPLOAD_VIDEO("upload_video"),// FOR VIDEOS, 
	  RECORD_AUDIO("record_audio"),
	  UPLOAD_AUDIO("upload_audio"),// FOR AUDIO FILES, 
	  UPLOAD_DOCUMENT("upload_document"),// FOR GENERAL FILES, 
	  FIND_LOCATION("find_location");// FOR LOCATION DATA.
	  
	  private String actionToBroadcast;

	  private BroadcastActionType(final String actionToBroadcast){
		  this.actionToBroadcast = actionToBroadcast;
	  }

	public String getActionToBroadcast() {
		return actionToBroadcast;
	}
	  
	  
}
