package culturemedia.exception;

import java.text.MessageFormat;

public class VideoNotFoundByTitleException extends CulturotecaException{
    public VideoNotFoundByTitleException(String title){
        super(MessageFormat.format("Video not found by title {0}",title));
    }
}
