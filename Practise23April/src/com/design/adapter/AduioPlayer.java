package com.design.adapter;

public class AduioPlayer implements MediaPlayer{
	MediaAdapter adpter;
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equals("mp3")){
			System.out.println("playing mp3");
		} else if(audioType.equals("vlc") || audioType.equals("mp4")){
			adpter = new MediaAdapter(audioType);
			adpter.play(audioType, fileName);
		}
	}

}
