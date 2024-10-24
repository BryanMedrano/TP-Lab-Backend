package culturemedia.service.impl;

import culturemedia.exception.DurationNotValidException;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CulturotecaService;

import java.util.List;

public class CulturotecaServiceImpl implements CulturotecaService {

    private final VideoRepository videoRepository;
    private final ViewsRepository viewsRepository;

    public CulturotecaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }

    @Override
    public List<Video> findAll() throws VideoNotFoundException {
        List<Video> videos = videoRepository.findAll();
        if (videos.isEmpty()){
            throw new VideoNotFoundException();
        }
        return videos;
    }

    @Override
    public Video save(Video save) {
        return videoRepository.save(save);
    }

    @Override
    public View add(View add) {
        return viewsRepository.add(add);
    }
}
