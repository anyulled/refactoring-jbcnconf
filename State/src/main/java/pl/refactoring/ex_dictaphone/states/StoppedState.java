package pl.refactoring.ex_dictaphone.states;

import pl.refactoring.ex_dictaphone.Dictaphone;
import pl.refactoring.ex_dictaphone.Engine;

public class StoppedState extends State {
    @Override
    public void handlePower(Dictaphone dictaphone) {
        dictaphone.setState(OFF_STATE);
        dictaphone.moveEngineWithHeadPutAway(Engine.TAPE_STOPPED);
    }

    @Override
    public void handlePlay(Dictaphone dictaphone) {
        dictaphone.setState(PLAYING_STATE);
        dictaphone.moveEngineWithHeadReading(Engine.TAPE_FORWARD);
    }

    @Override
    public void handleRecord(Dictaphone dictaphone) {
        dictaphone.setState(RECORDING_STATE);
        dictaphone.moveEngineWithHeadWriting();
    }
}
