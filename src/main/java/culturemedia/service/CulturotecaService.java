package culturemedia.service;

import culturemedia.exception.DurationNotValidException;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CulturotecaService {
    List<Video> findAll();
    Video save(Video save) throws DurationNotValidException;
    View add(View add);
}
