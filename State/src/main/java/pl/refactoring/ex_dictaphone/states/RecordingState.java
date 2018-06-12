package pl.refactoring.ex_dictaphone.states;

import pl.refactoring.ex_dictaphone.Dictaphone;
import pl.refactoring.ex_dictaphone.Engine;

public class RecordingState extends State {

    @Override
    public void handleStop(Dictaphone dictaphone) {
        dictaphone.setState(STOPPED_STATE);
        dictaphone.moveEngineWithHeadPutAway(Engine.TAPE_STOPPED);
    }

    @Override
    public void handlePause(Dictaphone dictaphone) {
        PausedState pausedState = new PausedState(this);
        dictaphone.setState(pausedState);
        dictaphone.moveEngineWithCurrentHead(Engine.TAPE_STOPPED);
    }
}
