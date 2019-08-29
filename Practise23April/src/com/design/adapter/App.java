package com.design.adapter;

public class App {
	public static void main(String[] args) {
		AduioPlayer player = new AduioPlayer();
		player.play("mp4", "xyz");
		player.play("mp3", "xyz");
		player.play("vlc", "xyz");
	}
}
