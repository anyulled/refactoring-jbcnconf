package pl.refactoring.ex_dictaphone;

import pl.refactoring.ex_dictaphone.states.State;

/*
 * Invented by Wlodek Krakowski
 */
public class Dictaphone {
    private State state;

    private Engine engine = new Engine();

    public Dictaphone() {
        this.setState(State.OFF_STATE);
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

    public void moveEngineWithCurrentHead(int tapeDirection) {
        engine.setTapeDirection(tapeDirection);
    }

    public void setState(State state) {
        this.state = state;
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

    public void fastForward() {
        state.handleFastForward(this);
    }

    public void rewind() {
        state.handleRewind(this);
    }

    public void pause() {
        this.state.handlePause(this);
    }

}
