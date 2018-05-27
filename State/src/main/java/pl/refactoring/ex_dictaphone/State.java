package pl.refactoring.ex_dictaphone;

/*
 * Invented by Wlodek Krakowski
 * Not Enum on purpose! :-P
 */
public class State {
    public static final State OFF_STATE = new State();
    public static final State STOPPED_STATE = new State();
    public static final State PLAYING_STATE = new State();
    public static final State FORWARD_PLAY_3x_STATE = new State();
    public static final State BACKWARD_3x_STATE = new State();
    public static final State RECORDING_STATE = new State();
    public static final State PAUSED_STATE = new State();
    public static final State FAST_FORWARD_STATE = new State();
    public static final State REWIND_STATE = new State();

    public State() {
    }

}
