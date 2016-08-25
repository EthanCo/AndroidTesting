package com.ethanco.myprojecttest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by EthanCo on 2016/8/23.
 */
public class MusicTest {

    IMusicPlayer player;

    @Before
    public void initData() {
        System.out.println("========== initData ==========");
        //player = new MiGuPlayer();
        player = mock(IMusicPlayer.class);
        when(player.isPlaying()).thenReturn(true);
    }

    @Test
    public void testPlay() {
        System.out.println("========== testPlay ==========");
        player.play();
        System.out.println("========== play Status:" + player.isPlaying() + " ==========");
    }

    @Test
    public void puase() {
        System.out.println("========== puase ==========");
        player.puase();
    }

    @After
    public void finish() {
        System.out.println("========== finish ==========");
    }
}
