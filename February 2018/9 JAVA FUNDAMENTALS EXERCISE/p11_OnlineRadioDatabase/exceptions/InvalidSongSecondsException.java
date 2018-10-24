package p11_OnlineRadioDatabase.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException{
    public InvalidSongSecondsException(String message) {
        super(message);
    }
}
