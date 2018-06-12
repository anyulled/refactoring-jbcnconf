package pl.refactoring.ex_dictaphone.states;

import pl.refactoring.ex_dictaphone.Dictaphone;
import pl.refactoring.ex_dictaphone.Engine;

/*
 * Invented by Wlodek Krakowski
 * Not Enum on purpose! :-P
 */
public abstract class State {
    public static final State OFF_STATE = new OffState();
    public static final State STOPPED_STATE = new StoppedState();
    public static final State PLAYING_STATE = new PlayingState();
    public static final State FORWARD_PLAY_3x_STATE = new ForwardPlayingState();
    public static final State BACKWARD_3x_STATE = new BackwardPlayingState();
    public static final State RECORDING_STATE = new RecordingState();
    public static final State PAUSED_STATE = new PausedState();
    public static final State FAST_FORWARD_STATE = new FastForwardState();
    public static final State REWIND_STATE = new RewindState();

    public State() {
    }

    public void handlePower(Dictaphone dictaphone){
        // Please override if required
    };

    public void handlePlay(Dictaphone dictaphone){
        // Please override if required
    };

    public void handleRecord(Dictaphone dictaphone){
        // Please override if required
    };

    public void handleStop(Dictaphone dictaphone){
        // Please override if required
    };

    public void handleFastForward(Dictaphone dictaphone){
        // Please override if required
    };

    public void handleRewind(Dictaphone dictaphone){
        // Please override if required
    };

    public void handlePause(Dictaphone dictaphone){
        // Please override if required
    }
}
