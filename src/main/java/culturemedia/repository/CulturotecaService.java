package culturemedia.repository;

import culturemedia.exception.DurationNotValidException;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CulturotecaService {
    List<Video> findAll();
    Video save(Video save) throws DurationNotValidException;
    View add(View add);
}
