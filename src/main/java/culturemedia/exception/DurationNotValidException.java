package culturemedia.exception;

import java.text.MessageFormat;

public class DurationNotValidException extends CulturotecaException{
    public DurationNotValidException(String title, Double duration){
        super(MessageFormat.format(
                "Video not valid by title {0} and duration {1} ",title, duration));
    }
}
