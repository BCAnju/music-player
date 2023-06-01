package com.test;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MusicPlayer {
	
	static Map<String, LinkedList<String>> songListForUsers = new HashMap<>();
	static int limitSongs = 3;
	
	static void playSong(String song, String user) {
		LinkedList<String> songList = songListForUsers.get(user);
		songList.add(song);
		if(songList.size()>limitSongs) {
			songList.removeFirst();
		}
	}
	
	static void getCurrentPlaylist(String user) {
		System.out.println(songListForUsers.get(user));
		
	}
	
	static String getLastPlayedSong(String user) {
		return songListForUsers.get(user).getLast();
	}
	
	private static void registeruser(String user) {
		songListForUsers.put(user,new LinkedList<String>());
	}
	
	static void testLastPlayed(String song) {
		try {
			assert getLastPlayedSong("user1").equals(song);
			System.out.println("The playlist is correct");
		}
		catch(AssertionError e) {
			System.out.println("The playlist is incorrect");
		}
	}
	

	public static void main(String[] args) {
		registeruser("user1");
		playSong("S1","user1");
		playSong("S2","user1");
		playSong("S3","user1");
		System.out.println("Current playlist");
		getCurrentPlaylist("user1");
		playSong("S4","user1");
		System.out.println("Current playlist after playing new song");
		getCurrentPlaylist("user1");
		playSong("S1","user1");
		System.out.println("Current playlist after playing first song");
		getCurrentPlaylist("user1");
		testLastPlayed("S1");
	}
       
}
