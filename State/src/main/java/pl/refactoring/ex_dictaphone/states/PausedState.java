package pl.refactoring.ex_dictaphone.states;

import pl.refactoring.ex_dictaphone.Dictaphone;
import pl.refactoring.ex_dictaphone.Engine;

public class PausedState extends State {
    @Override
    public void handlePower(Dictaphone dictaphone) {
        if (dictaphone.isInState(OFF_STATE)) {
            dictaphone.setState(STOPPED_STATE);
            dictaphone.moveEngineWithHeadPutAway(Engine.TAPE_STOPPED);
        } else if (dictaphone.isInState(STOPPED_STATE)) {
            dictaphone.setState(OFF_STATE);
            dictaphone.moveEngineWithHeadPutAway(Engine.TAPE_STOPPED);
        }
    }

    @Override
    public void handlePlay(Dictaphone dictaphone) {
        if (this == PLAYING_STATE) {
            dictaphone.setState(FORWARD_PLAY_3x_STATE);
            int tapeDirection = Engine.TAPE_FORWARD_3x;
            dictaphone.moveEngineWithHeadReading(tapeDirection);
        } else if (this == STOPPED_STATE) {
            dictaphone.setState(PLAYING_STATE);
            dictaphone.moveEngineWithHeadReading(Engine.TAPE_FORWARD);
        } else if (this == FORWARD_PLAY_3x_STATE) {
            dictaphone.setState(PLAYING_STATE);
            dictaphone.moveEngineWithHeadReading(Engine.TAPE_FORWARD);
        }
    }

    @Override
    public void handleRecord(Dictaphone dictaphone) {
        if (dictaphone.isInState(STOPPED_STATE)) {
            dictaphone.setState(RECORDING_STATE);
            dictaphone.moveEngineWithHeadWriting();
        }
    }

    @Override
    public void handleStop(Dictaphone dictaphone) {
        if (dictaphone.getState() != OFF_STATE) {
            dictaphone.setState(STOPPED_STATE);
            dictaphone.moveEngineWithHeadPutAway(Engine.TAPE_STOPPED);
        }
    }

}
