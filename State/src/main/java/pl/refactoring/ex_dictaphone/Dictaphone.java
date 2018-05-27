package pl.refactoring.ex_dictaphone;

/*
 * Invented by Wlodek Krakowski
 */
public class Dictaphone {

    private State prevState;
    private State state;
    private Engine engine = new Engine();

    public Dictaphone() {
        this.state = State.OFF_STATE;
    }

    public State getState() {
        return state;
    }

    public Engine getEngine() {
        return engine;
    }

    public void play() {
        if (state == State.PLAYING_STATE) {
            state = State.FORWARD_PLAY_3x_STATE;

            engine.setHead(Engine.HeadState.READING);
            engine.setTapeDirection(Engine.TAPE_FORWARD_3x);
            engine.setMicrophoneOn(false);
            engine.setSpeakersOn(true);
        } else if (state == State.STOPPED_STATE) {
            state = State.PLAYING_STATE;

            engine.setHead(Engine.HeadState.READING);
            engine.setTapeDirection(Engine.TAPE_FORWARD);
            engine.setMicrophoneOn(false);
            engine.setSpeakersOn(true);
        } else if (state == State.FORWARD_PLAY_3x_STATE) {
            state = State.PLAYING_STATE;

            engine.setHead(Engine.HeadState.READING);
            engine.setTapeDirection(Engine.TAPE_FORWARD);
            engine.setMicrophoneOn(false);
            engine.setSpeakersOn(true);
        }
    }

    public void power() {

        if (state == State.OFF_STATE) {
            state = State.STOPPED_STATE;

            engine.setHead(Engine.HeadState.PUT_AWAY);
            engine.setTapeDirection(Engine.TAPE_STOPPED);
            engine.setMicrophoneOn(false);
            engine.setSpeakersOn(false);
        } else if (state == State.STOPPED_STATE) {
            state = State.OFF_STATE;

            engine.setHead(Engine.HeadState.PUT_AWAY);
            engine.setTapeDirection(Engine.TAPE_STOPPED);
            engine.setMicrophoneOn(false);
            engine.setSpeakersOn(false);
        }
    }

    public void record() {
        if (state == State.STOPPED_STATE) {
            state = State.RECORDING_STATE;

            engine.setHead(Engine.HeadState.WRITING);
            engine.setTapeDirection(Engine.TAPE_FORWARD);
            engine.setMicrophoneOn(true);
            engine.setSpeakersOn(false);
        }
    }

    public void pause() {
        if (state == State.PAUSED_STATE) {
            state = prevState;
            engine.setTapeDirection(Engine.TAPE_FORWARD);
        } else if (state == State.PLAYING_STATE || state == State.RECORDING_STATE) {
            prevState = state;
            state = State.PAUSED_STATE;
            engine.setTapeDirection(Engine.TAPE_STOPPED);
        }
    }

    public void fastForward() {
        if (state == State.STOPPED_STATE) {
            state = State.FAST_FORWARD_STATE;

            engine.setHead(Engine.HeadState.PUT_AWAY);
            engine.setTapeDirection(Engine.TAPE_FAST_FORWARD);
            engine.setMicrophoneOn(false);
            engine.setSpeakersOn(false);
        } else if (state == State.PLAYING_STATE) {
            state = State.FORWARD_PLAY_3x_STATE;

            engine.setHead(Engine.HeadState.READING);
            engine.setTapeDirection(Engine.TAPE_FORWARD_3x);
            engine.setMicrophoneOn(false);
            engine.setSpeakersOn(true);
        }
    }

    public void rewind() {
        if (state == State.STOPPED_STATE) {
            state = State.REWIND_STATE;

            engine.setHead(Engine.HeadState.PUT_AWAY);
            engine.setTapeDirection(Engine.TAPE_FAST_BACKWARD);
            engine.setMicrophoneOn(false);
            engine.setSpeakersOn(false);
        } else if (state == State.PLAYING_STATE) {
            state = State.BACKWARD_3x_STATE;

            engine.setHead(Engine.HeadState.READING);
            engine.setTapeDirection(Engine.TAPE_BACKWARD_3x);
            engine.setMicrophoneOn(false);
            engine.setSpeakersOn(true);
        }
    }

    public void stop() {
        if (state != State.OFF_STATE) {
            state = State.STOPPED_STATE;

            engine.setHead(Engine.HeadState.PUT_AWAY);
            engine.setTapeDirection(Engine.TAPE_STOPPED);
            engine.setMicrophoneOn(false);
            engine.setSpeakersOn(false);
        }
    }
}
