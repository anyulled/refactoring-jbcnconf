package pl.refactoring.ex_dictaphone.states;

import pl.refactoring.ex_dictaphone.Dictaphone;
import pl.refactoring.ex_dictaphone.Engine;

public class PlayingState extends State {

    @Override
    public void handlePlay(Dictaphone dictaphone) {
        dictaphone.setState(FORWARD_PLAY_3x_STATE);
        dictaphone.moveEngineWithHeadReading(Engine.TAPE_FORWARD_3x);
    }

    @Override
    public void handleStop(Dictaphone dictaphone) {
        dictaphone.setState(STOPPED_STATE);
        dictaphone.moveEngineWithHeadPutAway(Engine.TAPE_STOPPED);
    }

    @Override
    public void handleFastForward(Dictaphone dictaphone) {
        dictaphone.setState(FORWARD_PLAY_3x_STATE);
        dictaphone.moveEngineWithHeadReading(Engine.TAPE_FORWARD_3x);
    }

    @Override
    public void handleRewind(Dictaphone dictaphone) {
        dictaphone.setState(BACKWARD_3x_STATE);
        dictaphone.moveEngineWithHeadReading(Engine.TAPE_BACKWARD_3x);
    }
}
