package pl.refactoring.ex_dictaphone;

import pl.refactoring.ex_dictaphone.states.State;

/*
 * Invented by Wlodek Krakowski
 */
public class Dictaphone {

    private State prevState;
    private State state;

    private Engine engine = new Engine();

    public Dictaphone() {
        this.setState(State.OFF_STATE);
    }

    public State getState() {
        return state;
    }

    public Engine getEngine() {
        return engine;
    }

    public void moveEngineWithHeadPutAway(int tapeDirection) {
        engine.moveEngineWithHeadPutAway(tapeDirection);
    }

    public void moveEngineWithHeadReading(int tapeDirection) {
        engine.moveEngineWithHeadReading(tapeDirection);
    }

    public void moveEngineWithHeadWriting() {
        engine.moveEngineWithHeadWriting();
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isInState(State state) {
        return this.state == state;
    }

    public void power() {
        state.handlePower(this);
    }

    public void play() {
        state.handlePlay(this);
    }

    public void record() {
        state.handleRecord(this);
    }

    public void stop() {
        state.handleStop(this);
    }

    public void pause() {
        if (isInState(State.PAUSED_STATE)) {
            setState(getPrevState());
            engine.setTapeDirection(Engine.TAPE_FORWARD);
        } else if (isInState(State.PLAYING_STATE) || isInState(State.RECORDING_STATE)) {
            setPrevState(getState());
            setState(State.PAUSED_STATE);
            engine.setTapeDirection(Engine.TAPE_STOPPED);
        }
    }

    public void fastForward() {
        state.handleFastForward(this);
    }

    public void rewind() {
        state.handleRewind(this);
    }

    public State getPrevState() {
        return prevState;
    }

    public void setPrevState(State prevState) {
        this.prevState = prevState;
    }

}
