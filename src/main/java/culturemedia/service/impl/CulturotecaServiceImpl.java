package culturemedia.service.impl;

import culturemedia.exception.DurationNotValidException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.service.CulturotecaService;

import java.util.List;

public class CulturotecaServiceImpl implements CulturotecaService {

    @Override
    public List<Video> findAll() {
        return List.of();
    }

    @Override
    public Video save(Video save) throws DurationNotValidException {
        return null;
    }

    @Override
    public View add(View add) {
        return null;
    }
}
