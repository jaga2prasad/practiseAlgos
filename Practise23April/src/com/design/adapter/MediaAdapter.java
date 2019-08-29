package com.design.adapter;

public class MediaAdapter implements MediaPlayer{
	AdvancePlayer advance;
	MediaAdapter(String audioType) {
		if(audioType.equals("vlc")) {
			advance = new VlcPlayer();
		}else if(audioType.equals("mp4")) {
			advance = new Mp4Player();
					
		}
	}
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equals("vlc")) {
			advance.playVlc(fileName);
		}else if(audioType.equals("mp4")){
			advance.playMp4(fileName);
		}
	}

}
