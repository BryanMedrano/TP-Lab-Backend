package culturemedia.exception;

import java.text.MessageFormat;

public class DurationNotValidException extends CulturotecaException{
    public DurationNotValidException(String title, Double duration){
        super(MessageFormat.format(
                "Duration not valid for video: {0} duration: {1}  ",title, duration));
    }
}
