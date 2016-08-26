package com.ethanco.myprojecttest;

/**
 * @Description 音乐播放器
 * Created by EthanCo on 2016/8/23.
 */
public interface IMusicPlayer {
    void play();

    void play(int index);

    void puase();

    void next();

    void prev();

    boolean isPlaying();
}
