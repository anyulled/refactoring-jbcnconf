package pl.refactoring.ex_dictaphone.states;

import pl.refactoring.ex_dictaphone.Dictaphone;
import pl.refactoring.ex_dictaphone.Engine;

public class ForwardPlayingState extends State {

    @Override
    public void handlePlay(Dictaphone dictaphone) {
        dictaphone.setState(PLAYING_STATE);
        dictaphone.moveEngineWithHeadReading(Engine.TAPE_FORWARD);
    }

    @Override
    public void handleStop(Dictaphone dictaphone) {
        dictaphone.setState(STOPPED_STATE);
        dictaphone.moveEngineWithHeadPutAway(Engine.TAPE_STOPPED);
    }

}
