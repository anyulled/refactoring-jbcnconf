package pl.refactoring.ex_dictaphone.states;

import pl.refactoring.ex_dictaphone.Dictaphone;
import pl.refactoring.ex_dictaphone.Engine;

public class PausedState extends State {

    private State previousState;

    public PausedState() {
    }

    public PausedState(State previousState) {

        this.previousState = previousState;
    }

    public State getPreviousState() {
        return previousState;
    }

    @Override
    public void handleStop(Dictaphone dictaphone) {
        dictaphone.setState(STOPPED_STATE);
        dictaphone.moveEngineWithHeadPutAway(Engine.TAPE_STOPPED);
    }

    @Override
    public void handlePause(Dictaphone dictaphone) {
        dictaphone.setState(previousState);
        dictaphone.moveEngineWithCurrentHead(Engine.TAPE_FORWARD);
    }
}
