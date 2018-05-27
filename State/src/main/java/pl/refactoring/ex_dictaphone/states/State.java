package pl.refactoring.ex_dictaphone.states;

/*
 * Invented by Wlodek Krakowski
 * Not Enum on purpose! :-P
 */
public class State {
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

}
