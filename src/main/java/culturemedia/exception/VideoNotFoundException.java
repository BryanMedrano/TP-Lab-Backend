package culturemedia.exception;

import java.text.MessageFormat;

public class VideoNotFoundException extends CulturotecaException{
    public VideoNotFoundException(String title){
        super(MessageFormat.format("Video not found by title {0}",title));
    }
}
